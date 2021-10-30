function uniteUnique(arr) {
  let newArr = [...arguments];
  let unique = newArr.shift();
  for (let i in newArr){
    for (let j in newArr[i]){
      if (!(unique.includes(newArr[i][j]))){
        unique.push(newArr[i][j])
      }
    }
  }

  //console.log(newArr);
  //console.log(unique);
  return arr;
}

uniteUnique([1, 3, 2], [5, 2, 1, 4], [2, 1]);