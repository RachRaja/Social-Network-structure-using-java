import java.util.Collection;
import java.util.Vector;

import edu.uci.ics.jung.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.Hypergraph;
import edu.uci.ics.jung.graph.Vertex;
import edu.uci.ics.jung.graph.impl.AbstractSparseGraph;
import edu.uci.ics.jung.graph.impl.DirectedSparseGraph;
import edu.uci.ics.jung.graph.impl.SetHyperedge;
import edu.uci.ics.jung.graph.impl.SetHypergraph;
import edu.uci.ics.jung.graph.impl.SparseGraph;

public class Quad {

	/*public String Vertex;
	public Integer Edge;
	
	public Integer x;
	public Integer y;{
	
	 this.x = x;
	 this.y = y;
	
	}
	public void graphclass (Integer addEdge, String addVertex)
	{
		Edge = addEdge;
		Vertex = addVertex;
		}
	public Integer getEdge()
	{
		return Edge;
		}
		public void setEdge(Integer newValue){
			Edge = newValue;
		}
		  public static void main(String[] args){
	
			  System.out.println(""); }

}
	*/
	
	 import java.util.Vector;    

	    class Node{
	    	
	    	static Vector<String> NodeVec = new Vector<String>();
	    	void setProperty(String prop, String Propname)
	    	{
	    		NodeVec.add(prop);
	    		NodeVec.add(Propname);		
	    	}
	    	
	    	//Vector<String> Vector=new Vector<String>(10,2); 
	    	//Vector<String> Vector1=new Vector<String>(10,2);
	    	public static void main(String []args){
	    		
	        Node NodeinMain = new Node();
	        NodeinMain.setProperty("name", "Martin");
	                     
	        for(int i=0; i<NodeVec.size(); i++){
	            
	                System.out.println(NodeVec.elementAt(i));
	            }
	    	}
	}

	
		
	
	
	
	
	
