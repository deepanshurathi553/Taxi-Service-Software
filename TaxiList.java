import java.util.*;

public class TaxiList{
	
	Myset<Taxi> setOfAllTaxis = new Myset<Taxi>();

	public TaxiList(){

	}

	public void addTaxi(Taxi x){
		setOfAllTaxis.addElement(x);
	}
	

}