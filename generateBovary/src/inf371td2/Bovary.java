package inf371td2;

public class Bovary {
	static HMap buildTable(String[] files, int n) {
		HMap h = new HMap();
		int l = files.length;
		for(int i = 0; i< l; i++) {
			WordReader wr = new WordReader(files[i]);
			Prefix p = new Prefix(n);
			String w = wr.read();
			while(w != null) {
				h.add(p, w);
				p=p.addShift(w);
				w = wr.read();
			}
			h.add(p,Prefix.end);
			//p.display();
		}
		return(h);
	}
	static void generate(HMap t, int n) {
		String cur;
		Prefix P = new Prefix(n);
		//P.display();
		while(true) {
			WordList w = t.find(P);
			if(w == null) { System.out.println("pas pu trouver de mot suivant"); return;}
			//System.out.println(w.print());
			cur = w.getRandom();
			if(cur.equals(Prefix.end)){System.out.println(); return;}
			else if(cur.equals(Prefix.par)) { System.out.println(); }
				else {System.out.print(cur+" ");}
			P=P.addShift(cur);
		}
	}
	public static void main(String[] a) {
		String[] files = new String[35];
		for (int i = 1; i< 36; i++) {
			files[i-1] = String.format("bovary/%d%d.txt", i/10, i%10);
			//System.out.print(files[i-1]);
		}
		
		HMap h = buildTable(files, 3);
		generate(h, 3);
		
	}
	
}
