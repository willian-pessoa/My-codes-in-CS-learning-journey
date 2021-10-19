
/**
 * Escreva a descrição da classe Part3 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Part3 {
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
    
    public int countGenes(String dna){
        String tempDna = dna.toUpperCase();
        int countGene = 0;
        while (true){
            String tempGene = findGene(tempDna);
            if ( tempGene.isEmpty() ){
                break;
            }
            else{
            countGene = countGene + 1;
            }
            tempDna = tempDna.substring(tempDna.indexOf(tempGene) + tempGene.length());
        }
        return countGene;
    }
    
    public void testCountGenes(){
        String test = "AAAATGTTTTAATTTATGGGGTGAATGTTTTTAAATTAG";
        System.out.println(" 3: " + countGenes(test));
    }
}
