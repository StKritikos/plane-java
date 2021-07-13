package app;

public class EquipmentCompartment extends PrivateCompartment {

	public EquipmentCompartment(String s) {
		super(s);
		System.out.println("An Equipment Compartment was just created ");
	}
	
	public EquipmentCompartment(EquipmentCompartment ec) {
		super(ec.get_description());
		System.out.println("A copy of an Equipment Compartment was just created ");
	}

	@Override
	public int ready_check() {
		if (get_readiness() == 2) //readiness = 2 if 2 employees worked here
		{
			System.out.println("Equipment Compartment is ready ");
			return 1;
		}
		else
		{
			System.out.println("Equipment Compartment is not ready ");
			return 0;
		}	
	}
	
	@Override
	public void process(Employee e) {
		System.out.println("Employee " +e.get_name() +" is requested to work on the Equipment Compartment");
		e.workOn(this);
	}
	
	@Override
	public String toString() {
		return "This is an Equipment Compartment with description : " +get_description();
	}
	

}
