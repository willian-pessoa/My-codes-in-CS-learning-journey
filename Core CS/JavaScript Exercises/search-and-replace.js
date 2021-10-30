function myReplace(str, before, after) {
  let arr = str.split(/\s/);
  let original = arr[arr.indexOf(before)];
  let newAfter = "";
  if (/^[A-Z]/.test(original)){
    newAfter = after.charAt(0).toUpperCase() + after.slice(1);
  } else {
    newAfter = after.charAt(0).toLowerCase() + after.slice(1);
  }
  //console.log(original);
  //console.log(newAfter);

  let newStr = str.replace(original, newAfter);
  //console.log(newStr);
  return newStr;
}

myReplace("He is Sleeping on the couch", "Sleeping", "sitting")
//myReplace("A quick brown fox jumped over the lazy dog", "jumped", "leaped");