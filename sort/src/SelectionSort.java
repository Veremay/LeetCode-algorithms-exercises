import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 找到未排序部分的最小值下标
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 将最小值换到已排序部分末尾
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
            System.out.println(Arrays.toString(arr));

        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前: " + java.util.Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("排序后: " + java.util.Arrays.toString(arr));
    }
}