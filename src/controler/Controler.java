package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Plane;

public class Controler {
	private Plane model;

	public Controler(Plane model) {
		this.model = model;
	}

	public Plane getModel() {
		return model;
	}

	public void setModel(Plane model) {
		this.model = model;
	}

	public void changeSytemState() {
		String initialState = model.getState();

		if (initialState == "closed") {
			model.setLockcontrols(true);
			model.getLight().setState("orange");
			System.out.println("Light status : " + model.getLight().getState());
			System.out.println("--- STARTING OPENING DOORS ---");
			System.out.println("Doors1 status : " + model.getDoor1().getState());
			System.out.println("Doors2 status : " + model.getDoor2().getState());
			System.out.println("Doors3 status : " + model.getDoor3().getState());
			
		    ActionListener taskPerformer = new ActionListener() {
		        public void actionPerformed(ActionEvent evt) {
					model.getDoor1().setState("half-opened");
					model.getDoor2().setState("half-opened");
					model.getDoor3().setState("half-opened");
					System.out.println("Doors1 status : " + model.getDoor1().getState());
					System.out.println("Doors2 status : " + model.getDoor2().getState());
					System.out.println("Doors3 status : " + model.getDoor3().getState());
					
					ActionListener taskPerformer2 = new ActionListener() {
				        public void actionPerformed(ActionEvent evt) {
							model.getDoor1().setState("opened");
							model.getDoor2().setState("opened");
							model.getDoor3().setState("opened");
							System.out.println("Doors1 status : " + model.getDoor1().getState());
							System.out.println("Doors2 status : " + model.getDoor2().getState());
							System.out.println("Doors3 status : " + model.getDoor3().getState());
							if (model.getDoor1().getState() == "opened" && model.getDoor2().getState() == "opened"
									&& model.getDoor3().getState() == "opened") {
								System.out.println("--- DOORS OPENED ! ---");
								System.out.println("--- STARTING OPENING GEARS ---");
								System.out.println("Gears1 status : " + model.getGear1().getState());
								System.out.println("Gears2 status : " + model.getGear2().getState());
								System.out.println("Gears3 status : " + model.getGear3().getState());
								
								ActionListener taskPerformer3 = new ActionListener() {
							        public void actionPerformed(ActionEvent evt) {
										model.getGear1().setState("half-opened");
										model.getGear2().setState("half-opened");
										model.getGear3().setState("half-opened");
										
										System.out.println("Gears1 status : " + model.getGear1().getState());
										System.out.println("Gears2 status : " + model.getGear2().getState());
										System.out.println("Gears3 status : " + model.getGear3().getState());
										
										 ActionListener taskPerformer4 = new ActionListener() {
										        public void actionPerformed(ActionEvent evt) {
										        	model.getGear1().setState("opened");
													model.getGear2().setState("opened");
													model.getGear3().setState("opened");
													System.out.println("Gears1 status : " + model.getGear1().getState());
													System.out.println("Gears2 status : " + model.getGear2().getState());
													System.out.println("Gears3 status : " + model.getGear3().getState());
													if (model.getGear1().getState() == "opened" && model.getGear2().getState() == "opened"
															&& model.getGear3().getState() == "opened") {
														System.out.println("--- GEARS OPENED ! ---");
														System.out.println("--- STARTING CLOSING DOORS ---");
														System.out.println("Doors1 status : " + model.getDoor1().getState());
														System.out.println("Doors2 status : " + model.getDoor2().getState());
														System.out.println("Doors3 status : " + model.getDoor3().getState());
														
														ActionListener taskPerformer5 = new ActionListener() {
													        public void actionPerformed(ActionEvent evt) {
																model.getDoor1().setState("half-opened");
																model.getDoor2().setState("half-opened");
																model.getDoor3().setState("half-opened");
																System.out.println("Doors1 status : " + model.getDoor1().getState());
																System.out.println("Doors2 status : " + model.getDoor2().getState());
																System.out.println("Doors3 status : " + model.getDoor3().getState());
																
															    ActionListener taskPerformer6 = new ActionListener() {
															        public void actionPerformed(ActionEvent evt) {
															        	model.getDoor1().setState("closed");
																		model.getDoor2().setState("closed");
																		model.getDoor3().setState("closed");
																		System.out.println("Doors1 status : " + model.getDoor1().getState());
																		System.out.println("Doors2 status : " + model.getDoor2().getState());
																		System.out.println("Doors3 status : " + model.getDoor3().getState());
																		if (model.getDoor1().getState() == "closed" && model.getDoor2().getState() == "closed"
																				&& model.getDoor3().getState() == "closed") {
																			System.out.println("--- DOORS CLOSED ! ---");
																			model.getLight().setState("green");
																			System.out.println("Light status : " + model.getLight().getState());
																			model.setState("opened");
																			model.setLockcontrols(false);
																		} else {
																			System.out.println("A problem occured during the closing phase of the doors!");
																			model.getLight().setState("red");
																			System.out.println("Light status : " + model.getLight().getState());
																			model.setLockcontrols(false);

																		}
																		
															        }
															    };
															    javax.swing.Timer t6 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer6);
															    t6.setRepeats(false);
															    t6.start();
													        }
													    };
													    javax.swing.Timer t5 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer5);
													    t5.setRepeats(false);
													    t5.start();
													    
													}
													
												    else {
														System.out.println("A problem occured during the opening phase of the gears!");
														model.getLight().setState("red");
														System.out.println("Light status : " + model.getLight().getState());
														model.setLockcontrols(false);
													}
													
										        }
										    };
										    javax.swing.Timer t4 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer4);
										    t4.setRepeats(false);
										    t4.start();

							        }
							    };
							    javax.swing.Timer t3 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer3);
							    t3.setRepeats(false);
							    t3.start();

							}
							else {
								System.out.println("A problem occured during the opening phase of the doors!");
								model.getLight().setState("red");
								System.out.println("Light status : " + model.getLight().getState());
								model.setLockcontrols(false);
							}
							
				        }
				    };
				    javax.swing.Timer t2 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer2);
				    t2.setRepeats(false);
				    t2.start();

		        }
		    };
		    javax.swing.Timer t = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer);
		    t.setRepeats(false);
		    t.start();
		}

		else {
			model.setLockcontrols(true);
			model.getLight().setState("orange");
			System.out.println("Light status : " + model.getLight().getState());
			System.out.println("--- STARTING OPENING DOORS ---");
			System.out.println("Doors1 status : " + model.getDoor1().getState());
			System.out.println("Doors2 status : " + model.getDoor2().getState());
			System.out.println("Doors3 status : " + model.getDoor3().getState());

			ActionListener taskPerformer7 = new ActionListener() {
		        public void actionPerformed(ActionEvent evt) {
					model.getDoor1().setState("half-opened");
					model.getDoor2().setState("half-opened");
					model.getDoor3().setState("half-opened");
					System.out.println("Doors1 status : " + model.getDoor1().getState());
					System.out.println("Doors2 status : " + model.getDoor2().getState());
					System.out.println("Doors3 status : " + model.getDoor3().getState());
					
					ActionListener taskPerformer8 = new ActionListener() {
				        public void actionPerformed(ActionEvent evt) {
				        	model.getDoor1().setState("opened");
							model.getDoor2().setState("opened");
							model.getDoor3().setState("opened");
							System.out.println("Doors1 status : " + model.getDoor1().getState());
							System.out.println("Doors2 status : " + model.getDoor2().getState());
							System.out.println("Doors3 status : " + model.getDoor3().getState());
							if (model.getDoor1().getState() == "opened" && model.getDoor2().getState() == "opened"
									&& model.getDoor3().getState() == "opened") {
								System.out.println("--- DOORS OPENED ! ---");
								System.out.println("--- STARTING CLOSING GEARS ---");
								System.out.println("Gears1 status : " + model.getGear1().getState());
								System.out.println("Gears2 status : " + model.getGear2().getState());
								System.out.println("Gears3 status : " + model.getGear3().getState());
								
								ActionListener taskPerformer9 = new ActionListener() {
							        public void actionPerformed(ActionEvent evt) {
										model.getGear1().setState("half-opened");
										model.getGear2().setState("half-opened");
										model.getGear3().setState("half-opened");
										System.out.println("Gears1 status : " + model.getGear1().getState());
										System.out.println("Gears2 status : " + model.getGear2().getState());
										System.out.println("Gears3 status : " + model.getGear3().getState());
										
										ActionListener taskPerformer10 = new ActionListener() {
									        public void actionPerformed(ActionEvent evt) {
												model.getGear1().setState("closed");
												model.getGear2().setState("closed");
												model.getGear3().setState("closed");		
												System.out.println("Gears1 status : " + model.getGear1().getState());
												System.out.println("Gears2 status : " + model.getGear2().getState());
												System.out.println("Gears3 status : " + model.getGear3().getState());
												if(model.getGear1().getState() == "closed" && model.getGear2().getState() == "closed"
														&& model.getGear3().getState() == "closed"){
													System.out.println("--- GEARS CLOSED ! ---");
													System.out.println("--- STARTING CLOSING DOORS ---");
													System.out.println("Doors1 status : " + model.getDoor1().getState());
													System.out.println("Doors2 status : " + model.getDoor2().getState());
													System.out.println("Doors3 status : " + model.getDoor3().getState());
													
													ActionListener taskPerformer11 = new ActionListener() {
												        public void actionPerformed(ActionEvent evt) {
															model.getDoor1().setState("half-opened");
															model.getDoor2().setState("half-opened");
															model.getDoor3().setState("half-opened");		
															System.out.println("Doors1 status : " + model.getDoor1().getState());
															System.out.println("Doors2 status : " + model.getDoor2().getState());
															System.out.println("Doors3 status : " + model.getDoor3().getState());
															
															ActionListener taskPerformer12 = new ActionListener() {
															        public void actionPerformed(ActionEvent evt) {
																		model.getDoor1().setState("closed");
																		model.getDoor2().setState("closed");
																		model.getDoor3().setState("closed");
																		System.out.println("Doors1 status : " + model.getDoor1().getState());
																		System.out.println("Doors2 status : " + model.getDoor2().getState());
																		System.out.println("Doors3 status : " + model.getDoor3().getState());
																		if (model.getDoor1().getState() == "closed" && model.getDoor2().getState() == "closed"
																				&& model.getDoor3().getState() == "closed") {
																			System.out.println("--- DOORS CLOSED ! ---");
																			model.getLight().setState("off");
																			System.out.println("Light status : " + model.getLight().getState());
																			model.setState("closed");
																			model.setLockcontrols(false);
																		} 
																		else {
																			System.out.println("A problem occured during the closing phase of the doors!");
																			model.getLight().setState("red");
																			System.out.println("Light status : " + model.getLight().getState());
																			model.setLockcontrols(false);

																		}
															        }
															    };
															    javax.swing.Timer t12 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer12);
															    t12.setRepeats(false);
															    t12.start();
												        }
												    };
												    javax.swing.Timer t11 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer11);
												    t11.setRepeats(false);
												    t11.start();

												}
												else{System.out.println("A problem occured during the closing phase of the gears!");
												model.getLight().setState("red");
												System.out.println("Light status : " + model.getLight().getState());
												model.setLockcontrols(false);
												}
									        }
									    };
									    javax.swing.Timer t10 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer10);
									    t10.setRepeats(false);
									    t10.start();
							        }
							    };
							    javax.swing.Timer t9 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer9);
							    t9.setRepeats(false);
							    t9.start();
							}
							else {System.out.println("A problem occured during the opening phase of the doors!");
							model.getLight().setState("red");
							System.out.println("Light status : " + model.getLight().getState());
							model.setLockcontrols(false);
							}
							
				        }
				    };
				    javax.swing.Timer t8 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer8);
				    t8.setRepeats(false);
				    t8.start();
		        }
		    };
		    javax.swing.Timer t7 = new javax.swing.Timer(model.getDoor1().getTimeToChangeState(), taskPerformer7);
		    t7.setRepeats(false);
		    t7.start();
		    
		}
	}

}
