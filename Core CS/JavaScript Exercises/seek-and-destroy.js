function destroyer(arr) {
  let args = [...arguments];
  args.shift();
  let newArr = [...arr]
  for (let i in args){
      while (newArr.indexOf(args[i]) != -1){
        let index = newArr.indexOf(args[i]);
        newArr.splice(index, 1);
      }
    }
  //console.log(newArr);
  //console.log(args);
  return newArr;
}

destroyer([1, 2, 3, 1, 2, 3], 2, 3);