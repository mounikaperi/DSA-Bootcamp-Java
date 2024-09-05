public class CustomDoubleLinkedListImplementation {
	public static void main(String[] args) {
		CustomDoubleLinkedList list = new CustomDoubleLinkedList();
		list.insertFirst(5);
		list.insertFirst(4);
		list.insertFirst(3);
		list.insertFirst(2);
		list.insertFirst(1);
		list.displayReverse();
		list.display();
		list.insertLast(6);
		list.display();
		list.insertAtIndex(7, 2);
		list.display();
	}
}
class CustomDoubleLinkedList {
    Node head;
    int size;
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.prev = null;
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        size++;
    }
    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;
        node.next = null;
        if (head == null) {
            node.prev = null;
            head = node;
            size++;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        last = node;
        size++;
    }
    public void insertAtIndex(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }
        Node prevNode = getNode(index-1);
        Node newNode = new Node(value);
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
    public Node getNode(int index) {
        Node temp = head;
        for (int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void display() {
        Node node = head;
        System.out.print(null + "-><-");
        while(node != null) {
            System.out.print(node.value + "-><- ");
            node = node.next;
        }
        System.out.println("null");
    }
    public void displayReverse() {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        System.out.print(null + "-><-");
        while (last != null) {
            System.out.print(last.value + "-><- ");
            last = last.prev;
        }
        System.out.println("null");
    }
    private class Node {
        Node prev;
        Node next;
        int value;
        Node (int value) {
            this.value = value;
        }
    }
}
