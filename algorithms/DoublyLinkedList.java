import java.util.*;

public class DoublyLinkedList {

	Link head;
	Link tail;

	private class Link {
		Link (String str) {
			this.str = str;
		}
	    Link next;
	    Link previous;
		String str;
	}

	public void insert(String str) {
		Link link = new Link(str);
		if(null != this.head) {
			this.tail.next = link;
			link.previous = this.tail;
			this.tail = link;
		} else {
			this.head = link;
			this.tail = link;
		}	
	}

	public void print() {
		Link l = this.head;
		while (null != l) {
			System.out.print(l.str + " ");
			l = l.next;
		}
	}

	public void delete (String str) {
		Link l = this.head;
		while(null != l) {
			if(l.str.equals(str)) {
				if(null != l.previous) {
					if(null != l.next) {
						l.previous.next = l.next;
						l.next.previous = l.previous;
					} else {
						l.previous.next = null;
						this.tail = l.previous;
					}
				} else {
					l.next.previous = null;
					this.head = l.next;
				}
				l = null;
				break;
			}
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
		DoublyLinkedList doublyLinkedLst = new DoublyLinkedList();

		//Insert elements to the list
		System.out.println("Enter the number of Strings to be inserted in the list: ");
		int n = scan.nextInt();
		System.out.println("Enter the Strings to be inserted: ");
		scan.nextLine();
		for(int i = 0; i < n; i++) {
			doublyLinkedLst.insert(scan.nextLine());
		}
		System.out.println("The elements in the linked list are : ");
		doublyLinkedLst.print();

		//Find element in the list
		System.out.println("\nEnter the element to find: ");
		String output = doublyLinkedLst.find(scan.nextLine());
		System.out.println("Element found in the list: " + output);

		//Delete elements from the list
		deleteElements(n, doublyLinkedLst);
		System.out.println("The list after deletion: ");
		doublyLinkedLst.print();
	}

	public static void deleteElements(int n, DoublyLinkedList doublyLinkedLst) {
		System.out.println("Enter the number of elements to be deleted from the list: ");
		int d = scan.nextInt();
		if(d > n) {
			System.out.println("Enter a number less than the size of the list: ");
			deleteElements(n, doublyLinkedLst);
		} else {
			System.out.println("Enter the elements to be deleted:");
			scan.nextLine();
			for(int i = 0; i < d; i++) {
				doublyLinkedLst.delete(scan.nextLine());
			}
		}
			
	}
}