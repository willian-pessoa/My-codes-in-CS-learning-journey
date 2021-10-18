
/**
 * Escreva a descrição da classe Part2 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Part2 {
    
    public String findSimpleGene (String dna, int startCodon, int stopCodon)
    {
        String tempDna = dna.toUpperCase();
        int start = tempDna.indexOf("ATG");
        if (start == -1)
        {
            return "";
        }
        int end = tempDna.indexOf("TAA", start + 3);
        if (end == -1)
        {
            return "";
        }
        String gene = dna.substring(start, end + 3);
        if ( gene.length() % 3 == 0 )
        {
            return gene;
        }
        else{
            return "";
        }
 
    }
    
    public void testSimpleGene()
    {
        String dna = "ATGTAGGTAGGTTAA";
        String gene = findSimpleGene(dna,0,0);
        System.out.println("DNA : " + dna);
        System.out.println("Gene : " + gene);
        System.out.println();
        
        String dna1 = "atgatttaa";
        String gene1 = findSimpleGene(dna1,0,0);
        System.out.println("DNA : " + dna1);
        System.out.println("Gene : " + gene1);
        System.out.println();
        
        String dna2 = "ATGTATTGA";
        String gene2 = findSimpleGene(dna2,0,0);
        System.out.println("DNA : " + dna2);
        System.out.println("Gene : " + gene2);
        System.out.println();
        
        String dna3 = "ATAGTAGA";
        String gene3 = findSimpleGene(dna3,0,0);
        System.out.println("DNA : " + dna3);
        System.out.println("Gene : " + gene3);
        System.out.println();
        
        String dna4 = "ATGTTAA";
        String gene4 = findSimpleGene(dna4,0,0);
        System.out.println("DNA : " + dna4);
        System.out.println("Gene : " + gene4);
        System.out.println();
    }

}
