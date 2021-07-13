package app;

public class MaintenanceEmployee extends Employee {
	
public MaintenanceEmployee(String s) { super(s); }
	
	public MaintenanceEmployee(MaintenanceEmployee me) { super(me.get_name()); }
	
	@Override
	public void workOn(CargoBay cb) {
		System.out.println("Maintenance Employee " +get_name() +" is working on the Cargo Bay");
		cb.add_readiness();
		workOn(cb.get_inside());
	}
	
	@Override
	public void workOn(EquipmentCompartment ec) {
		System.out.println("Maintenance Employee " +get_name() +" is working on the Equipment Compartment");
		ec.add_readiness();
	}
	
	@Override
	public void workOn(Plane p) {
		System.out.println("Maintenance Employee " +get_name() +" is working on the plane");
		
		p.get_cargo_bay().process(this);
		
		for(int i=0 ; i<3 ; i++)
			p.get_equip_comp()[i].process(this);
	}
	
	@Override
	public void report() {
	    System.out.println("Maintenance Employee " +get_name() +" made sure all parts of the plane are MAINTAINED");
	    System.out.println("OK");
	}
	
	@Override
	public String toString() {
		return "This is a Maintenance Employee with name : " +get_name() ;
	}
}
