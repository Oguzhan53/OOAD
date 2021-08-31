package question2;

import java.util.ArrayList;

/**
 * Web site class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class WebSite implements Subject {

	private ArrayList<Observer> subscriber;

	private boolean changed;

	private Audio audio;
	private Photo photo;
	private Text text;
	private News news;

	public WebSite() {
		changed = false;
		this.subscriber = new ArrayList<Observer>();

	}

	/**
	 * This method updates audio
	 * 
	 * @param audio New audio
	 */
	public void updateAudio(Audio audio) {
		this.audio = audio;
		setChange();

		notifyObservers();
	}

	/**
	 * This method updates news
	 * 
	 * @param news New news
	 */
	public void updateNews(News news) {
		this.news = news;

		notifyObservers();
	}

	/**
	 * This method updates photo
	 * 
	 * @param photo New photo
	 */
	public void updatePhoto(Photo photo) {
		this.photo = photo;
		setChange();
		notifyObservers();
	}

	/**
	 * This method updates text
	 * 
	 * @param text New text
	 */
	public void updateText(Text text) {
		this.text = text;
		setChange();
		notifyObservers();
	}

	/**
	 * This method updates all content of web site
	 * 
	 * @param audio New audio
	 * @param text  New text
	 * @param news  New news
	 * @param photo New photo
	 */
	public void updateContent(Audio audio, Text text, News news, Photo photo) {
		if (audio != null) {
			this.audio = audio;
			setChange();

		}
		if (text != null) {
			this.text = text;
			setChange();

		}
		if (photo != null) {
			this.photo = photo;
			setChange();

		}
		if (news != null) {
			this.news = news;
		}

		notifyObservers();
	}

	@Override
	public void setChange() {
		this.changed = true;
	}

	@Override
	public void registerObserver(Observer o) {
		subscriber.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		subscriber.remove(o);

	}

	@Override
	public void notifyObservers() {
		if (changed) {
			for (int i = 0; i < subscriber.size(); i++) {
				Observer observer = subscriber.get(i);
				observer.update(this.audio, this.news, this.photo, this.text);

			}
		}
		this.changed = false;

	}

}
