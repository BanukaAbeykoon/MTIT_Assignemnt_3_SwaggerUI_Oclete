package manager.model;

public class Manager {
	public String name;
	public String nic;
	public int age;
	public String gender;
	
	public Manager(String name, String nic, int age, String gender) {
		super();
		this.name = name;
		this.nic = nic;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

	
}
