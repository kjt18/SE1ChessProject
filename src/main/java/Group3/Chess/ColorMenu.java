package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class ColorMenu extends MenuButton {
	private static String choice;
	public ColorMenu() {
		super("Choose Player Color");
		MenuItem black = new MenuItem("Black");
		black.setOnAction(e -> {
		choice = "Black";
		this.setText(choice);
		});
		MenuItem white = new MenuItem("White");
		white.setOnAction(e -> {
		choice = "White";
		this.setText(choice);
		});
		MenuItem random = new MenuItem("Random");
		random.setOnAction(e -> {
		choice = "Random";
		this.setText(choice);
		});
		this.getItems().addAll(black, white, random);
	}
}
