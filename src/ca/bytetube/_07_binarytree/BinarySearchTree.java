package ca.bytetube._07_binarytree;
import ca.bytetube._07_binarytree.printer.BinaryTreeInfo;


public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root;

	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;

		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}


		@Override
		public String toString() {

			return String.valueOf(this.element);
		}
	}

	public int size(){
			return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void clear(){
		root = null;
		size = 0;
	}


	public void add(E element){

	}

	public void remove(E element){

	}


	public boolean contains(){
		return false;
	}



	//recursion
	public int height(){
		return height(root);
	}

	private int height(Node<E> node){
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left),height(node.right));

	}








	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>)node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root, sb, "");
		return sb.toString();
	}

	private void toString(Node<E> node, StringBuilder sb, String prefix) {//中序打印
		if (node == null) return;

		toString(node.left, sb, prefix + "L---");
		sb.append(prefix).append(node.element).append("\n");
		toString(node.right, sb, prefix + "R---");
	}
}
