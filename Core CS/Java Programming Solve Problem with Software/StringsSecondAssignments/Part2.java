
/**
 * Escreva a descrição da classe Part2 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int times = 0;
        int start = stringb.indexOf(stringa);
        while(true){
            if(start == -1){
                break;
            }
            times = times + 1;
            start = stringb.indexOf(stringa, start + stringa.length());
        }
        return times;
    }
    
    public void testHowMany(){
        String test1 = "AABBAABBAA";
        System.out.println(" 3: " + howMany("AA", test1));
        System.out.println(" 0: " + howMany("CC", test1));
        
        String test2 = "ATAAAA";
        System.out.println(" 2: " + howMany("AA", test2));
        
        String test3 = "BAAA AAA AAA AAA AAA AAA AAA AAAB";
        System.out.println(" 8: " + howMany("AAA", test3));
    }
    
}
