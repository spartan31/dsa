package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class treeNode<T> {
  public T data;
   public ArrayList<treeNode<T>> children;

   public treeNode(T data) {
	   this.data = data;
	   children = new ArrayList<>();
   }
   
   

   }

  