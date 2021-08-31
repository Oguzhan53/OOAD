/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class CpuRam2Core6GB implements CpuRam {

	private final double hz = 2.2;
	private final int memory = 6;
	private final int core = 2;

	@Override
	public String toString() {
		return this.hz + "GHz cpu and " + this.memory + " GB - " + this.core + " core ram.";
	}

}
