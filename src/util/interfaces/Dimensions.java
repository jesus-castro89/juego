package util.interfaces;

import java.awt.*;

public interface Dimensions {

	Dimension SCREEN_SIZE = new Dimension(1280, 680);
	Dimension START_PANEL_SIZE = new Dimension(960, 540);
	Dimension SIDE_PANEL_SIZE = new Dimension(256, 300);
	Dimension MAIN_PANEL_SIZE = new Dimension(768, 300);
	Dimension DIALOG_PANEL_SIZE = new Dimension(748, 140);
	Dimension DIALOG_SCROLL_SIZE = new Dimension(731, 124);
	Dimension TAB_SIZE = new Dimension(1275, 340);
	Dimension TAB_LABEL_SIZE = new Dimension(96, 32);
	Dimension SPRITE_SIZE = new Dimension(256, 140);
	Dimension PLAYER_SPRITE_SIZE = new Dimension(65, 85);
	Dimension BUTTON_SIZE = new Dimension(142, 30);
	Dimension STAT_LABEL_SIZE = new Dimension(185, 72);
	Dimension EQUIP_LABEL_SIZE = new Dimension(320, 72);
	Dimension ITEM_PANEL_SIZE = new Dimension(1245, 295);
	Dimension SKILL_PANEL_SIZE = new Dimension(900, 310);
	Dimension SKILL_DETAIL_SIZE = new Dimension((SKILL_PANEL_SIZE.width / 2) - 30,
			(SKILL_PANEL_SIZE.height / 2)-5);
	Dimension ITEM_DETAIL_SIZE = new Dimension((ITEM_PANEL_SIZE.width / 3) - 30,
			(ITEM_PANEL_SIZE.height / 2)-5);
	Dimension LABEL_SIZE = new Dimension(150, 30);
	Dimension FILE_LABEL_SIZE = new Dimension(200, 49);
	Dimension PORTRAIT_SIZE = new Dimension(117, 117);
	Dimension BAR_SIZE = new Dimension(150, 29);
}