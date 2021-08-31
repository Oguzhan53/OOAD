/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import controller.ControllerInterface;
import individuals.Factory;
import individuals.Individual;
import individuals.IndividualComponent;
import individuals.IndividualFactory;
import individuals.Mediator;
import individuals.Society;
import individuals.Status;
import view.Observer;

/**
 * @author Oguzhan SEZGIN
 *
 */
public class SocietyModel implements SocietyModelInterface, Runnable {

	private Society society;
	private ArrayList<Observer> societyObservers = new ArrayList<Observer>();
	private double mortalityRate;
	private double spreadingRate;
	private boolean changed;
	public final Object pauseLock = new Object();
	public boolean pause;
	private ControllerInterface controller;

	public SocietyModel(double mortalityRate, double spreadingRate) {
		super();
		this.society = new Society();
		this.mortalityRate = mortalityRate;
		this.spreadingRate = spreadingRate;
		this.changed = false;
		this.pause = false;

	}

	public ControllerInterface getController() {
		return controller;
	}

	@Override
	public void setController(ControllerInterface controller) {
		this.controller = controller;
	}

	@Override
	public Society getSociety() {
		return society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	public ArrayList<Observer> getSocietyObservers() {
		return societyObservers;
	}

	public void setSocietyObservers(ArrayList<Observer> societyObservers) {
		this.societyObservers = societyObservers;
	}

	public double getMortalityRate() {
		return mortalityRate;
	}

	public void setMortalityRate(double mortalityRate) {
		this.mortalityRate = mortalityRate;
	}

	public double getSpreadingRate() {
		return spreadingRate;
	}

	public void setSpreadingRate(double spreadingRate) {
		this.spreadingRate = spreadingRate;
	}

	@Override
	public Mediator create(int pnum, int healthyNum) {

		Random rand = new Random();

		Mediator mediator = new Mediator(spreadingRate, mortalityRate);
		Factory induvidualFactory = new IndividualFactory(mediator);
		double[] mask = { 0.2, 1.0 };

		for (int i = 0; i < pnum; i++) {
			int x = rand.nextInt(990) + 5;
			int y = rand.nextInt(590) + 5;
			int direct = rand.nextInt(4);
			int tmask = rand.nextInt(2);
			int speed = rand.nextInt(499) + 1;
			int distance = rand.nextInt(9);
			int collisionTime = rand.nextInt(5) + 1;
			boolean enfected;
			if (healthyNum <= i) {
				enfected = true;
			} else {
				enfected = false;
			}
			society.addInduvidual(induvidualFactory.createIndividual(i, x, y, direct, mask[tmask], speed, distance,
					collisionTime, enfected));

		}
		return mediator;

	}

	@Override
	public void start() {
		run();

	}

	@Override
	public void run() {

		while (true) {

			synchronized (society) {
				@SuppressWarnings("rawtypes")
				Iterator iterator = this.getSociety().getIndividulIterator();
				while (iterator.hasNext()) {
					IndividualComponent individual = (IndividualComponent) iterator.next();
					Status resp = individual.move(false);
					if (individual instanceof Individual) {
						boolean flag = true;
						if (resp == Status.DEATH) {
							individual.setX(2000);
							individual.setY(2000);
							individual.setWaitingTime(-1);
							((Individual) individual).setGoHospitalTime(-1);
							((Individual) individual).setLifetime(-1);
							this.society.setDeathNum(this.society.getDeathNum() + 1);
							this.society.setInfectedNum(this.society.getInfectedNum() - 1);
						} else if (resp == Status.HOSPITALIZED) {
							flag = false;
							controller.goHospital((Individual) individual);
						} else if (resp == Status.DISCHARGE) {
							controller.dischargeIndividual((Individual) individual);
						}
						if (flag) {
							controller.goHospital(null);
						}
						// controller.goHospital(null);
					}

					synchronized (pauseLock) {
						if (pause) {
							try {
								pauseLock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}

				setChange();
				notifyObserver();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * This method adds individual or individual array
	 * 
	 * @param individualComponent
	 */
	public void addInduvidual(IndividualComponent individualComponent) {
		society.addInduvidual(individualComponent);
	}

	@Override
	public void registerObserver(Observer o) {
		this.societyObservers.add(o);
		o.start(this);

	}

	@Override
	public void removeObserver(Observer o) {
		this.societyObservers.remove(o);

	}

	@Override
	public void pause() {
		pause = true;

	}

	@Override
	public void resume() {
		synchronized (pauseLock) {
			pause = false;
			pauseLock.notifyAll(); // Unblocks thread
		}

	}

	@Override
	public void notifyObserver() {
		if (changed) {
			for (int i = 0; i < societyObservers.size(); i++) {
				Observer observer = societyObservers.get(i);
				observer.update(this.society);
			}
		}
		this.changed = false;

	}

	@Override
	public void setChange() {
		this.changed = true;

	}

}
