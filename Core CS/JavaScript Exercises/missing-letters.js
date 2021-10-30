function fearNotLetter(str) {
  let arr = str.split("").map(item => item.charCodeAt());
  let current = arr[0];
  for (let i in arr){
    if (current !== arr[i]){
      return String.fromCharCode(current);
    }
    current++;
  }
  return undefined;
}

fearNotLetter("abce");