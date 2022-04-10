package typo;

import java.awt.Graphics;

public class Vbox extends Group {

	double lineskip;
	
	public Vbox(double lineskip) {
		this.lineskip = lineskip;
	}
	@Override
	void add(Box b) {
		super.add(b);
		this.ascent = this.ascent + this.descent + this.lineskip + b.getAscent();
		this.descent = b.getDescent();
		this.width = Math.max(width, b.getWidth());
		this.stretchingCapacity = Math.max(stretchingCapacity, b.getStretchingCapacity());		
	}
	public String toString() {
		return("Vbox"+super.toString());
	}
	@Override
	public boolean doDraw( Graphics g, double x, double y, double w) {
		double curY = y;
		for( Box b : list) {
			b.doDraw(g, x, curY, w);
			curY += b.getAscent()+b.getDescent() + lineskip;
		}
		return(true);
	}

}
