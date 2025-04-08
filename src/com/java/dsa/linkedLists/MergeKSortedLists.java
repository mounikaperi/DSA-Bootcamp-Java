import java.util.PriorityQueue;
public class MergeKSortedLists {
    public static class Pair {
        int data;
        LinkedListNode<Integer> Node;
        Pair(int data, LinkedListNode<Integer> Node) {
            this.data = data;
            this.Node = Node;
        }
    }
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] != null) {
                pq.add(new Pair(listArray[i].data, listArray[i]));
            }
        }
        LinkedListNode<Integer> dummyNode = new LinkedListNode<>(-1);
        LinkedListNode<Integer> temp = dummyNode;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            LinkedListNode<Integer> node = pair.Node;
            if (node.next != null) {
                pq.add(new Pair(node.next.data, node.next));
            }
            temp.next = node;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}
