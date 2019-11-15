public class Quick extends Object {

public <T extends Comparable<? super T>> void quick_sort(T [] arr , int low, int high){

    if (low < high)
    {
            /* pi is partitioning index, arr[pi] is
              now at right place */
        int pi = partiton(arr, low, high);

        // Recursively sort elements before
        // partition and after partition
        quick_sort(arr, low, pi-1);
        quick_sort(arr, pi+1, high);
    }





}

private <T extends Comparable<? super T>> int partiton(T arr[], int low , int high){

    T pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j].compareTo(pivot) < 0){
            i++;

            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    T temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i+1;
}

}
