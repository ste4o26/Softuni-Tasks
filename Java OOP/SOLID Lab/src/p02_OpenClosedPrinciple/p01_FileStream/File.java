package p02_OpenClosedPrinciple.p01_FileStream;

public class File extends StreamableResource {
    private String name;

    public File(String name, int length, int sent) {
        super(length, sent);
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
