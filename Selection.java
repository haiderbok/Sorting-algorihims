public class Selection extends Object  {

    public <T extends Comparable <? super T> > T [] selection_Sort(T [] arr){

        // boolean flag to see if we found the minimum element
        boolean flag = false;

        // Storing the minimum value
        T min = arr[0];

        // Temporary variable to store the variable being swapped
        T temp;

        // sorting the index of the minimum
        int index = 0;

        // for loops to compare the elements
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            min = arr[i];
            for (int j = i; j < arr.length - 1; j++) {

                // Finding the minimum element in the array
                if (arr[j + 1].compareTo(min) < 0){

                    min =  arr[j + 1];

                    index = j + 1;
                    flag = true;
                }
            }

            //swap
            if (flag) {
                temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }

        return  arr;
    }



}
