package com.ub.ModifiedTree;

public class DupTree extends AbsTree {
	public DupTree(int n) {
		super(n);
		count = 1;
		nodeCount =1;
	};

	protected AbsTree add_node(int n) {
		nodeCount++;
		return new DupTree(n);
	}

	protected void count_duplicates() {
		count++;
		nodeCount++;
	}

	protected int get_count() {
		// to be filled by you
		return nodeCount;
	}

	protected void set_count(int v) {
		// to be filled by you
		nodeCount = v;
	}

	protected int count;
	protected int nodeCount;
}