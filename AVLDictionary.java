import java.util.Scanner;

public class AVLDictionary<K, V>{
//public class AVLDictionary<K, V> implements Dictionary<K, V> {
    AVLNode<K, V> root; // the root of the AVL Tree.

//    private static final int BALANCED = 2;
//    private static final int MORELEFT = 1;
//    private static final int MORERIGHT = 3;
    public boolean debugging = true;

    public AVLDictionary() {
        this(null); //calls the other constructor.
    }

    public AVLDictionary(AVLNode<K, V> root) {
        this.root = root;
    }
    
    
    /**
     * Finds the minimum value from a particular node.
     * This simply involves traversing the left-most nodes
     * all the way down the tree until the left-most node is null.
     * 
     * @param node the node to start finding the min from
     * @return the node which contains the minimum value (the left most leaf)
     */
    public AVLNode<K, V> findMin(AVLNode<K, V> node) {
    	//continually gets the leftmost node until it can't any longer.
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
    
    public AVLNode<K, V> findMax(AVLNode<K, V> node) {
    	//continually gets the rightmost node until it can't any longer.
        while(node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
    
	/** 
     * This is a recursive solution to printing out the tree
     * in the order of "inorder" processing.
     * @param node the node we are traversing from
     */
    public void inorder(AVLNode<K,V> node) {
        if(node != null) {
            inorder(node.getLeft()); //get the left keys first
            System.out.println("key: " + node.getKey().toString() + " element: " + node.getValue().toString());
            inorder(node.getRight()); //thing get the right keys.
        }
    }
	
	/**
     * Print the Dictionary in sorted order (as determined by the keys)
     * to print in sorted order, we traverse and print the tree "inorder".
     */
    public void printTree() {
        System.out.println("\nPrinting the AVL Tree below...");
        
        inorder(root);
    }
	    
    /**
     * Returns the element of the node with the key value
     * of the specified value.
     */

    public V search(K key) {
        AVLNode<K, V> nodeFound;
        nodeFound = searchBelow(root, key);
        if(nodeFound == null) {
            return null; //not found
        }
        else return searchBelow(root,key).getValue(); //call another helper method.
    }

    /**
     * A recursive solution to finding a specific key in the binary tree.
     * 
     * @param node the node we wish to start searching below from.
     * @param key the key value of the node we are looking for.
     * @return the node which has the key value we are looking for.
     */
    private AVLNode<K,V> searchBelow(AVLNode<K, V> node, K key) {
        if(node == null) {
            return null; //nothing correctly passed.
        }
        // if the root is the key
        if(((String) key).compareTo((String) node.getKey()) == 0) {
            return node;
        }
        // if the key we are looking for is greater than the key
        // at the node we are at, then we must go down the right child
        // to continue the search.
        else if (((String) key).compareTo((String) node.getKey()) > 0) {
            return searchBelow(node.getRight(), key);
        }
        // if the key we are looking for is less than the key
        // at the node we are at, then we must go down the left child
        // to continue the search.
        else if(((String) key).compareTo((String) node.getKey()) < 0) {
            return searchBelow(node.getLeft(), key);
        }
        else {
            //this case should never be reached.
            System.out.println("Something went wrong. ERROR #1");
            return null;
        }
    }

    /**
     * Search for an entry with key KEY and return the node object
     * @param key the key value of the node we are looking for.
     * @return null if no such key was found, the node it was found in if it was found.
     */
//    public AVLNode<K, V> searchNode(K key) {
//        if(key == null) {
//            return null; //looking for nothing
//        }
//        if(root == null) {
//            return null; //nothing in the root, empty tree.
//        }
//        //if the keys are equal
//        if(((String) key).compareTo((String) root.getKey()) == 0) {
//            return root;
//        }
//        //if this key is less than the root's key
//        else if(((String) key).compareTo((String) root.getKey()) < 0) {
//            return searchBelow(root.getLeft(), key); //call the recursive search method.
//        }
//        //if this key is greater than the root's key
//        else if(((String) key).compareTo((String) root.getKey()) > 0) {
//            return searchBelow(root.getRight(), key); //call the recursive search method.
//        }
//        else {
//            //this case should never be reached.
//            System.out.println("Something went wrong. ERROR #1");
//            return null;
//        }
//    }
    
    boolean isEmpty(boolean quiet) {
        if (!quiet) {
//            reset();
        }
        return root == null;
    }
    
    public String toString() {
        String ret = isEmpty(true) ? "└── \n" : root.toString();
        return ret;
    }
    
    
    
 // A utility function to get the height of the tree 
    int height(AVLNode<K,V> N) { 
        if (N == null) 
            return -1; 
  
        return N.height; 
    } 
  
    // A utility function to get maximum of two integers 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  
    // A utility function to right rotate subtree rooted with y 
    // See the diagram given above. 
    AVLNode<K,V> rightRotate(AVLNode<K,V> y) { 
        AVLNode<K,V> x = y.left; 
        AVLNode<K,V> T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = max(height(y.left), height(y.right)) + 1; 
        x.height = max(height(x.left),height(x.right)) + 1; 
  
        // Return new root 
        return x; 
    } 
  
    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    AVLNode<K,V> leftRotate(AVLNode<K,V> x) { 
        AVLNode<K,V> y = x.right; 
        AVLNode<K,V> T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        //  Update heights 
        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y; 
    } 
  
    // Get Balance factor of AVLNode<E,K> N 
    int getBalance(AVLNode<K,V> N) { 
        if (N == null) 
            return 0; 
  
        return height(N.left) - height(N.right); 
    } 
    
    public int compare(AVLNode<K,V> n1, AVLNode<K,V> n2) {
  
        return n1.compareTo(n2);
    }
      
    AVLNode<K,V> insert(AVLNode<K,V> node, K key, V value) { 
        /* 1.  Perform the normal BST insertion */
        if (node == null) 
            return (new AVLNode<K,V>(key, value)); 
  
        if (key.toString().compareTo(node.key.toString()) < 0) {
        	//System.out.println(key.toString()+":"+node.key.toString()+"="+key.toString().compareTo(node.key.toString()));
        	node.left = insert(node.left, key, value); 
        } else if (key.toString().compareTo(node.key.toString()) > 0) {
        	//System.out.println(key.toString()+":"+node.key.toString()+"="+key.toString().compareTo(node.key.toString()));
            node.right = insert(node.right, key, value); 
        } else // Duplicate keys not allowed 
            return node; 
  
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), 
                              height(node.right)); 
  
        /* 3. Get the balance factor of this ancestor 
              node to check whether this node became 
              unbalanced */
        int balance = getBalance(node); 
  
        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && key.toString().compareTo(node.left.key.toString())<0) {
        	//System.out.println("LL Rotation:\n"+key+":"+node.left.key+"="+key.toString().compareTo(node.left.key.toString()));
            return rightRotate(node); 
        }
  
        // Right Right Case 
        if (balance < -1 && key.toString().compareTo(node.right.key.toString())>0) {
        	//System.out.println("RR Rotation:\n"+key+":"+node.right.key+"="+key.toString().compareTo(node.right.key.toString()));
            return leftRotate(node); 
        }
  
        // Left Right Case 
        if (balance > 1 && key.toString().compareTo(node.left.key.toString())>0) {
        	//System.out.println("LR Rotation:\n"+key+":"+node.left.key+"="+key.toString().compareTo(node.left.key.toString())); 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && key.toString().compareTo(node.right.key.toString())<0) {
        	//System.out.println("RL Rotation:\n"+key+":"+node.right.key+"="+key.toString().compareTo(node.right.key.toString())); 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        /* return the (unchanged) node pointer */
        return node; 
    }
    
    AVLNode<K,V> minValueNode(AVLNode<K,V> node)  
    {  
    	AVLNode<K,V> current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }  
    
    AVLNode<K,V> deleteNode(AVLNode<K,V> root, K key)  
    {  
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null)  
            return root;  
  
        // If the key to be deleted is smaller than  
        // the root's key, then it lies in left subtree  
        if (key.toString().compareTo(root.key.toString())<0)  
            root.left = deleteNode(root.left, key);  
  
        // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        else if (key.toString().compareTo(root.key.toString())>0)  
            root.right = deleteNode(root.right, key);  
  
        // if key is same as root's key, then this is the node  
        // to be deleted  
        else
        {  
  
            // node with only one child or no child  
            if ((root.left == null) || (root.right == null))  
            {  
            	AVLNode<K,V> temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // No child case  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }  
            else
            {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
            	AVLNode<K,V> temp = minValueNode(root.right);  
  
                // Copy the inorder successor's data to this node  
                root.key = temp.key;  
  
                // Delete the inorder successor  
                root.right = deleteNode(root.right, temp.key);  
            }  
        }  
  
        // If the tree had only one node then return  
        if (root == null)  
            return root;  
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        root.height = max(height(root.left), height(root.right)) + 1;  
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(root);  
  
        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightRotate(root);  
  
        // Left Right Case  
        if (balance > 1 && getBalance(root.left) < 0)  
        {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  
  
        // Right Right Case  
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);  
  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right) > 0)  
        {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    }  

	public class AVLNode<K, V> {
		// Public constants.
		public static final int MORE_LEFT = 1;

		public static final int EVEN = 2;

		public static final int MORE_RIGHT = 3;

		// Instance variables.
		protected K key;

		protected V value;
		
		protected int height;

		protected AVLNode<K, V> left, right;

		public int balance; // One of MORE_LEFT, EVEN, or MORE_RIGHT.

		public AVLNode(K key, V value, AVLNode<K, V> left, AVLNode<K, V> right,int balance) 
		{
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.balance = balance;
		} // AVLNode constructor
		
		public AVLNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.height = 1;
		}

		public K getKey() {
			return key;
		} // getKey method

		public V getValue() {
			return value;
		} // getElement method

		public AVLNode<K, V> getLeft() {
			return left;
		} // getLeft method

		public AVLNode<K, V> getRight() {
			return right;
		} // getRight method

		public int getBalance() {
			return balance;
		} // getBalance method

		public void setKey(K key) {
			this.key = key;
		} // setKey method

		public void setValue(V value) {
			this.value = value;
		} // setElement method

		public void setLeft(AVLNode<K, V> node) {
			left = node;
		} // setLeft method

		public void setRight(AVLNode<K, V> node) {
			right = node;
		} // setRight method

		public void setBalance(int balance) {
			this.balance = balance;
		} // setBalance method
		
		public String toString() {
	        StringBuilder sb = new StringBuilder();
	        toString("", sb, true);
	        return sb.toString();
	    }
		
		private void toString(String prefix, StringBuilder sb, boolean tail) {
	        sb.append(prefix)
	                .append(tail ? "└── " : "├── ")
	                .append(key).append("::").append(value)
	                .append('\n');
	        if (left != null) {
	            left.toString(
	                    prefix + (tail ? "    " : "│   "),
	                    sb,
	                    right == null
	            );
	        }
	        if (right != null) {
	            right.toString(
	                    prefix + (tail ? "    " : "│   "),
	                    sb,
	                    true
	            );
	        }
	    }
		
		public int compareTo(AVLNode<K,V> node) {
	        return ((Comparable<Integer>)key).compareTo((Integer) node.key);
	    }
	} /* AVLNode class */
	    
}
