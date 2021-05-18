package fa.training.entities;

import java.util.List;

public class Customer  {
	private String name;
	private String phoneNumber;
	private String address;
	private List<Order> listOfOrder;

	public Customer() {
	}

	public Customer(String name, String phoneNumber, String address, List<Order> listOfOrder) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.listOfOrder = listOfOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getListOfOrder() {
		return listOfOrder;
	}

	public void setListOfOrder(List<Order> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}

	@Override
	public String toString() {
		String listoder = "";
		for (Order order : listOfOrder) {
			listoder += order.toString();
		}
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", Order="
				+ listoder + "]";
	}


}
