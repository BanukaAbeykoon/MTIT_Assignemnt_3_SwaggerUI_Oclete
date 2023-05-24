package managerconsumer;

import java.util.List;
import java.util.Scanner;
import managerService.ManagerService;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import manager.model.Manager;
import managerImplService.ManagerImplService;
import managerService.ManagerService;

public class Activator implements BundleActivator {

	ServiceReference ManagerServiceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============Hotel Service started.============");
		ManagerServiceReference = context.getServiceReference(ManagerService.class.getName());
		@SuppressWarnings("unchecked")
		ManagerService managerService = (ManagerService) context.getService(ManagerServiceReference);
		
		do {
			int selection = 0;
			do {
			System.out.println("----------------------------Welcome to Hotel-------------------------------");
		
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Register to the system ");
			System.out.println("2.Display Managers ");
			System.out.println("3.Update Manager ");
			System.out.println("4.Delete Manager: ");
			System.out.println("5.Search Manager: ");
			System.out.println("6.Exit");
			
			System.out.println("Enter your selection...");
			 selection = input.nextInt();
			
			 input.nextLine();
			 if(selection == 6) {
				 exit = true;
			 }
			 if(selection !=1 && selection !=2 && selection !=3 && selection !=4 &&selection !=5 && selection !=6) {
				 System.out.println("Please enter a valid selection");
			 }
			}while(selection !=1 && selection !=2 && selection !=3 && selection !=4 &&selection !=5 && selection !=6);
			
			 String  backToHome = null;
			 if (selection == 1) {//Handles the adding process of new items to the list
					do {
					System.out.println("Manager Name");
					String name = input.nextLine();

					System.out.println("Manager NIC");
					String nic = input.nextLine();

					System.out.println("Manager Age");
					int age = input.nextInt();
					
					System.out.println("Manager Gender");
					String gender = input.next();
					
					input.nextLine();
					
					int result = managerService.RegisterManager(name, nic, age, gender);
					 String msg = (result ==1) ? "Manager added!" :"please enter name";
					   System.out.println(msg);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
					
				}
			 
			 
			 
			 else if(selection == 2) {
					do {
					
						List<Manager>parentsList = managerService.listManagers();
						System.out.println("............List of Managers...............");
						System.out.println("-------------------------------------------------------------------------------------------------S");
						for(Manager man: parentsList) {
						System.out.println(man.getName()+"  " +man.getNic()+"  "+man.getAge()+"  "+man.getGender()+"  ");
						}
						
							System.out.println("Press 0 to navigate back to home or press any other key to continue....");
							backToHome=input.nextLine();
							
					}while(!(backToHome.equals("0")));
		
				}
			 
			 
			 else if (selection == 3) {
					do {
						System.out.println("Manager name");
						String updatedManagerName = input.nextLine();

						System.out.println("Manager NIC");
						String updatedManagerNic = input.next();

						System.out.println("Manager age");
						int updatedManagerAge = input.nextInt();
						
						System.out.println("Manager Gender");
						String updatedManagerGender = input.next();
						input.nextLine();
						
						//managerService managerService = new managerService();
					int result =managerService.updateManager(updatedManagerName,updatedManagerNic,updatedManagerAge, updatedManagerGender);
					  String msg = (result ==1) ? "updated the Manager!" :"please enter a name";
					   System.out.println(msg);
		           System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
					
				}
			 
			 
			 else if (selection == 4) {//Handles the removing process of an existing item in the list 
					do {
					System.out.println("Enter the Manager name");

					String name = input.nextLine();
					int result =managerService.removeManager(name);
					   String msg = (result ==1) ? "Successfully Removed the Manager!" :"please enter a valid name";
					   System.out.println(msg);
		              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));

			 
			 }
			 
			 else if(selection == 5) {//Handles the searching process of an existing item in the list
					do {
					
					System.out.println("Enter the Manager name");
					

					String managerName = input.nextLine();
					//AdminService adminService = new AdminServiceImpl();
					int result =managerService.searchManager(managerName);//Consumes the ManagerService searchItems()
					 String msg = (result ==1) ? "Manager found!" :"Manager not found!";
					   System.out.println(msg);
					
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));
				
				}
			 
			 
			 else if(selection == 6) {
					return ;
			 
			 }}while(!exit);
	}

				public void stop(BundleContext context) throws Exception {
					System.out.println("******************Manager  consumer stopped.***************");
					context.ungetService(ManagerServiceReference);
				}
}
	
