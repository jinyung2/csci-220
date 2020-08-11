import java.util.Iterator;

public class TreeDriver {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        System.out.println("Checks if new tree is empty: ");
        System.out.println(tree.isEmpty());
        System.out.println("Adding a root with the String 'Jin' and setting a position p to it. Output of root element: ");
        tree.addRoot("Jin");
        Position<String> p = tree.root();
        System.out.println(p.getElement());
        System.out.println("Adding 'John' and 'Jawn' as the left and right child respectively. ");
        tree.addLeft(p,"John");
        tree.addRight(p, "Jawn");
        System.out.println("Setting position to left child.");
        p = tree.left(p);
        System.out.println("Outputting the current position's element: ");
        System.out.println(p.getElement());
        System.out.println("Outputting tree size: ");
        System.out.println(tree.size());
        System.out.println("Testing the parent method, outputting parent of left child: ");
        System.out.println(tree.parent(p).getElement());
        System.out.println("Outputting sibling of the left child: ");
        System.out.println(tree.sibling(p).getElement());
        System.out.println("Removing the current position. Returns the removed element: ");
        System.out.println(tree.remove(p));
        System.out.println("Outputting new size: ");
        System.out.println(tree.size());
        System.out.println("Removing the root element: ");
        System.out.println(tree.remove(tree.root()));
        System.out.println("Checking to see if tree is empty: ");
        System.out.println(tree.isEmpty());
        System.out.println("Outputs to check for new root. ");
        System.out.println(tree.root().getElement());
        System.out.println("Setting p to the root, removing the root element: ");
        p = tree.root();
        System.out.println(tree.remove(p));
        System.out.println("Once again running an empty check.");
        System.out.println(tree.isEmpty());
        System.out.println("Current size of tree: " + tree.size());
        System.out.println("Now testing methods inherited from AbstractTree  and AbstractBinaryTree classes. Adding a number of elements to test this.");
        tree.addRoot("Clayton Kershaw");
        p = tree.root();
        tree.addLeft(p,"Rich Hill");
        tree.addRight(p, "Yu Darvish");
        Position<String> q = tree.right(p);
        p = tree.left(p);
        tree.addLeft(p, "Alex Wood");
        tree.addRight(p, "Brandon McCarthy");
        tree.addLeft(q, "Fat Ryu");
        tree.addRight(q, "Kenta Maeda");
        Iterator<Position<String>> iterPost = tree.postorder().iterator();
        Iterator<Position<String>> iterPre = tree.preorder().iterator();
        Iterator<Position<String>> iterBre = tree.breadthfirst().iterator();
        Iterator<Position<String>> iterIn = tree.inorder().iterator();
        System.out.println("Added various pitchers for the Los Angeles Dodgers. Testing various cases: ");
        System.out.println("\n1.Trying the for each method of the tree.");
        for(String s:tree){
            System.out.println(s);
        }
        System.out.println("\n2.Running the postorder method from AbstractTree and outputting its contents in order.");
        while(iterPost.hasNext()){
            System.out.println(iterPost.next().getElement());
        }
        System.out.println("\n3.Running the preorder method from AbstractTree and outputting contents.");
        while(iterPre.hasNext()){
            System.out.println(iterPre.next().getElement());
        }
        System.out.println("\n4.Running the breadthfirst method from AbstractTree and outputting contents.");
        while(iterBre.hasNext()){
            System.out.println(iterBre.next().getElement());
        }
        System.out.println("\n5. Running the inorder method from the AbstractBinaryTree and outputting contents.");
        while(iterIn.hasNext()){
            System.out.println(iterIn.next().getElement());
        }
    }
}
