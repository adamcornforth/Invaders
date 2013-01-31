public class Goodie 
{
	// The following instance variables define the
	// information needed to represent a Rectangle
	// Feel free to add instance variables and methods to
	// this class to support your work... 
	
	double xPosition;		// The location of this rectangle
	double yPosition;		// The location of this rectangle
	double width;		// The dimensions of this rectangle
	double height;		// The dimensions of this rectangle
	String colour;	// The colour of this rectangle

	Rectangle rectangleBody;
	Rectangle rectangleGun; 

	int bulletSpeed = 7; 
	int bulletDelay = 15; 
	int bulletDelayer = 0; 

	Ball[] bullets = new Ball[100];

	public Goodie(double x, double y, int w, int h, String c, GameArena Arena) {

		this.xPosition = x;	
		this.yPosition = y;		
		this.width = w;		
		this.height = h;		
		this.colour = c;

		rectangleBody = new Rectangle(x, y, w, h, c); 
		Arena.addRectangle(rectangleBody);

		rectangleGun = new Rectangle(x+(w/2)-(w/5)/2, y-h, w/5, h+5, c); 
		Arena.addRectangle(rectangleGun);

	}

	public void moveLeft(int speed, GameArena Arena) {
		if(this.rectangleBody.xPosition > 0) {
			// move left
			this.rectangleBody.xPosition += -speed; 
			this.rectangleGun.xPosition += -speed; 
		}
	} 

	public void moveRight(int speed, GameArena Arena) {
		if(this.rectangleBody.xPosition < (Arena.arenaWidth - this.rectangleBody.width)) {
			// move right
			this.rectangleBody.xPosition += speed; 
			this.rectangleGun.xPosition += speed;  
		}
	} 

	public void fire(int number, GameArena Arena) {
		if(this.bulletDelayer == 0) {
			double fireX = this.rectangleGun.xPosition + (this.rectangleGun.width/2 - 5/2);  

			for (int insertIndex = 0; insertIndex < 100; insertIndex++) {
				if(bullets[insertIndex] == null)
				{
					bullets[insertIndex] = new Ball(fireX, this.yPosition - this.rectangleGun.height + 5, 5, "WHITE");
					Arena.addBall(bullets[insertIndex]); 
					break;
				}
			}
			this.bulletDelayer++;  
		}

		if(this.bulletDelayer == this.bulletDelay) {
			this.bulletDelayer = 0;
		} else {
			this.bulletDelayer++; 
		} 
	}

	public void moveBullet(int bulletIndex, GameArena Arena, Baddie[] baddies) {
			if (bullets[bulletIndex] != null) { 
				bullets[bulletIndex].yPosition += -bulletSpeed;   

				for (int i = 0; i < 15; i++) 
						baddies[i].checkCollision(bullets[bulletIndex], Arena);  

				if(bullets[bulletIndex].yPosition < 0 - bullets[bulletIndex].size) {
					Arena.removeBall(bullets[bulletIndex]); 
					bullets[bulletIndex] = null; 
				}

			}
	} 

}
