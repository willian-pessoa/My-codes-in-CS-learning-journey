function telephoneCheck(str) {
  let myRegex = /^1? ?(\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}$/
  // ^1? ? -> if start with 1 and have space
  // (\(\d{3}\)|\d{3}) -> if first 3 digits is (000) or 000
  // [- ]? -> have space or hifen btw first 3 digits and the second 3 digits
  // \d{3} -> three digits
  // [- ]? -> have space or hifen btw second 3 digits and the third 4 digits
  // \d{4}$ -> end with 4 digits 

  console.log(myRegex.test(str));
  return myRegex.test(str);
}

telephoneCheck("555-555-5555");
telephoneCheck("555-555-555");