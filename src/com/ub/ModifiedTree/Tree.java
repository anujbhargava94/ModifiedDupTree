package com.ub.ModifiedTree;

public class Tree extends AbsTree {
	protected int nodeCount;
	public Tree(int n) {
		super(n);
		nodeCount =1;
	}

	protected AbsTree add_node(int n) {
		nodeCount++;
		return new Tree(n);
	}

	protected void count_duplicates() {
		;
	}

	protected int get_count() {
		// to be filled by you
		return nodeCount;
	}

	protected void set_count(int v) {
		// to be filled by you
		nodeCount = v;
	}
}