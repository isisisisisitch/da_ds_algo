package ca.bytetube._07_binarytree;
import ca.bytetube._07_binarytree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;

	public BinarySearchTree() {
		this(null);
	}

	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}

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

	private Node<E> node(E element){
		Node<E> node = root;
		int cmp = 0;
		while (node != null){//依次向下寻找
			cmp = compare(element,node.element);
			if (cmp == 0) {
				return node;
			}
			if (cmp > 0) {//right
				node = node.right;
			}
			else if (cmp < 0) {//left
				node = node.left;
			}
		}

		return null;

	}

	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1,e2);
		}
		return ((Comparable<E>) e1).compareTo(e2);
	}

	public boolean contains(E element){
		return node(element) != null;
	}
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}

	public void add(E element){
		elementNotNullCheck(element);
		//1.添加第一个节点
		if (root == null) {
			root = new Node<>(element,null);
			size++;
			return;
		}
		//2.添加的不是第一个节点
		//2.1找到父节点
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		while (node != null){
			cmp = compare(element,node.element);
			parent = node;//update parent
			if (cmp > 0) {//right
				node = node.right;
			}else if (cmp < 0) {//left
				node = node.left;
			}else {//equals replace
				node.element = element;
				return;

			}
		}
		//2.2创建新节点
		Node<E> newNode = new Node<>(element,parent);
		if (cmp > 0) {
			parent.right = newNode;
		}else {
			parent.left = newNode;
		}

		size++;
	}



	public void remove(E element){
		remove(node(element));
	}

	private void remove(Node<E> node){
		if (node == null) return;

		size--;
		//remove degree 2
		if (node.left != null && node.right != null) {
			Node<E> s = successor(node);
			node.element = s.element;
			node = s;
		}
		Node<E> replaceNode = node.left != null ? node.left : node.right;
		//remove degree 1
		if (replaceNode != null) {
			//update parent
			replaceNode.parent = node.parent;
			//update child
			if (node.parent == null) {//node == root
				root = replaceNode;
			}else if (node == node.parent.left) {
				node.parent.left = replaceNode;
			}else {
				node.parent.right = replaceNode;
			}
		}
		//remove degree 0
		else if (node.parent == null) {//node == root
			root = null;
		}else {
			if (node == node.parent.left) {
				node.parent.left = null;
			}else {
				node.parent.right = null;
			}
		}
	}



	private boolean isLeaf(Node node){
		return node.left == null && node.right == null;
	}

	public boolean isComplete(){
		if (root == null) return false;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean leaf = false;//叶节点模式
		while (!queue.isEmpty()){
			Node node = queue.poll();

			if (leaf && !isLeaf(node)) {
				return false;
			}
			if (node.left != null && node.right != null) {//case 1
				queue.offer(node.left);
				queue.offer(node.right);
			}
			else if (node.left == null && node.right != null) {//case 1
				return false;
			}else {//之后遍历的所有节点必须都是叶子节点
				leaf = true;
			}

		}
		return true;
	}

	public Node<E> predecessor(Node<E> node){
		if (node == null) return null;
		//1.有left
		Node<E> p = node.left;
		while (p!=null){
			while (p.right != null){
				p = p.right;
			}
			return p;
		}
		//2.无left，有parent
		while (node.parent != null && node == node.parent.left){
			node = node.parent;
		}

		return node.parent;
	}

	public Node<E> successor(Node<E> node){
		if (node == null) return null;
		//1.有right
		Node<E> p = node.right;
		while (p!=null){
			while (p.left != null){
				p = p.left;
			}
			return p;
		}
		//2.无right，有parent
		while (node.parent != null && node == node.parent.right){
			node = node.parent;
		}

		return node.parent;
	}

	public int height(){//levelOrder
		if (root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int levelSize = 1;
		int height = 0;
		while (!queue.isEmpty()){
			Node node = queue.poll();
			levelSize--;

			if (node.left != null) {
			queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize == 0 ) {
				levelSize = queue.size();
				height++;
			}
		}

		return height;

	}


	//recursion
	public int height0(){

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
