
/**
 * Escreva a descrição da classe ExportData aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData {
    
    public String countryInfo(CSVParser parser, String country){
        String exports = "";
        String values = "";
        for(CSVRecord record : parser){
            if (record.get("Country").contains(country)){
                exports = record.get("Exports");
                values = record.get("Value (dollars)");
                break;
            }
        }
        if (exports == ""){
            return "NOT FOUND!";
        }
        else{
            String info = country + ": " + exports + ": " + values;
            return info;
        }
        
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem)){
                count = count + 1;
            }
            
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            String tocompare = record.get("Value (dollars)");
            System.out.println(tocompare.length() + " | " + amount.length());
            if (tocompare.length() > amount.length()){
                String country = record.get("Country");
                System.out.println(country + " " + tocompare);
            }
            
        }
    }
    
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));
        //listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "sugar"));
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
}
