/**
 * 
 */
package question3.mobese;

/**
 * Context and subscriber class. It has 3 different state and it subscribes
 * camera.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class TrafficLight implements Observer, DisplayUpdate {

	private State green;
	private State yellow;
	private State red;
	private State state;

	private Subject mobese;
	private int lightNum;
	private int maxSwitchNum;
	private int curSwitchNum;
	private int waitSec;

	public TrafficLight(HiTech mobese, int switchNum, int lightNum) {
		this.mobese = mobese;
		this.lightNum = lightNum;
		this.maxSwitchNum = switchNum;
		this.curSwitchNum = 0;
		this.green = new Green(this);
		this.yellow = new Yellow(this);
		this.red = new Red(this);
		this.state = red;
		this.waitSec = 0;
		mobese.registerObserver(this);
	}

	public int getLightNum() {
		return lightNum;
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

	@Override
	public void update(int update) {
		waitSec = this.getGreen().updateWaitingSec(update);
		display();
		this.curSwitchNum = 0;

	}

	@Override
	public void display() {
		System.out.println("Green light on time updated to " + waitSec + " seconds in " + lightNum + ". traffic light");

	}

}
