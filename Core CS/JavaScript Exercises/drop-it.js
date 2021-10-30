function dropElements(arr, func) {
  let newArr = arr;
  while (true){
    if (newArr.length === 0 ){
      return [];
    }
    if (func(newArr[0])){
      return newArr;
    } else {
      newArr.shift();
    }
  }
}

dropElements([1, 2, 3], function(n) {return n < 3; });