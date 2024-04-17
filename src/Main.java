import gui.GameWindow;
import player.Player;

public class Main {

	public static void main(String[] args) {

		GameWindow.getInstance(Player.getInstance()).startGame();
	}
}
