function pairElement(str) {
  let arr = str.split("");
  arr = arr.map(item => {
    switch (item) {
      case "A":
        return ["A", "T"];
      case "T":
        return ["T", "A"];
      case "G":
        return ["G", "C"];
      case "C":
        return ["C", "G"];
    }
  })

  console.log(arr);
  return arr;
}

pairElement("GCG");