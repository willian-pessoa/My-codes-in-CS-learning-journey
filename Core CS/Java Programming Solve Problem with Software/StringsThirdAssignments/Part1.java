import edu.duke.*;
/**
 * Escreva a descrição da classe Part1 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        String tempDna = dna.toUpperCase();
        // first possible gene
        int end = tempDna.indexOf(stopCodon.toUpperCase(), startIndex + 3);
        while (true){
        // don't find gene
        if (end == -1)
        {
            return -1;
        } 
        // check if a gene
        if ((end - startIndex) % 3 == 0 )
        {
            return end;
        }
        end = tempDna.indexOf(stopCodon.toUpperCase(), end+1);
        }
    }
    
    public String findGene(String dna){
        String tempDna = dna.toUpperCase();
        int start = tempDna.indexOf("ATG");
        if (start == -1){
            return "";
        }
        int indexTAA = findStopCodon(tempDna, start, "TAA");
        int indexTAG = findStopCodon(tempDna, start, "TAG");
        int indexTGA = findStopCodon(tempDna, start, "TGA");
        //System.out.println(indexTAA);
        //System.out.println(indexTAG);
        //System.out.println(indexTGA);
        // check if end is TAA
        if ( indexTAA != -1 && (indexTAA < indexTAG || indexTAG == -1)){
            if ( indexTAA < indexTGA || indexTGA == -1 ){
                return dna.substring(start, indexTAA+3);
            }  
        }
        // check if end is TAG
        if ( indexTAG != -1 && (indexTAG < indexTAA || indexTAA == -1)){
            if ( indexTAG < indexTGA || indexTGA == -1){
                return dna.substring(start, indexTAG+3);
            }  
        }
        // check if end is TGA
        if ( indexTGA != -1 && (indexTGA < indexTAA || indexTAA == -1)){
            if ( indexTGA < indexTAG || indexTAG == -1){
                return dna.substring(start, indexTGA+3);
            }  
        }
        return "";
    }
    
     public void printAllGenes(String dna){
        String tempDna = dna.toUpperCase();
        while (true){
            String tempGene = findGene(tempDna);
            if ( tempGene.isEmpty() ){
                break;
            }
            else{
            System.out.println( tempGene );
            }
            tempDna = tempDna.substring(tempDna.indexOf(tempGene) + tempGene.length());
        }
    }
    
     public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        String tempDna = dna.toUpperCase();
        while (true){
            String tempGene = findGene(tempDna);
            if ( tempGene.isEmpty() ){
                break;
            }
            else{
            geneList.add(tempGene);
            }
            tempDna = tempDna.substring(tempDna.indexOf(tempGene) + tempGene.length());
        }
        return geneList;
    }
    
    public double cgRatio(String dna){
        double countG = 0.0;
        double countC = 0.0;
        int index = 0;
        String tempDna = dna.toUpperCase();
        while (index < dna.length()){
            if ( tempDna.startsWith("G") ){
                countG = countG + 1;
            }
            if ( tempDna.startsWith("C") ){
                countC = countC + 1;
            }
            index = index + 1;
            if (index < dna.length()){
                tempDna = tempDna.substring(1);
            }
        }
        return (countG + countC) / dna.length();
    }
    
    public int countCTG(String dna){
        int countCTG = 0;
        int index = 0;
        String tempDna = dna.toUpperCase();
        while (index < dna.length()){
            if ( tempDna.startsWith("CTG") ){
                countCTG = countCTG + 1;
            }
            index = index + 1;
            if (index < dna.length()){
                tempDna = tempDna.substring(index);
            }
        }
        return countCTG;
    }
    
    public void processGenes(StorageResource sr){
        int countMoreNine = 0;
        System.out.println("All the Strings in sr that are longer than 60 characters");
        for(String s : sr.data()){
            if ( s.length() >= 60){
                System.out.println(s);
                countMoreNine = countMoreNine + 1;
            }
        }
        System.out.println("Total : " + countMoreNine);
        int countCG = 0;
        System.out.println("Strings in sr whose C-G-ratio is higher than 0.35");
        for(String s : sr.data()){
            if ( cgRatio(s) > 0.35){
                System.out.println(s);
                countCG = countCG  + 1;
            }
        }
        System.out.println("Total : " + countCG);
        String longest = "";
        for(String s : sr.data()){
            if ( s.length() > longest.length() ){
                longest = s;
            }
        }
        System.out.println("Longest gene have length : " + longest.length());
    }
    
    public void testProcessGenes(){
        FileResource fr = new FileResource("brca1.fa");
        String dna = fr.asString();
        //String dna = "ATGTAAATGGGGTGAATGTTTTAGATGAAAAAATAA";
        StorageResource genes = getAllGenes(dna);
        //printAllGenes(dna);
        processGenes(genes);
    }
    
    public void testFindStopCodon(){
        String dna = "AATGTAA";
        System.out.println(" 4 : " + findStopCodon(dna, 1, "TAA"));
        System.out.println(" -1 : " + findStopCodon(dna, 1, "tga"));
        //             v  v  v  v
        String dna2 = "ATGTTAATTTAA";
        System.out.println(" 12 : " + findStopCodon(dna2, 0, "TAA"));
        System.out.println(" -1 : " + findStopCodon(dna2, 0, "tga"));
    }
    
    public void testFindGene(){
        String test1 = "AAGGTT";
        String test2 = "ATATGTTTTGA";
        String test3 = "ATGTTTAATTAGTAAGG";
        String test4 = "ATGTTTTTTT";
        String test5 = "AAATGTAA";
        
        System.out.println("   : " + findGene(test1));
        System.out.println(" ATGTTTTGA : " + findGene(test2));
        System.out.println(" ATGTTTAATTAG : " + findGene(test3));
        System.out.println("   : " + findGene(test4));
        System.out.println(" ATGTAA : " + findGene(test5));
    }
    
    public void testAllGene(){
        //             v  v  v  v  v  v  v  v  v  v  v  v  v                             
        String test = "AAAATGTTTTAATTTATGGGGTGAATGTTTTTAAATTAG";
        System.out.println(" EXPECT ");
        System.out.println("ATGTTTTAA ");
        System.out.println("ATGGGGTGA ");
        System.out.println("ATGTTTTTA ");
        System.out.println(" TESTE ");
        printAllGenes(test);
        System.out.println(" TESTE 2 ");
        for ( String s : getAllGenes(test).data()){
            System.out.println(s);
        }
    }
}
