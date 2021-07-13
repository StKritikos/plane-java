package app;

import java.util.Random;

public class Main4 {

	public static void main(String[] args) {
		
		Random rand = new Random(); 		
		int random_capacity = rand.nextInt(201) + 100; //passenger capacity of plane = 100-300
		
		Plane plane = new Plane("'Airplane'" , "'This is a plane'" , random_capacity);
		
		SecurityEmployee security_emp = new SecurityEmployee("'security'");
		CleaningEmployee cleaning_emp = new CleaningEmployee("'cleaner'");
		MaintenanceEmployee maintenance_emp = new MaintenanceEmployee("'maintenance'");
		
		plane.process(security_emp);
		plane.process(cleaning_emp);
		plane.process(maintenance_emp);
		
		if (plane.ready_check() == 1)
			System.out.println("Plane ready to take off");
		else
			System.out.println("Plane not ready to take off");
	}
}
