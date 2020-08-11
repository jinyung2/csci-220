/*  Java Class: TextEditor.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/18/2017
    Description: A simple text editor with methods to move left, move right, insert and delete a character.

    I certify that the code below is my own work.

	Exception(s): N/A

*/


public class TextEditor {
    private static Position<Character> p;
    private static LinkedPositionalList<Character> list = new LinkedPositionalList<>();
    final static Character CURSOR = '>';

    public static void main(String[] args) {
        p = list.addFirst(CURSOR);
        System.out.println("\n" + list.toString());
        insert('A');
        insert('B');
        insert('C');
        insert('D');
        right();
        left();
        delete();
        delete();
        left();
        left();
        delete();
    }
    public static void left(){  // move cursor left
        System.out.println("Move Cursor Left:");
        if (list.before(p) == null){
            System.out.println("The cursor is already at the leftmost position.\n");
            return;
        }
        else{
            System.out.println("Moving the cursor left.");
            Character temp = list.before(p).getElement();
            p = list.before(p);
            list.set(p, CURSOR);
            list.set(list.after(p), temp);
            System.out.println(list.toString() + "\n");
        }
    }
    public static void right(){ // move cursor right
        System.out.println("Move Cursor Right:");
        if(list.after(p) == null){
            System.out.println("The cursor is already at the rightmost position.\n");
            return;
        }
        else{
            System.out.println("Moving the cursor right.");
            Character temp = list.after(p).getElement();
            p = list.after(p);
            list.set(p, CURSOR);
            list.set(list.before(p), temp);
            System.out.println(list.toString() + "\n");
        }
    }
    public static void delete(){ // deletes the character right of cursor
        System.out.println("Deleting Character Right of Cursor:");
        if (list.after(p) == null){
            System.out.println("There is no element to delete.\n");
            return;
        }
        else{
            list.remove(list.after(p));
            System.out.println(list.toString() + "\n");
        }
    }
    public static void insert(Character c){ // insert c after cursor.
        System.out.println("Inserting element after the cursor.");
        list.addBefore(p, c);
        System.out.println(list.toString()+"\n");
    }
}
