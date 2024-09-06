class ReverseDoubleLinkedList {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if (head == null || head.next == null) return head;
        DLLNode prev = null;
        DLLNode current = head;
        while (current!=null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        return prev.prev;
    }
    class DLLNode {
      int data;
      DLLNode next;
      DLLNode prev;
  
      DLLNode(int val) {
          data = val;
          next = null;
          prev = null;
      }
   }
}
