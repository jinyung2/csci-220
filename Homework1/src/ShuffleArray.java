import java.util.Random;

public class ShuffleArray {

    public void shuffle(int[] a) { // a is array with 1~52 int values in that order.
        Random n = new Random();
        int[] array = new int[52]; // creates new array filled with 0's.
        int i = 0; // counter variable
        while (i < 52){
            int index = n.nextInt(52);
            if (array[index] == 0){ // checks if random index is empty
                array[index] = a[i]; // ie. a[1] = 2, i[2] = 3 etc..
                i++;
            }
        }
    }
}

/*
Start with an array with 1~52 int values. created a new array that will take in the values at a random index. Have a conditional to check if the randomly generated index of the new array is set to 0 (initializing a fixed capacity int array fills the values with 0s, so checking if the array value is 0 will indicate whether is is "empty" or not). If the array is empty, fill the random index with the first value in the 1~52 array and increment the counter that references the index of that array so you get the next number.
 */
