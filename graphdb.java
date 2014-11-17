import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
//To use Directed sparse graph , I have imported "import edu.uci.ics.jung.graph*;*
//which is an open source implementation of graphs in java

// graphdb is the parent class and Node is an interface

public class graphdb {
    public DirectedSparseGraph<Vector<String>, Vector<String>> Relation_Graph;
    public graphdb()
    {
        Relation_Graph = new DirectedSparseGraph<Vector<String>, Vector<String>>();
    }
    
    public class Node extends graphdb
    {
           public Vector<String> NodeVec = new Vector<String>();
           public Vector<String> EdgeVec = new Vector<String>();
 
//Edges and Nodes for the graph are initialized as vectors to contain nodes and its properties          
          
           public Node returnFromNode(){
           
               return this;
           }
//Passing the method "setProperty" with arguments string and string   
           
           void setProperty(String prop, String Propname)
           {
               NodeVec.add(prop);
               NodeVec.add(Propname);
        }
           
//Vector has been alloted with type string for its property and its name            
           
           void createRelationshipTo(Node toNode,String Edge, String Known_Date){
 
//By using the method "CreateRelationshipto" the node , its relationship and the year can be inputed                            
        	   
        	   String date_alone = Known_Date.substring(8, 12);              
               EdgeVec.add(Edge);
               EdgeVec.add(date_alone);
    
               Relation_Graph.addVertex(toNode.NodeVec);
               Relation_Graph.addVertex(this.NodeVec);
               
//Adds edge to this graph with the specified with endpoints NodeVec and type Vector.      
            
               Relation_Graph.addEdge(EdgeVec, returnFromNode().NodeVec, toNode.NodeVec);
            
              }
           
//Storing the vector into an array to parse through and get the start node
           
               Vector<String> checkAllNodes (String StartNode){
               
               Collection<Vector<String>> allNodes = new ArrayList<Vector<String>>(); 
               allNodes = Relation_Graph.getVertices();
               
               for (Iterator<Vector<String>> iterator = allNodes.iterator(); iterator.hasNext();) 
               {
                   Vector<String> iter = iterator.next();
                   System.out.println(iter.get(0));
                   System.out.println(iter.get(1));
                   if(iter.get(1) == StartNode)
                       {    
                       System.out.println(iter.get(1));
                           return iter;
                           
                       }
                   else
                       {
                       System.out.println("Nulllll");
                       return null;
                       }
               }
            return null;
        
           }
           
    }
    
//new Object is created        
    
    Node createNode(){
        Node Nodex = new Node();
        return Nodex;
        
    }
    
//The input file is read using BufferedReader method
        
        String readQuery(String QueryFile){

        	//String QueryFile = "C:\\QueryFile.txt";
        
        	BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(QueryFile));
            String line;
            List<String> list = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
              list.add(line);
            }
            br.close();
            String StartNode ; Object SNode;
            String SuperStartNode = list.get(0);
            StartNode = (SuperStartNode.substring(36, (SuperStartNode.length() - 2)).toLowerCase());
            
            return StartNode;
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    

/*When the first method "createnode()" gets passed , the nodes are created as vector.
 Then "setProperty" method is passed to store the edges in type "vector". The nodes 
 contain the name of the person , the edges contain the relationship and year* */
        
public static void main (String args[]) throws IOException{
    graphdb g1 = new graphdb();
    Node martin = g1.createNode();
    martin.setProperty("name", "MARTIN");
    Node pramod = g1.createNode();
    pramod.setProperty("name", "PRAMOD");
    Node barbara = g1.createNode();
    barbara.setProperty("name", "Barbara");
    martin.createRelationshipTo(pramod, "FRIENDS", "since = 1998");
    pramod.createRelationshipTo(martin, "FRIENDS", "since = 1998");
    
    //for(int i=0; i<pramod.EdgeVec.size(); i++){    
    //    System.out.println(pramod.EdgeVec.get(i));
    //}
    //int noofedges = g1.Relation_Graph.getVertexCount();
    //int noofedges = martin.Relation_Graph.getEdgeCount();
       //System.out.println(noofedges);

    String StartNode = g1.readQuery("C:\\QueryFile.txt");
    
    Vector<String> SActualNode = martin.checkAllNodes(StartNode);
    String s = SActualNode.get(1);
    System.out.println(s);

    }
}
