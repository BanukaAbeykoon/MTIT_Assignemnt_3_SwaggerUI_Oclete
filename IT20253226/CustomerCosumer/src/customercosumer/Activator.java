package customercosumer;

import java.util.List;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


import customerModel.Customer;
import customerService.CustomerService;

public class Activator implements BundleActivator {

	ServiceReference CustomerServiceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============Customer Service started.============");
		CustomerServiceReference = context.getServiceReference(CustomerService.class.getName());
		@SuppressWarnings("unchecked")
		CustomerService customerService = (CustomerService) context.getService(CustomerServiceReference);
		
		do {
			int selection = 2;
			do {
			System.out.println("----------------------------Welcome to Hotel-------------------------------");
		
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Register to the system ");
			System.out.println("2.Display Customer");
			System.out.println("3.Update Customer");
			System.out.println("4.Delete Customer");
			System.out.println("5.Search Customer");
			System.out.println("6.Exit");
			
			
			System.out.println("Enter your selection...");
			 selection = input.nextInt();
			
			 input.nextLine();
			 if(selection == 6) {
				 exit = true;
			 }
			 if(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6) {
				 System.out.println("Please enter a valid selection");
			 }
			}while(selection !=1 && selection !=2 && selection !=3  && selection !=4 && selection !=5 && selection !=6);
			
			 String  backToHome = null;
			 if (selection == 1) {//Handles the adding process of new items to the list
				 
				 do {
					 
					System.out.println("Customer Name");
					String Name = input.nextLine();

					System.out.println("Customer Age");
					int Age = input.nextInt();

					System.out.println("Customer NIC");
					int NIC = input.nextInt();
					
					System.out.println("Customer Phone");
					int Phone = input.nextInt();
					
					input.nextLine(); //AdminService adminService = new AdminServiceImpl();
					int result = customerService.RegisterCustomer(Name, Age, NIC, Phone);
					 String msg = (result ==1) ? "Customer added!" :"please enter name";
					   System.out.println(msg);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
				 
			 }else if(selection == 2) {
						do {
						//AdminService adminService = new AdminServiceImpl();
							List<Customer>customerList = customerService.listCustomer();
							System.out.println("............List of Customers...............");
							System.out.println("-------------------------------------------------------------------------------------------------S");
							for(Customer man: customerList) {
							System.out.println(man.getName()+"  " + man.getAge()+"  "+man.getNIC()+"  "+man.getPhone());
							}
							
								System.out.println("Press 0 to navigate back to home or press any other key to continue....");
								backToHome=input.nextLine();
								
						}while(!(backToHome.equals("0")));
			
					}
					
			 else if (selection == 3) {
					do {
						
						System.out.println("Customer Name");
						String Name = input.nextLine();
						System.out.println("Customer Age");
						int Age = input.nextInt();
						System.out.println("Customer NIC");
						int NIC = input.nextInt();
						System.out.println("Customer Phone");
						int Phone = input.nextInt();
						input.nextLine();
						
						//AdminService adminService = new AdminServiceImpl();
						int result =customerService.updateCustomer(Name,Age,NIC, Phone);
						String msg = (result ==1) ? "updated the Customer!" :"please enter a name";
						
						System.out.println(msg);
						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						backToHome=input.nextLine();
						
					}while(!(backToHome.equals("0")));
					
			
			}
				else if (selection == 4) {
					return;
				}
			
				
		}while(!exit);
	}

				public void stop(BundleContext context) throws Exception {
					System.out.println("*******Customer  consumer stopped.******");
					context.ungetService(CustomerServiceReference);
				}
}

