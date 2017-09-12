import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
        computeTowerOfHanoi(4);
    }

    private static final int NUM_PEGS = 3;

    public static void computeTowerOfHanoi(int numOfRings) {
        List<Deque<Integer>> pegs = new ArrayList<>();
        for(int i = 0; i < NUM_PEGS; i++) {
            pegs.add(new LinkedList<Integer>());
        }
        for(int i = numOfRings; i>=1; --i) {
            pegs.get(0).addFirst(i);
        }
        computeTowerOfHanoiSteps(numOfRings, pegs, 0, 1, 2);
    }

    public static void computeTowerOfHanoiSteps(int numOfRingsToMove, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {
        if(numOfRingsToMove > 0) {
            computeTowerOfHanoiSteps(numOfRingsToMove-1, pegs, fromPeg, usePeg, toPeg);
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move from pegs " + fromPeg + " to peg " + toPeg); 
            computeTowerOfHanoiSteps(numOfRingsToMove-1, pegs, usePeg, toPeg, fromPeg);
        }
    }
}