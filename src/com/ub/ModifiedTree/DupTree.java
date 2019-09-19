package com.ub.ModifiedTree;

public class DupTree extends AbsTree {
	public DupTree(int n) {
		super(n);
		count = 1;
	};

	protected AbsTree add_node(int n) {
		return new DupTree(n);
	}

	protected void count_duplicates() {
		count++;
	}

	protected int get_count() {
		// to be filled by you
		return count;
	}

	protected void set_count(int v) {
		// to be filled by you
		count = v;
	}

	protected int count;
	protected int nodeCount;
}