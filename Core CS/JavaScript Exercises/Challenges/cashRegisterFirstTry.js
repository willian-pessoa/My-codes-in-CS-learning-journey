function checkCashRegister(price, cash, cid) {
  // variables
  let newCid = [...cid];
  let currency = [100, 20, 10, 5, 1, 0.25, 0.1, 0.05, 0.01];
  newCid.reverse();
  let status = {};
  let change = cash - price;
  let changeHand = [];

  // update change
  for (let i in currency){
    if (currency[i] < change){
      let inHand = [newCid[i][0], 0];
      while ( change > 0 &&  newCid[i][1] !== 0){
        change = change - currency[i];
        newCid[i][1] -= currency[i]; 
        inHand[1] += currency[i];
      }
      changeHand.push(inHand);
    }
  }

  // update status
  if (newCid.some(item => item[1] != 0)){
    status["status"] = "OPEN";
    status["change"] = changeHand;
  } else if (newCid.every(item => item[1] == 0)){
    status["status"] = "INSUFFICIENT_FUNDS";
    status["change"] = [];
  } else if (changeHand === cid.reverse()){
    status["status"] = "CLOSED";
    status["change"] = changeHand;
  }

  console.log(status)
  return status;
}

checkCashRegister(19.5, 20, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]);