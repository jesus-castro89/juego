package util.managers;

import gui.windows.GameWindow;
import player.Player;

import javax.swing.*;
import java.io.*;

public class FileManager {

	public static Player loadGame(int slot) throws FileNotFoundException {

		Player player;
		try {

			File file = new File(String.format("files/game%d.dat", slot));
			player = (Player) new ObjectInputStream(new FileInputStream(file)).readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new FileNotFoundException();
		}
		return player;
	}

	public static void saveGame(int slot, Player player) {

		ObjectOutputStream oos;
		try {
			File file = new File(String.format("files/game%d.dat", slot));
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(player);
			try {
				oos.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(GameWindow.getInstance(player, slot),
						"Error al guardar la partida", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (IOException e) {

			JOptionPane.showMessageDialog(GameWindow.getInstance(Player.getInstance(), slot),
					"Error al guardar la partida", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
