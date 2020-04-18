package hero;

public class Hero {
    private String username;
    private int level;

    public Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        String heroType = this.getClass()
                .getName();

        return String.format("Type: %s Username: %s Level: %s",
                heroType,
                this.getUsername(),
                this.getLevel());
    }
}
