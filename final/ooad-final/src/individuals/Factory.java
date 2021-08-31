/**
 * 
 */
package individuals;

/**
 * Factory interface
 * 
 * @author Oguzhan SEZGIN
 *
 */
public interface Factory {

	/**
	 * This method creates individual and returns
	 * 
	 * @param id         Individual id
	 * @param x          Individual x coordinate
	 * @param y          Individual y coordinate
	 * @param direction  Individual direction
	 * @param mask       Individual mask coefficient
	 * @param speed      Individual speed
	 * @param distance   Individual social distance
	 * @param collision  Individual colliision time
	 * @param isEnfected Individual infected status
	 * @return Created individual
	 */
	public Individual createIndividual(int id, int x, int y, int direction, double mask, double speed, double distance,
			double collision, boolean isEnfected);

}
