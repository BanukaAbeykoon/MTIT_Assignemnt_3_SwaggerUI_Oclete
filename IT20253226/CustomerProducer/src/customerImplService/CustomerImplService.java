package customerImplService;

import java.util.List;


import customerModel.Customer;
import customerService.CustomerService;
import customerStore.CustomerStore;

public class CustomerImplService implements CustomerService{
	
	@Override
	public int RegisterCustomer (String Name, int Age,int NIC, int Phone) {
     Customer newCustomer = new Customer(Name , Age , NIC , Phone);
     CustomerStore.customerList.add(newCustomer);
		return 1;
	}
	
	@Override
	public List<Customer> listCustomer(){
		return CustomerStore.customerList;
	}
	
	@Override
    public int updateCustomer(String Name, int age, int NIC, int phone) {
		Customer customerToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Customer tempCustomer : CustomerStore.customerList) {
			count++;
			if (tempCustomer.getName().equalsIgnoreCase(Name)) {
				
				customerToBeUpdated = tempCustomer;
			       invalid = false;
				   break;
				}
			
			}
		    if (!invalid) {
				
		    customerToBeUpdated.setName(Name);
		    customerToBeUpdated.setAge(age);
			customerToBeUpdated.setNIC(NIC);
			customerToBeUpdated.setPhone(phone);
			
			CustomerStore.customerList.set(count, customerToBeUpdated);
			return 1;
			
			} 
			else 
			{
				return -1;
				
			}
	}
		    @Override
		    public synchronized int removeCustomer(String Name) 
		    {
		    	boolean invalid = true;
		    	int count = -1;
		    	for (Customer tempItem :CustomerStore.customerList) 
		    	{
		    		count++;
		    	if (tempItem.getName().equalsIgnoreCase(Name)) 
		    	{
		    		invalid = false;
		    	    break;
		    	 }
		    	}
		    	if (!invalid)
		    	{
		    		CustomerStore.customerList.remove(count);
		    	     return 1;
		    	} else 
		    	{
		    		
		    		return -1;
		    		}
		    	
}
		    @Override
		    public int searchCustomer(String Name) 
		    	{
		    		boolean valid = false;
		    		for (Customer tempItem : CustomerStore.customerList) 
		    		{
		    			if (tempItem.getName().equalsIgnoreCase(Name)) 
		    			{
		    				valid = true;
		    			break;
		    			
		    			}
		    			}
		    		if(valid) 
		    		{
		    			return 1;
		    			
		    		}
		    		else 
		    		{
		    			return -1;
		    		}}
		    
	}




