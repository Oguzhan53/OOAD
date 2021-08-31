/**
 * 
 */
package question3;

/**
 * Green state class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Green implements State {

	private TrafficLight trafficLight;
	private int waitingSec;

	public Green(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
		this.waitingSec = 60;
	}

	public int getWaitingSec() {
		return waitingSec;
	}

	public void setWaitingSec(int waitingSec) {
		this.waitingSec = waitingSec;
	}

	public TrafficLight getTrafficLight() {
		return trafficLight;
	}

	public void setTrafficLight(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
	}

	@Override
	public void switchState() {
		System.out.println("Green light turned on for " + this.getWaitingSec() + " seconds ");

		if (trafficLight.updateSwitchNum() >= trafficLight.getMaxSwitchNum()) {
			System.out.println("Lights turned off");
		} else {
			trafficLight.setState(trafficLight.getYellow());
			trafficLight.getState().switchState();
		}
	}

}
