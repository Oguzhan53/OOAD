/**
 * 
 */
package question2;

/**
 * Subscriber class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Subscriber implements Observer, Notification {

	private String name;
	private Audio audio;
	private Photo photo;
	private Text text;
	private News news;

	@SuppressWarnings("unused")
	private Subject WebSite;

	public Subscriber(Subject WebSite, String name) {
		this.WebSite = WebSite;
		this.name = name;
		WebSite.registerObserver(this);
	}

	@Override
	public void update(Audio audio, News news, Photo photo, Text text) {
		if (audio != null) {
			this.audio = audio;

		}
		if (text != null) {
			this.text = text;

		}
		if (photo != null) {
			this.photo = photo;

		}
		if (news != null) {
			this.news = news;
		}
		notifyUser();

	}

	@Override
	public void notifyUser() {
		System.out.println("Hello " + name + ".New updates were made.Here is the new content of website ;");
		if (audio != null) {
			this.audio.display();

		}
		if (text != null) {
			this.text.display();

		}
		if (photo != null) {
			this.photo.display();

		}
		if (news != null) {
			this.news.display();

		}
		System.out.println();

	}

}
