// copy a deep array without allies
const deepCopy = (arr) => {
  let copy = [];
  arr.forEach(elem => {
    if(Array.isArray(elem)){
      copy.push(deepCopy(elem))
    }else{
      if (typeof elem === 'object') {
        copy.push(deepCopyObject(elem))
    } else {
        copy.push(elem)
      }
    }
  })
  return copy;
}

function checkCashRegister(price, cash, cid) {
  // copy cid without allies
  let newCid = deepCopy(cid);

  // variables
  let currency = [100, 20, 10, 5, 1, 0.25, 0.1, 0.05, 0.01];
  newCid.reverse();
  let status = {};
  let change = cash - price;
  let changeHand = [];
  //console.log("First change " + change)

  // update change
  for (let i in currency){
    if (currency[i] < change){
      let inHand = [newCid[i][0], 0];
      while ( change >= 0 && newCid[i][1] !== 0 && change >= currency[i]){
        change = change - currency[i];
        newCid[i][1] -= currency[i];
        change = parseFloat(change.toFixed(2))
        newCid[i][1] = parseFloat(newCid[i][1].toFixed(2))
        //console.log(change)
        //console.log(newCid[i])
        inHand[1] += currency[i];
        inHand[1] = parseFloat(inHand[1].toFixed(2))
        //console.log(inHand)
      }
      changeHand.push(inHand);
    }
  }

  // update status
  if (change > 0){
    status["status"] = "INSUFFICIENT_FUNDS";
    status["change"] = [];
    return status;
  }

  if (newCid.some(item => item[1] != 0)){
    status["status"] = "OPEN";
    status["change"] = changeHand;
  } else if (newCid.every(item => item[1] == 0)){
    status["status"] = "CLOSED";
    status["change"] = cid;
  } 

  console.log(status)
  return status;
}


checkCashRegister(19.5, 20, [["PENNY", 0.5], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 0], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]])

//checkCashRegister(19.5, 20, [["PENNY", 0.01], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 1], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]])

//checkCashRegister(3.26, 100, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]])

//checkCashRegister(19.5, 20, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]);