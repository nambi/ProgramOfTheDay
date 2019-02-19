package org.nava.pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author nambi
 * 
 */
public class PubSubApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PubSubApp app = new PubSubApp();
		Publisher pub = app.new Publisher();
		pub.addObserver(app.new Subscriber());
		pub.publish();
	}

	class Subscriber implements Observer
	{
		@Override
		public void update(Observable publisher, Object pubContent)
		{
			System.out.println("Notified By " + publisher);
		}
	}

	class Publisher extends Observable
	{

		public void publish()
		{
			this.setChanged();
			this.notifyObservers();
		}
	}

}
