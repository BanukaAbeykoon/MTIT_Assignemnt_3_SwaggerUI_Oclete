package bartenderconsumer;

import java.util.List;

import java.util.Scanner;
import BartenderService.BartenderService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import Bartender.model.Bartender;
import BartenderImplService.BartenderImplService;

public class Activator implements BundleActivator {

	ServiceReference BartenderServiceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("=====================Hotel Service started.==========================================");
		BartenderServiceReference = context.getServiceReference(BartenderService.class.getName());
		@SuppressWarnings("unchecked")
		BartenderService bartenderService = (BartenderService) context.getService(BartenderServiceReference);
		
		do {
			int selection = 2;
			
			
			do {
			System.out.println("----------------------------Welcome to Hotel-------------------------------");
		
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Enter barstock Details");
			System.out.println("2.Display barstock Details ");
			System.out.println("3.Update barstock Details");
			System.out.println("4.Delete barstock Details");
			System.out.println("5.Search barstock Details");
			System.out.println("6.Exit");
			
			
			System.out.println("Enter your selection...");
			 selection = input.nextInt();
			
			 input.nextLine();
			 if(selection == 6) {
				 exit = true;
			 }
			 
			 
			 	if(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6)  {
				 System.out.println("Please enter a valid selection");
			 	}
				}while(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6) ;
			
				String  backToHome = null;
			
			 
			 	if (selection == 1) {//Handles the adding process of new items to the list
				do {
					System.out.println("Bar Name");
					String bartenderName = input.nextLine();

					System.out.println("BarId");
					String bartenderNIC = input.nextLine();

					System.out.println("No of liquors");
					int  bartenderAge = input.nextInt();
					
					System.out.println("Bar Capacity");
					int bartenderGender = input.nextInt();
					
					input.nextLine();
					//AdminService adminService = new AdminServiceImpl();
					int result = bartenderService.RegisterBartender(bartenderName, bartenderNIC, bartenderAge, bartenderGender);
					 String msg = (result ==1) ? "BarStock added!" :"please enter name";
					   System.out.println(msg);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					}
					while(!(backToHome.equals("0")));
			
				
				
			 		}else if(selection == 2) {
						do {//BartenderService adminService = new BartenderServiceImpl();
						List<Bartender>bartenderList = bartenderService.listBartenders();
						System.out.println("............List of Barstock Details...............");
						System.out.println("-------------------------------------------------------------------------------------------------S");
						for(Bartender man: bartenderList) 
						{
							System.out.println("bar name:" +man.getBarname()+"              bar id: " + man.getBarId()+"              no of liquors:"+man.getNoOfliqours()+"              bar capacity:"+man.getCapacity());
						}
						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						backToHome=input.nextLine();
						}
						while(!(backToHome.equals("0")));
			 		}
					
					else if (selection == 3) {
						do {
							
							System.out.println("Bar Name");
							String bartenderName = input.nextLine();
							
							System.out.println("Bar Id");
							String bartenderNIC = input.nextLine();
							
							System.out.println("No of liquor");
							int bartenderAge = input.nextInt();

							System.out.println("Bar Capacity");
							int bartenderGender = input.nextInt();
							
							input.nextLine();
							
							//AdminService adminService = new AdminServiceImpl();
							int result =bartenderService.updateBartender(bartenderName, bartenderNIC, bartenderAge, bartenderGender);
							String msg = (result ==1) ? "updated the Bartender!" : "please enter a name" ;
							
							System.out.println(msg);
							System.out.println("Press 0 to navigate back to home or press any other key to continue....");
							backToHome=input.nextLine();
							
						}while(!(backToHome.equals("0")));
					
					}
			 
			 
			 
				else if(selection == 4){
				do {
				System.out.println("Bar Name");
				String barname = input.nextLine();
				
				int result =  bartenderService.removeBartender(barname);
				String msg = ( result == 1) ? "Successfully Removed the Bar!" :"Please enter a valid name";
				System.out.println(msg);
				System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				
				backToHome = input.nextLine();
				}
				while(!(backToHome.equals("0")));
				}
			 
			 
			 
				else if (selection == 5) {			
				do
				{
				System.out.println("Enter the Bar Name");
				
				String barname =  input.nextLine();
				
				int result = bartenderService.searchBartender(barname);
				String msg = (result ==1) ? "Bar Found! " : "Bar not Found!";
				   System.out.println(msg);
				   
				   System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				   
				   backToHome = input.nextLine();
					}
					while(!backToHome.equals("0"));
						
		
				}else if(selection == 6) {
					return ;
				}
			 	
		} while(!exit);
					 
		}
	
				public void stop(BundleContext context) throws Exception {
					System.out.println("*******Bartender  consumer stopped.******");
					context.ungetService(BartenderServiceReference);
				}
}