package gui.buttons;

import gui.GameWindow;
import gui.NewGameWindow;
import player.Player;

public class StartButton extends ActionButton {

	NewGameWindow newGameWindow;

	public StartButton(NewGameWindow window) {

		super("Iniciar");
		window.dispose();
		addActionListener(e -> {

			Player player = Player.getInstance(window.getPlayerName());
			window.dispose();
			GameWindow.getInstance(player).startGame();
		});
	}
}
