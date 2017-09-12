import java.util.*;

public class TransformOneStringToAnother {
    private static class StringWithDistance {
        public String candidateString;
        public Integer distance;

        public StringWithDistance(String candidateString, Integer distance) {
            this.candidateString = candidateString;
            this.distance = distance;
        }
    }

    public static int transformString(Set<String> D, String s, String t) {
        Queue<StringWithDistance> q = new LinkedList<>();
        q.add(new StringWithDistance(s, 0));
        D.remove(s);

        StringWithDistance f;
        while((f = q.poll())!=null) {
            if(f.candidateString.equals(t)) {
                return f.distance;
            }

            String str = f.candidateString;
            for(int i = 0; i < str.length(); i++) {
                String strStart = i == 0 ? "" : str.substring(0,i);
                String strEnd = i+1 > str.length() ? "" : str.substring(i+1);

                for(int j = 0; j < 26; j++) {
                    String modString = strStart + (char)('a' + j) + strEnd;
                    if(D.remove(modString)) {
                        q.add(new StringWithDistance(modString, f.distance + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Set<String> D = new HashSet<>();
        D.add("bat");
        D.add("cot");
        D.add("dog");
        D.add("dag");
        D.add("dot");
        D.add("cat");

        System.out.println(transformString(D, "cat", "dog"));
    }
}