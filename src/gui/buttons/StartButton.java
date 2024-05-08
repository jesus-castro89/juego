package gui.buttons;

import gui.windows.GameWindow;
import gui.windows.NewGameWindow;
import player.Player;

public class StartButton extends ActionButton {

	private int slot;

	public StartButton(NewGameWindow window, int slot) {

		super("Iniciar");
		this.slot = slot;
		// Asignamos la acción de iniciar el juego
		addActionListener(e -> {

			// Obtenemos el jugador y la ventana de inicio de juego
			Player player = Player.getInstance(window.getPlayerName());
			// Cerramos la ventana de inicio de juego y abrimos la ventana de juego
			window.dispose();
			// Iniciamos el juego
			GameWindow.getInstance(player, getSlot()).startGame();
		});
	}

	public void setSlot(int slot) {

		this.slot = slot;
	}

	public int getSlot() {

		return slot;
	}
}
