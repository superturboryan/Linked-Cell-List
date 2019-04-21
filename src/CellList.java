import java.util.NoSuchElementException;

public class CellList {

	public class CellNode {
		
		private CellPhone c;
		private CellNode next;
		
		public CellNode() {
			this.c = null;
			this.next = null;
		}
		
		public CellNode (CellPhone cp, CellNode node) {
			this.c = cp;
			this.next = node;
		}
		
		public CellNode (CellNode cn) {
			this.c = cn.c;
			this.next = cn.next;
		}

		public CellPhone getC() {
			return c;
		}

		public void setC(CellPhone c) {
			this.c = c;
		}

		public CellNode getNext() {
			return next;
		}

		public void setNext(CellNode next) {
			this.next = next;
		}
		
		public CellNode clone() {
			return new CellNode(this.c, this.next);
		}
	}
	
	private CellNode head;
	private int size;
	
	public CellList() {
		head = null;
		size = 0;
	}
	public CellList (CellList cl) {
		this.head = cl.getHead();
		this.size = cl.getSize();
	}
	public CellNode getHead() {
		return head;
	}
	public void setHead(CellNode head) {
		this.head = head;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public void addToStart(CellPhone cp) {
		
		CellNode cn = new CellNode(cp, head);
		head = cn;
		cn = null;
		size++;
	}
	
	public void insertAtIndex (CellPhone cp, int index) {
		System.out.println("Attempting to insert the given node at index "+index);
		
		if (index > size - 1 || index < 0) {
			System.out.println("ERROR: The index provided is invalid! Program terminating");
			throw new NoSuchElementException();
		}
		
		int i = 0;
		CellNode temp = head;
		
		if (index == 0) {
			CellNode cn = new CellNode(cp, head);
			head = cn;
			cn = null;
		}
		else {
			while (i != index - 1) {
				temp = temp.next;
				i++;
			}
			CellNode cn = new CellNode(cp, temp.next);
			temp.next = cn;
			cn = null;			
		}
		size++;
		System.out.println("Successful!\n");
	}
	
	public void deleteFromIndex(int index) {
		
		System.out.println("Attempting to delete the node at index "+index);
		
		if (index > size-1) {
			System.out.println("ERROR: The index provided is invalid! Program terminating...");
			throw new NoSuchElementException();
		}
		
		int i = 0;
		CellNode temp = head;
		
		//If list only has one node, we can only delete that node...
		if (size == 1) {
			System.out.println("This list only has one node to be deleted...");
			head = null;
			size--;
			return;			
		}
		
		if (index == 0) {
			head = head.next;
		}
		else if (index == size-1) {
			
		}
		else {
			
			while (i != index-1) {
				temp = temp.next;
				i++;
			}
			temp.next = temp.next.next;
		}
		size--;
		System.out.println("Successful!\n");
	}
	
	public void deleteFromStart() {
		
		System.out.println("Attempting to delete from the start of the list...");
		
		if (head == null) {
			System.out.println("The list is already empty! Program terminating...");
			throw new NullPointerException();
		}
		
		head = head.next;
		size--;
		System.out.println("Successful!\n");
	}
	
	public void replaceAtIndex(CellPhone cp, int index) {
		System.out.println("Attempting to replace the node at index "+index+" with the CellPhone provided...");
		
		if (index > size-1 || index < 0) {
			System.out.println("ERROR: The index provided is invalid! Program terminating");
			throw new NoSuchElementException();
		}
		
		int i = 0;
		CellNode temp = head;
		
		if (index == 0) {
			CellNode cn  = new CellNode(cp, head);
			head = cn;
			cn = null;
		}
		else {
			//Point at the node we want to replace
			while (i != index) {
				temp = temp.next;
				i++;
			}
			CellNode cn = new CellNode(cp, temp);
			temp = cn;
			cn = null;
		}
		System.out.println("Successful!\n");
	}
	
	public CellNode find(long serial) {
		
		CellNode temp = head;
		
		int it = 1;
		
		while (temp != null) {
			
			if (temp.c.getSerialNum() == serial) {
				System.out.println("Iterations performed: "+it);
				return temp;
			}
			temp = temp.next;
			it++;
		}
		System.out.println("Iterations performed: " + it + " - CellPhone not found in list");
		return null;
	}
	
	public boolean contains (long serial) {
		
		CellNode temp = head;
		
		while (temp != null) {
			if (temp.c.getSerialNum() == serial) {
				return true;
			}
			temp = temp.next;
		}
		
		return false;
	}
	
	public void showContents() {
		
		System.out.println("The current size of the list is "+size+". Here are the contents of the list: ");
		System.out.println("============================================================================");
		
		CellNode temp = head;
		
		int i = 0;
		
		while (temp != null) {
			System.out.print("["+temp.getC()+"] --> ");
			temp = temp.next;
			i++;
			if (i%2 == 0) {
				System.out.println("");
			}
		}
		
		System.out.println("--> X\n============================================================================");
	}
	
	public boolean equals(CellList cl) {
		
		CellNode temp = head;
		CellNode temp2 = cl.head;
		
		if (this.size != cl.size)
			return false;
		
		while (temp != null) {
			
			if (!temp.c.equals(temp2.c)) {
				return false;
			}
			
			temp = temp.next;
			temp2 = temp2.next;
		}
		return true;
	}
	
	
	
	
	
	
}
