package servletbasedwebapp.dao;

import servletbasedwebapp.model.Customer;

public interface CustomerDAO {
	public Customer addCustomer (Customer customer);
	public Customer getCustomer (Customer customer);
}
