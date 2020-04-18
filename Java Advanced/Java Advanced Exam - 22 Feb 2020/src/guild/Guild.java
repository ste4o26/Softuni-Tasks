package guild;


import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster; // -> playersRepository;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < this.getCapacity()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            String currentPlayerName = player.getName();
            if (currentPlayerName.equals(name)) {
                return this.roster.remove(player);
            }
        }

        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            String currentPlayerName = player.getName();

            if (currentPlayerName.equals(name)) {
                String currentPlayerRank = player.getRank();

                if (!currentPlayerRank.equals("Member")) {
                    player.setRank("Member");
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            String currentPlayerName = player.getName();

            if (currentPlayerName.equals(name)) {
                String currentPlayerRank = player.getRank();

                if (!currentPlayerRank.equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }


    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayers = new ArrayList<>();

        List<Player> players = new ArrayList<>(this.roster);
        for (Player player : players) {
            String currentPlayerClazz = player.getClazz();

            if (currentPlayerClazz.equals(clazz)) {
                removedPlayers.add(player);
                this.removePlayer(player.getName());
            }
        }

         Player[] array = new Player[removedPlayers.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = removedPlayers.get(i);
        }

        return array;
    }


    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append(String.format("Players in the guild: %s:", this.getName()));
        this.roster.forEach(sb::append);
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
