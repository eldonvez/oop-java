package inf371td2;

public class Node {
	String head;
	Node next;

	Node(String head, Node next) {
		this.head = head;
		this.next = next;
	}
	static int lengthRec(Node l) {
		if(l==null) return(0);
		else return(lengthRec(l.next)+1);
	}
	
	static int length(Node l) {
		int r = 0;
		for(Node cur = l; cur != null; cur = cur.next) {
			r++;
		}
		return(r);
	}
	
	static String printNodes(Node l) {
		String r = "[";
		for(Node cur = l; cur != null; cur = cur.next) {
			r+= cur.head;
			if (cur.next != null) r+=", ";
		}
		r+="]";
		return(r);
		
	}
	static void addLast(String s, Node l) {
		//Pour cette fonction, nous supposerons que l ne vaut pas null.
		Node cur = l;
		while(cur.next != null) {cur = cur.next;}
		cur.next = new Node(s, null );
	}
	static Node copy(Node the) {
		if(the == null) {return(null);}
		Node cpy = new Node(the.head, null);
		for(Node cur = the.next; cur != null; cur = cur.next) {
			addLast(cur.head, cpy);
			
		}
		return(cpy);
	}
	static Node insert(String s, Node l) {
		//suppose que la chaîne l est triée pour fabriquer la chaîne triée dans laquelle on aura inséré s (on a le droit de modifier la chaîne l).
		if(l == null) return(new Node(s,null));
		Node cur = l;
		while(cur.head.compareTo(s)<0) {
			if(cur.next == null) {cur.next = new Node(s,null); return(l);}
			else cur = cur.next;
		}
		Node temp = copy(cur);
		cur.next = temp;
		cur.head = s;
		
		return(l);
		
	}
	static Node insertionSort(Node l) {
		if( l == null) return(null);
		Node sort = new Node(l.head, null);
		for(Node cur = l.next; cur != null; cur = cur.next) {
			insert(cur.head, sort);
		}
		return(sort);
	}
	static Node merge(Node l1, Node l2) {
		//fusionne deux listes triéés
		Node current = l1;
		while(current != null) {l2= insert(current.head, l2); current = current.next;}
		return(l2);
	}
	public static void main(String[] a) {
		Node foobar = new Node("foo", new Node("bar", new Node("baz", null)));
		addLast("qux", foobar);
		Node sort = insertionSort(foobar);
		sort = insert("derp", sort);
		String d = printNodes(sort);

		System.out.print(d);
	}
}

