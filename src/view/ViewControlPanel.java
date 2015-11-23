package view;

import java.awt.Font;
import java.awt.Image;
import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controler.Controler;
import model.Door;
import model.Gear;
import model.Light;
import model.Plane;

public class ViewControlPanel extends JFrame implements Observer {

	private JPanel contentPane;
	private JLabel imgDoor1, imgDoor2, imgDoor3, imgGear1, imgGear2, imgGear3, imgLight;
	private String stateslider ="up";
    private JSlider slider; 
	/**
	 * Create the frame.
	 */
	public ViewControlPanel(Controler controler) {
		Image imgDoorClosed = new ImageIcon(this.getClass().getResource("/door2_closed.jpg")).getImage();
		Image imgGearClosed = new ImageIcon(this.getClass().getResource("/gear2_retracted.jpg")).getImage();
		Image imgLightEmpty = new ImageIcon(this.getClass().getResource("/feu_vide.jpg")).getImage();
		this.imgDoor1 = new JLabel("imgDoor1");
		this.imgDoor2 = new JLabel("imgDoor2");
		this.imgDoor3 = new JLabel("imgDoor3");
		this.imgGear1 = new JLabel("imgGear1");
		this.imgGear2 = new JLabel("imgGear2");
		this.imgGear3 = new JLabel("imgGear3");
		this.imgLight = new JLabel("");
		
		// lblimgDoor1.setIcon(new ImageIcon(imgDoorClosed));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		imgDoor1.setIcon(new ImageIcon(imgDoorClosed));
		imgDoor1.setHorizontalAlignment(SwingConstants.CENTER);
		imgDoor1.setBounds(72, 53, 101, 104);
		contentPane.add(imgDoor1);

		imgDoor2.setIcon(new ImageIcon(imgDoorClosed));
		imgDoor2.setHorizontalAlignment(SwingConstants.CENTER);
		imgDoor2.setBounds(201, 53, 101, 104);
		contentPane.add(imgDoor2);

		imgDoor3.setIcon(new ImageIcon(imgDoorClosed));
		imgDoor3.setHorizontalAlignment(SwingConstants.CENTER);
		imgDoor3.setBounds(331, 53, 101, 104);
		contentPane.add(imgDoor3);

		imgGear1.setIcon(new ImageIcon(imgGearClosed));
		imgGear1.setHorizontalAlignment(SwingConstants.CENTER);
		imgGear1.setBounds(72, 232, 101, 104);
		contentPane.add(imgGear1);

		imgGear2.setIcon(new ImageIcon(imgGearClosed));
		imgGear2.setHorizontalAlignment(SwingConstants.CENTER);
		imgGear2.setBounds(201, 232, 101, 104);
		contentPane.add(imgGear2);

		imgGear3.setIcon(new ImageIcon(imgGearClosed));
		imgGear3.setHorizontalAlignment(SwingConstants.CENTER);
		imgGear3.setBounds(331, 232, 101, 104);
		contentPane.add(imgGear3);

		JLabel lblImgDoor1 = new JLabel("Door1");
		lblImgDoor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgDoor1.setBounds(86, 167, 74, 14);
		contentPane.add(lblImgDoor1);

		JLabel lblImgDoor2 = new JLabel("Door2");
		lblImgDoor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgDoor2.setBounds(218, 167, 74, 14);
		contentPane.add(lblImgDoor2);

		JLabel lblImgDoor3 = new JLabel("Door3");
		lblImgDoor3.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgDoor3.setBounds(345, 168, 74, 14);
		contentPane.add(lblImgDoor3);

		JLabel lblImgGear1 = new JLabel("Gear1");
		lblImgGear1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgGear1.setBounds(85, 347, 74, 14);
		contentPane.add(lblImgGear1);

		JLabel lblImgGear2 = new JLabel("Gear2");
		lblImgGear2.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgGear2.setBounds(215, 347, 74, 14);
		contentPane.add(lblImgGear2);

		JLabel lblImgGear3 = new JLabel("Gear3");
		lblImgGear3.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgGear3.setBounds(346, 347, 74, 14);
		contentPane.add(lblImgGear3);

		imgLight.setIcon(new ImageIcon(imgLightEmpty));
		imgLight.setHorizontalAlignment(SwingConstants.CENTER);
		imgLight.setBounds(471, 47, 95, 321);
		contentPane.add(imgLight);

		JLabel lblTitle = new JLabel("Command Pannel");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(665, 11, 127, 23);
		contentPane.add(lblTitle);

		slider = new JSlider();
		slider.setValue(100);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBounds(579, 79, 91, 166);
		contentPane.add(slider);

		JLabel lblInstructions = new JLabel(
				"<html><center>Instructions : </center><br>> Cliquez et tirez le curseur<br>en but\u00E9e maximale/minimale<br><br>> Lachez le clic pour confirmer<br></html>");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setBounds(680, 53, 154, 192);
		contentPane.add(lblInstructions);

		JLabel lblUp = new JLabel("UP");
		lblUp.setBounds(611, 54, 32, 14);
		contentPane.add(lblUp);

		JLabel lblDown = new JLabel("DOWN");
		lblDown.setBounds(611, 244, 47, 14);
		contentPane.add(lblDown);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 271, 240, 97);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));		
		
		JLabel lblCockpitView = new JLabel("Cockpit view");
		lblCockpitView.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCockpitView.setBounds(210, 11, 87, 23);
		contentPane.add(lblCockpitView);
	    System.setOut(printStream);
		System.setErr(printStream);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(30, 343, 360, 97);
//		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));		
//	    System.setOut(printStream);
//		System.setErr(printStream);
//		
//		
//		
//		JScrollPane scroll = new JScrollPane(textArea);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		contentPane.add(scroll);
		

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (slider.getValue() == 100 && slider.getValueIsAdjusting() == false && stateslider=="down") {
					controler.changeSytemState();
					stateslider="up";
				} else if (slider.getValue() == 0 && slider.getValueIsAdjusting() == false && stateslider=="up") {
					controler.changeSytemState();
					stateslider="down";
				}
			}
		});
	}

	@Override
	public void update(Observable obs, Object obj) {
		Image imgDoorClosed = new ImageIcon(this.getClass().getResource("/door2_closed.jpg")).getImage();
		Image imgDoorMoving = new ImageIcon(this.getClass().getResource("/door2_moving.jpg")).getImage();
		Image imgDoorOpened = new ImageIcon(this.getClass().getResource("/door2_opened.jpg")).getImage();
		Image imgGearClosed = new ImageIcon(this.getClass().getResource("/gear2_retracted.jpg")).getImage();
		Image imgGearMoving = new ImageIcon(this.getClass().getResource("/gear2_moving.jpg")).getImage();
		Image imgGearOpened = new ImageIcon(this.getClass().getResource("/gear2_extracted.jpg")).getImage();
		Image imgLightEmpty = new ImageIcon(this.getClass().getResource("/feu_vide.jpg")).getImage();
		Image imgLightOrange = new ImageIcon(this.getClass().getResource("/feu_orange.jpg")).getImage();
		Image imgLightRed = new ImageIcon(this.getClass().getResource("/feu_rouge.jpg")).getImage();
		Image imgLightGreen = new ImageIcon(this.getClass().getResource("/feu_vert.jpg")).getImage();
		// TODO Auto-generated method stub
		if (obs instanceof Door) {
			if (((Door) obs).getState() == "closed" && ((Door) obs).getIndex() == 1) {
				imgDoor1.setIcon(new ImageIcon(imgDoorClosed));
			}
			if (((Door) obs).getState() == "closed" && ((Door) obs).getIndex() == 2) {
				imgDoor2.setIcon(new ImageIcon(imgDoorClosed));
			}

			if (((Door) obs).getState() == "closed" && ((Door) obs).getIndex() == 3) {
				imgDoor3.setIcon(new ImageIcon(imgDoorClosed));
			}

			if (((Door) obs).getState() == "half-opened" && ((Door) obs).getIndex() == 1) {
				imgDoor1.setIcon(new ImageIcon(imgDoorMoving));
			}
			if (((Door) obs).getState() == "half-opened" && ((Door) obs).getIndex() == 2) {
				imgDoor2.setIcon(new ImageIcon(imgDoorMoving));
			}

			if (((Door) obs).getState() == "half-opened" && ((Door) obs).getIndex() == 3) {
				imgDoor3.setIcon(new ImageIcon(imgDoorMoving));
			}
			
			if (((Door) obs).getState() == "opened" && ((Door) obs).getIndex() == 1) {
				imgDoor1.setIcon(new ImageIcon(imgDoorOpened));
			}
			if (((Door) obs).getState() == "opened" && ((Door) obs).getIndex() == 2) {
				imgDoor2.setIcon(new ImageIcon(imgDoorOpened));
			}

			if (((Door) obs).getState() == "opened" && ((Door) obs).getIndex() == 3) {
				imgDoor3.setIcon(new ImageIcon(imgDoorOpened));
			}
		}

		else if (obs instanceof Gear) {
			if (((Gear) obs).getState() == "closed" && ((Gear) obs).getIndex() == 1) {
				imgGear1.setIcon(new ImageIcon(imgGearClosed));
			}
			
			if (((Gear) obs).getState() == "closed" && ((Gear) obs).getIndex() == 2) {
				imgGear2.setIcon(new ImageIcon(imgGearClosed));
			}
			
			if (((Gear) obs).getState() == "closed" && ((Gear) obs).getIndex() == 3) {
				imgGear3.setIcon(new ImageIcon(imgGearClosed));
			}
			
			if (((Gear) obs).getState() == "half-opened" && ((Gear) obs).getIndex() == 1) {
				imgGear1.setIcon(new ImageIcon(imgGearMoving));
			}
			
			if (((Gear) obs).getState() == "half-opened" && ((Gear) obs).getIndex() == 2) {
				imgGear2.setIcon(new ImageIcon(imgGearMoving));
			}
			
			if (((Gear) obs).getState() == "half-opened" && ((Gear) obs).getIndex() == 3) {
				imgGear3.setIcon(new ImageIcon(imgGearMoving));
			}
			
			if (((Gear) obs).getState() == "opened" && ((Gear) obs).getIndex() == 1) {
				imgGear1.setIcon(new ImageIcon(imgGearOpened));
			}
			
			if (((Gear) obs).getState() == "opened" && ((Gear) obs).getIndex() == 2) {
				imgGear2.setIcon(new ImageIcon(imgGearOpened));
			}
			
			if (((Gear) obs).getState() == "opened" && ((Gear) obs).getIndex() == 3) {
				imgGear3.setIcon(new ImageIcon(imgGearOpened));
			}
		}
		
		else if (obs instanceof Light) {
			if (((Light) obs).getState() == "off") {
				imgLight.setIcon(new ImageIcon(imgLightEmpty));
			}
			
			if (((Light) obs).getState() == "red") {
				imgLight.setIcon(new ImageIcon(imgLightRed));
			}
			
			if (((Light) obs).getState() == "green") {
				imgLight.setIcon(new ImageIcon(imgLightGreen));
			}
			
			if (((Light) obs).getState() == "orange") {
				imgLight.setIcon(new ImageIcon(imgLightOrange));
			}
		}
		
		else if (obs instanceof Plane) {
			if (((Plane) obs).getLockcontrols()==false) {
				slider.setEnabled(true);
			}
			if (((Plane) obs).getLockcontrols()==true) {
				slider.setEnabled(false);
			}
		}

	}
}
