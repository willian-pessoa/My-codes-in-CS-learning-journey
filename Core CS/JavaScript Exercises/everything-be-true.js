function truthCheck(collection, pre) {
  for (let i in collection){
      if (!(collection[i].hasOwnProperty(pre))){
        return false;
      }
      if ((collection[i].hasOwnProperty(pre))){
        let temp = collection[i][pre];
        if (Boolean(temp)){
          continue;
        } else {
          return false;
        }
      }
  }
  return true;
}
console.log(Boolean(0));

truthCheck([{"user": "Tinky-Winky", "sex": "male"}, {"user": "Dipsy"}, {"user": "Laa-Laa", "sex": "female"}, {"user": "Po", "sex": "female"}], "sex");