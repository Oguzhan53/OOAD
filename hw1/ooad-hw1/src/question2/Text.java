/**
 * 
 */
package question2;

/**
 * Text class (Web content)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Text extends WebContent {

	public Text(String name) {
		this.name = name;
	}

	@Override
	public void display() {
		System.out.println("This is " + this.getName() + " text");

	}

}
