package typo;

import java.awt.Graphics;

public class Hbox extends Group {

	public Hbox() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void add(Box b) {
		super.add(b);
		this.ascent = Math.max(ascent, b.getAscent());
		this.descent = Math.max(descent, b.getDescent());
		this.width = width + b.getWidth();
		this.stretchingCapacity = stretchingCapacity + b.getStretchingCapacity();
		
	}
	
	public String toString() {
		return("Hbox"+super.toString());
	}
	@Override
	public boolean doDraw(Graphics graph, double x, double y, double w) {
		double mw = this.getWidth();
		double stretchable = 0;
		double curX = x, curY = y;
		double curW;
		if( w < mw) {
			for (Box b: list) {
				curY = y + b.getAscent() - this.getAscent();
				curW = b.getWidth();
				b.doDraw(graph, curX, curY, curW);
				curX += curW;}
		
			return(false);
		}
		else {
			for (Box b: list) {
				stretchable += b.getStretchingCapacity();
			}
			if( stretchable == 0) {stretchable = 1;}
			for (Box b: list) {
				curY = y - b.getAscent() + this.getAscent();
				curW = b.getWidth() + (w-mw)*b.getStretchingCapacity()/stretchable;
				b.doDraw(graph, curX, curY, curW);
				curX += curW;
			}
			
			return(true);
		}
	}
	
}
