package question2;

/**
 * Observer interface
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public interface Observer {

	/**
	 * This method notify user when updates is made(Save updates to user side)
	 * 
	 * @param audio New audio
	 * @param news  New news
	 * @param photo New photo
	 * @param text  New text
	 */
	public void update(Audio audio, News news, Photo photo, Text text);
}
