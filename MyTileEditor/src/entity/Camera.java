package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;
import main.KeyHandler;

public class Camera extends Entity{
	
	Panel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Camera(Panel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 25;
		worldY = gp.tileSize * 25;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_4.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_4.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_4.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_4.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "up";
				worldY -= speed;
			}
			else if(keyH.downPressed == true) {
				direction = "down";
				worldY += speed;
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
				worldX -= speed;
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
				worldX += speed;
			}
			
			spriteCounter++;
	        if(spriteCounter > 10) {  // Controls the speed of the sprite change
	            spriteNum++;  // Increment spriteNum to cycle through images
	            if(spriteNum > 4) {
	                spriteNum = 1;  // Reset to 1 when it exceeds 4
	            }
	            spriteCounter = 0;  // Reset spriteCounter
	        }
		}
		
	}
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		if(direction == "up") {
			if(spriteNum == 1) {
				image = up1;
			} else if(spriteNum == 2) {
				image = up2;
			} else if(spriteNum == 3) {
				image = up3;
			} else if(spriteNum == 4) {
				image = up4;
			}

		}
		if(direction == "down") {
			if(spriteNum == 1) {
				image = down1;
			} else if(spriteNum == 2) {
				image = down2;
			} else if(spriteNum == 3) {
				image = down3;
			} else if(spriteNum == 4) {
				image = down4;
			}

		}
		if(direction == "left") {
			if(spriteNum == 1) {
				image = left1;
			} else if(spriteNum == 2) {
				image = left2;
			} else if(spriteNum == 3) {
				image = left3;
			} else if(spriteNum == 4) {
				image = left4;
			}

		}
		if(direction == "right") {
			if(spriteNum == 1) {
				image = right1;
			} else if(spriteNum == 2) {
				image = right2;
			} else if(spriteNum == 3) {
				image = right3;
			} else if(spriteNum == 4) {
				image = right4;
			}

		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize,  gp.tileSize, null);
		
	}

}
