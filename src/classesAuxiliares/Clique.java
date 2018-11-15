package classesAuxiliares;
// Teoria dos Grafos - UFCG



import java.util.Iterator;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.clique.DegeneracyBronKerboschCliqueFinder;
import org.jgrapht.alg.clique.PivotBronKerboschCliqueFinder;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.GmlImporter;
import org.jgrapht.io.ImportException;
import org.jgrapht.io.VertexProvider;

public class Clique {
	
	public static void main(String[] args) {
	    //Import Gml
	    VertexProvider <Object> vp1 = 
	    		(label,attributes) -> new DefaultVertex (label,attributes);
	    EdgeProvider <Object,RelationshipEdge> ep1 = 
	    		(from,to,label,attributes) -> new RelationshipEdge(from,to,attributes);
		GmlImporter <Object,RelationshipEdge> gmlImporter = new GmlImporter <> (vp1,ep1);
	    Graph<Object, RelationshipEdge> graphgml = new SimpleGraph<>(RelationshipEdge.class);
  	    try {
	        gmlImporter.importGraph(graphgml, 
	        		ImportGraph.readFile("./src/grafo/lesmis.gml"));
	      } catch (ImportException e) {
	        throw new RuntimeException(e);
	      }	    
	       
	    DegeneracyBronKerboschCliqueFinder <Object,RelationshipEdge> cf2 = 
	    		new DegeneracyBronKerboschCliqueFinder <> (graphgml); 
	    Iterator  <Set <Object>> it2 = cf2.iterator();
	    System.out.print("DegenearyBronKerboschCliqueFinder cliques: \n");
	    while (it2.hasNext()) {
	    	System.out.print(it2.next() + " ");
	    }
	    
	    PivotBronKerboschCliqueFinder <Object,RelationshipEdge> cf3 = 
	    		new PivotBronKerboschCliqueFinder <> (graphgml); 
	    Iterator  <Set <Object>> it3 = cf3.iterator();
	    System.out.print("\n\nPivotBronKerboschCliqueFinder cliques: \n");
	    while (it3.hasNext()) {
	    	System.out.print(it3.next() + " ");
	    	
	    }
	    

	}
	
	
}
