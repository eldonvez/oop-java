package typo;

import java.awt.Graphics;
import java.util.LinkedList;

public abstract class Group extends Box {
	
	protected final LinkedList<Box> list = new LinkedList<Box>();
	double ascent;
	double descent;
	double width;
	double stretchingCapacity;
	
	Group() {
			}
	void add(Box e) {
		this.list.add(e);
		return;
	}
	@Override
	public double getWidth() {
				return width;
	}
	
	@Override
	public double getAscent() {
		// TODO Auto-generated method stub
		return ascent;
	}

	@Override
	public double getDescent() {
		// TODO Auto-generated method stub
		return descent;
	}

	@Override
	public double getStretchingCapacity() {
		// TODO Auto-generated method stub
		return stretchingCapacity;
	}


	@Override
	public String toString() {
		String s =super.toString()+"{\n";
		for( Box b: list) {
			s+= b.toString()+",\n";
		}
		s = s.replaceAll("(?m)^", "\t");
		s+="}";
		return(s);
	}

}
