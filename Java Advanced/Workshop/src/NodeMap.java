import java.util.Map;

public class NodeMap {
    private static final int INITIAL_CAPACITY = 8;

    private NodeList[] buckets;

    public NodeMap() {
        buckets = new NodeList[INITIAL_CAPACITY];
    }

    public void put(String key, String value) {
        int bucketIndex = getBucketIndex(key);
        NodeList currentBucket = this.buckets[bucketIndex];
        if (currentBucket == null) {
            currentBucket = new NodeList();
        }

        Node existing = getFirstElementWithKey(key);
        if (existing == null) {
            Node node = new Node(key, value);
            currentBucket.add(node);
        } else {
            existing.setValue(value);
         //  currentBucket.overrideElementWithKey(key, value);
        }
    }

    public String get(String key) {
        int bucketIndex = getBucketIndex(key);
        NodeList currentBucket = this.buckets[bucketIndex];
        if (currentBucket == null) {
            return null;
        }

        Node result = getFirstElementWithKey(key);
        if (result == null) {
            return null;
        } else {
            return result.getValue();
        }
    }

    public boolean contains(String key) {
        int bucketIndex = getBucketIndex(key);
        NodeList currentBucket = this.buckets[bucketIndex];
        NodeList list = currentBucket;
        Node currentNode = list.getHead();
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }


    public Node getFirstElementWithKey(String key) {
        int bucketIndex = getBucketIndex(key);
        NodeList currentBucket = this.buckets[bucketIndex];

        Node currentNode = currentBucket.getHead();
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public int getBucketIndex(String key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public static int getInitialCapacity() {
        return INITIAL_CAPACITY;
    }
}
