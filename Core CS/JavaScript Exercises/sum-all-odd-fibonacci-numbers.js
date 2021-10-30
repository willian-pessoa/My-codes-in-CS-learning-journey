function sumFibs(num) {
  let first = 1;
  let second = 1;
  let current = 1;
  let sum = 1;
  while (current <= num){
    if (current % 2 == 1){
      sum = sum + current;
    }
    first = second;
    second = current; 
    current = first + second;
  }
  return sum;
}

sumFibs(4);