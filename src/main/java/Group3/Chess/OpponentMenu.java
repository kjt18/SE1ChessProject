package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class OpponentMenu extends MenuButton{
	public OpponentMenu() {
		super("Choose Opponent");
		MenuItem ai = new MenuItem("vs. AI");
		MenuItem player = new MenuItem("vs. Player");
		this.getItems().addAll(ai, player);
	}
}
