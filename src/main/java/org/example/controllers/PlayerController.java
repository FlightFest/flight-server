package src.main.java.org.example.controllers;
import src.main.java.org.example.entities.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PlayerController {

    //Parameters
    private ArrayList<Player> players;

    //Constructors
    public PlayerController() {
        this.players = new ArrayList<>();
    }

    public PlayerController(ArrayList<Player> list) {
        this.players = list;
    }

    //Setters
    public void setPlayers(ArrayList<Player> list) {
        this.players = list;
    }

    //Getters
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int getNumPlayers() {
        return this.players.size();
    }

    //Returns the highest score
    public int getBestScore() {
        int bestScore = 0;
        for (Player p : this.players){
            if (p.getPoints() > bestScore) bestScore = p.getPoints();
        }
        return bestScore;
    }

    //Returns an array of players which score is exactly the best
    public ArrayList<Player> getTop1Players() {
        int bestScore = this.getBestScore();

        ArrayList<Player> result = new ArrayList<>();

        for (Player p : this.players) {
            if (p.getPoints() == bestScore) result.add(p);
        }

        return result;
    }

    //returns all the players ordered by their score
    public ArrayList<Player> getBestPlayers() {
        HashMap<Player, Integer> topPlayers = new HashMap<>();
        for (Player p : this.players) topPlayers.put(p, p.getPoints());

        ArrayList<Player> result = new ArrayList<>(topPlayers.keySet());
        Collections.sort(result);

        return result;
    }

    //Operations
    public void addPlayer(Player p) {
        this.players.add(p);
    }
    
    public void addPlayer(String n){this.players.add(new Player(n));}

    public void delPlayer(Player p) {
        this.players.remove(p);
    }

    public void delPlayer(String nom) {
        boolean done = false;

        for (int i = 0; i < this.players.size() && !done; ++i) {
            if (this.players.get(i).getName().equals(nom)) {
                this.players.remove(i);
                done = true;
            }
        }
    }
}
