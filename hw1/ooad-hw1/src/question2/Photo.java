/**
 * 
 */
package question2;

/**
 * News class (Web content)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Photo extends WebContent {

	public Photo(String name) {
		this.name = name;
	}

	@Override
	public void display() {
		System.out.println("This is " + this.getName() + " image");
	}

}
