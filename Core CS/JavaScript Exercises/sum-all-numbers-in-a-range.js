function sumAll(arr) {
  let amountE = Math.abs(arr[0] - arr[1]) + 1
  return amountE * (arr[0] + arr[1]) / 2
}

console.log(sumAll([1, 4]));