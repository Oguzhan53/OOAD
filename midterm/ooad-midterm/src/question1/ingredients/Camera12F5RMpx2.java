/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Camera12F5RMpx2 implements Camera {

	public final int front = 12;
	public final int rear = 5;
	public final int zoom = 2;

	@Override
	public String toString() {
		return this.front + " Mp front - " + this.rear + " Mp rear - x" + this.zoom + " zoom";
	}
}
