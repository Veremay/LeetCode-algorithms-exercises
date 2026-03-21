public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 当前要插入的元素
            int j = i - 1;
            // 将比 key 大的元素依次后移
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 将 key 插入正确位置
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前: " + java.util.Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("排序后: " + java.util.Arrays.toString(arr));
    }
}