package niv;

import java.util.Scanner;

public class Main {
	public static Scanner reader = new Scanner(System.in);
	public static Node<Integer> a(int[] a){
		//q1
		Node<Integer> fr = new Node<Integer>(a[0]);
		Node<Integer> last = fr;
		for(int i=1;i<a.length;i++) {
			Node<Integer> x = new Node<Integer>(a[i]);
			last.setNext(x);
			last=x;
		}
		return fr;
	}
	public static Node<Integer> buildNode(int x, int y,int n) {
		//from class
		Node<Integer> a = new Node<Integer>((int)(Math.random()*(x+y-1)+x));
		Node<Integer> last = a;
		for(int i=0;i<n-1;i++) {
			Node<Integer> k = new Node<Integer>((int)(Math.random()*(x+y-1)+x));
			last.setNext(k);
			last = k;
		}
		return a;
	}
	public static int count(Node<Integer> h, int x) {
		//from class
		int count=0;
		while(h!=null) {
			if(x==h.getValue())
				count++;
			h = h.getNext();
		}
		return count;
	}
	public static void printList(Node<Integer> a) {
		//q2a
		while(a.getNext()!=null) {
			System.out.println(a.getValue());
			a = a.getNext();
		}
	}
	public static void printListRec(Node<Integer> a) {
		//q2b
		if(a==null)
			return;
		System.out.println(a.getValue());
		printListRec(a.getNext());
	}
	public static void printListRecRev(Node<Integer> a) {
		//q2c
		if(a==null)
			return;
		printListRecRev(a.getNext());
		System.out.println(a.getValue());
		
	}
	public static Node<Integer> inputList(){
		//q3
		System.out.println("enter num or -1 to stop");
		Node<Integer> first = new Node<Integer>(null);
		Node<Integer> p = first;
		int num = reader.nextInt();
		Node<Integer> x;
		while(num!=-1) {
			x = new Node<Integer>(num);
			p.setNext(x);
			p=x;
			System.out.println("enter num or -1 to stop");
			num = reader.nextInt();
		}
		return first.getNext();
	}
	public static void printZogi(Node<Integer> a) {
		//q4
		while(a!=null) {
			if(a.getValue()%2==0)
				System.out.println(a.getValue());
			a=a.getNext();
		}
	}
	public static boolean check(Node<Integer> h, int x) {
		//q5a
		while(h!=null) {
			if(x==h.getValue())
				return true;
			h = h.getNext();
		}
		return false;
	}
	public static boolean checkRec(Node<Integer> h, int x) {
		//q5b
		if(h==null) {
			return false;
		}
		if(h.getValue()==x)
			return true;
		return checkRec(h.getNext(),x);
			
	}
	public static Node<Integer> buildNode(int x, int y,int n) {
		//from class
		Node<Integer> a = new Node<Integer>((int)(Math.random()*(x+y-1)+x));
		Node<Integer> last = a;
		for(int i=0;i<n-1;i++) {
			Node<Integer> k = new Node<Integer>((int)(Math.random()*(x+y-1)+x));
			last.setNext(k);
			last = k;
		}
		return a;
	}
	public static Node<Integer> earse(Node<Integer> a,int n){
		//q6
		if(a.getValue()==n)
			return a.getNext();
		Node<Integer> list = a;
		Node<Integer> save= list;
		while(a != null) {
			if(a.getValue()==n) {
				list.setNext(a.getNext());
				return save;
			}
			list = a;
			a=a.getNext();
		}
		return save;
	}
	public static Node<Integer> earseindex(Node<Integer> a, int i){
		if(i==1) {
			return a.getNext();
		}
		Node<Integer> prev = a;
		Node<Integer> save = a;
		for(int j=0;j<i-1;j++) {
			prev=a;
			a=a.getNext();
		}
		prev.setNext(a.getNext());
		return save;
		
	}
	public static boolean isAppear(Node<Integer> L1,Node<Integer> L2,Node<Integer> s) {
		//q8
		if(L1==null)
			return true;
		if(L2==null)
			return false;
		if(L1.getValue()==L2.getValue()) {
			return isAppear(L1.getNext(),s,s);
		}

		return isAppear(L1.getNext(),L2.getNext(),s);
		
	}
	public static void printappboth(Node<Integer> L1,Node<Integer> L2) {
		Node<Integer> saveL2 = L2;
		while(L1!=null) {
			
			L2=saveL2;
			while(L2!=null) {
				if(L1.getValue()==L2.getValue())
					System.out.println(L1.getValue());
				L2=L2.getNext();
			}
			L1=L1.getNext();
		}
	}
	public static Node<Integer> q10(Node<Integer> L1,Node<Integer> L2){
		Node<Integer> fir = new Node<Integer>(null);
		Node<Integer> d = fir;
		Node<Integer> saveL2 = L2;
		while(L1!=null) {
			
			L2=saveL2;
			while(L2!=null) {
				if(L1.getValue()==L2.getValue()) {
					Node<Integer> a = new Node<Integer>(L1.getValue());
					d.setNext(a);
					d=a;
				}
				L2=L2.getNext();
			}
			L1=L1.getNext();
		}
		return fir.getNext();
	}
	public static Node<Integer> q11(Node<Integer> L1, Node<Integer> L2){
		Node<Integer> saveL1 = L1;
		Node<Integer> saveL2 = L2;
		while(L1!=null) {
			
			L2=saveL2;
			while(L2!=null) {
				if(L1.getNext().getValue()==L2.getNext().getValue())
					L1.setNext(L1.getNext().getNext());
				L2=L2.getNext();
			}
			L1=L1.getNext();
		}
		return saveL1;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println(a(arr));
		Node<Integer> rachel = buildNode(1,10,20);
		System.out.println(rachel);
		System.out.println("count: "+count(rachel,3));
		System.out.println();
//		printList(rachel);
		System.out.println();
//		printListRecRev(rachel);
		printListRec(rachel);
//		Node<Integer> jj = inputList();
//		System.out.println(jj);
		System.out.println("zogi:");
		printZogi(rachel);
		System.out.println(checkRec(rachel,1));
	}

}
