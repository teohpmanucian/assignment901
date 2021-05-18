package fa.training.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.services.CustomerService;
import fa.training.services.OrderService;
import fa.training.utils.Validator;

public class CustomerImp implements CustomerService {
	private List<String> l = new ArrayList<String>();

	@Override
	public List<String> createCustomer() {
		Scanner sc = new Scanner(System.in);
		Customer c = new Customer();
		OrderService odService = new OrderService();
		l.addAll(l);
		System.out.println("----Enter Customer Information----");
		boolean check;
		String phone = "";
		do {
			System.out.println("Enter name");
			c.setName(sc.nextLine());
			do {
				System.out.println("Enter phone");
				phone = sc.nextLine();
			} while (!Validator.isOrderNumber(phone));
			c.setPhoneNumber(phone);
			System.out.println("Enter address");
			c.setAddress(sc.nextLine());
			System.out.println("Enter order info");
			List<Order> orderList = odService.createListOrder();
			c.setListOfOrder(orderList);
			l.add(c.toString());
			System.out.println("Enter N or n to finish entering customer information. Press any key to continue");
			String r = sc.nextLine();
			check = (r.equals("n") || r.equals("N")) ? false : true;
		} while (check);
		return l;
	}

	@Override
	public List<String> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showAll() {
		if (l.size() > 0) {
			for (String sList : l) {
				System.out.println(sList);
			}
		} else {
			System.out.println("No customer");
		}

	}

	@Override
	public boolean remove(String phone) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).contains("phone=" + phone))
				l.remove(i);
			return true;
		}
		return false;
	}

	@Override
	public List<String> search(String phone) {
		List<String> list = new ArrayList<String>();
		for (String item : l) {
			if (item.contains(phone)) {
				list.add(item);
			}
		}
		return list;
	}

}
