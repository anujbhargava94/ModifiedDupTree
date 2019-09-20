package com.ub.ModifiedTree;

public class Tree extends AbsTree {
	//protected int nodeCount;
	public Tree(int n) {
		super(n);
	}

	protected AbsTree add_node(int n) {
		return new Tree(n);
	}

	protected void count_duplicates() {
		;
	}

	protected int get_count() {
		// to be filled by you
		return 0;
	}

	protected void set_count(int v) {
		// to be filled by you
	}
}