public class Sorter {
    public Sorter() {
    }

    private void swapArrayElements(int[] arr, int index1, int index2) {
        int t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }
    public void selectionSort(int[] arr) {
        int length = arr.length;
        int min;
        int minIndex;
        for (int i = 0; i < length; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swapArrayElements(arr, i, minIndex);
        }
    }
}
