package ro.ase.cts.observer;

public class CoffeeNotifier extends CoffeeNotification {
		public void done() {
			this.notifiyObserver();
		}
}
