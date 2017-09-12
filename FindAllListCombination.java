import java.util.*;

public class FindAllListCombination {
    public static void main(String[] args) {
        int[] array = {4,2,1,3,6,8};
        // Arrays.sort(array);
        List<List<Integer>> result = findTaget(array, 8);
        System.out.println(result);
    }

    public static List<List<Integer>> findTaget(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curComb = new ArrayList<>();
        targetHelper(array,target,0,curComb, result);
        return result;
    }

    // public static void targetHelper(int[] array, int target, int index, List<Integer> curComb, List<List<Integer>> result) {
    //     System.out.println("array value: " + array[index]);
    //     System.out.println("index: " + index);
    //     System.out.println("rem: " + target);

    //     if(index>= array.length) return;

    //     if(target == 0) {
    //         result.add(new ArrayList<>(curComb));
    //         // curComb.clear();
    //         return;
    //     }else{
    //     if(array[index] == target) {
    //         curComb.add(array[index]);
    //         result.add(new ArrayList<>(curComb));
    //         // curComb.clear();
    //         return;
    //     }else{

    //     if(array[index] < target && target > 0) {
    //         int rem = target - array[index];
    //         curComb.add(array[index]);
    //         targetHelper(array, rem, index, curComb, result);
    //         curComb.remove(curComb.size()-1);
    //         // curComb.add(array[index]);
    //         targetHelper(array, rem, index+1, curComb, result);
    //         // curComb.remove(curComb.size()-1);
    //     }
    //         }
    // }
    // }

//     public static void targetHelper(int[] array, int target, int index, List<Integer> curComb, List<List<Integer>> result) {
//        if (target > 0) {
//         for (int i=index;i<array.length && target>= array[i];++i ) {
//             curComb.add(array[i]);
//             targetHelper(array,target - array[i],i,curComb,result);
//             curComb.remove(curComb.size()-1);
//         }
// }else if(target == 0){
//         result.add(new ArrayList<>(curComb));
//        }
//            }
    public static void targetHelper(int[] array, int target, int index, List<Integer> curComb, List<List<Integer>> result) {
       if (target == 0) {
        result.add(new ArrayList<>(curComb));
        return;
       }

       if (index >= array.length|| target <0) {
        // result.add(new ArrayList<>(curComb));
        return;
       }

       for (int i=index;i<array.length ;++i ) {
        if (array[i] <= target) {
            curComb.add(array[i]);
            System.out.println("index: " + i);
            System.out.println("curComb: " + curComb);
            targetHelper(array,target - array[i],i+1,curComb,result);
            curComb.remove(curComb.size()-1);
        }
           
       }
    }







}