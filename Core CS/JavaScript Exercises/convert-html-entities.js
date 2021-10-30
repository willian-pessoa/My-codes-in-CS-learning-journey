function convertHTML(str) {
  let arr = str.split("");
  for (let i in arr){
    if (arr[i] == "&"){
      arr[i] = "&amp;";
    } else if (arr[i] == "<"){
      arr[i] = "&lt;";
    } else if (arr[i] == ">"){
      arr[i] = "&gt;";
    } else if (arr[i] == '"'){
      arr[i] = "&quot;";
    } else if (arr[i] == "'"){
      arr[i] = "&apos;";
    } else {
      continue;
    }
  }
  return arr.join("");
}
convertHTML("Hamburgers < Pizza < Tacos");
convertHTML("Dolce & Gabbana");