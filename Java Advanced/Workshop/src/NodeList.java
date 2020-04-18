public class NodeList{

    private int size;
    private Node head;

    public void add(Node node) {
        this.size++;
        if (this.head == null) {
            this.head = node;
            return;
        }

        Node currentNode = this.head;
        while (true) {
            if (currentNode.next == null) {
                currentNode.next = node;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public void overrideElementWithKey(String key, String value){
        if (this.head == null){
            return;
        }

        Node nodeToReplaceWith = new Node(key, value);
        if (key.equals(nodeToReplaceWith.getKey())){
            nodeToReplaceWith.next = this.head.next;
            this.head = nodeToReplaceWith;
            return;
        }

        Node currentNode = this.head;
        while (currentNode != null){
            if (currentNode.next != null){
                if (key.equals(currentNode.getKey())){
                    nodeToReplaceWith.next = currentNode.next.next;
                    currentNode.next = nodeToReplaceWith;
                    return;
                }
            }

            currentNode = currentNode.next;
        }
    }

    public Node getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }
}
