package com.graph.basics;

class Vertex {
	private char label; // label (e.g. �A�)
	private boolean visited;

	public Vertex(char lab) // constructor
	{
		label = lab;
		visited = false;
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
} // end class Vertex
