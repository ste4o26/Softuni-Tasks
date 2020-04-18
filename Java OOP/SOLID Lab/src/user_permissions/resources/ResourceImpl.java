package user_permissions.resources;

public abstract class ResourceImpl implements Resource{
    private int size;

    public ResourceImpl(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return String.format(" with size of %d MB.", this.getSize());
    }
}
