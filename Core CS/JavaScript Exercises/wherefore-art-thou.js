function whatIsInAName(collection, source) {
  const arr = [];
  // Only change code below this line
  for (let i in collection){
      let maybeIn = false;
      for (let key in source){
        if (collection[i].hasOwnProperty(key)){
           if (source[key] === collection[i][key]){
             maybeIn = true;
           } else {
             maybeIn = false;
             break;
           }
        } else {
          maybeIn = false;
          break;
        }
      }
      console.log(maybeIn)
      if (maybeIn) {
        arr.push(collection[i])
      }
  }
  console.log(arr)
  // Only change code above this line
  return arr;
}

whatIsInAName([{"a": 1, "b": 2, "c": 3}], {"a": 1, "b": 9999, "c": 3})

whatIsInAName([{ "apple": 1, "bat": 2 }, { "bat": 2 }, { "apple": 1, "bat": 2, "cookie": 2 }], { "apple": 1, "bat": 2 })