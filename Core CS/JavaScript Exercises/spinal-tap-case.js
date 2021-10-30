function spinalCase(str) {
  let newStr = str.replace( /([a-z])([A-Z])/g ,"$1 $2");
  let arr = [];
  arr = newStr.split(/_|[^\w\d]/)
  newStr = arr.join("-")
  console.log(arr);
  return newStr.toLowerCase();
}

spinalCase('This Is Spinal Tap');
spinalCase("thisIsSpinalTap")
spinalCase("The_Andy_Griffith_Show")