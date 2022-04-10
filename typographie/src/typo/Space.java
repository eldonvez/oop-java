package typo;
import java.awt.Color;
import java.awt.Graphics;

public class Space extends Box {
	final private double width;
	final private double stretchingCapacity;
	
	Space(double w, double sc){
		width = w;
		stretchingCapacity = sc;
	}
	
	public double getStretchingCapacity() {return(stretchingCapacity);}
	public double getWidth() {return(width);}
	public double getAscent() {return 0;}
	public double getDescent() {return 0;}
	public boolean doDraw(Graphics graph, double x, double y, double w) {return(true);}
	public String toString() {
		return("Space"+super.toString());
	}
	
	
}

