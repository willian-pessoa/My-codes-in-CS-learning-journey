import edu.duke.*;
/**
 * Escreva a descrição da classe Part4 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Part4 {
    public void printYoutube(){
        URLResource url = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        String youtube = "www.youtube.com";
        for (String s : url.words()) {
             String temp = s.toLowerCase();
             int start = temp.indexOf(youtube);
             if (start != -1){
                System.out.println(s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\"")));
                }
     }
    }
}
