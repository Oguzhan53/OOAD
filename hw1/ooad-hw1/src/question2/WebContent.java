package question2;

/**
 * Web content classes extends this class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public abstract class WebContent {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method prints contents info to screen.
	 */
	public abstract void display();

}
