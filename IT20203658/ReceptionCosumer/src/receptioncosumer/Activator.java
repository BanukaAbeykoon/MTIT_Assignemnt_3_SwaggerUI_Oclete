package receptioncosumer;

import java.util.List;
import java.util.Scanner;
import receptionService.ReceptionService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import receptionimplService.ReceptionImplService;
import receptionModel.Reception;

public class Activator implements BundleActivator {

	ServiceReference ReceptionServiceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============Reception Service started.============");
		ReceptionServiceReference = context.getServiceReference(ReceptionService.class.getName());
		@SuppressWarnings("unchecked")
		ReceptionService receptionService = (ReceptionService) context.getService(ReceptionServiceReference);
		
		do {
			int selection = 2;
			do {
			System.out.println("----------------------------Welcome to Hotel-------------------------------");
		
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Register to the system ");
			System.out.println("2.Display Reception");
			System.out.println("3.Update Reception");
			System.out.println("4.Delete Reception");
			System.out.println("5.Search Reception");
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
			}while(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=6);
			
			 String  backToHome = null;
			 if (selection == 1) {//Handles the adding process of new items to the list
				 
				 do {
					System.out.println("Room Name");
					String roomName = input.nextLine();

					System.out.println("Age Group");
					int ageGroup = input.nextInt();

					System.out.println("Room ID");
					int roomId = input.nextInt();
					
					System.out.println("Room Capacity");
					int roomCapacity = input.nextInt();
					
					input.nextLine(); //AdminService adminService = new AdminServiceImpl();
					int result = receptionService.RegisterReception(roomName, ageGroup, roomId, roomCapacity);
					 String msg = (result ==1) ? "Reciption added!" :"please enter name";
					   System.out.println(msg);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}while(!(backToHome.equals("0")));
				 
			 }else if(selection == 2) {
						do {
						//AdminService adminService = new AdminServiceImpl();
							List<Reception>receptionList = receptionService.listReception();
							System.out.println("............List of Reception...............");
							System.out.println("-------------------------------------------------------------------------------------------------S");
							for(Reception man: receptionList) {
							System.out.println(man.getRoomName()+"  " + man.getAgeGroup()+"  "+man.getRoomId()+"  "+man.getRoomCapacity());
							}
							
								System.out.println("Press 0 to navigate back to home or press any other key to continue....");
								backToHome=input.nextLine();
								
						}while(!(backToHome.equals("0")));
			
					}
					else if (selection == 3) {
						do {
							
							System.out.println("Room Name");
							String Name = input.nextLine();
							System.out.println("Age Group");
							int Age = input.nextInt();
							System.out.println("Room ID");
							int RoomID = input.nextInt();
							System.out.println("Room Capacity");
							int RoomCapacity = input.nextInt();
							input.nextLine();
							
							//AdminService adminService = new AdminServiceImpl();
							int result =receptionService.updateReception(Name,Age,RoomID, RoomCapacity);
							String msg = (result ==1) ? "updated the Reception!" :"please enter a name";
							
							System.out.println(msg);System.out.println("Press 0 to navigate back to home or press any other key to continue....");
							backToHome=input.nextLine();
							
						}while(!(backToHome.equals("0")));
						
				
				}else if(selection == 4){
					do {
						System.out.println("Room Name");
						String Name = input.nextLine();
						
						int result =  receptionService.removeReception(Name);
						String msg = ( result == 1) ? "Successfully Removed the Room!" :"Please enter a valid name";
						System.out.println(msg);
						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						
						backToHome = input.nextLine();
					}while(!(backToHome.equals("0")));
				}
			 
			 
			 
					else if (selection == 5) {
						do {
							System.out.println("Enter the Room Name");
							
							String Name =  input.nextLine();
							
							int result = receptionService.searchReception(Name);
							String msg = (result ==1) ? "Reception Found! " : "Reception not Found!";
							   System.out.println(msg);
							   
							   System.out.println("Press 0 to navigate back to home or press any other key to continue....");
							   
							   backToHome = input.nextLine();
						}
						
						while(!backToHome.equals("0"));
						
						
					}else if(selection == 6) {
						return ;
					}
				
		}while(!exit);
	}

				public void stop(BundleContext context) throws Exception {
					System.out.println("*******reception  consumer stopped.******");
					context.ungetService(ReceptionServiceReference);
				}
}

