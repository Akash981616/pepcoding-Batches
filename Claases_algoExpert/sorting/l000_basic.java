public class l000_basic {
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Actual Algo -> avg : O(N2) , best : O(N2)
  // modified Algo ->avg : O(N2) , best : O(N)
  public static int[] bubbleSort(int[] array) {
    int n = array.length;
    if (n <= 1)
      return array;

    for (int i = 0; i < n; i++) {
      boolean isEleSwapped = false;
      for (int j = 1; j < n - i; j++) {
        if (array[j] < array[j - 1]) {
          isEleSwapped = true;
          swap(array, j, j - 1);
        }
      }
      if (!isEleSwapped)
        break;
    }

    return array;
  }

  // avg : O(N2) , best : O(N2)
  public static int[] selectionSort(int[] array) {
    int n = array.length;
    if (n <= 1)
      return array;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[i]) {
          swap(array, j, i);
        }
      }
    }

    return array;
  }

  // avg : O(N2) , best : O(N)
  public static int[] insertionSort(int[] array) {
    int n = array.length;
    if (n <= 1)
      return array;

    for (int i = 1; i < n; i++) {
      for (int j = i; j > 0; j--) {
        if (array[j - 1] > array[j]) {
          swap(array, j, j - 1);
        } else
          break;
      }
    }

    return array;
  }

  // Time : O(n), Space : O(1)
  public static void sort01(int[] arr) {
    int pt = -1, idx = 0, n = arr.length;
    while (idx < n) {
      if (arr[idx] == 0) {
        swap(arr, idx, ++pt);
      }
      idx++;
    }
  }

  // Time : O(n), Space : O(1)
  public static void sort012(int[] arr) {
    int n = arr.length, pt1 = -1, pt2 = n, idx = 0;
    while (idx < pt2) {
      if (arr[idx] == 0)
        swap(arr, idx++, ++pt1);
      else if (arr[idx] == 1)
        idx++;
      else
        swap(arr, --pt2, idx);
    }
  }

  // Time : O(n), Space : O(1)
  public int[] threeNumberSort(int[] array, int[] order) {
    int n = arr.length, pt1 = -1, pt2 = n, idx = 0;
    while (idx < pt2) {
      if (arr[idx] == -1)
        swap(arr, idx++, ++pt1);
      else if (arr[idx] == 0)
        idx++;
      else
        swap(arr, --pt2, idx);
    }
  }

  // merge Two Sorted Arrays
  public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
    int n = arr1.length, m = arr2.length;
    if (n == 0 || m == 0)
    return n == 0 ? arr2 : arr1;

    int[] ans = new int[n + m];
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {
      if (arr1[i] < arr2[j])
        ans[k++] = arr1[i++];
      else
        ans[k++] = arr2[j++];
    }

    while (i < n)
      ans[k++] = arr1[i++];
    while (j < m)
      ans[k++] = arr2[j++];

    return ans;
  }

  public static int[] mergeSort(int[] arr, int li, int ri) {
    if (li == ri) {
      int[] base = new int[1];
      base[0] = arr[li];
      return base;
    }

    int mid = (li + ri) / 2;
    return mergeTwoSortedArrays(mergeSort(arr, li, mid), mergeSort(arr, mid + 1, ri));
  }

  public static int[] mergeSort(int[] array) {
    int n = array.length;
    if (n <= 1)
      return array;
    return mergeSort(array, 0, n - 1);
  }

}
