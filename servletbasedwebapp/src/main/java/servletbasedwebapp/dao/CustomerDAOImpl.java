package servletbasedwebapp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import servletbasedwebapp.model.Customer;
import servletbasedwebapp.service.CustomerService;

public class CustomerDAOImpl implements CustomerService{

	@Override
	public Customer addCustomer(Customer customer) {
		Connection conn = servletbasedwebapp.utility.DBConnectionUtil.getDBConnection();
		PreparedStatement pStmt;
		try {
			//pStmt = conn.prepareStatement(sqlInsert);
			pStmt = conn.prepareStatement(servletbasedwebapp.utility.QueryMapper.INSERT_CUSTOMER);
			pStmt.setInt(1, customer.getCustId());
			pStmt.setString(2, customer.getCustName());
			int row = pStmt.executeUpdate();
			if(row !=0) {
				return customer;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer getCustomerById(Integer custId) {
		Customer customer = null;
		Connection conn = servletbasedwebapp.utility.DBConnectionUtil.getDBConnection();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(servletbasedwebapp.utility.QueryMapper.GET_CUSTOMER_BY_ID);
			pStmt.setInt(1, custId);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				customer = new Customer();
				customer.setCustId(custId);
				customer.setCustName(rs.getString(2));
			}
			
			pStmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer; 
	}
	
}
