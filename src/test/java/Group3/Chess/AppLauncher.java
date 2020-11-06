package Group3.Chess;

import javafx.application.Application;

public class AppLauncher extends Thread {
	@Override
	public void run() {
		Application.launch(App.class, "");		
	}
}
