/**
 * 
 */
package individuals;

import java.awt.Graphics;
import java.util.Iterator;

/**
 * Individual component class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public abstract class IndividualComponent {

	public int getX() {
		throw new UnsupportedOperationException();
	}

	public void setX(int x) {
		throw new UnsupportedOperationException();
	}

	public int getY() {
		throw new UnsupportedOperationException();
	}

	public void setY(int y) {
		throw new UnsupportedOperationException();
	}

	public int[] getPrevCoor() {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		throw new UnsupportedOperationException();
	}

	public Direction getDirection() {
		throw new UnsupportedOperationException();
	}

	public void setDirection(Direction direction) {
		throw new UnsupportedOperationException();
	}

	public double getMask() {
		throw new UnsupportedOperationException();
	}

	public double getSpeed() {
		throw new UnsupportedOperationException();
	}

	public double getDistance() {
		throw new UnsupportedOperationException();
	}

	public double getCollision() {
		throw new UnsupportedOperationException();
	}

	public void setEnfected(boolean isEnfected) {
		throw new UnsupportedOperationException();
	}

	public boolean isEnfected() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();
	}

	public Mediator getMediator() {
		throw new UnsupportedOperationException();
	}

	public int getInfectedNum() {
		throw new UnsupportedOperationException();
	}

	public int getHealtyNum() {
		throw new UnsupportedOperationException();
	}

	public Status move(boolean repeat) {
		throw new UnsupportedOperationException();
	}

	public void paint(Graphics g) {
		throw new UnsupportedOperationException();
	}

	public int getWaitingTime() {
		throw new UnsupportedOperationException();
	}

	public void setWaitingTime(int waitingTime) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method adds the new individual to individual component array
	 * 
	 * @param individualComponent New individual component
	 */
	public void add(IndividualComponent individualComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method removes the individual from individual component array
	 * 
	 * @param individualComponent individual component
	 */
	public void remove(IndividualComponent individualComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method creates iterator for array component
	 * 
	 * @return individual component array iterator
	 */
	@SuppressWarnings("rawtypes")
	abstract Iterator createIterator();

}
