public class Ball 
{
	// The following instance variables define the
	// information needed to represent a Ball
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	double xPosition;		// The location of this Ball
	double yPosition;		// The location of this Ball
	double size;		// The diameter of this Ball
	String colour;	// The colour of this Ball

	public Ball(double x, double y, int s, String c) {
		this.xPosition = x;	
		this.yPosition = y;		
		this.size = s;		
		this.colour = c;	
	}
					// Permissable colours are:
					// BLACK, BLUE, CYAN, DARKGREY, GREY,
					// GREEN, LIGHTGREY, MAGENTA, ORANGE,
					// PINK, RED, WHITE, YELLOW 
}
