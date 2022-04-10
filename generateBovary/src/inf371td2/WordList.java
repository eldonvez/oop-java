package inf371td2;

public class WordList {
	Node content;
	
	WordList(){
		content = null;
	}
	WordList(String s, WordList n){
		content = new Node(s, n.content);
	}
	WordList(String[] t ){
		int len = t.length;
		content = new Node(t[0],null);
		for(int i = 1; i< len; i++) {
			Node.addLast(t[i], content);
		}
	}
	
	static WordList foobar = new WordList("foo", new WordList("bar", new WordList("baz", new WordList())));
	
	String print() {
		return Node.printNodes(this.content);
	}
	
	void addFirst(String w) {
		this.content = new Node(w, this.content);
	}
	
	void addLast(String w) {
		Node.addLast(w, this.content);
	}
	
	String removeFirst() {
		if (this.content == null) return(null);
		String h = this.content.head;
		this.content = this.content.next;
		return(h);
		
	}
	String removeLast() {
		if (this.content == null) return(null);
		Node n = this.content;
		while(n.next != null) {n = n.next;}
		String h = n.head;
		n = null;
		return(h);			
	}
	
	String getRandom() {
		int r = (int) (Math.random()*Node.length(this.content));
		Node cur = this.content;
		for(int i = 0; i < r; i++) {
			cur = cur.next;
			}
		if (cur == null) return(null);
		return(cur.head);
	}
	void insert(String s) {
		Node.insert(s, this.content);
	}
	void insertionSort() {
		Node.insertionSort(content);
	}
	
	void mergeSort() {
		// j'ai la flemme
	}
	String[] toArray() {
		int len = Node.length(this.content);
		Node cur = this.content;
		String[] t = new String[len];
		for(int i = 0; i<len; i++) {
			t[i]= cur.head;
			cur = cur.next;
		}
		return(t);
		
	}
	public static void main(String[] a) {
		WordList chibre = new WordList("foo", new WordList("bar", new WordList("baz",new WordList("qux", new WordList("chibre", new WordList())))));
		System.out.print(chibre.getRandom());
	}
}
