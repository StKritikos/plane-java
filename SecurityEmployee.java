package app;

public class SecurityEmployee extends Employee {

	public SecurityEmployee(String s) { super(s); }
	
	public SecurityEmployee(SecurityEmployee se) { super(se.get_name()); }
	
	@Override
	public void workOn(CargoBay cb) {
		System.out.println("Security Employee " +get_name() +" is working on the Cargo Bay");
		cb.add_readiness();
		workOn(cb.get_inside());
	}
	
	@Override
	public void workOn(PassengerCompartment pc) {
		System.out.println("Security Employee " +get_name() +" is working on the Passenger Compartment");
		pc.add_readiness();
		if(pc.get_inside() != null)
			workOn(pc.get_inside());
	}
	
	@Override
	public void workOn(EquipmentCompartment ec) {
		System.out.println("Security Employee " +get_name() +" is working on the Equipment Compartment");
		ec.add_readiness();
	}
	
	@Override
	public void workOn(Plane p) {
		System.out.println("Security Employee " +get_name() +" is working on the plane");
		
		p.get_cargo_bay().process(this);
		
		for(int i=0 ; i < p.get_num_of_compartments() ; i++)
			p.get_passenger_comp()[i].process(this);
		
		for(int i=0 ; i<3 ; i++)
			p.get_equip_comp()[i].process(this);
	}
	
	@Override
	public void report() {
	    System.out.println("Security Employee " +get_name() +" made sure all parts of the plane are SECURE");
	    System.out.println("OK");
	}

	@Override
	public String toString() {
		return "This is a Security Employee with name : " +get_name();
	}
}
