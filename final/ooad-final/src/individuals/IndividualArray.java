/**
 * 
 */
package individuals;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Individual array class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public class IndividualArray extends IndividualComponent {

	ArrayList<IndividualComponent> individuals = new ArrayList<IndividualComponent>();

	private int infectedNum;

	private int healtyNum;

	public ArrayList<IndividualComponent> getIndividuals() {
		return individuals;
	}

	public void setIndividuals(ArrayList<IndividualComponent> individuals) {
		this.individuals = individuals;
	}

	@Override
	public int getInfectedNum() {
		return infectedNum;
	}

	public void setInfectedNum(int infectedNum) {
		this.infectedNum = infectedNum;
	}

	@Override
	public int getHealtyNum() {
		return healtyNum;
	}

	public void setHealtyNum(int healtyNum) {
		this.healtyNum = healtyNum;
	}

	@Override
	public void add(IndividualComponent individualComponent) {
		try {
			if (individualComponent.isEnfected()) {
				this.infectedNum++;
			} else if (!individualComponent.isEnfected()) {
				this.healtyNum++;
			}
		} catch (UnsupportedOperationException e) {
		}

		this.individuals.add(individualComponent);
	}

	@Override
	public void remove(IndividualComponent individualComponent) {
		this.individuals.remove(individualComponent);
	}

	@SuppressWarnings("rawtypes")
	@Override
	Iterator createIterator() {
		return new CompositeIterator(individuals.iterator());
	}

}
