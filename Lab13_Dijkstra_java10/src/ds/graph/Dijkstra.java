package ds.graph;

import ds.queue.DistanceQueue;

public class Dijkstra {
    private DistanceQueue distQueue;
    private int[] prev;
    private double[] D;
    private Graph G;

    public Dijkstra(Graph G) {
        // Fill your code
    	for (int i=0;i<G.n();i++)
    		D[i]=Integer.MAX_VALUE;
    }

    public void calculateShortestPath(Graph G, int start) {
        // Fill your code	
    	
    	D[start]=0;
    	for(int i=0; i<G.n();i++) {
    		int v=minVertex(G);
    		G.setMark(v, "VISITED");
    		if (D[v]==Integer.MAX_VALUE) return;
    		for (int w =G.first(v);w<G.n();w=G.next(v, w))
    			if (D[w]>(D[v]+G.weight(v, w)))
    				D[w]=D[v]+G.weight(v, w);
    	}
    }

    private void printPathToEnd(Graph G, int end) {
        // Fill your code
    }
    
    public void printAllPath(Graph G, int src) {
    	// Fill your code
    }

    public int minVertex(Graph G) {
    	// Fill your code
    	int v=0;
    	for(int i=0;i<G.n();i++)
    		if(G.getMark(i).compareTo("VISITED")!=0) {
    			v=i; 
    			break;
    		}
    	for(int i=0;i<G.n();i++)
    		if((G.getMark(i).compareTo("VISITED")!=0)&&(D[i]<D[v]))
    			v=i;
		return v;
    }

    
}
