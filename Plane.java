package app;

import java.util.Random;

public class Plane {
	
	private String title;
	private String description;
	private int capacity;
	
	private CargoBay cargo_bay;
	private EquipmentCompartment[] equip_comp;
	private PassengerCompartment[] passenger_comp;
	
	public Plane(String t , String d , int c) {    //constructor
		
		title = t;
		description = d;
		capacity = c;	//c was randomized between 100 and 300
		
		cargo_bay = new CargoBay("This is the cargo bay of the plane");
		
		equip_comp = new EquipmentCompartment[3];
		for(int i=0 ; i<3 ; i++) 
			equip_comp[i] = new EquipmentCompartment("This is the equipment compartment of the plane " +(i+1));
		
		passenger_comp = new PassengerCompartment[get_num_of_compartments()]; //get_num_of_compartments() returns how many passenger compartments should be in the plane 
		for(int i=0 ; i < get_num_of_compartments() ; i++) 					  //based on the random passenger capacity
		{
			Random rand = new Random(); 
			int chance = rand.nextInt(2); //chance is 0 or 1 to choose randomly if there is going to be another Passenger Compartment inside of each one
			passenger_comp[i] = new PassengerCompartment("This is the passenger compartment of the plane " +(i+1) , chance);
		}
		
		System.out.println("A plane was just created");
	}
	
	public Plane(Plane plane) {
		
		title = plane.get_title();
		description = plane.get_description();
		capacity = plane.get_capacity();
		
		cargo_bay = new CargoBay(plane.get_cargo_bay());
		
		equip_comp = new EquipmentCompartment[3];
		for(int i=0 ; i<3 ; i++) 
			equip_comp[i] = new EquipmentCompartment(plane.get_equip_comp()[i]);
		
		passenger_comp = new PassengerCompartment[plane.get_num_of_compartments()];
		for(int i=0 ; i < plane.get_num_of_compartments() ; i++) 
			passenger_comp[i] = new PassengerCompartment(plane.get_passenger_comp()[i]);
		
		System.out.println("A copy of a plane was just created with title " +title +" description " +description +" and capacity " +capacity);
	}

	public String get_title() { return title; }
	public String get_description() { return description; }
	public int get_capacity() {	return capacity; }
	public CargoBay get_cargo_bay() { return cargo_bay; }
	public EquipmentCompartment[] get_equip_comp() { return equip_comp; }
	public PassengerCompartment[] get_passenger_comp() { return passenger_comp; }
	
	public int get_num_of_compartments() {
		if(capacity % 50 > 0) 
			return capacity/50 +1;
		else 
			return capacity/50;
	}
		
	public int ready_check() {
		int cb_check = cargo_bay.ready_check();
		
		int equip_check = 0;
		for(int i=0 ; i<3 ; i++) 
			equip_check += equip_comp[i].ready_check();
		
		int pass_check = 0;	
		for(int i=0 ; i < get_num_of_compartments() ; i++) 
			pass_check += passenger_comp[i].ready_check();
		
		if ( (cb_check == 1) && (equip_check == 3) && (pass_check == get_num_of_compartments()) ) //if ALL parts are ready
		{
			System.out.println("Plane OK");
			return 1;	
		}
		else
		{
			System.out.println("Plane not ready"); //if not ALL parts are ready
			return 0;
		}
	}
	
	public void process(Employee e) {
		System.out.println("Employee " +e.get_name() +" is requested to work on the Plane");
		e.workOn(this);
		e.report();
	}
	
	@Override
	public String toString() {
		String a1 = "This is a Plane with description : " +description +" and title : " +title +" with passenger capacity : " +capacity;
		String a2 = ".Also inside of it is a Cargo Bay,3 Equipment Compartments and " +get_num_of_compartments() +" Passenger Compartments";
		return a1 + a2;
	}
}




























