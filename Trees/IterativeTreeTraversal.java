package trees;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.List;
import java.util.Stack;

public class RecursiveTreeTraversal {
	public static List<Integer> preorderTraversal(Node root) {
	    List<Integer> result = new ArrayList<>();
	    Stack<Node> stack = new Stack<>();
	    Node p = root;
	    while (p != null || !stack.isEmpty()) {
	        if (p != null) {
	            stack.push(p);
	            result.add(p.data);  // Add before going to children
	            p = p.left;
	        } else {
	        	Node node = stack.pop();
	            p = node.right;   
	        }
	    }

	    return result;
	}
	
	public static List<Integer> inorderTraversal(Node root) {
	    List<Integer> result = new ArrayList<>();
	    Stack<Node> stack = new Stack<>();
	    Node p = root;
	    while (p != null || !stack.isEmpty()) {
	        if (p != null) {
	            stack.push(p);
	            p = p.left;
	        } else {
	        	Node node = stack.pop();
	            result.add(node.data);  // Add after all left children
	            p = node.right;   
	        }
	    }
	    return result;
	}
	public static List<Integer> postorderTraversal(Node root) {
	    List<Integer> result = new ArrayList<>();
	    Stack<Node> stack = new Stack<>();
	    Node p = root;
	    while (p != null || !stack.isEmpty()) {
	        if (p != null) {
	            result.add(p.data);  // Add before going to children
	            stack.push(p);
	            p = p.right;
	        } else {
	            p = stack.pop();
	            p = p.left;
	        }
	    }
	    Collections.reverse(result);
	    return result;
	}
	
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("pre order recursive ");
		List<Integer> list = preorderTraversal(root);
		System.out.println(list);
		
		System.out.println("post order recursive ");
		List<Integer> list1 = postorderTraversal(root);
		System.out.println(list1);
		
		//System.out.println("In order recursive ");
		//List<Integer> list2 = inorderTraversal(root);
		//System.out.println(list2);
	}
}
