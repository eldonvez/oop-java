package inf371td2;


public class HMap {
	int size;
	EntryList[] t;
	
	HMap(int n){
		size = 0;
		t = new EntryList[n];
	}
	
	HMap(){
		size = 0;
		t = new EntryList[20];
	}
	
	WordList find(Prefix key) {
		int k =key.hashCode(this.t.length);
		for(EntryList entry = this.t[k]; entry != null; entry = entry.next) {
			if(Prefix.eq(key, entry.head.key)) {
				//entry.head.key.display();
				//System.out.println(entry.head.value.print());
				return(entry.head.value);		

			}
			}
		return(null);
		
	}
	void addSimple(Prefix key, String w) {
		WordList wlist = this.find(key);
		if(wlist == null) {
			int index = key.hashCode(this.t.length);
			t[index] = new EntryList( new Entry(key, new WordList(w, new WordList())), null);
			this.size ++;
			return;
		}
		wlist.insert(w);
	}
	void rehash(int n) {
		EntryList[] current = this.t;
		int curCapacity = current.length;
		this.t = new EntryList[n];
		for( int i = 0; i<curCapacity; i++) {
			for(EntryList read = current[i]; read != null; read = read.next) {
				Prefix key = read.head.key;
				WordList value = read.head.value;
				int index = key.hashCode(n);
				t[index] = new EntryList(new Entry(key,value), t[index]);
			}
			
		}
		
	}
	void add(Prefix key, String w) {
		WordList wlist = this.find(key);
		if(wlist == null) {
			// create new entry in table:
			if((long) (0.75*t.length) < (size+1)){
				this.rehash(2*t.length);
				System.out.println(this.t.length);
			}
			
			int index = key.hashCode(this.t.length);
			t[index] = new EntryList( new Entry(key, new WordList(w, new WordList())), t[index]);
			this.size ++;
			//key.display();
			return;
			}
		wlist.insert(w);
		
	}

		
		
	
}
