
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {98,21,65,87,32,65,54,98,87,21,54,65,23};
		arr = new QuickSort().quickSort(arr, 0, arr.length-1);
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}

	public int[] quickSort(int[] arr, int start, int end) {
		int pivot = partition(arr, start, end);
		if(start<pivot-1) {
			quickSort(arr, start, pivot-1);
		}
		if(end>pivot) {
			quickSort(arr, pivot, end);
		}
		return arr;
		

	}

	public int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
}
