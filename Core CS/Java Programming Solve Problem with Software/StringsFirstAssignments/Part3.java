
/**
 * Escreva a descrição da classe Part3 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Part3 {

    public Boolean twoOccurrences(String stringa, String stringb){
        int start = stringb.indexOf(stringa);
        if ( start != -1){
            int other = stringb.indexOf(stringa, start + stringa.length());
            if (other != -1){
                return true;
            }
            else{
                return false;
            }}
        else{
            return false;
        }
    }    
    public String lastPart(String stringa, String stringb){
        int start = stringb.indexOf(stringa);
        if (start == -1){
            return stringb;
        }
        else{
            return stringb.substring(start + stringa.length());
        }
    }
    
    public void testing(){
        String test1 = "A story by Abby Long";
        System.out.println("Expect True, returned: " + twoOccurrences("by", test1));
        
        String test2 = "My friend Charlies Brow";
        System.out.println("Expect False, returned: " + twoOccurrences("Brow", test2));
        
        System.out.println("Expect ana : " + lastPart( "an","banana"));
        
        System.out.println("Expect forest : " + lastPart( "zoo", "forest")); 
    }    
}