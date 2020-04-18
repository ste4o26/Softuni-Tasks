package team;

import person_encapsulation.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String teamName;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String teamName) {
        this.setName(teamName);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    private void setName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void addPlayer(Person member) {
        if (member.getAge() < 40) {
            this.firstTeam.add(member);
        } else {
            this.reserveTeam.add(member);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }
}
