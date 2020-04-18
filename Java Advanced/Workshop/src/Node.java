public class Node {
    private final String key;
    private String value;
    Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }


    @Override
    public String toString() {
        return String.format("k: %s\tv: %s", this.key, this.value);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
