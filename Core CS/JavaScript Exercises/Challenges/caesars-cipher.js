function rot13(str) {
  let normalA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  let rot13A = "NOPQRSTUVWXYZABCDEFGHIJKLM";
  let decoded = "";
  for (let i = 0; i < str.length; i++){
    if (/[^A-Z]/.test(str[i])){
      decoded = decoded + str[i];
    } else {
      let tempChar = normalA[rot13A.indexOf(str[i])]
      decoded = decoded + tempChar;
    }
  }
  console.log(decoded);
  return decoded;
}

rot13("SERR PBQR PNZC");