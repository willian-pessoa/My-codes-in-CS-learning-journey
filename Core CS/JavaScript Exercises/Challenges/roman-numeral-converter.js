function convertToRoman(num) {
  let mapRoman = {
    M : 1000,
    CM : 900,
    D : 500,
    CD : 400,
    C : 100,
    XC : 90,
    L : 50,
    XL : 40,
    X : 10,
    IX : 9,
    V : 5,
    IV : 4,
    I : 1 
  }
   
  let roman = ""
  let tempNum = num;
  for (let key in mapRoman){
    while (tempNum >= mapRoman[key]){
      roman = roman + key;
      tempNum -= mapRoman[key];
    }
  }
 console.log(roman);
 return roman;
}

convertToRoman(44);