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
public class News extends WebContent {

	public News(String name) {
		this.name = name;
	}

	@Override
	public void display() {
		System.out.println("This is " + this.getName() + " news");

	}

}
