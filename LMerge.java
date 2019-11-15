public class LMerge extends Object {



    public <K extends Comparable<? super K>> void lmerge_Sort(K arr[], int length, int d) {

        //Base case when there is only one element in the sub arrays
        if (length < 2) {
            return;
        }


        // mid variable to split the array
        int mid = length / 2;

        // create two arrays left and right
        K[] left = (K[]) new Comparable[mid];
        K[] right = (K[]) new Comparable[length - mid];

        //save all the elements left of the mid in the right array
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        // save all the elements into the right array
        for (int i = mid; i < length; i++) {
            right[i - mid] = arr[i];
        }

        // call merge sort with the left array and the length to be the mid
        lmerge_Sort(left, mid, d);

        // call merge sort with the right array and the length to be the length - mid
        lmerge_Sort(right, length - mid, d);


        // call the merge function to merge the two arrays
        merge(arr, left, right, d);


    }



    int main = 0; // to increment the main array
    public <T extends Comparable<? super T>> void merge(T[] arr, T[] left, T[] right, int d) {




    }
}
