// --== CS400 File Header Information ==--
// Name: YoonChae Na
// Email: yna23@wisc.edu
// Team: DE
// TA: Daniel
// Lecturer: Florian
// Notes to Grader: N/A

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;


/**
 * Red-Black Tree implementation with a Node inner class for representing
 * the nodes of the tree. Currently, this implements a Binary Search Tree that
 * we will turn into a red black tree by modifying the insert functionality.
 * In this activity, we will start with implementing rotations for the binary
 * search tree insert algorithm. You can use this class' insert method to build
 * a regular binary search tree, and its toString method to display a level-order
 * traversal of the tree.
 */
public class RedBlackTree<T extends Comparable<T>> implements SortedCollectionInterface<T> {

    /**
     * This class represents a node holding a single value within a binary tree
     * the parent, left, and right child references are always maintained.
     */
    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild; 
        public Node<T> rightChild; 
        public Node(T data) { this.data = data; }
        public boolean isBlack = false; //Specification 1
        
        /**
         * @return true when this node has a parent and is the left child of
         * that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }
        /**
         * This method performs a level order traversal of the tree rooted
         * at the current node. The string representations of each data value
         * within this tree are assembled into a comma separated string within
         * brackets (similar to many implementations of java.util.Collection).
         * Note that the Node's implementation of toString generates a level
         * order traversal. The toString of the RedBlackTree class below
         * produces an inorder traversal of the nodes / values of the tree.
         * This method will be helpful as a helper for the debugging and testing
         * of your rotation implementation.
         * @return string containing the values of this tree in level order
         */
        @Override
        public String toString() {
            String output = "[";
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this);
            while(!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if(next.leftChild != null) q.add(next.leftChild);
                if(next.rightChild != null) q.add(next.rightChild);
                output += next.data.toString();
                if(!q.isEmpty()) output += ", ";
            }
            return output + "]";
        }
    }

    protected Node<T> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree
    
    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree. After  
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException when the provided data argument is null
     * @throws IllegalArgumentException when the newNode and subtree contain
     *      equal data references
     */
    @Override
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
        // null references cannot be stored within this tree
        if(data == null) throw new NullPointerException(
            "This RedBlackTree cannot store null references.");

        Node<T> newNode = new Node<>(data);
        if(root == null) { 
        	root = newNode;
        	root.isBlack = true;//Specification 2
        	size++; 
        	return true; } // add first node to an empty tree
        else{
            boolean returnValue = insertHelper(newNode,root); // recursively insert into subtree
            if (returnValue) {
            	size++;
            }
            
            
            else throw new IllegalArgumentException(
	    	"This RedBlackTree already contains that value.");
            return returnValue;
        }
    }

    /** 
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the 
     *      newNode should be inserted as a descenedent beneath
     * @return true is the value was inserted in subtree, false if not
     */
    private boolean insertHelper(Node<T> newNode, Node<T> subtree) {
        int compare = newNode.data.compareTo(subtree.data);
        // do not allow duplicate values to be stored within this tree
        if(compare == 0) return false;

        // store newNode within left subtree of subtree
        else if(compare < 0) {
            if(subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);//Specification 4
                return true;
            // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.leftChild);
        }

        // store newNode within the right subtree of subtree
        else { 
            if(subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);//Specification 4
                return true;
            // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.rightChild);
        }
    }
    
    private void enforceRBTreePropertiesAfterInsert (Node<T> newNode) {
    	 if (newNode == root) {//root is one of end condition for recursive
    	      newNode.isBlack = true;
    	      return;
    	    }
    	    if (!(!newNode.isBlack && !newNode.parent.isBlack)) {
    	      return;
    	    }

    	    boolean uncleIsRight;
    	    Node<T> grandparent = newNode.parent.parent;
    	    Node<T> parent = newNode.parent;
    	    Node<T> uncleNode;
    	    if (parent == grandparent.leftChild) {
    	      uncleIsRight = true;
    	      uncleNode = grandparent.rightChild;
    	    } else {
    	      uncleIsRight = false;
    	      uncleNode = grandparent.leftChild;
    	    }

    	    if (uncleNode == null || uncleNode.isBlack) {

    	      if ((newNode == parent.rightChild && uncleIsRight)  // Case 2
    	          || (newNode == parent.leftChild && !uncleIsRight)) {
    	        rotate(newNode, parent);
    	        rotate(newNode, grandparent);
    	        newNode.isBlack = true;
    	        grandparent.isBlack = false;

    	      } else {// Case 1
    	        
    	        rotate(parent, grandparent);
    	        parent.isBlack = true;
    	        grandparent.isBlack = false;
    	      }

    	    } else { // Case 3    	      
    	      grandparent.isBlack = false;
    	      parent.isBlack = true;
    	      uncleNode.isBlack = true;
    	      enforceRBTreePropertiesAfterInsert(grandparent); //Recursive

    	    }
    	
    }
     	
    
    
    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * rightChild of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
        // TODO: Implement this method.
    	if(parent.leftChild == child) {
    		//right rotation
    		if(child.rightChild!=null) {
    			child.rightChild.parent=parent;
    			parent.leftChild=child.rightChild;    			
    		}
    		else {
    			parent.leftChild=child.rightChild; 
    		}
    		
    		child.parent=parent.parent;
    		
    		if(parent.parent==null)
    			root=child;
    		else if (parent.parent.leftChild==parent)
    			parent.parent.leftChild = child;
    		else
    			parent.parent.rightChild= child;
    		
    		parent.parent=child;
    		child.rightChild=parent;
    		}
    	
    	
    	else if (parent.rightChild==child) {
    		//left rotation
    		if(child.leftChild!=null) {
    			child.leftChild.parent=parent;
    			parent.rightChild=child.leftChild;    	
    		}
    		else {
    			parent.rightChild=child.leftChild;
    		}
    		
    		child.parent=parent.parent;
    		
    		if(parent.parent==null)
    			root=child;
    		else if (parent.parent.leftChild==parent)
    			parent.parent.leftChild = child;
    		else
    			parent.parent.rightChild= child;
    		
    		parent.parent=child;
    		child.leftChild=parent;
    		}
   
    	else {
    		throw new IllegalArgumentException();
    	}
    }
    
    
    

    // Add at least 3 JUnit5 test methods with the test annotation similar to
    // the one from the comment below. You can use your notes from lecture for
    // ideas on concrete examples of rotation to test for. Make sure to include
    // rotations within and at the root of a tree in your test cases.   
 
    /*
    @Test
	public void test1() {
		//check right Rotation
		RedBlackTree A = new RedBlackTree();
 		Node b1 = new Node(1);
   		Node b2 = new Node(2);
   		Node b3 = new Node(3);
   		Node b4 = new Node(4);
   		Node b5 = new Node(5);
   		Node b6 = new Node(6);
   		Node b7 = new Node(7);
   		
   		A.root=b1;
   		A.root.leftChild=b2;
   		A.root.rightChild=b3;   		
   		A.root.leftChild.leftChild=b4;
   		A.root.leftChild.rightChild=b5;
   		A.root.rightChild.leftChild=b6;
   		A.root.rightChild.rightChild=b7;
		
   		A.rotate(A.root.rightChild,A.root);
   		
   		
   		//if(b6==A.root.leftChild.rightChild)
   			//System.out.println("yes");
   		assertEquals(A.root.rightChild,b6);	
   		//fail("This test has not been implemented3.");	
		
  			
	}
    
    @Test
   	public void test2() {
   	//check right Rotation
   		RedBlackTree A = new RedBlackTree();
 		Node b1 = new Node(1);
   		Node b2 = new Node(2);
   		Node b3 = new Node(3);
   		Node b4 = new Node(4);
   		Node b5 = new Node(5);
   		Node b6 = new Node(6);
   		Node b7 = new Node(7);
   		
   		A.root=b1;
   		A.root.leftChild=b2;
   		A.root.rightChild=b3;   		
   		A.root.leftChild.leftChild=b4;
   		A.root.leftChild.rightChild=b5;
   		A.root.rightChild.leftChild=b6;
   		A.root.rightChild.rightChild=b7;

    		
   		A.rotate(A.root.leftChild,A.root);
   
   		
   		//if(b5==A.root.rightChild.leftChild)
   			//System.out.println("yes");

   		
   		assertEquals(A.root.rightChild.leftChild,b5);	
   		//fail("This test has not been implemented3.");				
   	}
   	

   	
   	
    
    @Test
   	public void test3() {
   	//check right Rotation when rightchild node is null
   		
   		RedBlackTree A = new RedBlackTree();
 		Node b1 = new Node(1);
   		Node b2 = new Node(2);
   		Node b3 = new Node(3);
   		Node b4 = new Node(4);
   		Node b5 = new Node(5);
   		Node b6 = new Node(6);
   		
   		A.root=b1;
   		A.root.leftChild=b2;
   		A.root.leftChild.leftChild=b3;   		
   		A.root.leftChild.leftChild.leftChild=b4;
   		A.root.leftChild.leftChild.leftChild.leftChild=b5;
   		A.root.leftChild.leftChild.leftChild.leftChild.leftChild=b6;

		A.rotate(A.root.leftChild,A.root);
		
		//if(b1==A.root.rightChild)
   			//System.out.println("yes");

		assertEquals(A.root.rightChild,b1);	   	
   	}
   	
*/


    /**
     * Get the size of the tree (its number of nodes).
     * @return the number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     * @return true of this.size() return 0, false if this.size() > 0
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Checks whether the tree contains the value *data*.
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */
    @Override
    public boolean contains(T data) {
        // null references will not be stored within this tree
        if(data == null) throw new NullPointerException(
            "This RedBlackTree cannot store null references.");
        return this.containsHelper(data, root);
    }

    /**
     * Recursive helper method that recurses through the tree and looks
     * for the value *data*.
     * @param data the data value to look for
     * @param subtree the subtree to search through
     * @return true of the value is in the subtree, false if not
     */
    private boolean containsHelper(T data, Node<T> subtree) {
        if (subtree == null) {
            // we are at a null child, value is not in tree
            return false;
        } else {
            int compare = data.compareTo(subtree.data);
            if (compare < 0) {
                // go left in the tree
                return containsHelper(data, subtree.leftChild);
            } else if (compare > 0) {
                // go right in the tree
                return containsHelper(data, subtree.rightChild);
            } else {
                // we found it :)
                return true;
            }
        }
    }

    /**
     * Returns an iterator over the values in in-order (sorted) order.
     * @return iterator object that traverses the tree in in-order sequence
     */
    @Override
    public Iterator<T> iterator() {
        // use an anonymous class here that implements the Iterator interface
        // we create a new on-off object of this class everytime the iterator
        // method is called
        return new Iterator<T>() {
            // a stack and current reference store the progress of the traversal
            // so that we can return one value at a time with the Iterator
            Stack<Node<T>> stack = null;
            Node<T> current = root;

            /**
             * The next method is called for each value in the traversal sequence.
             * It returns one value at a time.
             * @return next value in the sequence of the traversal
             * @throws NoSuchElementException if there is no more elements in the sequence
             */
            public T next() {
                // if stack == null, we need to initialize the stack and current element
                if (stack == null) {
                    stack = new Stack<Node<T>>();
                    current = root;
                }
                // go left as far as possible in the sub tree we are in until we hit a null
                // leaf (current is null), pushing all the nodes we fund on our way onto the
                // stack to process later
                while (current != null) {
                    stack.push(current);
                    current = current.leftChild;
                }
                // as long as the stack is not empty, we haven't finished the traversal yet;
                // take the next element from the stack and return it, then start to step down
                // its right subtree (set its right sub tree to current)
                if (!stack.isEmpty()) {
                    Node<T> processedNode = stack.pop();
                    current = processedNode.rightChild;
                    return processedNode.data;
                } else {
                    // if the stack is empty, we are done with our traversal
                    throw new NoSuchElementException("There are no more elements in the tree");
                }

            }

            /**
             * Returns a boolean that indicates if the iterator has more elements (true),
             * or if the traversal has finished (false)
             * @return boolean indicating whether there are more elements / steps for the traversal
             */
            public boolean hasNext() {
                // return true if we either still have a current reference, or the stack
                // is not empty yet
                return !(current == null && (stack == null || stack.isEmpty()) );
            }
            
        };
    }

    /**
     * This method performs an inorder traversal of the tree. The string 
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations 
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * Note that this RedBlackTree class implementation of toString generates an
     * inorder traversal. The toString of the Node class class above
     * produces a level order traversal of the nodes / values of the tree.
     * @return string containing the ordered values of this tree (in-order traversal)
     */
    @Override
    public String toString() {
        // use the inorder Iterator that we get by calling the iterator method above
        // to generate a string of all values of the tree in (ordered) in-order
        // traversal sequence
        Iterator<T> treeNodeIterator = this.iterator();
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        if (treeNodeIterator.hasNext())
            sb.append(treeNodeIterator.next());
        while (treeNodeIterator.hasNext()) {
            T data = treeNodeIterator.next();
            sb.append(", ");
            sb.append(data.toString());
        }
        sb.append(" ]");
        return sb.toString();
    }

}