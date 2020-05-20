package 基本算法.basic_class_01;

public class Code_test {
	
	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		int[] arr = {47,23 ,58 ,-61 ,29 ,63 ,-13 ,-21 ,-76 ,6 ,43 ,-84 ,34 ,-42 ,-21 ,17 ,33 ,7 ,7 ,-73,-53,23,-34};
		mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("耗时为：" + (System.currentTimeMillis() - start));
		
//		String str = "ssss=%s,,,,%s";
//		System.out.println(str.format(str, "jay"));
	}

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
	}
}
