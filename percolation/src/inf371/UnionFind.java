package inf371;

public class UnionFind {

	static int[] equiv;
	static int[] height;
	
	
	static void init(int len) {
		equiv = new int[len+2];
		height = new int[len+2];

		for(int i=0; i<len+2; i++) {
			equiv[i]=i;
			height[i]=1;
		}
	}
	
	static int naiveFind(int x) {
		return(equiv[x]);	
	}
	static int naiveUnion(int x, int y) {
		int repy = naiveFind(y);
		int repx = naiveFind(x);
		for(int i=0; i<equiv.length; i++) {
			if (equiv[i]==repx) equiv[i]=repy;
		}
		return(repy);
	}
	
	static int fastFind(int x) {
		while(x != equiv[x]) x=equiv[x];
		return(x);
		
	}
	
	static int fastUnion(int x, int y) {
		x=fastFind(x);
		equiv[x]=fastFind(y);
		return(equiv[x]);
	}
	
	static int logUnion(int x, int y ) {
		int i = find(x);
		int j = find(y);
		if(height[i]<height[j]){ equiv[i]=j; return(j);}
		else if(height[j]<height[i]){ equiv[j]=i; return(i);}
		else{equiv[i]= j; height[j]++; return(j);}
	}
	
	static int logFind(int x) {
		int i = x;
		while (i != equiv[i]) i=equiv[i];
		int k;
		while(x != i) {
			k = equiv[x];
			equiv[x]=i;
			x = k;
		}
		return(i);
		
	}
	
	static int find(int x) {return logFind(x);}
	static int union(int x, int y) {return(logUnion(x,y));}
}
