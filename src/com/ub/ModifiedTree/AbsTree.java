package com.ub.ModifiedTree;

public abstract class AbsTree {
	public AbsTree(int n) {
		value = n;
		left = null;
		right = null;
	}

	public void insert(int n) {
		if (value == n)
			count_duplicates();
		else if (value < n)
			if (right == null) {
				right = add_node(n);
			} else
				right.insert(n);
		else if (left == null) {
			left = add_node(n);
		} else
			left.insert(n);
	}

	public void delete(int n) {
		AbsTree t = find(n);

		if (t == null) { // n is not in the tree
			System.out.println("Unable to delete " + n + " -- not in the tree!");
			return;
		}

		int c = t.get_count();
		if (c > 1) {
			t.set_count(c - 1);
			return;
		}

		if (t.left == null && t.right == null) { // n is a leaf value
			if (t != this)
				case1(t);
			else
				System.out.println("Unable to delete " + n + " -- tree will become empty!");
			return;
		}
		if (t.left == null || t.right == null) { // t has one subtree only
			if (t != this) { // check whether t is the root of the tree
				case2(t);
				return;
			} else {
				if (t.right == null)
					case3L(t);
				else
					case3R(t);
				return;
			}
		}
		// t has two subtrees; go with smallest in right subtree of t
		case3R(t);
	}

	private AbsTree findPreviousNode(AbsTree findNode, AbsTree node) {
		if (node.left == null && node.right == null) {
			System.out.println("this is root node");
			return null;
		} else if ((node.left != null && node.left.value == findNode.value)
				|| (node.right != null && node.right.value == findNode.value)) {
			return node;
		} else if (node.left == null || node.right == null) {
			if (node.right != null && node.right.value > findNode.value) {
				return findPreviousNode(findNode, node.right);
			} else {
				return findPreviousNode(findNode, node.left);
			}
		} else {
			if (node.right.value < findNode.value) {
				return findPreviousNode(findNode, node.right);
			} else {
				return findPreviousNode(findNode, node.left);
			}
		}
	}

	protected void case1(AbsTree t) { // remove the leaf
		// to be filled by you
		AbsTree prevNode = findPreviousNode(t, this);
		if (prevNode != null) {
			if (prevNode.left != null && prevNode.left.value == t.value) {
				prevNode.left = null;
			} else {
				prevNode.right = null;
			}
		}
	}
	
	private void removeNode(AbsTree t, AbsTree root) {
		AbsTree prevNode = findPreviousNode(t, root);
		if (prevNode != null) {
			if (prevNode.left != null && prevNode.left.value == t.value) {
				prevNode.left = null;
			} else {
				prevNode.right = null;
			}
		}
	}

	protected void case2(AbsTree t) { // remove internal node
		// to be filled by you
		AbsTree prevNode = findPreviousNode(t, this);
		if (t.right != null) {
			prevNode.right = t.right;
		} else {
			prevNode.left = t.left;
		}
		t.right = null;
		t.left = null;
	}

	protected void case3L(AbsTree t) { // replace t.value and t.count
		// to be filled by you
		AbsTree maxNode = t.left.max();
		AbsTree copyMaxNode = maxNode;
		removeNode(maxNode, this);
		t.value = copyMaxNode.value;
		int count = copyMaxNode.get_count();
		t.set_count(count);
	}

	protected void case3R(AbsTree t) { // replace t.value
		// to be filled by you
		AbsTree minNode = t.right.min();
		AbsTree copyMinNode = minNode;
		removeNode(minNode, this);
		t.value = copyMinNode.value;
		int count = copyMinNode.get_count();
		t.set_count(count);
	}

	private AbsTree find(int n) {
		// to be filled by you
		if (value == n) {
			return this;
		} else if (n > value && right != null) {
			return this.right.find(n);
		} else if (n < value && left != null) {
			return this.left.find(n);
		} else {
			return null;
		}
	}

	public AbsTree min() {
		// to be filled by you
		if (this.left != null) {
			return this.left.min();
		} else
			return this;
	}

	public AbsTree max() {
		// to be filled by you
		if (this.right != null) {
			return this.right.max();
		} else
			return this;
	}

	protected int value;
	protected AbsTree left;
	protected AbsTree right;
	protected AbsTree parent;

	protected abstract AbsTree add_node(int n);

	protected abstract void count_duplicates();

	protected abstract int get_count();

	protected abstract void set_count(int v);
}