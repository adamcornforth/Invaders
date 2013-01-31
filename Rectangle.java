public class Rectangle 
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
	int health; 

	public Rectangle(double x, double y, int w, int h, String c) {
		this.xPosition = x;	
		this.yPosition = y;		
		this.width = w;		
		this.height = h;		
		this.colour = c;	
		this.health = 5; 
	}

	public boolean collides(Ball ball)
	{
		return (xPosition < ball.xPosition + ball.size &&
		xPosition + width > ball.xPosition &&
		yPosition < ball.yPosition + ball.size &&
		yPosition + height > ball.yPosition); 
	}

					// Permissable colours are:
					// BLACK, BLUE, CYAN, DARKGREY, GREY,
					// GREEN, LIGHTGREY, MAGENTA, ORANGE,
					// PINK, RED, WHITE, YELLOW 
					//
	// There are no methods defined in this class... yet. :-)
	// Feel free to add your own if you think it useful.


}
