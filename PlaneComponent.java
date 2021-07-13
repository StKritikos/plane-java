package app;

public abstract class PlaneComponent {
	
	private String description;
	private int readiness; //counter for many Employees completed their work here
	
	public PlaneComponent(String s) {
		description = s;
		readiness = 0;
		System.out.println("A Plane Component was just created");
	}
	
	public PlaneComponent(PlaneComponent pc) {
		description = pc.get_description();
		readiness = pc.get_readiness();
		System.out.println("A copy of a Plane Component was just created");
	}
	
	public String get_description() { return description; }
	public int get_readiness() { return readiness; }
	public void add_readiness() { readiness++; } //every time an Employee completes work here
	
	public int ready_check() { return 1; }
	public void process(Employee e) {}
}
