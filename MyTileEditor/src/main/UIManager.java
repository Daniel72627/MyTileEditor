package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class UIManager {
	Panel gp;
	
	public UIManager(Panel gp) {
		this.gp = gp;
	
		}
	

		public void draw(Graphics2D g2) {
			int UI_width = gp.screenWidth;
			int UI_height = gp.screenHeight/4;
			int UI_location = gp.screenHeight-UI_height;
			if(gp.keyH.epressed == true) {
				g2.setColor(new Color(0, 0, 0, 150));
				g2.fillRect(0, UI_location, UI_width, UI_height);
				
				g2.drawImage(gp.tileM.tile[0].image, UI_location + UI_height/2, 0, gp.tileSize, gp.tileSize, null);
			}
		}
}
