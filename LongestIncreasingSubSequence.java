public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(increasingSubSeq(arr));
    }

    public static int increasingSubSeq(int[] array) {
        int[] cache = new int[array.length];
        cache[0] = 1;
        int maximumVal = 0;
        int finalMax = 1;
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j]) {
                    maximumVal = Math.max(maximumVal,cache[j]);
                }
            }
            cache[i] = maximumVal + 1;
            finalMax = Math.max(maximumVal,cache[i]);
        }
        return finalMax;
    }
}

