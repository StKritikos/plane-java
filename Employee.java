package app;

public class Employee {
	
	private String name;
	
	public Employee(String s) { 
		name = s;
		System.out.println("An Employee was just created");
	}
	
	public Employee(Employee e) {
		name = e.get_name();
		System.out.println("A copy of an Employee was just created");
	}
	
	public String get_name() { return name; }
	
	public void workOn(CargoBay cb) {}
	public void workOn(PassengerCompartment pc) {}
	public void workOn(EquipmentCompartment ec) {}
	public void workOn(Plane p) {}
	public void report() {}
	
}


























