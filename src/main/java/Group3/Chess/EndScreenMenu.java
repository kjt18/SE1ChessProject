package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class EndScreenMenu extends MenuButton{

	private static String choice;
	public EndScreenMenu() {
		super("Play Again?");
		MenuItem yes = new MenuItem("Yes");
		yes.setOnAction(e -> {
		choice = "Yes";
		this.setText(choice);
		});
		MenuItem no = new MenuItem("No");
		no.setOnAction(e -> {
		choice = "No";
		this.setText(choice);
		});
		this.getItems().addAll(yes, no);
	}
	public static String getChoice() {
		return choice;
	}
}
