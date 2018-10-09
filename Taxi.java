import java.util.*;

public class Taxi{
	
	String taxiName;
	Position currPosition;
	int availability;

	public Taxi(String y, Position x, int t){
		taxiName = y;
		currPosition = x;
		availability = t;
	}
}