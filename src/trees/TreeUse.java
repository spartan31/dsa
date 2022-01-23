package trees;

import java.util.*;

public class TreeUse {
	
	public static boolean checkelement(treeNode<Integer> root , int x) {
          if(root == null) {
        	  return  false;  
          }
	      
	       boolean bb = false ;
	       if(root.data == x) {
	    	   bb = true; 
	       } else {
	       for(int i = 0 ; i < root.children.size(); i++) {
	    	bb = checkelement(root.children.get(i) , x); 
	    	if(bb == true) {
	    		break;
	    	}
	       }
	       }
	      return bb; 
	}

	public static treeNode<Integer> takeinput(Scanner sc) {
		int n;

		System.out.println("Enter the next node data");
		n = sc.nextInt();
		treeNode<Integer> root = new treeNode<Integer>(n);
		System.out.println("Enter Number of childrens");
		int childcount = sc.nextInt();
		for (int i = 0; i < childcount; i++) {
			treeNode<Integer> child = takeinput(sc);
			root.children.add(child);
		}
		return root;
	}

	public static void print(treeNode<Integer> root) {
		String s = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}

	public static int nodes(treeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < root.children.size(); i++) {
			count += nodes(root.children.get(i));
		}
		return count;
	}

	public static int largest(treeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int ans = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			int child = largest(root.children.get(i));
			if (child > ans) {
				ans = child;
			}

		}
		return ans;
	}

	public static int height(treeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int ans = 0;

		for (int i = 0; i < root.children.size(); i++) {
			int res = height(root.children.get(i));
			if (res > ans) {
				ans = res;
			}
		}
        return ans + 1;
	}
	
	public static void printdepth(treeNode<Integer> root , int k) {
		if(k < 0) {
			return ;
		}
		if(k == 0) {
			System.out.print(root.data + " ");
		}
		
		for(int i = 0 ; i < root.children.size() ; i++) {
			printdepth(root.children.get(i) , k-1);
		}
	}
	
	public static int countleaf(treeNode<Integer> root) {
		if(root == null) {
			return 0;
		} 
	   if(root.children.size()  == 0) {
		   return 1 ;
	   }
	   int count = 0;
	   for(int i = 0 ; i < root.children.size();i++) {
		count = count + countleaf(root.children.get(i));
	   }
	  return count ; 
	}
	
	
	public static void preorder(treeNode<Integer> root) {
		if(root == null) {
			return ;
		}
          System.out.print(root.data +  " ");
		for(int i = 0 ; i < root.children.size(); i++) {
			preorder(root.children.get(i));
		}
	}
	
	public static void postorder(treeNode<Integer> root) {
		if(root == null) {
			return ;
		}
		for(int  i = 0 ; i < root.children.size(); i++ ) {
			postorder(root.children.get(i));
		}
		System.out.print(root.data + " ");
		
	}

	public static treeNode<Integer> takeinputlevel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		Queue<treeNode<Integer>> pendingNodes = new LinkedList<>();
		treeNode<Integer> root = new treeNode<>(rootData);
		pendingNodes.add(root);
		while (!pendingNodes.isEmpty()) {
			treeNode<Integer> frontNode = pendingNodes.remove();
			System.out.println("Enter num of childrens of " + frontNode.data);
			int numchild = sc.nextInt();
			for (int i = 0; i < numchild; i++) {
				System.out.println(" Enter " + (i + 1) + "th child of" + frontNode.data);
				int child = sc.nextInt();
				treeNode<Integer> childNde = new treeNode<Integer>(child);
				frontNode.children.add(childNde);
				pendingNodes.add(childNde);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		treeNode<Integer> root = takeinputlevel();
     	print(root);
        System.out.println("total " + nodes(root) + " nodes are present");
    	System.out.println("largest node is " + largest(root));
		System.out.println(height(root)+" is maximum height of tree ");
		printdepth(root,2);
		System.out.println();
		System.out.println("Number of leaf nOdes are "+countleaf(root));
		preorder(root);
		System.out.println();
		postorder(root);
		System.out.println();   
		System.out.println(checkelement(root,44));
	}

}

//input	4 2 1 3 0 1 3 0
