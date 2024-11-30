class Main {
  public static Node<Integer> q1(int x, int y) {
		Node<Integer> a = new Node<Integer>((int)(Math.random()*(x+y)+x));
		Node<Integer> last = a;
		for(int i=0;i<19;i++) {
			Node<Integer> n = new Node<Integer>((int)(Math.random()*(x+y)+x));
			last.setNext(n);
			last = n;
		}
		return a;
	}
	public static int q2(Node<Integer> h, int x) {
		int count=0;
		while(h!=null) {
			if(x==h.getValue())
				count++;
			h = h.getNext();
		}
		return count;
	}
  public static void main(String[] args) {
    Node<Integer> a = q1(0,50);
		System.out.println(a);
		System.out.println(q2(a,40));
  }
}
