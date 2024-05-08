package gui.windows;

import enemies.Enemy;
import player.Player;
import util.enemies.EnemyFactory;
import gui.panels.*;

import javax.swing.*;

/**
 * Clase que representa la ventana principal del juego
 */
public class GameWindow extends JFrame {

	/**
	 * Instancia de la ventana principal
	 */
	private static GameWindow instance;
	/**
	 * Panel principal de la ventana
	 */
	private JPanel backgroundPanel;
	private Player player;
	private Enemy enemy;
	private final int slot;
	private JTabbedPane actionTabs;
	private JPanel topPanel;
	private JPanel playerPanel;
	private JPanel enemyPanel;
	private JPanel mainPanel;
	private JPanel statusPanel;
	private JPanel battlePanel;
	private JPanel inventoryPanel;

	/**
	 * Método que devuelve la instancia de la ventana principal
	 *
	 * @param player El jugador
	 * @param slot   El slot de guardado
	 *
	 * @return La instancia de la ventana principal
	 */
	public static synchronized GameWindow getInstance(Player player, int slot) {

		//Si la instancia es nula, la creamos
		if (instance == null) {

			instance = new GameWindow(player, slot);
		}
		//Devolvemos la instancia
		return instance;
	}

	/**
	 * Método que devuelve la instancia de la ventana principal
	 *
	 * @return La instancia de la ventana principal
	 */
	public static synchronized GameWindow getInstance() {

		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param player El jugador
	 * @param slot   El slot de guardado
	 */
	private GameWindow(Player player, int slot) {

		this.player = player;
		this.slot = slot;
	}

	/**
	 * Método que inicializa la ventana
	 */
	public void startGame() {

		//Título de la Ventana
		setTitle("Game Window");
		//Operación por defecto de cierre
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//No la hacemos escalable
		setResizable(false);
		//Agregamos el panel principal
		add(backgroundPanel);
		//Tamaño de la ventana
		pack();
		//Centramos la ventana
		setLocationRelativeTo(null);
		//Hacemos visible la ventana
		setVisible(true);
	}

	private void createUIComponents() {

		DialogPanel.getInstance().addText("¡Bienvenido a la aventura!\n");
		//Agregamos el panel del jugador
		playerPanel = PlayerPanel.getInstance(player);
		//Agregamos el enemigo
		enemy = EnemyFactory.generateRegularEnemy(player);
		//Agregamos el panel del enemigo
		enemyPanel = EnemyPanel.getInstance(enemy);
		//Agregamos el panel principal
		mainPanel = MainPanel.getInstance(enemy, player);
		//Agregamos las pestañas
		actionTabs = ActionsPanel.getInstance();
		//Agregamos el panel de estado
		statusPanel = StatusPanel.getInstance(0, player);
		//Agregamos el panel de batalla
		battlePanel = BattlePanel.getInstance(1, enemy, player, slot);
		//Agregamos el panel de inventario
		inventoryPanel = InventoryPanel.getInstance(2, player);
	}

	public Player getPlayer() {

		return player;
	}

	public void setPlayer(Player player) {

		this.player = player;
	}

	public Enemy getEnemy() {

		return enemy;
	}

	public void setEnemy(Enemy enemy) {

		BattlePanel.getInstance(1, this.enemy, player, slot).setEnemy(enemy);
		this.enemy = enemy;
	}

	public int getSlot() {

		return slot;
	}
}
