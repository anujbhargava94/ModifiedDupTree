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

	protected void case1(AbsTree t) { // remove the leaf
		// to be filled by you
		t = null;
	}

	protected void case2(AbsTree t) { // remove internal node
		// to be filled by you
		t = t.left == null? t.right:t.left;
	}

	protected void case3L(AbsTree t) { // replace t.value and t.count
		// to be filled by you
		
	}

	protected void case3R(AbsTree t) { // replace t.value
		// to be filled by you
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