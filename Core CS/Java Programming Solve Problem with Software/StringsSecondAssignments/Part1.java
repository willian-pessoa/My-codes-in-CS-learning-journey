
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
        int end = tempDna.indexOf(stopCodon.toUpperCase(), startIndex);
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
        end = end + tempDna.indexOf(stopCodon.toUpperCase(), end+1);
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
        
        System.out.println("   : " + findGene(test1));
        System.out.println(" ATGTTTTGA : " + findGene(test2));
        System.out.println(" ATGTTTAATTAG : " + findGene(test3));
        System.out.println("   : " + findGene(test4));
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
    }
}
