package managerImplService;

import java.util.List;

import manager.model.Manager;
import managerService.ManagerService;
import managerStore.ManagerStore;


public class ManagerImplService implements ManagerService{
	
	@Override
	public int RegisterManager(String name, String nic, int age, String gender) {
		Manager newManager = new Manager(name, nic, age, gender);
		ManagerStore.managersList.add(newManager);
		return 1;
	}
	
	@Override
	public   List<Manager> listManagers() {
		return ManagerStore.managersList;
	}
	
	@Override
	public int updateManager(String name, String nic, int age, String gender) {
		Manager managerToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Manager tempManager : ManagerStore.managersList) {
			count++;
			if (tempManager.getName().equalsIgnoreCase(name)) {

				managerToBeUpdated = tempManager;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			managerToBeUpdated.setName(name);
			managerToBeUpdated.setNic(nic);
			managerToBeUpdated.setAge(age);
			managerToBeUpdated.setGender(gender);

			ManagerStore.managersList.set(count, managerToBeUpdated);
			return 1;

		} else {
			return -1;
		}
	}
	
	
	@Override
	public synchronized int removeManager(String name) {
		
		boolean invalid = true;
		int count = -1;
		for (Manager tempManager :ManagerStore.managersList) 
		{
			count++;
			if (tempManager.getName().equalsIgnoreCase(name)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			ManagerStore.managersList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchManager(String name) {
		boolean valid = false;
		
		for (Manager tempManager : ManagerStore.managersList) {
		
			if (tempManager.getName().equalsIgnoreCase(name)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	
}
