import java.util.List;

import controller.FlowerHelper;
import controller.OrderHelper;
import model.Flower;

public class FlowerTester {

	public static void main(String[] args) {
		Flower Me = new Flower("Rose", "Red");
		
		Me.toString();
		
		System.out.println(Me.toString());
		FlowerHelper fh = new FlowerHelper();
		fh.insertFlower(Me);

		List<Flower>allFlowers = fh.showAllFlowers();
		for(Flower f: allFlowers) {
			System.out.println(f.toString());
		}
//		
//		List<Order> allOrders = oh.showAllOrders();
//		for(Order a: allOrders) {
//			System.out.println(a.toString());
//		}
//		
		
		
	}

}
