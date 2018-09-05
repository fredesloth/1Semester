package model;

import java.util.ArrayList;

public class SortMethods {

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(String[] array) {
        for (int i = 0; i <= array.length; i++) {
            // laver 2 for løkkker, så den ikke behøver at løbe hele arrayet igennem efter
            // hver gang. Så den ikke skal starte forfra hver gang
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // swap temp and array[i]
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            String key = array[i];
            int j = i;

            /*
             * Move elements of arr[0..i-1], that are greater than key, to one position
             * ahead of their current position
             */

            while (i > 0 && array[j].compareTo(key) > 0) {
                array[j] = array[j + 1];
                j--;

            }
            array[j] = key;
        }
    }

    public static void selectionSortsCustomer(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size() - 1; i++) {
            for (int j = 0; j < customers.size() - i - 1; j++) {
                if (customers.get(j).compareTo(customers.get(j + 1)) < 0) {
                    String temp = customers.get(j).toString();
                    customers.get(j).equals(customers.get(j + 1));
                    customers.get(j + 1).equals(temp);
                }
            }
        }

    }

    // public static void selectionSort(String[] array) {
    // for (int i = 0; i < array.length; i++) {
    // int low = i;
    //
    // for (int j = i; j < array.length; j++) {
    // if (array[low].compareTo(array[j]) > 0) {
    // low = j;
    // }
    // }
    // swap(array, low, i);
    // }
    // }

    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void insertCustomer(ArrayList<Customer> customer) {
        for (int i = 0; i < customer.size(); i++) {
            // Se billede på telefon om opgaveløsning
        }
    }
}
