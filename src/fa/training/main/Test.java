package fa.training.main;

import java.util.List;
import java.util.Scanner;

import fa.training.dao.CustomerImp;

public class Test {
	public static void main(String[] args) {
		CustomerImp cusImpl = new CustomerImp();
		Scanner sc = new Scanner(System.in);
		int c;
		
		boolean check = true;
		do {
			System.out.println("Choose function: ");
			System.out.println("1. Add new a Customer");
			System.out.println("2. Show all Customer");
			System.out.println("3. Search Customer");
			System.out.println("4. Remove Customer");
			System.out.println("5. Exit");
			c = Integer.parseInt(sc.nextLine());
			switch (c) {
			case 1:
				System.out.println("1");
				cusImpl.createCustomer();
				break;
			case 2:
				System.out.println("2");
				cusImpl.showAll();
				break;
			case 3:
				System.out.println("Enter Customer Phone number ");
				String sPhone = sc.nextLine();
				List<String> searchList = cusImpl.search(sPhone);
				if(searchList.size()==0) {
					System.out.println("Customer not exits");
				}else {
					for (String s : searchList) {
						System.out.println(s);
					}
				}
				break;
			case 4:
				System.out.println("Enter Customer Phone number ");
				String phone = sc.nextLine();
				if (cusImpl.remove(phone)) {
					System.out.println("Remove success");
				} else {
					System.out.println("Customer not exits");
				}
				break;
			case 5:
				System.out.println("EXIT");
				check = false;
				break;
			default:
				System.out.println("Enter 1 to 5");
				break;
			}
		} while (check);

	}
}
