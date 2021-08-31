package question2;

/**
 * Audio class (Web content)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Audio extends WebContent {

	public Audio(String name) {
		this.name = name;
	}

	@Override
	public void display() {
		System.out.println("This is " + this.getName() + " audio");

	}

}
