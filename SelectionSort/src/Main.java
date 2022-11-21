import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int argsCount = args.length;
        for (int i = 0; i < argsCount; i++) {
            System.out.print(args[i] + ' ');
        }
        int[] arr = {1, 10, 0 ,8, 7, -1, 2, 1, 1, 15};
        System.out.println("\nInitial array:" + Arrays.toString(arr));
        Sorter sorter = new Sorter();
        sorter.selectionSort(arr);
        System.out.println("\nSorted array:" + Arrays.toString(arr));
    }
}