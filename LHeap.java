import java.awt.*;
import java.lang.reflect.Array;
import java.util.PriorityQueue;

public class LHeap <Key extends Comparable<Key>>  extends Object {

    Key [] min_heap;

    int size;

    public LHeap(int capacity){
        size = 0;
        min_heap = (Key[]) new Comparable[capacity + 1];
    }


    public void Insert (Key k ){
        min_heap[++size] = k;
        swim(size);
    }

    public Key deleteMin(){

        Key min = min_heap[1];

        min_heap[1] = min_heap[size];

        min_heap[size--] = null;

        sink(1);

        return min;
    }


    // the smallest element swims up the heap
    private void swim (int k){

        while (k > 1 && less(k,k/2)){

            swap(k,k/2);

            k = k/2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {

            if ((min_heap[(2 * k) + 1] != null && less(2 * k, (2 * k) + 1))) {
                if (less(2 * k, k)) {
                    swap(k, 2 * k);
                    k = 2 * k;
                    continue;
                }
            }


            if (min_heap[(2 * k) + 1] != null && less((2 * k) + 1, k)) {
                swap((2 * k) + 1, k);
                k = (2 * k) + 1;
                continue;
            }

            if (less(2 * k, k)) {
                swap(k, 2 * k);
                k = 2 * k;
                continue;
            }

            break;
        }
    }



    // i is the index which is less
    private boolean less (int i , int j){
        return  min_heap[i].compareTo(min_heap[j]) < 0;
    }



    private void swap (int i, int j){

        Key temp = min_heap[i];
        min_heap[i] = min_heap[j];
        min_heap[j] = temp;
    }


    int length = 0;
    boolean flag = true;
    LHeap<Key> heap;
    static int k = 0;
    static int l = 0;
    static int m = 0;
    public  <T extends Comparable<T>> void sort(T[] a, int d)
    {

        if (flag) {
            heap = new LHeap<>(d + 1);
            length = a.length;
            flag = false;
        }

        if (length == 0){
            return;
        }


        heapify(a,d);

        // swap(a);

        length--;

        sort(a,d);

    }

    private <T extends Comparable<T>> void heapify (T[] a, int d){

        if(k + (d + 1) < a.length) {
            for (int i = 0; i < d + 1; i++) {
                heap.Insert((Key) a[k++]);
            }

            for (int i = 0; i < d + 1; i++) {
                a[l++] = (T) heap.deleteMin();
            }
        } else {
            for (int i = m; i < a.length ; i++) {
                heap.Insert((Key) a[k++]);
            }

            for (int i = m; i < a.length ; i++) {
                a[l++] = (T) heap.deleteMin();
            }
        }

        k = ++m;
        l = m;

    }

}
