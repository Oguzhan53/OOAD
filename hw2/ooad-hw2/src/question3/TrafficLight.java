/**
 * 
 */
package question3;

/**
 * Context class. It has 3 different state.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class TrafficLight {

	private State green;
	private State yellow;
	private State red;
	private State state;

	private int maxSwitchNum;
	private int curSwitchNum;

	public TrafficLight(int num) {
		this.maxSwitchNum = num;
		this.curSwitchNum = 0;
		this.green = new Green(this);
		this.yellow = new Yellow(this);
		this.red = new Red(this);
		this.state = red;
	}

	public int getMaxSwitchNum() {
		return maxSwitchNum;
	}

	public int getCurSwitchNum() {
		return curSwitchNum;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getGreen() {
		return green;
	}

	public State getYellow() {
		return yellow;
	}

	public State getRed() {
		return red;
	}

	/**
	 * This method increases switch number with each switch
	 * 
	 * @return new switch number
	 */
	public int updateSwitchNum() {
		return ++this.curSwitchNum;

	}

	/**
	 * This method switches the state.
	 */
	public void switchState() {
		this.state.switchState();
	}

	/**
	 * This method turns on the light.
	 */
	public void turnOnLight() {
		System.out.println("Lights turned on");
		this.state.switchState();
	}

}
