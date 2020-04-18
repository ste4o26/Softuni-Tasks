package p02_OpenClosedPrinciple.p01_FileStream;

public abstract class StreamableResource {
    private int length;
    private int sent;

    public StreamableResource(int length, int sent) {
        this.setLength(length);
        this.setSent(sent);
    }

    public final int getLength() {
        return this.length;
    }

    protected void setLength(int length) {
        this.length = length;
    }

    public final int getSent() {
        return this.sent;
    }

    protected void setSent(int sent) {
        this.sent = sent;
    }
}
