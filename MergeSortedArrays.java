import java.util.*;

public class MergeSortedArrays {
	private static class ArrayEntry {
		public Integer value;
		public Integer arrayId;

		public ArrayEntry(Integer value, Integer arrayId) {
			this.value = value;
			this.arrayId = arrayId;
		}
	}

	public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
		// iterator to move over different arrays.
		List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
		for(List<Integer> array: sortedArrays) {
			iters.add(array.iterator());
		}

		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>((int)sortedArrays.size(), new Comparator<ArrayEntry>() {
			@Override
			public int compare(ArrayEntry o1, ArrayEntry o2) {
				return Integer.compare(o1.value, o2.value);
			}
		});

		//intialize minheap with one entry each from different arrays.
		for(int i = 0; i < iters.size(); i++) {
			if(iters.get(i).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(i).next(), i));
			}
		}

		System.out.println()

		List<Integer> result = new ArrayList<>();
		while(!minHeap.isEmpty()) {
			ArrayEntry headEntry = minHeap.poll();
			result.add(headEntry.value);
			if(iters.get(headEntry.arrayId).hasNext()) {
				// add the element from the array from which we have added to result list
				minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId));
			}
		}
		return result;
	}

	public static void main(String[] args) {

		List<List<Integer>> s = Arrays.asList(Arrays.asList(1, 5, 10), Arrays.asList(2, 3, 100), Arrays.asList(2, 12, Integer.MAX_VALUE));
		List<Integer> ans = mergeSortedArrays(s);
		System.out.println(ans);
	}
}