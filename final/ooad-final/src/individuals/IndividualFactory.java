/**
 * 
 */
package individuals;

/**
 * Individual factory class
 * @author Oguzhan SEZGIN
 *
 */
public class IndividualFactory implements Factory {

	private Mediator mediator;

	public IndividualFactory(Mediator mediator) {
		super();
		this.mediator = mediator;
	}

	@Override
	public Individual createIndividual(int id, int x, int y, int direction, double mask, double speed, double distance,
			double collision, boolean isEnfected) {

		return new Individual(id, x, y, Direction.values()[direction], mask, speed, distance, collision, isEnfected,
				this.mediator.getMortalityRate(), this.mediator);
	}

}
