package app;

public abstract class PrivateCompartment extends PlaneComponent {

	public PrivateCompartment(String s) {
		super(s);
		System.out.println("A Private Compartment was just created");
	}
	
	public PrivateCompartment(PrivateCompartment pc) {
		super(pc.get_description());
		System.out.println("A copy of a Private Compartment was just created");
	}
	
	public int ready_check() { return 1; }
	public void process(Employee e) {}
}
