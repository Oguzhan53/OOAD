/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Random;

import individuals.Individual;

/**
 * Hospital class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public class Hospital {

	private ArrayList<Individual> infected;
	private int infectedNum;
	private int hopistalSize;
	private final int HOSPITAL_TIME = 10;

	public Hospital(int hospitalSize) {
		this.hopistalSize = hospitalSize;
		this.infected = new ArrayList<Individual>();
		this.infectedNum = 0;

	}

	public int getInfectedNum() {
		return infectedNum;
	}

	public void setInfectedNum(int infectedNum) {
		this.infectedNum = infectedNum;
	}

	/**
	 * This method adds infected individual to hospital
	 * 
	 * @param individual Added individual
	 * @return If hospital has ventilator return adds and true , else return false
	 */
	public boolean addInfected(Individual individual) {
		if (this.infectedNum == this.hopistalSize) {
			return false;
		} else {
			infected.add(individual);
			individual.setInHospitalTime(HOSPITAL_TIME);
			individual.setGoHospitalTime(-1);
			individual.setWaitingTime(-1);
			individual.setGoHospitalTime(-1);
			individual.setLifetime(-1);
			individual.setX(1500);
			individual.setY(1500);
			infectedNum++;

			return true;
		}
	}

	/**
	 * This method removes the individual from hospital as healthy individual
	 * 
	 * @param individual Healthy individual
	 */
	public void dischargeIndividual(Individual individual) {
		Random rand = new Random();
		individual.setInHospitalTime(-1);
		individual.setWaitingTime(0);
		individual.getPrevCoor()[0] = 1600;
		individual.getPrevCoor()[1] = 800;
		individual.setX(rand.nextInt(995 + 5));
		individual.setY(rand.nextInt(595 + 5));
		individual.setEnfected(false);
		this.infected.remove(individual);
		this.infectedNum--;

	}

}
