package fa.training.main;

import java.util.List;
import java.util.Scanner;

import fa.training.entities.Customer;
import fa.training.services.CustomerServices;

public class CustomerManagerment {
	private static List<Customer> listNewCustomer;

	public static void main(String[] args) throws Exception {
		CustomerServices customerServices = new CustomerServices();
		Scanner sc = new Scanner(System.in);
		int option;
		String status = "";
		String str = "";
		boolean check = false;
		do {
			System.out.println("Select option");
			System.out.println("1.Add a new Customer" + "\n2.Show all Customers" + "\n3.Search Customer"
					+ "\n4.Remove Customer" + "\n5.Exit");
			option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				listNewCustomer = customerServices.createCustomer(sc);
				try {
					if (listNewCustomer == null) {
						throw new Exception();
					}
					status = customerServices.save(listNewCustomer);
					System.out.println(status);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
				break;
			case 2:
				List<Customer> listCustomers = customerServices.displayCustomers();
				for (int i = 0; i < listCustomers.size(); i++) {
					System.out.println(listCustomers.get(i).toString());
				}
				break;
			case 3:
				System.out.println("Enter phone number of customer you want to find?");
				str = sc.nextLine();
				System.out.println(customerServices.findCustomerByPhone(str));
				break;
			case 4:
				check = false;
				System.out.println("Enter phone number of customer you want to find?");
				str = sc.nextLine();
				check = customerServices.remove(str);
				if (check == true)
					System.out.println("Delete customer have " + str + " success");
				else
					System.out.println("Delete fail");
				break;
			case 5:
				option = 5;
				break;

			}
		} while (option != 5);
	}
}
