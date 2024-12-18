package servletbasedwebapp.service;

import servletbasedwebapp.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer getCustomerById(Integer custId);
}