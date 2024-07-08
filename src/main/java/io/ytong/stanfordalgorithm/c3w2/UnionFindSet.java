package io.ytong.stanfordalgorithm.c3w2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFindSet {
	
	private int[] parents;
	private int[] ranks;
	private int claimNumber;
	private int clusterNumber;
	
	
	public UnionFindSet(int size) {
		this.parents = new int[size];
		for (int i=0; i<size; i++) {
			this.parents[i] = i;
		}
		
		this.ranks = new int[size];
		this.claimNumber = size;
		this.clusterNumber = size;
	}
	
	public UnionFindSet(int size, int clusterNumber) {
		this.parents = new int[size];
		for (int i=0; i<size; i++) {
			this.parents[i] = i;
		}
		
		this.ranks = new int[size];
		this.claimNumber = size;
		this.clusterNumber = clusterNumber;
	}
	
	
	
	public int find(int x) {	
		if (this.parents[x] != x) {
			this.parents[x] = find(this.parents[x]);
		}
		return this.parents[x];
	}
	
	public boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if (px == py) {
			return false;
		} else {
			if (this.ranks[px] > this.ranks[py]) {
				this.parents[py] = px;
			} else if (this.ranks[px] < this.ranks[py]) {
				this.parents[px] = py;
			} else {
				this.parents[py] = px;
				this.ranks[px] += 1;
			}
			this.clusterNumber -= 1;
			return true;
		}	
	}

	public int getClaimNumber() {
		return claimNumber;
	}
	
	public int getClusterNumber() {
		return clusterNumber;
	}
	
	public List<List<Integer>> getClusters() {
		Map<Integer, List<Integer>> clusterMap = new HashMap<Integer, List<Integer>>();
		for (int i=0; i<this.parents.length; i++) {
			find(i);
			if (!clusterMap.containsKey(this.parents[i])) {
				List<Integer> members = new ArrayList<Integer>();
				clusterMap.put(this.parents[i], members);
			}
			clusterMap.get(this.parents[i]).add(i);
		}
		
		List<List<Integer>> clusters = new ArrayList<List<Integer>>();
		for (Integer leader : clusterMap.keySet()) {
			clusters.add(clusterMap.get(leader));
		}
		return clusters;
	}
}
