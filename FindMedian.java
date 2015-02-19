import java.util.*;

/**
 * Find median with max-heap and min-heap
 * O(1) find and O(logN) insert 
 *
 */
public class FindMedian {
	private static PriorityQueue<Integer> maxHeap, minHeap;
	private static int numOfElements = 0;

	public static void main(String[] args) {

		Comparator<Integer> revCmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return right.compareTo(left);
			}
		};

		// Or you can use Collections' reverseOrder method as follows.
		// Comparator<Integer> revCmp = Collections.reverseOrder();

		maxHeap = new PriorityQueue<Integer>(20, revCmp);
		minHeap = new PriorityQueue<Integer>(20);

		addNumber(6);
		addNumber(4);
		addNumber(3);
		addNumber(10);
		addNumber(12);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());

		addNumber(5);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());

		addNumber(7);
		addNumber(8);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());
	}

	/*
	 * Maintains a condition that maxHeap.size() >= minHeap.size()
	 * 1) the max-heap contains the smallest half of the numbers and min-heap contains the largest half
	 * 2) the number of elements in max-heap is either equal to or 1 more than the number of elements in the min-heap
	 */
	public static void addNumber(int value) {
		maxHeap.add(value);
		// If total number of elements in the heap is even before insertion,
		// then there are N elements both in max-heap and min-heap.
		// Insert to max-heap, result in max-heap has n+1 elements, but this is
		// valid since max-heap can contain 1 more element than min-heap
		if (numOfElements%2 == 0) {
			
			if (minHeap.isEmpty()) {
				numOfElements++;
				return;
			}
			// If the newly inserted value is larger than root of min-heap
			// we need to pop the root of min-heap and insert it to max-heap.
			// And pop root of max-heap and insert it to min-heap
			else if (maxHeap.peek() > minHeap.peek()) {
				Integer maxHeapRoot = maxHeap.poll();
				Integer minHeapRoot = minHeap.poll();
				maxHeap.add(minHeapRoot);
				minHeap.add(maxHeapRoot);
			} 
		} 
		// For this case, before insertion, max-heap has n+1 and min-heap has n elements.
		// After insertion, max-heap has n+2 and min-heap has n elements, so violate!
		// And we need to pop 1 element from max-heap and push it to min-heap
		else {
			minHeap.add(maxHeap.poll());
		}
		numOfElements++;
	}

	/*
	 * If maxHeap and minHeap are of different sizes, then maxHeap must have one
	 * extra element.
	 */
	public static double getMedian() {
		if (numOfElements%2 != 0)		// If total number received is not even
			return new Double(maxHeap.peek());
		else
			return (maxHeap.peek() + minHeap.peek()) / 2.0; 
	}
}
