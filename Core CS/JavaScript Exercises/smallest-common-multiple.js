// return true if prime else false
const isPrime = num => {
    for(let i = 2, s = Math.sqrt(num); i <= s; i++)
        if(num % i === 0) return false; 
    return num > 1;
}

// return true if n1 or n2 is divisor each other 
const isDiv = (n1, n2) => {
    if (n1 % n2 == 0 | n2 % n1 == 0){
      return true;
    } else {
      return false;
    }
}

// return the first prime that's factor n1 and n2 or -1 if don't have
const factore = (n1, n2) => {
    for (let i = 2; i <= Math.max(n1, n2); i++){
      if (i > Math.min(n1, n2)){
        return -1;
      }
      if (isPrime(i) && n1 % i == 0 && n2 % i == 0){
        return i;
      }
    }
}

// return the mmc between n1 and n2
const mmc = (n1, n2) => {
  if (isDiv(n1, n2)){
    return Math.max(n1, n2)
  } else if (isPrime(n1) | isPrime(n2) | factore(n1,n2) == -1){
    return n1 * n2;
  } else {
      let fact = factore(n1, n2)
      let f1 = n1 / fact;
      let f2 = n2 / fact;
      console.log(fact);
      console.log(f1);
      console.log(f2);
    return fact * mmc(f1,f2);
  }
}

function smallestCommons(arr) {
  let nums = [];
  let bigger = Math.max(...arr);
  let smaller = Math.min(...arr);
  for (let i = smaller; i <= bigger; i++){
    nums.push(i);
  }

  let mc = nums[0];
  for (let i = 0; i < nums.length - 1; i++){
    mc = mmc(mc, nums[i+1]);
    console.log(mc);
  }
  return mc;
}

smallestCommons([23,18]);