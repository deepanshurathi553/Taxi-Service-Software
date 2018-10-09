import java.util.*;
public class TaxiService{
	
	public TaxiService(){
		
	}
	EdgeList edgeSet = new EdgeList();
	PositionList positionSet = new PositionList();
	//PathList pathSet = new PathList();
	TaxiList taxiSet = new TaxiList();
	ShortPath pathSet = new ShortPath(positionSet, edgeSet);
	public void addEdgeToMap(String x, String y, int t){
		if(positionSet.findPosition(x) != null &&positionSet.findPosition(y)!= null){
			edgeSet.addEdge(positionSet.findPosition(x), positionSet.findPosition(y), t);
		}
		else{
			if(positionSet.findPosition(x)==null){
				positionSet.addPosition(x);
			}
			if(positionSet.findPosition(y)==null){
				positionSet.addPosition(y);
			}
			edgeSet.addEdge(positionSet.findPosition(x), positionSet.findPosition(y), t);
		}
	}
	/*public void thisloop(Path xj, Position xy, String x, String y){
		System.out.println("thisLopp me aa gaya");
		Myset<Edge> cgsuck = edgeSet.getAllEdgesThroughThisVertex(xy);
		System.out.println(cgsuck.getSizeSet());
		for(int i=0;i<cgsuck.getSizeSet();i++){
			System.out.println(i);
			if(cgsuck.getElement(i).end.thisPosition.equals(y) || cgsuck.getElement(i).start.thisPosition.equals(y)){
				System.out.println("if me aa gya");
				xj.addEdgeForThisPath(cgsuck.getElement(i));
				System.out.println(xj.edgeSetOfThisPath.getSizeSet());
				pathSet.addPath(xj);
				System.out.println(pathSet.setOfAllPaths.getSizeSet());
				xj.removeTheEdge(cgsuck.getElement(i));
				continue;
			}
			
			if(cgsuck.getElement(i).end.thisPosition.equals(x) &&!xy.thisPosition.equals(x)){
				continue;
			}
			
			if(cgsuck.getElement(i).start.thisPosition.equals(x) &&!xy.thisPosition.equals(x)){
				continue;
			}

			xj.addEdgeForThisPath(cgsuck.getElement(i));
			System.out.println(xj.edgeSetOfThisPath.getSizeSet());
			if(xj.edgeSetOfThisPath.getSizeSet() >3){
				break;
			}
			thisloop(xj, cgsuck.getElement(i).end, x, y);
			
		}
	}*/
	/*public void dfs(Myset<Path> fuck, Myset<Position> settled, Position a, Position b, int k, Position cf){
		//System.out.println("dfs me aaya");
		//System.out.println("fuck ki size"+fuck.getSizeSet());
		//System.out.println("settled ki size"+settled.getSizeSet());
		//System.out.println("k"+k);
		//settled.addElement(a);
		Myset<Edge> cgsuck = edgeSet.getAllEdgesThroughThisVertex(a);
		int d=cgsuck.getSizeSet();
		Myset<Position> shit = new Myset<Position>();
		for(int j=0;j<d;j++){
			if(!cgsuck.getElement(j).start.thisPosition.equals(a.thisPosition)){
				shit.addElement(cgsuck.getElement(j).start);
			}
			if(!cgsuck.getElement(j).end.thisPosition.equals(a.thisPosition)){
				shit.addElement(cgsuck.getElement(j).end);
			}
		}

		for(int i=0;i<d;i++){
			//System.out.println(i + " " +shit.getElement(i).thisPosition);
			System.out.println("i="+i);
			if(settled.set1.list1.contains(shit.getElement(i))!=true && settled.isMember(a)){
				System.out.println(i + " " +shit.getElement(i).thisPosition);
				settled.addElement(shit.getElement(i));
				//System.out.println(settled.getSizeSet());
				if(!shit.getElement(i).thisPosition.equals(b.thisPosition)){
					if(fuck.getSizeSet()>k){
						fuck.getElement(k).edgeSetOfThisPath.addElement(cgsuck.getElement(i));
						//settled.addElement(shit.getElement(i));
						dfs(fuck, settled, shit.getElement(i), b, k, cf);
					}
					else{
						Path pj = new Path(cf, b, 0);
						fuck.addElement(pj);
						fuck.getElement(k).edgeSetOfThisPath.addElement(cgsuck.getElement(i));
						//settled.addElement(shit.getElement(i));
						dfs(fuck, settled, shit.getElement(i), b, k, cf);
					}
				}
				if(shit.getElement(i).thisPosition.equals(b.thisPosition)){
					System.out.println("isme aaya");
					if(fuck.getSizeSet()>k){
						System.out.println("if m hu");
						fuck.getElement(k).edgeSetOfThisPath.addElement(cgsuck.getElement(i));
						//settled.addElement(shit.getElement(i));
						pathSet.addPath(fuck.getElement(k));
						k++;
						System.out.println(pathSet.setOfAllPaths.getSizeSet());
						break;
					}
					else{
						Path pj = new Path(cf, b, 0);
						fuck.addElement(pj);
						fuck.getElement(k).edgeSetOfThisPath.addElement(cgsuck.getElement(i));
						//settled.addElement(shit.getElement(i));
						pathSet.addPath(fuck.getElement(k));

						k++;
						break;	
					}
				}
			}
			if(settled.set1.list1.contains(positionSet.findPosition(shit.getElement(i).thisPosition))==true && shit.getElement(i).thisPosition.equals(b.thisPosition)){
				if(fuck.getSizeSet()>k){
						fuck.getElement(k).edgeSetOfThisPath.addElement(cgsuck.getElement(i));
						//settled.addElement(shit.getElement(i));
						pathSet.addPath(fuck.getElement(k));
						k++;
						break;
					}
					else{
						Path pj = new Path(cf, b, 0);
						fuck.addElement(pj);
						fuck.getElement(k).edgeSetOfThisPath.addElement(cgsuck.getElement(i));
						//settled.addElement(shit.getElement(i));
						pathSet.addPath(fuck.getElement(k));
						k++;
						break;	
					}
			}
		}
		//System.out.println("pathSet ki size" + pathSet.setOfAllPaths.getSizeSet());
	}

	public void addPaths(String x, String y){
		Position source = positionSet.findPosition(x);
		Position destination = positionSet.findPosition(y);
		System.out.println("Add path me a gay");
		/*Path xj = new Path(source, destination, 0);
		thisloop(xj, source, x, y);
		
		Myset<Path> fuck = new Myset<Path>();
		//System.out.println("fuck ki size"+fuck.getSizeSet());
		Myset<Position> settled = new Myset<Position>();
		settled.addElement(source);
		//System.out.println("settled ki size"+settled.getSizeSet());
		int k=0;
		//System.out.println("k"+k);
		dfs(fuck, settled, source, destination, k, source);

	}*/

	/*public void allotTimeToEachPath(){
		for(int i=0;i<pathSet.setOfAllPaths.getSizeSet();i++){
			pathSet.setOfAllPaths.getElement(i).totalTime=0;
			for(int j=0;j<pathSet.setOfAllPaths.getElement(i).edgeSetOfThisPath.getSizeSet();j++){
				pathSet.setOfAllPaths.getElement(i).totalTime += pathSet.setOfAllPaths.getElement(i).edgeSetOfThisPath.getElement(j).time;
			}
		}
	}*/
	/*public Path returnMinPath(String x, String y){
		//System.out.println(pathSet.setOfAllPaths.getSizeSet());
		//System.out.println(x+"888");
		//System.out.println(y+"88");

		Myset<Path> cv = pathSet.getPaths(positionSet.findPosition(x), positionSet.findPosition(y));
		/*for(int i=0;i<pathSet.setOfAllPaths.getSizeSet();i++){
			if(pathSet.setOfAllPaths.getElement(i).thisSource.thisPosition.equals(x)){
				if(pathSet.setOfAllPaths.getElement(i).thisDestination.thisPosition.equals(y)){
					cv.addElement(pathSet.setOfAllPaths.getElement(i));
				}
			}
		}
		
		Path min = cv.getElement(0);
		for(int u=1;u<cv.getSizeSet();u++){
			if(cv.getElement(u).totalTime < min.totalTime){
				min = cv.getElement(u);
			}
		}
		return min;
	}*/
	/*public int distanceGraph(String x, String y){
		Path distanceGraph = returnMinPath(x, y);
		return distanceGraph.totalTime;
	}*/

	public void addTaxiToMap(String x, String y){
		Position p = positionSet.findPosition(y);
		Taxi ch = new Taxi(x, p, 0);
		if(p!=null){
			taxiSet.addTaxi(ch);
		}
		else{
			System.out.println("No Such Position Exist");
		}
	}

	public void performAction(String actionMessage){
		System.out.println("action to be performed: " + actionMessage);
		String[] tmp = actionMessage.split(" ");
		if(tmp[0].equals("edge")){
			int timegiven = Integer.parseInt(tmp[3]);
			addEdgeToMap(tmp[1], tmp[2], timegiven);
			System.out.println("Edge added : " + tmp[1] + "--" + tmp[2] + " distance = " + tmp[3]);
		}
		if(tmp[0].equals("taxi")){
			addTaxiToMap(tmp[1], tmp[2]);
			System.out.println("Taxi " + tmp[1] + " added at " + tmp[2]);
			//System.out.println(edgeSet.getAllEdgesThroughThisVertex(positionSet.findPosition("AIIMS")).getSizeSet());
			//System.out.println(edgeSet.getAllEdgesThroughThisVertex(positionSet.findPosition("iitmaingate")).getSizeSet());
		}
		if(tmp[0].equals("customer")){
			/*if(positionSet.findPosition(tmp[1])!=null && positionSet.findPosition(tmp[2])!=null){
			addPaths(tmp[1], tmp[2]);
			for(int i=0;i<taxiSet.setOfAllTaxis.getSizeSet();i++){
				addPaths(taxiSet.setOfAllTaxis.getElement(i).currPosition.thisPosition, tmp[1]);
			}
			allotTimeToEachPath();
			Myset<Taxi> availableTaxis = new Myset<Taxi>();
			for(int i=0;i<taxiSet.setOfAllTaxis.getSizeSet();i++){
				if(taxiSet.setOfAllTaxis.getElement(i).availability == 0){
					availableTaxis.addElement(taxiSet.setOfAllTaxis.getElement(i));
				}
			}
			System.out.println("Available Taxis :");
			for(int j=0;j<availableTaxis.getSizeSet();j++){
				if(!availableTaxis.getElement(j).currPosition.thisPosition.equals(tmp[1])){
					Path x = returnMinPath(availableTaxis.getElement(j).currPosition.thisPosition, tmp[1]);
					Myset<Position> c = new Myset<Position>();
					c.addElement(availableTaxis.getElement(j).currPosition);
					for(int p=0;p<x.edgeSetOfThisPath.getSizeSet();p++){
						if(p>=1){
							if(c.isMember(x.edgeSetOfThisPath.getElement(p).start)){
								c.addElement(x.edgeSetOfThisPath.getElement(p).end);
							}
							if(c.isMember(x.edgeSetOfThisPath.getElement(p).end)){
								c.addElement(x.edgeSetOfThisPath.getElement(p).start);
							}
						}
						else{
						if(!c.isMember(x.edgeSetOfThisPath.getElement(p).start)){
							c.addElement(x.edgeSetOfThisPath.getElement(p).start);
						}
						if(!c.isMember(x.edgeSetOfThisPath.getElement(p).end)){
							c.addElement(x.edgeSetOfThisPath.getElement(p).end);
						}
						}
					}
					System.out.print("Path of Taxi " + availableTaxis.getElement(j).taxiName + " : " );
					for(int l=0;l<c.getSizeSet()-1;l++){
						System.out.print(c.getElement(l).thisPosition + ", ");
					}
					System.out.println(tmp[1] + ". " + "Time Taken is : " + x.totalTime);
				}
				else{
					System.out.print("Path of Taxi " + availableTaxis.getElement(j).taxiName + " : " );
					System.out.println(tmp[1] + ". " + "Time Taken is : 0");
				}
			}
			System.out.println(" ");
			}
			else{
				System.out.println("Please put the correct stations");
			}*/
			int kil = 1000;
			Taxi best = new Taxi(null, null, 0);
			int timeCust = Integer.parseInt(tmp[3]);
			if(positionSet.findPosition(tmp[1])!=null && positionSet.findPosition(tmp[2])!=null){
			for(int i=0;i<positionSet.ridam.getSizeSet();i++){
				if(positionSet.ridam.getElement(i).thisPosition.equals(tmp[1])){
					//System.out.println("if me aa gya");
					
					System.out.println("Available Taxis : ");
					
					for(int j=0;j<taxiSet.setOfAllTaxis.getSizeSet();j++){
						//System.out.println("for me aa gya");
						Myset<Taxi> setOfAvailableTaxis = new Myset<Taxi>();
						if(taxiSet.setOfAllTaxis.getElement(j).availability<timeCust){
						setOfAvailableTaxis.addElement(taxiSet.setOfAllTaxis.getElement(j)); 
						pathSet.mainFunction(taxiSet.setOfAllTaxis.getElement(j).currPosition);
						Myset<Position> cf = pathSet.getPath(positionSet.ridam.getElement(i));
						System.out.print("Taxi : " + taxiSet.setOfAllTaxis.getElement(j).taxiName + " " + taxiSet.setOfAllTaxis.getElement(j).currPosition.thisPosition + " ");
						
						if(cf!=null){
							for(int k=1;k<cf.getSizeSet()-1;k++){
							System.out.print(cf.getElement(k).thisPosition + ", ");
							}
						}

						System.out.print(positionSet.ridam.getElement(i).thisPosition); 
						System.out.println(". Time Taken is : " + pathSet.getShortestDistance(positionSet.ridam.getElement(i)) + " units.");
						if(kil>pathSet.getShortestDistance(positionSet.ridam.getElement(i))){
							kil = pathSet.getShortestDistance(positionSet.ridam.getElement(i));
							best = taxiSet.setOfAllTaxis.getElement(j);
						}
						
						}
						//System.out.println(best.availability);
					}	
				}
				if(positionSet.ridam.getElement(i).thisPosition.equals(tmp[1])){
					pathSet.mainFunction(positionSet.ridam.getElement(i));
				}
			}
			System.out.println("*** Chose " + best.taxiName + " to service the customer request ***");
			for(int i=0;i<positionSet.ridam.getSizeSet();i++){	
				if(positionSet.ridam.getElement(i).thisPosition.equals(tmp[2])){
					System.out.println("Path of Customer : ");
					
					Myset<Position> cf1 = pathSet.getPath(positionSet.ridam.getElement(i));
					if(cf1!=null){
					for(int k=0;k<cf1.getSizeSet()-1;k++){
						System.out.print(cf1.getElement(k).thisPosition + ", ");
					}
					}
					System.out.print(positionSet.ridam.getElement(i).thisPosition);
					System.out.print(". Time Taken is : " + pathSet.getShortestDistance(positionSet.ridam.getElement(i)) + " units.");
					int gh= pathSet.getShortestDistance(positionSet.ridam.getElement(i));
					//System.out.println(gh);
					/*for(int l=0;l<taxiSet.setOfAllTaxis.getSizeSet();l++){
				System.out.println(taxiSet.setOfAllTaxis.getElement(l).availability);
			}*/	System.out.println("");
				System.out.println("Total Time is : " + (gh + kil));
					
					best.availability = gh;
					/*for(int l=0;l<taxiSet.setOfAllTaxis.getSizeSet();l++){
				System.out.println(taxiSet.setOfAllTaxis.getElement(l).availability);
			}
				}*/
				/*for(int l=0;l<taxiSet.setOfAllTaxis.getSizeSet();l++){
				System.out.println(taxiSet.setOfAllTaxis.getElement(l).availability);
			}*/
			}
			/*for(int l=0;l<taxiSet.setOfAllTaxis.getSizeSet();l++){
				System.out.println(taxiSet.setOfAllTaxis.getElement(l).availability);
			}*/
			}
			for(int bir=0;bir<taxiSet.setOfAllTaxis.getSizeSet();bir++){
				if(best.taxiName.equals(taxiSet.setOfAllTaxis.getElement(bir).taxiName)){
					//System.out.println(kil);
					//System.out.println(best.availability);
					//System.out.println(taxiSet.setOfAllTaxis.getElement(bir).availability);
					taxiSet.setOfAllTaxis.getElement(bir).availability += timeCust + kil;
					taxiSet.setOfAllTaxis.getElement(bir).currPosition = positionSet.findPosition(tmp[2]);
				}
			}
			/*for(int l=0;l<taxiSet.setOfAllTaxis.getSizeSet();l++){
				System.out.println(taxiSet.setOfAllTaxis.getElement(l).availability);
			}*/
			}
			else{
				System.out.println("Please Provide Correct inputs");
			}
		}
		if(tmp[0].equals("printTaxiPosition")){
			int timer = Integer.parseInt(tmp[1]);
			for(int i=0;i<taxiSet.setOfAllTaxis.getSizeSet();i++){
				if(taxiSet.setOfAllTaxis.getElement(i).availability<=timer){
					System.out.println("Taxi " + taxiSet.setOfAllTaxis.getElement(i).taxiName + ": " + taxiSet.setOfAllTaxis.getElement(i).currPosition.thisPosition);
				}
			}
		}
	}
}
