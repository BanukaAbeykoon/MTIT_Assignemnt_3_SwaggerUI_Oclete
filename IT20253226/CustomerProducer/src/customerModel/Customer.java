package customerModel;

public class Customer {
    public String Name;
    public int Age;
    public int NIC;
    public int Phone;
    
    public Customer(String Name, int Age, int NIC, int Phone) {
    	this.Name = Name;
    	this.Age = Age;
    	this.NIC = NIC;
    	this.Phone= Phone;
    }

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getNIC() {
		return NIC;
	}

	public void setNIC(int nIC) {
		NIC = nIC;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}
    

}