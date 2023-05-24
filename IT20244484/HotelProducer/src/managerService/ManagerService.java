package managerService;

import java.util.List;



import manager.model.Manager;


public interface ManagerService {
	public int RegisterManager(String name, String nic,int age, String gender);
	public   List<Manager> listManagers();
	public   int updateManager(String name, String nic, int age, String gender);
	public   int removeManager(String name);
	public   int searchManager(String name);
}
