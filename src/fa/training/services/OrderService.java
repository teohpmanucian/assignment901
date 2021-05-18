package fa.training.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Order;
import fa.training.utils.Validator;

public class OrderService {

	public Order createOrder()  {
		Scanner sc = new Scanner(System.in);
		String number = "";
			Order orderItem = new Order(); 
			do {
				System.out.println("+ number: ");
				number = sc.nextLine();

			}while(!Validator.isOrderNumber(number));
			orderItem.setNumber(number);

			System.out.println("+ Date: ");
			String d = sc.nextLine();
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = null;
			try {
				date = formatter.parse(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			orderItem.setDate(date);
		return orderItem;
	}
	public List<Order> createListOrder () {
		List<Order> orderList = new ArrayList<Order>();
		boolean check = true;
		Scanner sc = new Scanner(System.in);

		do {
			Order o = createOrder();
			orderList.add(o);
			System.out.println("Enter N or n to finish entering order information. Press any key to continue");
			String r = sc.nextLine();
			check = (r.equals("N")|| r.equals("n"))?false:true;
		}while(check);
		return orderList;
		
		
	}
}
