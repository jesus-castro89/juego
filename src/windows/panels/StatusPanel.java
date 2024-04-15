package windows.panels;

import player.Player;
import windows.labels.StatLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StatusPanel extends JPanel {

	private static StatusPanel instance;
	private final Image img;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private final ImageIcon activeIcon;
	private final ImageIcon inactiveIcon;
	private JPanel backgroundPanel;
	private JLabel levelLabel;
	private JLabel attackLabel;
	private JLabel defenseLabel;
	private JLabel goldLabel;
	private JLabel intLabel;
	private JLabel resLabel;
	private JLabel luckLabel;
	private JLabel desLabel;
	private JLabel speedLabel;

	public static StatusPanel getInstance(int tabIndex) {

		if (instance == null) {

			instance = new StatusPanel(tabIndex, Player.getInstance());
		}
		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param tabIndex índice de la pestaña
	 * @param player   jugador
	 */
	private StatusPanel(int tabIndex, Player player) {

		this.player = player;
		img = new ImageIcon("img/ui/panels/statusPanel.png").getImage();
		this.tabIndex = tabIndex;
		this.activeIcon = new ImageIcon("img/ui/tabs/statusTabActive.png");
		this.inactiveIcon = new ImageIcon("img/ui/tabs/statusTabInactive.png");
		this.actionsPanel = ActionsPanel.getInstance();
		Dimension size = new Dimension(1019, 342);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		add(backgroundPanel);
		setOpaque(false);
		setBackground(null);
		setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
		actionsPanel.addTab("Status", this);
		actionsPanel.setTabIcon(tabIndex, isActive() ? activeIcon : inactiveIcon);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				actionsPanel.setTabIcon(tabIndex, activeIcon);
			}

			@Override
			public void componentHidden(ComponentEvent e) {

				actionsPanel.setTabIcon(tabIndex, inactiveIcon);
			}
		});
	}

	private boolean isActive() {

		return actionsPanel.getSelectedIndex() == tabIndex;
	}

	/**
	 * Método que inicializa el panel
	 */
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(img, 0, 0, 1019, 342, null);
	}

	private void createUIComponents() {

		levelLabel = new StatLabel("EXP: " + player.getExperience(),
				new ImageIcon("img/ui/holders/expHolder.png").getImage());
		attackLabel = new StatLabel(player.getTotalAttack(),
				new ImageIcon("img/ui/holders/attackHolder.png").getImage());
		defenseLabel = new StatLabel(player.getTotalDefense(),
				new ImageIcon("img/ui/holders/defenseHolder.png").getImage());
		goldLabel = new StatLabel("ORO: " + player.getGold(),
				new ImageIcon("img/ui/holders/goldHolder.png").getImage());
	}
}
