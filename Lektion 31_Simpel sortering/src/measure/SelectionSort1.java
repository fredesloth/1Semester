package measure;

import java.util.Arrays;

public class SelectionSort1 {

    public static void main(String[] args) {
        String[] s = { "F", "C", "A", "B", "D" };
        System.out.println(Arrays.toString(s));
        SortMethods.bubbleSort(s);
        System.out.println(Arrays.toString(s));

        String[] s1 = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul",
                "Torkild" };

        System.out.println(Arrays.toString(s1));
        SortMethods.selectionSort(s1);
        System.out.println(Arrays.toString(s1));

    }

}
