import java.util.Scanner;

//import rbt.RedBlackTree.Node;

public class Main {

	public static void main(String args[]) {
		// Dictionary<String> d;

		Scanner sc = new Scanner(System.in);
		RedBlackTree<String> rbt = new RedBlackTree<>();

		System.out.println("**********************RED BLACK TREE***********************");
		char c = 0;
		do {
			
			//System.out.println("1. Insert into Tree.");
            System.out.println("\nRed Black Tree Operations\n");
            
            System.out.println("1. Insert ");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("\n---------For case 4 and 5, please make sure the tree is not empty---------\n");
            System.out.println("4. Minimum Node");
            System.out.println("5. Maximum node");
            System.out.println("6. Empty tree check");
            
            
            System.out.println();
            System.out.println("Enter the operation to be carried out :");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					System.out.println("Enter the  number of elements to insert : ");
					int num = sc.nextInt();
					System.out.println("Inserting "+num+" elements :");
					int i=0;
					while( i < num)
					{
					  rbt.add(sc.next());
					  i++;
					}
					System.out.println("Printing Red Black Tree : (1 = Black color, 0 = Red Color)");
					System.out.println(rbt.toString());
					break;
					
		     	case 2:
					System.out.println("Enter the element to search: ");
					boolean search = rbt.contains(sc.next());
					System.out.println(search);
					break;
					
				case 3:
					System.out.println("Enter the  number of elements to delete : ");
					int num1 = sc.nextInt();
					System.out.println("Deleting "+num1+" elements :");
					int d = 0;
					while(d < num1)
					{
					  rbt.delete(sc.next());
					  d++;
					  break;
					}
						
		     	case 4:
					System.out.println("Minimum of the entire tree : ");
					rbt.min();
					break;
					
		     	case 5:
		     		System.out.println("Maximum of the entire tree: ");
					rbt.max();
					break;
					
		     	case 6:
		     		System.out.println("Check whether the tree is empty: ");
					boolean e = rbt.isEmpty();
					System.out.println();
					System.out.println(e);
					break;
		     		
				default:
					System.out.println("Invalid choice");
					break;
			}
			
			System.out.println("\nDo you want to continue (y/n): \n");
			c = sc.next().charAt(0);
		}while (c == 'y');
		
		System.out.println();
		
		System.out.println("Printing Red Black Tree : (1 = Black color, 0 = Red Color)");
		System.out.println(rbt.toString());
	
	}
}
//		System.out.println();
//		rbt.add("a");
//		rbt.add("b");
//		rbt.add("f");
//		rbt.add("o");
//		rbt.add("w");
//		rbt.add("p");
//		rbt.add("h");
//		rbt.add("q");
//		rbt.add("l");
//
//		System.out.println("Printing Red Black Tree : (1 = Black color, 0 = Red Color)");
//		System.out.println(rbt.toString());

//		System.out.println("Searching 15 in the tree :");
//		System.out.println(rbt.contains("f"));
//		System.out.println("Searching 12 in the tree :");
//		System.out.println(rbt.contains("o"));
//		System.out.println("The item has a Predecessor :");
//		System.out.println(rbt.hasPredecessor("w"));
//		System.out.println("The item has a Successor :");
//		System.out.println(rbt.hasSuccessor("q"));
//
//		System.out.println("The minimum item :");
//		System.out.println(rbt.min());
//		System.out.println("The maximum item :");
//		System.out.println(rbt.max());
//
//		System.out.println();
//		rbt.delete("l");
//		System.out.println("After deleting 12 :");
//		System.out.println(rbt.toString());

//    System.out.println(rbt.getMin());
//    System.out.println(rbt.maximum(rbt.getRoot()));
//    RedBlackTree<Integer>.Node n= rbt.getRoot();
//    System.out.println(rbt.maximum(n.left));

		// System.out.println();

//    Iterator<Integer> it = rbt.iterator();
////  System.out.println();
//    while(it.hasNext()) 
//    {
//  	Integer n = it.next();
//  	
//  	System.out.println(n);
//    }

	

