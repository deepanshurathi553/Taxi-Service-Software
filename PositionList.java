import java.util.*;

public class PositionList{

	Myset<Position> ridam = new Myset<Position>();
	public PositionList(){

	}
	public void addPosition(String xx){
		Position newx = new Position(xx);
		ridam.addElement(newx);
	}

	public Position findPosition(String x){
		for(int i=0;i<ridam.getSizeSet();i++){
			if(ridam.getElement(i).thisPosition.equals(x)){
				return ridam.getElement(i);
			}
		}
		return null;
	}
}