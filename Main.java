import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    AVLDictionary<String, String> dict = new AVLDictionary<String, String>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**********************AVL TREE***********************");
		char c = 0;
		do {
			
			//System.out.println("1. Insert into Tree.");
            System.out.println("\nAVL Tree Operations\n");
            
            System.out.println("1. Insert ");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Inorder Representation");
            System.out.println("5. Printing the tree");
            
            System.out.println();
            System.out.println("Enter the operation to be carried out :");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					System.out.println("Enter the  key value pairs to insert: ");
					int i = 0; 
					while(i < 4)
					{
						String str = sc.next();
						String[] arr = str.split(",");
						dict.root=dict.insert(dict.root, arr[0], arr[1]);
						i++;
					}
					System.out.println("\n\n\nTree to to String\n\n\n"+dict.toString());
					break;
//				
//				case 2: 
//					System.out.println("Enter the element to be searched :");
//					break;
//			
//				case 3:
//					System.out.println("Enter the key value pair to be deleted :");
//		     		
				default:
					System.out.println("Invalid choice"); 
					break;
			}
			
			System.out.println("\nDo you want to continue (y/n): \n");
			c = sc.next().charAt(0);
		}while (c == 'y');
            
//		dict.printTree();
//
//		dict.root = dict.insert(dict.root, "13", "13");
//		dict.root = dict.insert(dict.root, "10", "10");
//		dict.root = dict.insert(dict.root, "15", "15");
//		dict.root = dict.insert(dict.root, "05", "05");
//		dict.root = dict.insert(dict.root, "11", "11");
//		dict.root = dict.insert(dict.root, "16", "16");
//		dict.root = dict.insert(dict.root, "04", "04");
//		dict.root = dict.insert(dict.root, "06", "06");
//
//  	    dict.printTree();
//  	    System.out.println("\n\n\nTree to to String\n\n\n"+dict.toString());
//  	    System.out.println(dict.search("04"));
//  	    
//  	    StringBuilder s = new StringBuilder();
//  	    s.append("hello ");
//  	    s.append(true);
//  	    System.out.println(s);

		}
	}
