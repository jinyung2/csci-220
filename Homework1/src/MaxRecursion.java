public class MaxRecursion<E extends Comparable<E>> {
    public E max(E[] e, int size, int n){
        if (n==size-1){
            return e[n];
        }
        else if (e[n].compareTo(e[size-1]) < 0){
            return max(e, size, n+1);
        }
        else{
            return max(e,size-1, n);
        }
    }

}
/*
R-3.11 The recursive algorithm would involve comparing the first value and the last value in the array, if the first value is bigger, check last - 1 value. if last value is greater, check first + 1 value. have a base case where the index of the first and last is same in which it returns the max element.
 */