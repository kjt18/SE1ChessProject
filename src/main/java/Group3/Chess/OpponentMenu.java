package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class OpponentMenu extends MenuButton{
	private static String choice;
	public OpponentMenu() {
		super("Choose Opponent");
		MenuItem ai = new MenuItem("vs. AI");
		ai.setOnAction(e -> {
		choice = "vs. AI";
		this.setText(choice);
		});
		MenuItem player = new MenuItem("vs. Player");
		player.setOnAction(e -> {
		choice = "vs. Player";
		this.setText(choice);
		});
		this.getItems().addAll(ai, player);
	}
}
