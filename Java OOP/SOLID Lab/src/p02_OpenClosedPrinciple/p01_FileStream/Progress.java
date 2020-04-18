package p02_OpenClosedPrinciple.p01_FileStream;

public class Progress {

    public Progress() {
    }

    public int getCurrentPercent(StreamableResource resource) {
        return resource.getSent() * 100 / resource.getLength();
    }
}
