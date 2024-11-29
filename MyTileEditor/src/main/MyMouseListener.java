package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tile.TileManager;

public class MyMouseListener implements MouseListener{
	
	public Panel gp;
	
	public MyMouseListener(Panel gp) {
		this.gp = gp;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Get the mouse position on the screen
		int mouseX = e.getX();
		int mouseY = e.getY();

	// Calculate the mouse position in the world
		int worldMouseX = mouseX + gp.camera.worldX - gp.camera.screenX;
		int worldMouseY = mouseY + gp.camera.worldY - gp.camera.screenY;

		// Calculate the column and row of the clicked tile
		int col = worldMouseX / gp.tileSize;
		int row = worldMouseY / gp.tileSize;

		// Check if the clicked tile is within the bounds of the map
		if (col >= 0 && col < gp.maxWorldCol && row >= 0 && row < gp.maxWorldRow) {
		    System.out.println("Tile clicked at: [" + col + "][" + row + "]");
		} else {
		    System.out.println("Clicked outside of map bounds.");
		}
		
		gp.tileM.mapTileNum[col][row] = 1;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
