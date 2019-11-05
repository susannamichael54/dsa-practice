import java.util.*;

public class LinkedList {

	Link head;
	Link tail;

	private class Link {
		Link (String str) {
			this.str = str;
		}
		Link next;
		String str;
	}

	public void insert (String str) {
		Link l = new Link(str);
		if(null != this.head) {
			this.tail.next = l;
			this.tail =l;
		} else {
			this.head = l;
			this.tail = l;
		}
	}

	public void delete (String str) {
		Link l = this.head;
		while (null != l) {
			if(str.equals(l.str)) {
				if(this.head == l) {
					this.head = l.next;
				} else {
					if(null == l.next) {
						this.tail = findPrevious(l);
					} else {
						findPrevious(l).next = l.next;
					}
				}
				l = null;
				break;
			}
			l = l.next;
		}
	}



	private Link findPrevious (Link l) {
		Link link = this.head;
		while (null != link) {
			if(link.next == l) {
				return link;
			}
			link = link.next;
		}
		return null;
	}

	public void print() {
		Link l = this.head;
		while (null != l) {
			System.out.print(l.str + " ");
			l = l.next;
		}
	}

	public String find(String str) {
		Link l = this.head;
		String output = null;
		while(null != l) {
			if(l.str.equals(str)) {
				output = l.str;
				break;
			}
			l = l.next;
		}
		return output;
	}

	private static Scanner scan = new Scanner(System.in);

	public static void main (String [] args) {
		LinkedList llst = new LinkedList();

		//Insert elements to the list
		System.out.println("Enter the number of strings to be inserted to the list: ");
		int n = scan.nextInt();
		System.out.println("Enter the strings to be inserted into the list:");
		scan.nextLine();
		for(int i = 0; i < n; i++) {
			llst.insert(scan.nextLine());
		}
		System.out.println("The elements in the linked list are: ");
		llst.print();

		//Find element in the list
		System.out.println("\nEnter the element to find: ");
		String output = llst.find(scan.nextLine());
		System.out.println("Element found in the list: " + output);

		//Delete elements from the list
		deleteElements(n, llst);
		System.out.println("The list after deletion: ");
		llst.print();
	}

	public static void deleteElements(int n, LinkedList llst) {
		System.out.println("Enter the number of elements to be deleted from the list: ");
		int d = scan.nextInt();
		if(d > n) {
			System.out.println("Enter a number less than the size of the list: ");
			deleteElements(n, llst);
		} else {
			System.out.println("Enter the elements to be deleted: ");
			scan.nextLine();
			for(int i = 0; i < d; i++) {
				llst.delete(scan.nextLine());
			}
		}
			
	}
}