import java.util.*;

public class GeneratePowerSet {
	public static void main(String[] args) {
		List<Integer> inputSequence = Arrays.asList(0,1,2);
		List<List<Integer>> powerSet = new ArrayList<>();
		generatePowerSet(inputSequence, powerSet);

		for(int i = 0; i < powerSet.size(); i++) {
			System.out.println(powerSet.get(i));
		}
	}

	public static void generatePowerSet(List<Integer> inputSequence, List<List<Integer>> powerSet) {
		List<Integer> sequenceAsOfNow = new ArrayList<>();
		directPowerSet(inputSequence, 0, sequenceAsOfNow, powerSet);
	}

	public static void directPowerSet(List<Integer> inputSequence, int sequenceOrder, List<Integer> sequenceAsOfNow, List<List<Integer>> powerSet) {

		if(sequenceOrder == inputSequence.size()) {
			powerSet.add(new ArrayList<Integer>(sequenceAsOfNow));
			return;
		}

		// System.out.println("sequenceOrder: " + sequenceOrder);
		sequenceAsOfNow.add(inputSequence.get(sequenceOrder));
		// System.out.println("sequenceAsOfNow Before: " + sequenceAsOfNow);
		directPowerSet(inputSequence, sequenceOrder+1, sequenceAsOfNow, powerSet);
		sequenceAsOfNow.remove(sequenceAsOfNow.size()-1);
		// System.out.println("sequenceAsOfNow After: " + sequenceAsOfNow);
		directPowerSet(inputSequence, sequenceOrder+1, sequenceAsOfNow, powerSet);
	}
}