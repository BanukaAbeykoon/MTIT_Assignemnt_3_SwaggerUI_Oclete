package customerService;

import java.util.List;

import customerModel.Customer;

public interface CustomerService {
	public int RegisterCustomer(String roomName, int ageGroup,int roomId, int roomCapacity);
    public List<Customer> listCustomer();
    public int updateCustomer(String roomName, int ageGroup, int roomId, int roomCapacity);
    public int removeCustomer(String roomName);
    public int searchCustomer(String roomName);
	
}
