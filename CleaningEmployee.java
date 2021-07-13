package app;

public class CleaningEmployee extends Employee {
	
	public CleaningEmployee(String s) { super(s); }
	
	public CleaningEmployee(CleaningEmployee ce) { super(ce.get_name()); }
	
	@Override
	public void workOn(CargoBay cb) {
		System.out.println("Cleaning Employee " +get_name() +" is working on the Cargo Bay");
		cb.add_readiness();
	}
	
	@Override
	public void workOn(PassengerCompartment pc) {
		System.out.println("Cleaning Employee " +get_name() +" is working on the Passenger Compartment");
		pc.add_readiness();
		if(pc.get_inside() != null)
			workOn(pc.get_inside());
	}
	
	@Override
	public void workOn(Plane p) {
		System.out.println("Cleaning Employee " +get_name() +" is working on the plane");
		
		p.get_cargo_bay().process(this);
		
		for(int i=0 ; i < p.get_num_of_compartments() ; i++)
			p.get_passenger_comp()[i].process(this);
	}
	
	@Override
	public void report() {
	    System.out.println("Cleaning Employee " +get_name() +" made sure all parts of the plane are CLEAN");
	    System.out.println("OK");
	}
	
	@Override
	public String toString() {
		return "This is a Cleaning Employee with name : " +get_name() ;
	}
}
