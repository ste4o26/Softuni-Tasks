package guild;

public class Player {
    private static final String INITIAL_RANK = "Trial";
    private static final String INITIAL_DESCRIPTION = "n/a";

    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = INITIAL_RANK;
        this.description = INITIAL_DESCRIPTION;
    }

    public String getName() {
        return this.name;
    }

    public String getClazz() {
        return this.clazz;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Player %s: %s", this.getName(), this.getClazz()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Rank: %s", getRank()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Description: %s", getDescription()));

        return sb.toString();
    }
}
