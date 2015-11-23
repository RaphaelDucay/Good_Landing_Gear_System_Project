import java.awt.EventQueue;

import controler.Controler;
import model.Door;
import model.Gear;
import model.Light;
import model.Plane;
import view.ViewControlPanel;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Door door1 = new Door("closed",2000,1);
		Door door2 = new Door("closed",2000,2);
		Door door3 = new Door("closed",2000,3);
		Gear gear1 = new Gear("closed", 2000,1);
		Gear gear2 = new Gear("closed", 2000,2);
		Gear gear3 = new Gear("closed", 2000,3);
		Light light = new Light("off");
		Plane plane = new Plane("closed",gear1, gear2, gear3, door1, door2, door3, light);
		Controler controler = new Controler(plane);
		ViewControlPanel frame = new ViewControlPanel(controler);
		plane.getDoor1().addObserver(frame);
		plane.getDoor2().addObserver(frame);
		plane.getDoor3().addObserver(frame);
		plane.getGear1().addObserver(frame);
		plane.getGear2().addObserver(frame);
		plane.getGear3().addObserver(frame);
		plane.getLight().addObserver(frame);
		plane.addObserver(frame);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
