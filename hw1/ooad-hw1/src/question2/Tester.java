/**
 * 
 */
package question2;

/**
 * Tester Class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WebSite webSite = new WebSite();
		Subscriber subscriber1 = new Subscriber(webSite, "ali");
		Subscriber subscriber2 = new Subscriber(webSite, "veli");
		Subscriber subscriber3 = new Subscriber(webSite, "ayse");

		// ---- All content update ----

		System.out.println(" -------- When all content is updated -------- ");
		Audio audio = new Audio("mozart");
		Photo photo = new Photo("Davinci");
		News news = new News("breaking");
		Text text = new Text("sokrates");
		webSite.updateContent(audio, text, news, photo);

		// ---- Audio update ----
		System.out.println("\n  -------- When audio is updated  -------- ");
		audio.setName("beethoven");
		webSite.updateAudio(audio);

		// ---- Photo update ----
		System.out.println("\n  -------- When photo is updated -------- ");
		photo.setName("picasso");
		webSite.updatePhoto(photo);

		// ---- Text update ----
		System.out.println("\n  -------- When text is updated -------- ");
		text.setName("platon");
		webSite.updateText(text);

		// ---- News update ----
		System.out.println("\n  -------- When news is updated -------- ");
		news.setName("daily");
		webSite.updateNews(news);

		// ----When subscriber(veli) remove from membership and audio, text update ----
		System.out.println(
				"\n  -------- When subscriber(veli) remove from membership and audio, text are updated --------  ");
		audio.setName("tchaikovsky");
		text.setName("descartes");
		webSite.removeObserver(subscriber2);
		webSite.updateContent(audio, text, null, null);

	}

}
