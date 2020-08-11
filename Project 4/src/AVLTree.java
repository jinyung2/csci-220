/*  Java Class: AVLTree.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/4/17
    Description: The AVL Tree implementation.

    I certify that the code below is my own work.

	Exception(s): N/A

*/
public class AVLTree {
    private AVLNode root;
    private int size;
    private int time;

    public AVLNode getRoot() {
        return root;
    }

    public int getSize(){
        return size;
    }

    public int getTime(){
        return time;
    }

    public int count(AVLNode node){
        if (node == null){
            return 0;
        }
        else{
            int count = 1;
            count += count(node.getLeft());
            count += count(node.getRight());
            return count;
        }
    }

    public Record search(AVLNode node, Integer code){
        AVLNode result = find(node, code);
        if (result != null) {
            System.out.println("Record found: ");
            return result.getRecord();
        }
        else{
            System.out.println("Record not found. \n");return null; }
    }

    public void insert(AVLNode node, Record record){
        AVLNode result = null;
        node = find(node, record.getCode());
        if (node == null){
            node = findLeaf(root,record.getCode());
            if(node == null){
                node = new AVLNode(record);
                root = node;
            }
            else if (node.getRecord().getCode() > record.getCode()){
                AVLNode leftChild = new AVLNode(record);
                result = leftChild;
                node.setLeft(leftChild);
                leftChild.setParent(node);
            }
            else{
                AVLNode rightChild = new AVLNode(record);
                result = rightChild;
                node.setRight(rightChild);
                rightChild.setParent(node);
            }
            size++;
        }
        if (root != null){root.computeHeight();}
        Balancer(result);

    }

    public Record remove(AVLNode node, Integer code){
        AVLNode result = find(node, code);
        Record removed = result != null ? result.getRecord() : null;
        if (result != null){ //assumes you've found a the node with the searched code to remove.
            if(result.getLeft() == null && result.getRight() == null){ //if the node found has no children (is external)
                if(result.getParent() == null){ //if the parent node is null then it is root, so remove root and now you have an empty AVL tree.
                    root = null;
                }
                else{ // there exists a parent, it is not the root
                    result.getParent().remove(result); // run the remove command from AVLNode class.
                }
            }
            else if (result.getLeft() == null){
                AVLNode resultParent = result.getParent();
                result = result.getRight();

                result.setParent(resultParent);
                resultParent.setRight(result);
            }
            else {
                AVLNode lesserMax = findLesserMax(result);
                AVLNode lesserMaxParent = lesserMax.getParent();

                AVLNode resultParent = result.getParent();
                AVLNode resultLeft = result.getLeft();
                AVLNode resultRight = result.getRight();

                result.setParent(null);
                result.setLeft(null);
                result.setRight(null);

                lesserMax.setLeft(resultLeft);
                lesserMax.setRight(resultRight);
                lesserMax.setParent(resultParent);
                lesserMaxParent.setRight(null);
                if (resultRight != null){
                    resultRight.setParent(lesserMax);
                }
                if (resultLeft != null){
                    resultLeft.setParent(lesserMax);
                }
                if(resultParent == null){
                    root = lesserMax;
                }
                else if(resultParent.getLeft() == result){
                    resultParent.setLeft(lesserMax);
                }
                else {
                    resultParent.setRight(lesserMax);
                }
            }
            size--;
            if (root != null){ root.computeHeight(); }
            Balancer(result.getParent());
        }
        else{
            System.out.println("Record not found. ");
        }
        return removed;
    }

    public void printAll(){  // Graphical drawing of tree
        System.out.println();
    }

    void debug(AVLNode node){
        if(node.getLeft()!=null){
            debug(node.getLeft());
        }
        System.out.println(node.getRecord().toString());
        if(node.getRight()!=null){
            debug(node.getRight());
        }
    }

    private AVLNode find(AVLNode node, Integer code){
        time = 3;
        AVLNode result = null;
        if (node != null){
            if (node.getRecord().getCode().equals(code)){
                result = node;
                time = 1;
            }
            else if(node.getRecord().getCode() > code ){
                result = find(node.getLeft(),code);
                time += 2;
            }
            else {
                result = find(node.getRight(),code);
                time += 2;
            }
        }
        return result;
    }

    private AVLNode findLeaf(AVLNode node, Integer code){
        AVLNode result = node;
        if (node != null){
            if (node.getRecord().getCode() > code){
                if(node.getLeft()!= null){
                    result = findLeaf(node.getLeft(),code);
                }
            }
            else{
                if (node.getRight() != null){
                    result = findLeaf(node.getRight(),code);
                }
            }
        }
        return result;
    }

    private AVLNode findLesserMax(AVLNode node){
        AVLNode result = null;
        if (node.getLeft()!=null){
            result = node.getLeft();
        }
        if (result != null) {
            while(result.getRight() != null){
                result = result.getRight();
            }
        }
        return result;
    }

    private boolean isBalanced(AVLNode node){ // does this work?
        if (node.getLeft()==null && node.getRight()== null){
            return true;
        }
        else if (node.getLeft() == null){
            return node.getRight().getHeight() <= 0;
        }
        else if(node.getRight() == null){
            return node.getLeft().getHeight() <= 0;
        }
        else{
            return Math.abs(node.getLeft().getHeight()-node.getRight().getHeight()) <= 1;
        }
    }
    private int getHeight(AVLNode node){return node == null ? -1 : node.getHeight(); }

    private void Balancer(AVLNode node){
        while(node!=null){
            if (node.getParent()!= null){
                AVLNode parent = node.getParent();
                AVLNode grandParent = parent.getParent();
                if (!isBalanced(parent)){
                    if (grandParent == null){
                        if(getHeight(parent.getLeft())<getHeight((parent.getRight()))){
                            rotateLeft(node);
                            root = node;
                        }
                        else{
                            rotateRight(node);
                            root = node;
                        }
                    }
                    else if (grandParent.getLeft()==parent){
                        if (getHeight(parent.getLeft())<getHeight(parent.getRight())){
                            rotateLeft(node);
                        }
                        rotateRight(node);
                    }
                    else{
                        if (getHeight(parent.getLeft())>getHeight(parent.getRight())){
                            rotateRight(node);
                        }
                        rotateLeft(node);
                    }
                }
            }
            node = node.getParent();
        }

    }

    private void rotateLeft(AVLNode node){
        AVLNode parent = node.getParent();
        AVLNode grandParent = parent.getParent();
        AVLNode leftChild = node.getLeft();
        AVLNode rightChild = node.getRight();
        node.setLeft(parent);
        if(leftChild != null){
            leftChild.setParent(parent);
        }
        parent.setRight(leftChild);
        parent.setParent(node);
        node.setParent(grandParent);
        if(grandParent != null){
            if (grandParent.getRight().equals(parent)){
                grandParent.setRight(node);
            }
            else{
                grandParent.setLeft(node);
            }
        }
        else{
            root = node;
        }
        if(root!=null){root.computeHeight();}
    }
    private void rotateRight(AVLNode node){
        AVLNode parent = node.getParent();
        AVLNode grandParent = parent.getParent();
        AVLNode leftChild = node.getLeft();
        AVLNode rightChild = node.getRight();
        node.setRight(parent);
        if (rightChild != null){
            rightChild.setParent(parent);
        }
        parent.setLeft(rightChild);
        parent.setParent(node);
        node.setParent(grandParent);
        if(grandParent != null){
            if(grandParent.getRight().equals(parent)){
                grandParent.setRight(node);
            }
            else{
                grandParent.setLeft(node);
            }
        }
        else{
            root = node;
        }
        if (root!=null){root.computeHeight();}
    }

}
