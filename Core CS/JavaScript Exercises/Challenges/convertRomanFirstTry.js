// take a number btw 1 and 9 return roman
function convertToRoman(num) {
  let romanChar1 = ["I", "X", "C", "M", ""];
  let romanChar2 = ["V", "L", "D", ""]

  let mod = 10;
  let compare = 1;
  let rest = num % mod;
  let house = 0;
  let roman = "";
  let isTrue = true;
  while (isTrue){
    // ...1 to ...3
    if (rest <= compare * 3){
      for (let i = 0; i < rest; i++){
        roman = roman + romanChar1[house];
      }
    }
    // ...4
    else if ( rest == compare * 4){
      roman = romanChar2[house] + romanChar1[house];
    }
    // ...5 to ...8
    else if ( rest <= compare * 8){
      roman = roman + romanChar2[house];
      for (let i = 5; i < rest; i++){
        roman = roman + romanChar1[house];
      }
    }
    // ...9
    else if ( rest == compare * 9){
      roman = romanChar1[house + 1] + romanChar1[house]
    }
    // ...0
    else if ( rest == 0 ){
      roman = roman + romanChar1[house + 1];
    }

    // check if to stop
    if (num - rest == 0 | num - rest % 10 == 0){
      isTrue = false;
    }
    // update variables
    mod = mod * 10;
    compare = compare * 10;
    house++;
    rest = num % mod;
  }

  return roman;
}
console.log();
console.log(convertToRoman(10))
// convertToRoman(36);