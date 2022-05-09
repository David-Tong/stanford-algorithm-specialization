package io.ytong.stanfordalgorithm.c1w4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MinCutSolver {
	private ArrayList<Edge> edges;
	private ArrayList<String> vertexs;
	private long runTime;
	
	public MinCutSolver(ArrayList<Edge> edges) {
		this.edges = edges;
		this.vertexs = new ArrayList<String>();
		for (Edge edge: this.edges) {
			if (!this.vertexs.contains(edge.getStartVertex())) {
				this.vertexs.add(edge.getStartVertex());
			}
			if (!this.vertexs.contains(edge.getEndVertex())) {
				this.vertexs.add(edge.getEndVertex());
			}
		}
		this.runTime = 0;
	}
	
	public int getMinCut() {
		int minMinCut = Integer.MAX_VALUE;
		long runTimes = this.getRunTimes();
		
		for (int index=0; index<runTimes; index++) {
			ArrayList<String> copiedVertexs = new ArrayList<String>();
			for (String vertex : vertexs) {
				copiedVertexs.add(vertex);
			}
			
			ArrayList<Edge> copiedEdges = new ArrayList<Edge>();
			for (Edge edge : edges) {
				Edge copiedEdge = new Edge(edge.getStartVertex(), edge.getEndVertex());
				copiedEdges.add(copiedEdge);
			}
			int minCut = this.runMinCut(copiedVertexs, copiedEdges);
			minMinCut = Math.min(minMinCut, minCut);
		}
		
		System.out.println("[FINAL] The final result of min cut is " + minMinCut);
		return minMinCut;
	}
	
	public int runMinCut(ArrayList<String> copiedVertexs, ArrayList<Edge> copiedEdges) {
		Random random = new Random(System.currentTimeMillis());
		this.runTime++;
		
		while (copiedVertexs.size() > 2) {
			int targetEdgeIndex = random.nextInt(copiedEdges.size());
			Edge targetEdge = copiedEdges.get(targetEdgeIndex);
			String targetVertex = targetEdge.getStartVertex();
			String deletedVertex = targetEdge.getEndVertex();
			
			Iterator<Edge> edgeIter = copiedEdges.iterator();
			while (edgeIter.hasNext()) {
				Edge edge = edgeIter.next();
				if ((edge.getStartVertex().equals(targetVertex)
						&& edge.getEndVertex().equals(deletedVertex))
				|| (edge.getStartVertex().equals(deletedVertex)
						&& edge.getEndVertex().equals(targetVertex))) {
					edgeIter.remove();
				}
			}
			
			edgeIter = copiedEdges.iterator();
			while (edgeIter.hasNext()) {
				Edge edge = edgeIter.next();
				if (edge.getStartVertex().equals(deletedVertex)) {
					edge.setStartVertex(targetVertex);
				}
				if (edge.getEndVertex().equals(deletedVertex)) {
					edge.setEndVertex(targetVertex);
				}
			}
			
			Iterator<String> vertexIter = copiedVertexs.iterator();
			while (vertexIter.hasNext()) {
				String vertex = vertexIter.next();
				if (vertex.equals(deletedVertex)) {
					vertexIter.remove();
				}
			}
		}
		
		int minCut = copiedEdges.size() / 2;
		String str = String.format(
				"[RUN %s] The min cut number of this run is %s", this.runTime, minCut);
		System.out.println(str);
		return minCut;
	}
	
	private long getRunTimes() {
		//int vertexsNum = this.vertexs.size();
		//long runTimes = (long) (vertexsNum * vertexsNum * Math.log(vertexsNum));
		long runTimes = 2000;
		return runTimes;
	}
	
	
	
}
