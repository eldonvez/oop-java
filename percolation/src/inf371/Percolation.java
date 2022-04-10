package inf371;

public class Percolation {
	static int size = 2027;
	static int length = size*size;
	static boolean[] grid;
	
	static void init() {
		grid = new boolean[length];
		for(int i=0; i<length; i++) {grid[i]=false;}
		UnionFind.init(length);
	}
	static void print() {
		for(int i = 0; i < length; i++) {
			if (grid[i]) System.out.print("*");
			else System.out.print("-");
			if(i%size == size-1) System.out.println();
		}
		System.out.println();
	}

	static int randomShadow() {
		int i;
		do {
		i = (int) (Math.random() * length);
		}while(grid[i]);
		grid[i]=true;
		propagateUnion(i);
		return(i);
		}
		
	
	
	static boolean isNaivePercolation(int n) {
		boolean up;
		boolean down;
		boolean[] seen = new boolean[length];
		up = detectPath(seen, n, true);
		seen = new boolean[length];
		down = detectPath(seen, n, false);
		return(up && down);
	}
	
	static boolean detectPath(boolean[] seen, int n, boolean up) {
		seen[n]=true;
		if( (up && n/size ==0) || (!up && n/size == size-1) ) return(true);
		boolean left=false;
		boolean right=false;
		boolean above=false;
		boolean below=false;
		
		if(n%size !=0 && grid[n-1] && !seen[n-1]) {
			left=detectPath(seen,n-1,up);
		}
		if(n%size != size-1 && grid[n+1] && !seen[n+1]) {
			right=detectPath(seen,n+1,up);
		}
		if(n/size != 0 && grid[n-size] && !seen[n-size]) {
			above= detectPath(seen,n-size,up);
		}
		if(n/size!= size-1 && grid[n+size] && !seen[n+size]) {
			below = detectPath(seen,n+size,up);
		}
		
		return(left || right || above || below);
		
		
		
	}
		
			
	static boolean isPercolation(int n) {return(isLogPercolation(n));}	
	
	static double percolation() {
		init();
		int n;
		double res=0;
		do {
			n=randomShadow();
		//	print();
			res=res+1;
			
			
		}while(!isPercolation(n));
		//print();
		return(res/length);	
	}
	
	static double monteCarlo(int n) {
		double avg=0;
		for(int i = 0; i<n; i++) {
			avg+=percolation();
			
		}
		return(avg/n);
	}
	
	static void propagateUnion(int x) {
		if(x%size != 0 && grid[x-1]) UnionFind.union(x-1, x);
		if(x%size != size-1 && grid[x+1]) UnionFind.union(x+1, x);
		if(x/size != 0 && grid[x-size]) UnionFind.union(x-size, x);
		if(x/size != size-1 && grid[x+size]) UnionFind.union(x+size, x);
		if(x/size == 0) UnionFind.union(x, length);
		if(x/size == size-1) UnionFind.union(x, length+1);
		
		
}
	
	static boolean isFastPercolation(int n) {
		int rep = UnionFind.find(n);
		boolean bot = false;
		boolean top = false;
		for(int i=0; i<size; i++) {
			if(rep==UnionFind.find(i+size*(size-1))) bot=true;
			if(rep==UnionFind.find(i)) top=true;
			
		}
		return(bot&&top);
		
	}
			
	static boolean isLogPercolation(int n) {
		return(UnionFind.find(length+1)==UnionFind.find(length));
	}
		
	
	public static void main(String[] a) {
		double p = monteCarlo(100);
		System.out.print(p);
		
	}

}
