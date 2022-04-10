package inf371td2;

public class Prefix {
	String[] t;
	final static String start = "<START>", end = "<END>", par = "<PAR>";
	
	Prefix(int n){
		String[] t = new String[n];
		for(int i = 0; i<n; i++) {
			t[i] = start;
		}
		this.t = t;
	
	}
	Prefix(String[] s){
		this.t = s;
	}
	static boolean eq(Prefix p1, Prefix p2) {
		String[] u = p1.t, v= p2.t; 
		if(u.length != v.length ) {return(false);}
		int L = u.length;
		for(int i = 0; i< L; i++) {
			if(! u[i].equals(v[i])) return(false);
		}
		return(true);
	}
	void display(){
		int i = t.length;
		String toPrint = "{";
		for(int j = 0; j < i-1; j++) {
			toPrint += t[j]+", ";
		}
		toPrint+=t[i-1]+"}";
		System.out.println(toPrint);
	}
	Prefix addShift(String w) {
		int len = this.t.length;
		String[] s = new String[len];
		for(int i = 0; i<len-1; i++) {
			s[i]=t[i+1];
		}
		s[len-1]=w;
		return(new Prefix(s));
	}
	public int hashCode() {
		int len = this.t.length;
		int h = 0;
		for(int i = 0; i<len-1; i++) {
			h = 37*h + t[i].hashCode();
		}
		return(h);
	}
	public int hashCode(int n) {
		return(Math.floorMod(this.hashCode(), n));
	}
}
