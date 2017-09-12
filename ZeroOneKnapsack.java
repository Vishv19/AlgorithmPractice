import java.util.*;

public class ZeroOneKnapsack {
    private static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static double optimumSubjectToCapFraction(List<Item> items, int capacity) {
        Collections.sort(items, Collections.reverseOrder(new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return Double.compare((i1.value/i1.weight),(i2.value/i2.weight));
            }
        }));

        return optimumSubjectToItemCapFraction(items, capacity);
    }

    public static double optimumSubjectToItemCapFraction(List<Item> items, int capacity) {
        double sum = 0;
        for(int i = 0; i < items.size();i++) {
            if(items.get(i).weight < capacity) {
                sum += items.get(i).value;
                // System.out.println("item has weight " + items.get(i).weight);
                // System.out.println("item has value " + items.get(i).value);
                capacity -= items.get(i).weight;
                System.out.println("remaining capacity " + capacity);
                System.out.println("current sum " + sum);
            }
            else {
                // System.out.println("item has weight " + items.get(i).weight);
                // System.out.println("item has value " + items.get(i).value);
                //typecast the integers to double before dividing them   
                double frac = ((double)capacity/(double)items.get(i).weight);
                sum += (frac*items.get(i).value);
                // System.out.println("current sum " + sum);
                break;
            }
        }
        return sum;
    }

    public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
        int[][] V = new int[items.size()+1][capacity+1];
        // for(int[] v: V ) {
        //     Arrays.fill(v, -1);
        // }

        return optimumSubjectToItemCapacityIter(items, items.size(), capacity, V);
    }

    // top-down
    public static int optimumSubjectToItemCapacity(List<Item> items, int k,
        int availableCapacity, int[][] V) {
        if(k < 0) {
            return 0;
        }

        if(V[k][availableCapacity] == -1) {
            int withoutCurItem = optimumSubjectToItemCapacity(items, k-1, availableCapacity, V);
            int withCurItem = availableCapacity < items.get(k).weight
                ? 0
                : items.get(k).value
                    + optimumSubjectToItemCapacity(items, k-1, availableCapacity - items.get(k).weight, V);
            V[k][availableCapacity] = Math.max(withoutCurItem, withCurItem);
        }
        return V[k][availableCapacity];
    }

    // bottom - up
    public static int optimumSubjectToItemCapacityIter(List<Item> items, int k,
        int availableCapacity, int[][] V) {

        // for(int i = 1; i <= availableCapacity; i++) {
        //     if(items.get(0).weight <= i) {
        //         V[0][i] = items.get(0).value;
        //     }
        // }

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= availableCapacity; j++) {
                if(items.get(i-1).weight <= j) {
//                    System.out.println("newcapacity " + (availableCapacity-j));
                    V[i][j] = Math.max(V[i-1][j], V[i-1][j-items.get(i-1).weight] + items.get(i-1).value);
                }
                else {
                    V[i][j] = V[i-1][j];
                }
            }
        }
        return V[k][availableCapacity];
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item(20, 65), new Item(8, 35), new Item(60, 245), new Item(55, 195),
            new Item(40, 65), new Item(70, 150), new Item(85, 275),
            new Item(25, 155), new Item(30, 120), new Item(65, 320),
            new Item(75, 75), new Item(10, 40), new Item(95, 200),
            new Item(50, 100), new Item(40, 220), new Item(10, 99));
        System.out.println(optimumSubjectToCapacity(items, 130));
        //System.out.println(optimumSubjectToCapFraction(items, 130));
    }
}