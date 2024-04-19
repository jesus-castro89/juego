import gui.GameWindow;
import gui.NewGameWindow;
import player.Player;
import util.managers.FileManager;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {

		try {

			Player.setInstance(FileManager.loadGame(new File("files/game.dat")));
			GameWindow.getInstance(Player.getInstance()).startGame();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			new NewGameWindow();
		}
	}
}
