import java.util.*;

public class ShortPath{
	
	EdgeList thisEdgeList = new EdgeList();
	PositionList thisPositionList = new PositionList();

	Myset<Position> settled;
	Myset<Position> unsettled;

	public Map<Position, Position> deeps;
	public Map<Position, Integer> timeSpan;

	public ShortPath(PositionList p, EdgeList e){
		thisPositionList = p;
		thisEdgeList = e;
	}
	public boolean isSettled(Position njk){
		return settled.isMember(njk);
	}
	
	public Myset<Position> getAllVertexNeibhouringThisVertex(Position c){
		
		Myset<Position> shit = new Myset<Position>();
		for(int i=0;i<thisEdgeList.bir.getSizeSet();i++){
			if(thisEdgeList.bir.getElement(i).start.thisPosition.equals(c.thisPosition) && !isSettled(thisEdgeList.bir.getElement(i).end)){
				shit.addElement(thisEdgeList.bir.getElement(i).end);
			}
			if(thisEdgeList.bir.getElement(i).end.thisPosition.equals(c.thisPosition) && !isSettled(thisEdgeList.bir.getElement(i).start)){
				shit.addElement(thisEdgeList.bir.getElement(i).start);
			}
		}
		return shit; 
	}

	public Position getMinimum(Myset<Position> pos){
		//System.out.println("getMinimum me aa gya");
		Position min = null;
		for(int i=0;i<pos.getSizeSet();i++){
			Position node = pos.getElement(i);
			if(min==null){
                min = node;
            } 
            else{
                if(getShortestDistance(node)<getShortestDistance(min)){
                    min = node;
                }
            }
        }
    	return min;
	}

	public int getShortestDistance(Position v){
		Integer c = timeSpan.get(v);
		if(c == null){
			return Integer.MAX_VALUE;
		}
		else{
			return c;
		}
	}
	public int getDistance(Position a, Position b){
		Edge c = thisEdgeList.getEdge(a, b);
		return c.time;
	}
	public void findMinLength(Position fg){
		Myset<Position> neib = getAllVertexNeibhouringThisVertex(fg);
		for(int i=0;i<neib.getSizeSet();i++){
			if(getShortestDistance(neib.getElement(i))>getShortestDistance(fg) + getDistance(fg, neib.getElement(i))){
				timeSpan.put(neib.getElement(i), getShortestDistance(fg) + getDistance(fg, neib.getElement(i)));
				
				deeps.put(neib.getElement(i), fg);
				//System.out.println(deeps);
				unsettled.addElement(neib.getElement(i));
			}
		}
		//System.out.println(deeps);
	}	
	public void mainFunction(Position imp){
		//System.out.println("main func");
		settled = new Myset<Position>();
		unsettled = new Myset<Position>();
		timeSpan = new HashMap<Position, Integer>();
		deeps = new HashMap<Position, Position>();
		unsettled.addElement(imp);
		timeSpan.put(imp, 0);
		while(unsettled.getSizeSet()>0){
			//System.out.println("while me aa gya");
			Position vgh = getMinimum(unsettled);
			settled.addElement(vgh);
			//System.out.println(unsettled.getSizeSet());
			unsettled.removeElement(vgh);
			//System.out.println(unsettled.getSizeSet());
			findMinLength(vgh);
		}
	}
	public int time(Position desti)
	{
		Integer l =timeSpan.get(desti);
		return l;
	}
	public Myset<Position> getPath(Position destination){
		Myset<Position> path = new Myset<Position>();
		Position temp = destination;
		path.addElement(destination);
		//System.out.println(deeps);

		if(deeps.get(temp)==null){
			//System.out.println("bh");
			return null;
		}
		while (deeps.get(temp) != null){
            temp = deeps.get(temp);
            path.addElement(temp);             
        }
        Myset<Position> path1 = new Myset<Position>();
        for(int i=0;i<path.getSizeSet();i++){
        	path1.addElement(path.getElement(path.getSizeSet()-1-i));
        }

   		return path1;
	}

 }