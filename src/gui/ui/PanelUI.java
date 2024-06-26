package gui.ui;

import org.jetbrains.annotations.Nullable;
import util.interfaces.Dimensions;
import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

public class PanelUI extends BasicPanelUI {

	@Override
	protected void installDefaults(JPanel p) {

		GridLayout layout = new GridLayout(1, 1);
		layout.setHgap(0);
		layout.setVgap(0);
		p.getInsets(new Insets(0, 0, 0, 0));
		p.setLayout(layout);
		p.setOpaque(false);
	}

	@Override
	public void paint(Graphics g, JComponent c) {

		super.paint(g, c);
		Graphics2D g2d = (Graphics2D) g;
		Image image = getImage(c);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, getPreferredSize(c).width, getPreferredSize(c).height, null);
	}

	private static @Nullable Image getImage(JComponent c) {

		ImageManager manager = ImageManager.getInstance();
		return switch (c.getClass().getSimpleName()) {
			case "StartPanel", "ItemPanel", "SkillPanel" -> manager.getImage("skillPanel");
			case "DialogPanel" -> manager.getImage("dialogPanel");
			case "PlayerPanel" -> manager.getImage("playerPanel");
			case "EnemyPanel" -> manager.getImage("enemyPanel");
			case "ItemDetail", "ShopItemDetail", "SkillDetail" -> manager.getImage("itemHolder");
			case "InventoryPanel" -> manager.getImage("inventoryPanel");
			case "MainPanel" -> manager.getImage("charactersPanel");
			case "BattlePanel" -> manager.getImage("battlePanel");
			case "StatusPanel" -> manager.getImage("statusPanel");
			case "ShopPanel" -> manager.getImage("shopPanel");
			default -> null;
		};
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {

		return switch (c.getClass().getSimpleName()) {
			case "StartPanel" -> Dimensions.START_PANEL_SIZE;
			case "PlayerPanel", "EnemyPanel" -> Dimensions.SIDE_PANEL_SIZE;
			case "InventoryPanel", "BattlePanel", "StatusPanel", "ShopPanel" -> Dimensions.TAB_SIZE;
			case "MainPanel" -> Dimensions.MAIN_PANEL_SIZE;
			case "DialogPanel" -> Dimensions.DIALOG_PANEL_SIZE;
			case "SkillPanel" -> Dimensions.SKILL_PANEL_SIZE;
			case "ItemPanel" -> Dimensions.ITEM_PANEL_SIZE;
			case "ItemDetail", "ShopItemDetail" -> Dimensions.ITEM_DETAIL_SIZE;
			case "SkillDetail" -> Dimensions.SKILL_DETAIL_SIZE;
			default -> new Dimension(0, 0);
		};
	}

	@Override
	public Dimension getMinimumSize(JComponent c) {

		return getPreferredSize(c);
	}

	@Override
	public Dimension getMaximumSize(JComponent c) {

		return getPreferredSize(c);
	}
}
