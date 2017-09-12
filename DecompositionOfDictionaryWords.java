import java.util.*;

public class DecompositionOfDictionaryWords {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("a");
        dictionary.add("am");
        dictionary.add("an");
        List<String> decomposition = decompositionIntoDictionaryWords("aaman", dictionary);
        System.out.println(decomposition);
    }

    public static List<String> decompositionIntoDictionaryWords(String domain, Set<String> dictionary) {
        //be careful about string and int array intialization
        int[] lastLength = new int[domain.length()];
        Arrays.fill(lastLength, -1);

        // iterate over the whole string
        for(int i = 0; i < domain.length(); i++) {

            if(dictionary.contains(domain.substring(0,i+1))) {
                lastLength[i] = i+1;
            }
            // iterate the possible substrings in the dictionary
            // if lastlength[i]=-1 look for j < i such that domain.substring(0,j+1)
            // has a valid decomposition and domain.substring(j+1, i+1) is a dictionary word. If so
            // record the length in lastLength[j]
            if(lastLength[i] ==-1) {
                for(int j = 0; j < i; ++j) {
                    if(lastLength[j]!=-1 && 
                        dictionary.contains(domain.substring(j+1, i+1))) {
                        lastLength[i] = i-j;
                        break;
                    }
                }
            }
        }
        List<String> decomposition = new ArrayList<String>();
        if(lastLength[lastLength.length-1]!=-1) {
            int idx = domain.length() - 1;

            // aggregate the dictionary words found
            while(idx >= 0) {
                decomposition.add(domain.substring(idx+1 - lastLength[idx], idx + 1));
                idx -= lastLength[idx];
            }
            Collections.reverse(decomposition);
        }
        return decomposition;
    }
}