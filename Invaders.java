import java.util.*;

public class Invaders 
{
	public static void main(String[] args) 
	{
		GameArena Arena = new GameArena(); 
		Arena.setSize(800,600); 

		Goodie goodie = new Goodie(Arena.arenaWidth/2, Arena.arenaHeight*0.9, 30, 5, "RED", Arena); 

		Baddie[] baddies = new Baddie[100];

		// create row of baddies 
		for (int i = 0; i < 5; i++) {
			baddies[i] = new Baddie((Arena.arenaWidth/8 * i) + ((Arena.arenaWidth/5)/2) - 30, Arena.arenaHeight*0.4, 60, 8, "GREEN", Arena); 
		} 

		// 2nd row
		for (int i = 0; i < 5; i++) {
			baddies[i+5] = new Baddie((Arena.arenaWidth/8 * i) + ((Arena.arenaWidth/5)/2) - 30, Arena.arenaHeight*0.3, 60, 8, "GREEN", Arena); 
		} 

		// 3rd row
		for (int i = 0; i < 5; i++) {
			baddies[i+10] = new Baddie((Arena.arenaWidth/8 * i) + ((Arena.arenaWidth/5)/2) - 30, Arena.arenaHeight*0.2, 60, 8, "GREEN", Arena); 
		} 
		

		int speed = 7; 
		int invaderSpeed = 4; 
		int moveDown = 0; 
 
		while (true) {

			// movement and firing
			if(Arena.left) 
				goodie.moveLeft(speed, Arena); 

			if(Arena.right) 
				goodie.moveRight(speed, Arena);

			if(Arena.up) 
				goodie.fire(1, Arena); 

			// update all bullets
			for (int bulletIndex = 0; bulletIndex < 100; bulletIndex++) 
				goodie.moveBullet(bulletIndex, Arena, baddies); 

			// check if any baddies are out of bounds 
			for (int d = 0; d < 15; d++) {
				if(baddies[d].health > 0) {
					if(baddies[d].xPosition() < 0 || baddies[d].xPosition() > Arena.arenaWidth - baddies[d].width) {
						invaderSpeed = -invaderSpeed; 
						moveDown = 1;

						for (int e = 0; e < 15; e++) 
							baddies[e].moveX(invaderSpeed, Arena); 

						break;
					}
				}
			}

			// move baddies
			for (int i = 0; i < 15; i++) {
				// move down if down flag triggered by an invader going out of bounds
				if(moveDown > 0) {
					baddies[i].moveY(2, Arena); 
					moveDown++; 
					if(moveDown > 120)
						moveDown = 0; 
				} else {
				// move in direction required
				baddies[i].moveX(invaderSpeed, Arena); 
				}
			}

			// Pause for 1/6th of a second then run main loop again
			Arena.pause();
		}

	}
}