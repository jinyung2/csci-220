/*  Java Class: AVLNode.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/04/17
    Description: The Node used in the AVL Tree implementation. Holds various data for population database within record and holds variables for its height, parent nodes and left right children nodes.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class AVLNode {
    private Record record;
    private AVLNode parent;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(Record record){
        this.record = record;
        this.height = 0;
    }

    public AVLNode getParent() {
        return parent;
    }

    public void setParent(AVLNode parent) {
        if(this != parent){
            this.parent = parent;
        }
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        if (this != left){
            this.left = left;
        }
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        if(this != right){
            this.right = right;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer computeHeight(){
        Integer currentHeight = Math.max(left != null ? left.computeHeight() : -1, right != null ? right.computeHeight() : -1) + 1;
        this.height = currentHeight;
        return currentHeight;
    }




    public void remove(AVLNode node){
        if (left != null && left == node){
            this.setLeft(null);
        }
        else if(right != null && right == node){
            this.setRight(null);
        }
    }
}
