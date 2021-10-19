
/**
 * Escreva a descrição da classe Ex1 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ex1 {
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || index >= input.length() - 3){
               break;
        }
        //System.out.println("Index : " + index);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+3);
        //System.out.println("index after updating " + index);
    }
}
   public void test() {
    //no code yet
    //findAbc("abcd");
    //       01234567  
    //        bcd                           bcabca                   
    //findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    findAbc("abcabcabcabca");
}
}
