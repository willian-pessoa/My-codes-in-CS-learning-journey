function translatePigLatin(str) {
  let myRegex = /^[aeiou]/
  let newStr = "";
  if (!(myRegex.test(str))){
    newStr = str.replace(/^[^aeiou]+/, "").concat(str.match(/^[^aeiou]+/)+"ay");
  } else {
    newStr = str.concat("way");
  }

  return newStr;
}

console.log(translatePigLatin("algorithm"));
console.log(translatePigLatin("glove"));