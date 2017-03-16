import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MelodiousPassword {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        char[] consonant = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v','w' ,'x', 'z'};
        
        List<String> allCombination = new ArrayList<>();
        char[] combinationSoFar = new char[n];
        //String combinationSoFar = "";
        combination(combinationSoFar, 0, n, allCombination, vowel, consonant);
        combination(combinationSoFar, 0, n, allCombination, consonant, vowel);
        for(int i = 0; i < allCombination.size(); i++) {
            System.out.println(allCombination.get(i));
        }
    }
    

    public static void combination(char[] combinationSoFar, int currentPos, int maxPos, List<String> allCombination, char[] l1, char[] l2)  {
        if(currentPos == maxPos) {
            allCombination.add(String.valueOf(combinationSoFar));
            return;
        }
        
        for(int i = 0; i < l1.length; i++) {
            combinationSoFar[currentPos] = l1[i];
            combination(combinationSoFar, currentPos+1, maxPos, allCombination, l2, l1);            
        }

    }
}
