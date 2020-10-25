package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class ColorMenu extends MenuButton {
	public ColorMenu() {
		super("Choose Player Color");
		MenuItem black = new MenuItem("Black");
		MenuItem white = new MenuItem("White");
		MenuItem random = new MenuItem("Random");
		this.getItems().addAll(black, white, random);
	}
}
