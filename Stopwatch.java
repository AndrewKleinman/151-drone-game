import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {

	private static int seconds;
	private boolean isZero;

	public Stopwatch() {
		seconds = 90;
		isZero = false;
	}

	public int getSeconds() {
		return seconds;
	}

	public String printTime() {

		if (seconds % 60 < 10) {
			return "Time: " + seconds / 60 + ":0" + seconds % 60;
		}
		return "Time: " + seconds / 60 + ":" + seconds % 60;
	}

	public void resetTime() {
		seconds = 90;
	}

	public void resetTime(int customTime) {
		seconds = customTime;
	}

	/**
	 * 
	 * @return a formatted string of the time remaining
	 */
	public void startTimer() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				seconds--;
				// used for debugging purposes System.out.println(printTime());
				// //currently prints out to console, change to print out to a
				// component
				if (seconds < 0) {
					resetTime();
				}
			}
		}, 0, 1000);

	}

	public boolean getIsZero() {
		return isZero;
	}

}
