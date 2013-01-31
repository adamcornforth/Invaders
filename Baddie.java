public class Baddie 
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

	Rectangle[] rectangles = new Rectangle[15];
	
	int bulletSpeed = 7; 
	int bulletDelay = 30; 
	int bulletDelayer = 0; 
	int health; 

	// test 
	
	Ball[] bullets = new Ball[100]; 

	public Baddie(double x, double y, int w, int h, String c, GameArena Arena) {

		this.xPosition = x;	
		this.yPosition = y;		
		this.width = w;		
		this.height = h;		 
		this.colour = c;
		this.health = 8; 

		//Rectangle(double x, double y, int w, int h, String c) 
		rectangles[0] = new Rectangle(x, y, w, h, c); // Body
		rectangles[1] = new Rectangle(x+8, y-5, w-16, h, c); // Face
		rectangles[2] = new Rectangle(x+15, y-h-2, w-30, 23, c);  // Mouth
		rectangles[3] = new Rectangle(x, y+h, 7, h+3, c); // Left Arm
		rectangles[4] = new Rectangle(x+w-7, y+h, 7, h+3, c); // Right Arm
		rectangles[5] = new Rectangle(x+15, y+h, 6, h+3, c); // Left Fang
		rectangles[6] = new Rectangle(x+w-21, y+h, 6, h+3, c); // Right Fang
		rectangles[7] = new Rectangle(x+21, y+h+11, w-42, 6, c); // Fang Bottom
		rectangles[8] = new Rectangle(x+27, y+h+11, 6, 6, "BLACK"); // Fang Bottom Gap
		rectangles[9] = new Rectangle(x+19, y-5, 6, 6, "BLACK"); // Left Eye
		rectangles[10] = new Rectangle(x+35, y-5, 6, 6, "BLACK"); // Right Eye
		rectangles[11] = new Rectangle(x+19, y-15, 6, 6, c); // Atenna Left 1
		rectangles[12] = new Rectangle(x+13, y-20, 6, 6, c); // Atenna Left 2
		rectangles[13] = new Rectangle(x+35, y-15, 6, 6, c); // Atenna Right 1
		rectangles[14] = new Rectangle(x+41, y-20, 6, 6, c); // Atenna Right 2

		for (int i = 0; i <= 14; i++) {
			Arena.addRectangle(rectangles[i]); 
		}
	}

	public void moveX(int speed, GameArena Arena) {
		// move 
		for (int i = 0; i <= 14; i++) {
			if(this.rectangles[i] != null) 
				this.rectangles[i].xPosition += speed; 
		}
		this.xPosition += speed; 
	} 

	public void moveY(int speed, GameArena Arena) {
		// move 
		for (int i = 0; i <= 14; i++) {
			if(this.rectangles[i] != null) 
				this.rectangles[i].yPosition += speed; 
		}
		this.yPosition += speed; 
	} 

	public double xPosition() {
		return this.xPosition; 
	}

	public void checkCollision(Ball bullet, GameArena Arena) {
		for (int i = 0; i <= 14; i++) {
			if(this.rectangles[i] != null) {
				if(this.rectangles[i].collides(bullet)) {
					bullet.colour = "RED"; 
					bullet.size = 3; 
					if((this.rectangles[i].colour == "ORANGE" || this.rectangles[i].colour == "RED") && this.rectangles[i].health == 0) {
						this.rectangles[i].colour = "RED"; 
						this.health--; 
					}
					else { 
						this.rectangles[i].colour = "ORANGE"; 
						this.rectangles[i].health--; 
					}
				}
				if(this.health <= 0) {
					for (int d = 0; d <= 14; d++) {
						Arena.removeRectangle(this.rectangles[i]); 
						this.rectangles[i] = null; 
					}
				}
			}
		}
	}

}
