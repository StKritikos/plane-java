package app;

public class PassengerCompartment extends PlaneComponent {
	
	private PassengerCompartment inside = null;
	
	public PassengerCompartment(String s , int chance) { //chance has a random value.either 1 or 0.to choose if the inside variable will be null or not
		super(s);
		if(chance == 1) {
			inside = new PassengerCompartment("This is a Passenger Compartment inside another one" , 0); //chance will be 0.only one passenger compartment with another one
		}
		System.out.println("A Passenger Compartment was just created");
	}
	
	public PassengerCompartment(PassengerCompartment pc) {
		super(pc.get_description());
		if(pc.get_inside() != null) {
			inside = new PassengerCompartment(pc.get_inside().get_description() , 0);
		}
		System.out.println("A copy of a Passenger Compartment was just created");
	}

	public PassengerCompartment get_inside() { return inside; }
	
	@Override
	public int ready_check() {
		if (get_readiness() == 2) //readiness = 2 if 2 employees worked here
		{	
			if (inside != null)
				return inside.ready_check();
			
			System.out.println("Passenger Compartment is ready");
			return 1;
		}	
		else
		{
			System.out.println("Passenger Compartment is not ready");
			return 0;
		}
	}
	
	@Override
	public void process(Employee e) {
		System.out.println("Employee " +e.get_name() +" is requested to work on the Passenger Compartment");
		e.workOn(this);
	}
	
	@Override
	public String toString() {
		if(inside == null)
			return "This is a Passenger Compartment with description : " +get_description() +" without another passenger compartment inside of it";
		else
			return "This is a Passenger Compartment with description : " +get_description() +" with another passenger compartment inside of it";
	}

}
