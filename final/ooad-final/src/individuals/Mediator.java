/**
 * 
 */
package individuals;

import java.util.ArrayList;
import java.util.Random;

/**
 * Mediator class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public class Mediator {

	private ArrayList<Individual> individuals = new ArrayList<Individual>();
	private double spreadingFactor;
	private final int P_SIZE = 5;
	private double mortalityRate;
	private final int HOSPITAL_TIME = 25;

	public ArrayList<Individual> getIndividuals() {
		return individuals;
	}

	public void setIndividuals(ArrayList<Individual> individuals) {
		this.individuals = individuals;
	}

	public double getSpreadingFactor() {
		return spreadingFactor;
	}

	public void setSpreadingFactor(float spreadingFactor) {
		this.spreadingFactor = spreadingFactor;
	}

	public double getMortalityRate() {
		return mortalityRate;
	}

	public void setMortalityRate(float mortalityRate) {
		this.mortalityRate = mortalityRate;
	}

	public Mediator(double spreadingFactor, double mortalityRate) {
		super();
		this.spreadingFactor = spreadingFactor;
		this.mortalityRate = mortalityRate;
	}

	/**
	 * This method calculates infecting probability and assign the new status
	 * 
	 * @param in1 Colliding individual
	 * @param in2 Colliding individual
	 * @return Infected status
	 */
	private boolean probability(Individual in1, Individual in2) {
		double c = Math.max(in1.getCollision(), in2.getCollision());
		double d = Math.min(in1.getDistance(), in2.getDistance());

		if (in1.isEnfected() ^ in2.isEnfected()) {
			double prob = spreadingFactor * (1 + c / 10.0) * in1.getMask() * in2.getMask() * (1 - d / 10.0);
			Random rand = new Random();
			double boundary = rand.nextDouble();
			boolean enfected;
			if (boundary <= prob)
				enfected = true;
			else
				enfected = false;

			if (!in1.isEnfected() && enfected) {
				in1.setEnfected(enfected);
				in1.setGoHospitalTime(HOSPITAL_TIME);
				in1.setLifetime((int) (100 * (1.0 - this.mortalityRate)));
			} else if (!in2.isEnfected() && enfected) {
				in2.setEnfected(enfected);
				in2.setGoHospitalTime(HOSPITAL_TIME);
				in2.setLifetime((int) (100 * (1.0 - this.mortalityRate)));
			}
			in1.setWaitingTime((int) c);
			in2.setWaitingTime((int) c);
			return enfected;
		} else {
			in1.setWaitingTime((int) c);
			in2.setWaitingTime((int) c);
			return false;
		}

	}

	/**
	 * This method checks the collision situation
	 * 
	 * @return New infected number
	 */
	public int chekCollision() {
		int newEnfectedNum = 0;
		for (int i = 0; i < individuals.size() - 1; i++) {
			for (int j = i + 1; j < individuals.size(); j++) {
				Individual in1 = individuals.get(i);
				Individual in2 = individuals.get(j);
				if (in1.getWaitingTime() == 0 && in2.getWaitingTime() == 0) {

					if ((in1.getX() > in2.getX() - P_SIZE && in1.getX() < in2.getX() + P_SIZE)
							&& in1.getY() == in2.getY()) {
						if (probability(in1, in2)) {
							newEnfectedNum++;
						}

					} else if ((in1.getX() > in2.getX() - P_SIZE && in1.getX() < in2.getX() + P_SIZE)
							&& in1.getDirection() != in2.getDirection()
							&& ((in1.getY() <= in2.getY() && in1.getDirection() == Direction.DOWN)
									|| (in2.getY() <= in1.getY() && in2.getDirection() == Direction.DOWN))) {
						int distance = Math.abs(in1.getY() - in2.getY());
						double totalSpeed = in1.getSpeed() + in2.getSpeed();
						if (distance <= totalSpeed) {
							int cPoint = (int) ((int) distance / totalSpeed);
							int newX = 0;
							if (in1.getDirection() == Direction.DOWN) {
								newX = in1.getY() + cPoint;
								in1.setY(newX);
								in2.setY(newX);
							} else {
								newX = in1.getY() - cPoint;
								in1.setY(newX);
								in2.setY(newX);
							}
							if (probability(in1, in2)) {
								newEnfectedNum++;
							}
						}

					}

					else if ((in1.getX() > in2.getX() - P_SIZE && in1.getX() < in2.getX() + P_SIZE)
							&& in1.getDirection() == in2.getDirection()) {
						int distance = Math.abs(in1.getY() - in2.getY());
						double totalSpeed = Math.abs(in1.getSpeed() - in2.getSpeed());
						if (distance <= totalSpeed) {
							int cPoint = (int) ((int) distance / totalSpeed);
							cPoint *= in1.getSpeed();
							int newX = 0;
							if (in1.getDirection() == Direction.DOWN) {
								newX = in1.getY() + cPoint;
								in1.setY(newX);
								in2.setY(newX);
							} else {
								newX = in1.getY() - cPoint;
								in1.setY(newX);
								in2.setY(newX);
							}
							if (probability(in1, in2)) {
								newEnfectedNum++;
							}
						}

					} else if ((in1.getY() > in2.getY() - P_SIZE && in1.getY() < in2.getY() + P_SIZE)
							&& in1.getDirection() != in2.getDirection()
							&& ((in1.getX() <= in2.getX() && in1.getDirection() == Direction.RIGHT)
									|| (in2.getX() <= in1.getX() && in2.getDirection() == Direction.RIGHT))) {
						int distance = Math.abs(in1.getX() - in2.getX());
						double totalSpeed = in1.getSpeed() + in2.getSpeed();
						if (distance <= totalSpeed) {
							double cPoint = (double) distance / totalSpeed;
							cPoint *= in1.getSpeed();
							int newX = 0;
							if (in1.getDirection() == Direction.LEFT) {
								newX = in1.getX() - (int) cPoint;
								in1.setX(newX);
								in2.setX(newX);
							} else {
								newX = in1.getX() + (int) cPoint;
								in1.setX(newX);
								in2.setX(newX);
							}
							if (probability(in1, in2)) {
								newEnfectedNum++;
							}
						}

					} else if ((in1.getY() > in2.getY() - P_SIZE && in1.getY() < in2.getY() + P_SIZE)
							&& in1.getDirection() == in2.getDirection()) {
						int distance = Math.abs(in1.getX() - in2.getX());
						double totalSpeed = Math.abs(in1.getSpeed() - in2.getSpeed());
						if (distance <= totalSpeed) {
							double cPoint = (double) distance / totalSpeed;
							cPoint *= in1.getSpeed();
							int newX = 0;
							if (in1.getDirection() == Direction.LEFT) {
								newX = in1.getX() - (int) cPoint;
								in1.setX(newX);
								in2.setX(newX);
							} else {
								newX = in1.getX() + (int) cPoint;
								in1.setX(newX);
								in2.setX(newX);
							}
							if (probability(in1, in2)) {
								newEnfectedNum++;
							}
						}

					}

				}

			}
		}
		return newEnfectedNum;
	}

	/**
	 * This method register individual to mediator
	 * 
	 * @param individual
	 */
	public void registerÝndividual(Individual individual) {
		individuals.add(individual);
	}

}
