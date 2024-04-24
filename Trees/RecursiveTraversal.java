package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Trees {
	
	public static void preorderRec(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}
	public static void preorderItr(Node root) {
		Stack<Node> stack = new Stack<>();
		Node t = root;
		while(t != null || !stack.isEmpty()) {
			while(t !=null) {
				System.out.print(t.data+ " ");
				stack.add(t);
				t = t.left;
			}
			t = stack.pop();
			
			t= t.right;
		}
		
	}
	
	public static void postorderRec(Node root) {
		if(root != null) {
			
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static void inorderRec(Node root) {
		if(root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
		
	}
	public static void levelOrder(Node root) {
		if(root == null) return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node t = queue.poll();
			System.out.print(t.data+" ");
			if(t.left != null) {
				queue.add(t.left);
			}
			if(t.right !=null) {
				queue.add(t.right);
			}
		}
	}
	
	public static void inOrderRec(Node root) {
		if(root == null) return;
		Node t = root;
		Stack<Node> stack = new Stack<>();
		
		while(t!=null || !stack.isEmpty()) {
			while(t!=null) {
				stack.push(t);
				t = t.left;
			}
			t = stack.pop();
			System.out.print( t.data + " ");
			t = t.right;
		}
	}
	
	public static void postOrderIteratvie(Node root) {
		
	}
	

	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.print("Pre order recursive ");
		preorderRec(root);
		System.out.println();
		
		System.out.println("Post order recursive ");
		postorderRec(root);
		System.out.println();
		
		System.out.println("In order recursive ");
		inorderRec(root);
		System.out.println();
		
		System.out.println("level order ");
		levelOrder(root);
		System.out.println();
		
		System.out.println("Pre order Iterative ");
		preorderItr(root);
		System.out.println();
		
		System.out.println("Inorder order recursive ");
		inorderRec(root);
		System.out.println();
		
		System.out.println("Post order Iterative");
	}
}
