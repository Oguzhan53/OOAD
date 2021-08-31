/**
 * 
 */
package question3.mobese;

/**
 * Red state class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Red implements State {

	private TrafficLight trafficLight;
	private int waitingSec;

	public Red(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
		this.waitingSec = 15;
	}

	public int getWaitingSec() {
		return waitingSec;
	}

	public void setWaitingSec(int waitingSec) {
		this.waitingSec = waitingSec;
	}

	@Override
	public int updateWaitingSec(int waitingSec) {
		return this.waitingSec += waitingSec;
	}

	public TrafficLight getTrafficLight() {
		return trafficLight;
	}

	public void setTrafficLight(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
	}

	@Override
	public void switchState() {
		System.out.println("Red light turned on for " + this.getWaitingSec() + " seconds ");

		if (trafficLight.updateSwitchNum() >= trafficLight.getMaxSwitchNum()) {
			System.out.println("Lights turned off");
		} else {
			trafficLight.setState(trafficLight.getGreen());
			trafficLight.getState().switchState();
		}
	}

}
