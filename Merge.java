public class Merge extends Object{

    public <K extends Comparable <? super K>> void merge_Sort (K [] arr , int length){

        //Base case when there is only one element in the sub arrays
        if (length < 2)  {
            return;
        }


        // mid variable to split the array
        int mid = length / 2;

        // create two arrays left and right
        K [] left = (K[]) new Comparable[mid];
        K [] right = (K[]) new Comparable[length - mid];

        //save all the elements left of the mid in the right array
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        // save all the elements into the right array
        for (int i = mid; i < length; i++) {
            right[i - mid] = arr[i];
        }

        // call merge sort with the left array and the length to be the mid
        merge_Sort(left,mid);

        // call merge sort with the right array and the length to be the length - mid
        merge_Sort(right,length - mid);


        // call the merge function to merge the two arrays
        merge(arr,left,right,mid,length - mid);

    }

    public <T extends Comparable<? super T>> void merge (T []arr , T [] left , T [] right,  int l, int r){

        // to iterate the left array
        int lit = 0;

        // to iterate the right array
        int rit =0;

        // to iterate through the main array
        int main = 0;

        // when both the lit and rit are less than the respective lengths
        while (lit < l && rit < r){

            // check if the element in left sub array is less than that of the right one
            if (left[lit].compareTo(right[rit]) <= 0){
                arr[main++] = left[lit++];
            } else {
                arr[main++] = right[rit++];
            }
        }
        // after one of the array inserted just insert the other one
        while(lit < l){
            arr[main++] = left[lit++];
        }

        while (rit < r){
            arr[main++] = right[rit++];
        }

    }

}

