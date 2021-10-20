/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }
    
    public int getRank(int year, String name, String gender){
       FileResource fr = new FileResource("testing/yob2012short.csv");
       int rank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String genderTemp = rec.get(1);
            if ( genderTemp.equals(gender) ) {
                rank += 1;
                if ( name.equals(rec.get(0))){
                    return rank;
                }
            }     
       }
       return -1;
    }
    
    public String getName(int year, int rank, String gender){
       FileResource fr = new FileResource("testing/yob2014short.csv");
       int rankTemp = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String genderTemp = rec.get(1);
            if ( genderTemp.equals(gender) ) {
                rankTemp += 1;
                if ( rankTemp == rank){
                    return rec.get(0);
                }
            }     
       }
       return "NO NAME";
    }
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        String pronome = "";
        if (gender.equals("F")){
            pronome = "she";
        }
        else{
            pronome = "he";
        }
        return name + " born in " + year + " would be " + newName + " if " + pronome + " was born in " + newYear;
    }
    
    
    public void test(){
        System.out.println(getRank(2012, "Mason", "M"));
        System.out.println(getRank(2012, "Mason", "F"));
        System.out.println(getName(2012, 3, "M"));
        System.out.println(getName(2012, 6, "F"));
        String NewName = whatIsNameInYear("Mason", 2012, 2014, "M");
        System.out.println(NewName);
    }
    
    public void testTotalBirths() {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("data/yob2014.csv");
        totalBirths(fr);
    }
}
