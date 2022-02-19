
public class MergeSort {
	public static void main(String[] args) {
		printArr(new MergeSort().sort(new int[] {9, 6, 8, 7, 2, 5, 3 }));
	}

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public int[] sort(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];

		for (int i = 0; i < left.length; i++) {
			left[i] = arr[i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = arr[mid + i];
		}

		left = sort(left);
		right = sort(right);

		return merge(left, right);
	}

	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftPointer = 0;
		int rightPointer = 0;
		int resultPointer = 0;
		while (leftPointer < left.length || rightPointer < right.length) {
			if (leftPointer < left.length && rightPointer < right.length) {
				if (left[leftPointer] < right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				} else {
					result[resultPointer++] = right[rightPointer++];
				}
			} else if (leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			} else if (rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}

		return result;
	}

}
