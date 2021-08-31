/**
 * 
 */
package question3.mobese;

import java.util.ArrayList;

/**
 * Camera class.Traffic lights subscribe this class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class HiTech implements Subject {

	private ArrayList<Observer> lights;
	private boolean changed;
	private int updateTime;
	private boolean isCrowded;

	public HiTech(int time) {
		this.changed = false;
		this.lights = new ArrayList<Observer>();
		this.updateTime = time;
		this.isCrowded = false;
	}

	@Override
	public void registerObserver(Observer o) {
		lights.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		lights.remove(o);

	}

	@Override
	public void notifyObservers() {
		if (changed) {
			for (int i = 0; i < lights.size(); i++) {
				Observer observer = lights.get(i);
				observer.update(updateTime);
			}
		}
		this.changed = false;

	}

	@Override
	public void setChange() {
		this.changed = true;

	}

	/**
	 * This method calls notifyOberver method when the traffic state change.
	 * 
	 * @param flag If flag is true means that traffic gets crowded else means that
	 *             not crowded.
	 */
	public void changeDetected(boolean flag) {
		if (flag && !isCrowded) {
			setChange();
			notifyObservers();
			isCrowded = true;

		} else if (flag && isCrowded) {
			updateTime *= -1;
			setChange();
			notifyObservers();
			updateTime *= -1;
			isCrowded = false;

		}
	}

}
