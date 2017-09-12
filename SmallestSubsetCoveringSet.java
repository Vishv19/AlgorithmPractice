import java.util.*;

public class SmallestSubsetCoveringSet {
    private static class SubArray {
        public Integer start;
        public Integer end;

        public SubArray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static SubArray findSmallestSubArrayCoveringSet(List<String> paragraph, Set<String> keywords) {
        Map<String, Integer> keywordsToCover = new HashMap<>();
        for(String keyword: keywords) {
            keywordsToCover.put(keyword, keywordsToCover.containsKey(keyword)
                                            ? keywordsToCover.get(keyword) + 1 : 1);
        }
        for (Map.Entry<String, Integer> entry : keywordsToCover.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        SubArray result = new SubArray(-1, -1);
        int remainingToCover = keywords.size();

        for(int left = 0, right = 0; right < paragraph.size(); ++right) {
            Integer keywordCount = keywordsToCover.get(paragraph.get(right));
            System.out.println("left: " + left);
            System.out.println("right: " + right);
            System.out.println("right index: " + paragraph.get(right));
            System.out.println("keywordCount: " + keywordCount);
            if(keywordCount != null) {
                keywordsToCover.put(paragraph.get(right), --keywordCount);
                if(keywordCount >= 0) {
                    --remainingToCover;
                    // System.out.println("remainingToCover: " + remainingToCover);
                }
            }

            while(remainingToCover == 0) {
                System.out.println("in while loop");
                if(result.start == -1 && result.end == -1 
                    || right - left < result.end - result.start) {
                    result.start = left;
                    result.end = right;
                }
                keywordCount = keywordsToCover.get(paragraph.get(left));
                if(keywordCount !=null) {
                    keywordsToCover.put(paragraph.get(left), ++keywordCount);
                    if(keywordCount > 0) {
                        ++remainingToCover;
                    }
                }
                ++left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> A = Arrays.asList("a", "b", "c", "b", "a", "d", "c", "a", "e",
                               "a", "a", "b", "e");
        List<String> dict = Arrays.asList("b", "c", "e");
        SubArray s = findSmallestSubArrayCoveringSet(A, new HashSet<String>(dict));
        System.out.println(s.start);
        System.out.println(s.end);        
    }
}