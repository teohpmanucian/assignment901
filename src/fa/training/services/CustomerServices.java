package fa.training.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Customer;
import fa.training.utils.Validator;

public class CustomerServices {

	public List<Customer> createCustomer(Scanner sc) throws ParseException {
		Customer customer;
		OrderService orderService = new OrderService();
		ArrayList<Customer> customers = new ArrayList<>();
		boolean status = false;
		String loop = "";
		String str = "";
		do {
			customer = new Customer();
			System.out.println("Create New Customer");
			System.out.println("Enter name customer");
			customer.setName(sc.nextLine());

			System.out.println("Enter phone number:");
			do {
				status = false;
				str = sc.nextLine();
				if (!Validator.isPhoneNumber(str)) {
					status = true;
					System.out.println("Enter again");
				}
				customer.setPhoneNumber(str);
			} while (status);

			System.out.println("Enter Address");
			customer.setAddress(sc.nextLine());

			System.out.println("Enter total order");
			int total = Integer.parseInt(sc.nextLine());

			System.out.println("Enter Order");
			customer.setListOfOrder(orderService.createOrder(sc, total));

			customers.add(customer);
			System.out.println("Do you want continue create customer Y/N ?");
			str = sc.nextLine();
			if (str.equals("N") || str.equals("n"))
				loop = "N";
			else
				loop = "Y";
		} while (loop.equals("Y"));

		return customers;
	}

	public String save(List<Customer> customers) throws Exception {
		ObjectOutputStream objectOutputStream = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("D:/FileInputJava/customer.dat");
			objectOutputStream = new ObjectOutputStream(fos);
			objectOutputStream.writeObject(customers);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception();
		} finally {
			if (objectOutputStream != null)
				objectOutputStream.close();
			if (fos != null)
				fos.close();
		}
		return "Save success";
	}

	@SuppressWarnings("unchecked")
	public List<Customer> displayCustomers() throws IOException {
		ObjectInputStream objectInputStream = null;
		FileInputStream fis = null;
		List<Customer> listCustomer = new ArrayList<>();
		try {
			fis = new FileInputStream("D:/FileInputJava/customer.dat");
			objectInputStream = new ObjectInputStream(fis);
			listCustomer = (List<Customer>) objectInputStream.readObject();
		} catch (Exception e) {
		} finally {
			if (objectInputStream != null)
				objectInputStream.close();
			if (fis != null)
				fis.close();
		}
		return listCustomer;
	}

	public String findCustomerByPhone(String phoneNumber) throws Exception {
		List<Customer> listCustomer = displayCustomers();
		for (int i = 0; i < listCustomer.size(); i++) {
			if (phoneNumber.equals(listCustomer.get(i).getPhoneNumber())) {
				return listCustomer.get(i).toString();
			}
		}
		return "Phone Number is not in the list customers";
	}

	public boolean remove(String phoneNumber) throws Exception {
		List<Customer> listCustomers = displayCustomers();
		for (int i = 0; i < listCustomers.size(); i++) {
			if (phoneNumber.equals(listCustomers.get(i).getPhoneNumber())) {
				listCustomers.remove(i);
				this.save(listCustomers);
				return true;
			}
		}
		return false;
	}
}
