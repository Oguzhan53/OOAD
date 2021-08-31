/**
 * 
 */
package individuals;

import java.util.Iterator;

/**
 * Society class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public class Society {

	private IndividualComponent individuals;

	private int healtyNum;

	private int infectedNum;

	private int hospitalized;

	private int deathNum;

	public Society() {
		this.individuals = new IndividualArray();
		this.healtyNum = 0;
		this.infectedNum = 0;
		this.hospitalized = 0;
		this.hospitalized = 0;
	}

	public void setHealtyNum(int healtyNum) {
		this.healtyNum = healtyNum;
	}

	public void setInfectedNum(int infectedNum) {
		this.infectedNum = infectedNum;
	}

	public void setHospitalized(int hospitalized) {
		this.hospitalized = hospitalized;
	}

	public void setDeathNum(int deathNum) {
		this.deathNum = deathNum;
	}

	public IndividualComponent getIndividuals() {
		return individuals;
	}

	public int getHealtyNum() {
		return healtyNum;
	}

	public int getInfectedNum() {
		return infectedNum;
	}

	public int getHospitalized() {
		return hospitalized;
	}

	public int getDeathNum() {
		return deathNum;
	}

	/**
	 * This method creates and returns iterator for society
	 * 
	 * @return Society iterator
	 */
	@SuppressWarnings("rawtypes")
	public Iterator getIndividulIterator() {
		return this.individuals.createIterator();
	}

	/**
	 * This method add individual or individual array to society
	 * 
	 * @param individual Added individual or individual array
	 */
	public void addInduvidual(IndividualComponent individual) {
		if (individual instanceof IndividualArray) {
			infectedNum += individual.getInfectedNum();
			healtyNum += individual.getHealtyNum();
		} else {
			if (individual.isEnfected()) {
				infectedNum++;
			} else {
				healtyNum++;
			}

		}
		individuals.add(individual);
	}

	/**
	 * This method prints society individuals
	 */
	public void print() {
		@SuppressWarnings("rawtypes")
		Iterator iterator = individuals.createIterator();
		while (iterator.hasNext()) {
			IndividualComponent arraycomponent = (IndividualComponent) iterator.next();
			try {
				arraycomponent.print();

			} catch (UnsupportedOperationException e) {
			}
		}
	}

	/**
	 * This method finds and returns individual
	 * 
	 * @param id Individual id
	 * @return Found individual
	 */
	public IndividualComponent find(int id) {
		@SuppressWarnings("rawtypes")
		Iterator iterator = individuals.createIterator();
		while (iterator.hasNext()) {
			IndividualComponent arraycomponent = (IndividualComponent) iterator.next();
			try {
				if (arraycomponent.getId() == id) {
					return arraycomponent;
				}
			} catch (UnsupportedOperationException e) {
			}

		}
		return null;

	}

	/**
	 * This method removes individual from society
	 * 
	 * @param id Removed individual id
	 */
	public void remove(int id) {
		@SuppressWarnings("rawtypes")
		Iterator iterator = individuals.createIterator();
		while (iterator.hasNext()) {
			IndividualComponent arraycomponent = (IndividualComponent) iterator.next();
			try {
				if (arraycomponent.getId() == id) {
					iterator.remove();
					this.infectedNum--;
					this.deathNum++;
				}
			} catch (UnsupportedOperationException e) {
			}

		}

	}

}
