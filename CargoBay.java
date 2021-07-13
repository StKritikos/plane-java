package app;

public class CargoBay extends PrivateCompartment {
	
	private EquipmentCompartment inside;
	
	public CargoBay(String s) {
		super(s);
		inside = new EquipmentCompartment("This is the Equipment Compartment of the CargoBay of the Plane");
		System.out.println("A Cargo Bay was just created");
	}
	
	public CargoBay(CargoBay cb) {
		super(cb.get_description());
		inside = new EquipmentCompartment(cb.get_inside().get_description());
	}

	public EquipmentCompartment get_inside() { return inside; }
	
	@Override
	public int ready_check() {
		if ( (get_readiness() == 3) && (inside.ready_check() == 1) ) //readiness = 3 if all 3 employees worked here
		{	
			System.out.println("Cargo Bay is ready");
			return 1;
		}	
		else
		{
			System.out.println("Cargo Bay is not ready");
			return 0;
		}
	}
	
	@Override
	public void process(Employee e) {
		System.out.println("Employee " +e.get_name() +" is requested to work on the Cargo Bay");
		e.workOn(this);
	}

	@Override
	public String toString() {
		return "This is a Cargo Bay with description : " +get_description() +" and an Equipment Compartment inside";
	}
}
