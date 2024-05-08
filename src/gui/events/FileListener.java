package gui.events;

import gui.windows.GameWindow;
import gui.windows.NewGameWindow;
import gui.buttons.ActionButton;
import gui.buttons.LoadGameButton;
import gui.buttons.NewGameButton;
import gui.windows.StartWindow;
import player.Player;
import util.managers.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class FileListener implements ActionListener {

	private final int slot;
	private final ActionButton button;

	public FileListener(ActionButton button, int slot) {


		this.slot = slot;
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Este método se encarga de gestionar las acciones de los botones de la ventana de inicio
		switch (button) {
			case NewGameButton _ -> {
				StartWindow.getInstance().dispose();
				// Si el botón es de nueva partida, se abre la ventana de nueva partida
				NewGameWindow.getInstance(slot).setVisible(true);
			}
			case LoadGameButton _ -> {
				// Si el botón es de cargar partida, se carga la partida del slot correspondiente
				try {
					// Se carga la partida y se abre la ventana de juego
					Player player = FileManager.loadGame(slot);
					StartWindow.getInstance().dispose();
					GameWindow.getInstance(player, slot).startGame();
				} catch (FileNotFoundException fileNotFoundException) {
					// Si no se encuentra la partida, se muestra un mensaje de error
					JOptionPane.showMessageDialog(null, "No hay partida guardada en este slot",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			default -> throw new IllegalStateException("Unexpected value: " + button);
		}
	}
}
