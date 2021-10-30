function diffArray(arr1, arr2) {
  const newArr = [];
  for (let i in arr1){
    if (!(arr2.some(item => item == arr1[i]))){
        newArr.push(arr1[i]);
    }
  }
  for (let i in arr2){
    if (!(arr1.some(item => item == arr2[i]))){
        newArr.push(arr2[i]);
    }
  }
  return newArr;
}

diffArray([1, 2, 3, 5], [1, 2, 3, 4, 5]);