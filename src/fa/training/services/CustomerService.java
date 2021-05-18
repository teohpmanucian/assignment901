package fa.training.services;

import java.util.List;

public interface CustomerService {
	List<String> createCustomer();
	List<String> findAll();
	void showAll();
	boolean remove (String phone);
	public List<String> search(String phone);
}
