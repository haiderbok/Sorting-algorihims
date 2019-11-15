public class LSelection extends Object {

public <T extends Comparable<? super T>> void lselection_Sort(T [] arr, int d){
    int index = 0;

    T temp;

    for (int i = 0; i < arr.length - 1; i++) {
        index = find_Min(arr,d,i);

        temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

}


private <T extends Comparable<? super T>> int find_Min(T [] arr, int d, int start_index){

    int min = start_index;


    if (!((start_index + d) >= arr.length)) {
        for (int i = (start_index); i < (start_index + d); i++) {

            if (arr[i + 1].compareTo(arr[start_index]) < 0) {
                min = i + 1;
            }
        }
    } else {
        for (int i = start_index; i < arr.length - 1 ; i++) {
            if (arr[i + 1].compareTo(arr[start_index]) < 0) {
                min = i + 1;
            }
        }
    }

    return min;
}

}
