function palindrome(str) {
  let newArr = str.toLowerCase().match(/[A-Za-z0-9]/g)
  let n1 = 0;
  let n2 = newArr.length - 1
  while ((n2 - n1) > 0){
    let s1 = newArr[n1];
    let s2 = newArr[n2];
    if (s1 !== s2){
      return false;
    }
    n1++;
    n2--;
  }
  return true;
}
palindrome("five|\_/|four")
//palindrome("My age is 0, 0 si ega ym.")
palindrome("eye");