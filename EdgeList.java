import java.util.*;

public class EdgeList{

	Myset<Edge> bir = new Myset<Edge>();
	public EdgeList(){

	}
	public Edge getEdge(Position x, Position y){
		for(int c=0;c<bir.getSizeSet();c++){
			if(bir.getElement(c).start.thisPosition.equals(x.thisPosition)){
				if(bir.getElement(c).end.thisPosition.equals(y.thisPosition)){
					return bir.getElement(c);
				}
			}
			if(bir.getElement(c).end.thisPosition.equals(x.thisPosition)){
				if(bir.getElement(c).start.thisPosition.equals(y.thisPosition)){
					return bir.getElement(c);
				}
			}
		}
		return null;
	}

	public void addEdge(Position x, Position y, int t){
		Edge newx = new Edge(x, y, t);
		bir.addElement(newx);
	}
	public Myset<Edge> getAllEdgesThroughThisVertex(Position x){
		//System.out.println("Ha abhai");
		Myset<Edge> vh1 = new Myset<Edge>();

		for(int i=0;i<bir.getSizeSet();i++){
			if(bir.getElement(i).start.thisPosition.equals(x.thisPosition) || bir.getElement(i).end.thisPosition.equals(x.thisPosition)){
				vh1.addElement(bir.getElement(i));
			}
		}
		return vh1;
	}
}