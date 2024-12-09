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
