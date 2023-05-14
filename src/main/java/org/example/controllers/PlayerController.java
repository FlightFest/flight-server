package org.example.controllers;
import org.example.entities.Player;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PlayerController {

    //Parameters
    private ArrayList<Player> players;
    private ArrayList<Player> activePlayers;
    private ArrayList<Player> playingPlayers;

    //Constructors
    public PlayerController() {
        this.players = new ArrayList<>();
        this.activePlayers = new ArrayList<>();
        this.playingPlayers = new ArrayList<>();
    }

    public PlayerController(ArrayList<Player> list, ArrayList<Player> active) {
        this.players = list;
        this.activePlayers = active;
        this.playingPlayers = new ArrayList<>();
    }

    //Setters
    public void setPlayers(ArrayList<Player> list) {
        this.players = list;
    }

    public void setActivePlayers(ArrayList<Player> active) {
        this.activePlayers = active;
    }

    public void setPlayingPlayers(ArrayList<Player> playing) {this.playingPlayers = playing;}

    //Getters
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int getNumPlayers() {
        return this.players.size();
    }

    public ArrayList<Player> getActivePlayers(){
        return this.activePlayers;
    }

    public ArrayList<String> getActivePlayersString(){
        ArrayList<String> result = new ArrayList<>();

        for (Player p : this.activePlayers) {
            result.add(p.getName());
        }
        return result;
    }

    public ArrayList<Player> getPlayingPlayers(){
        return this.playingPlayers;
    }

    public ArrayList<String> getPlayingPlayersString(){
        ArrayList<String> result = new ArrayList<>();

        for (Player p : this.playingPlayers) {
            result.add(p.getName());
        }
        return result;
    }

    public int getActivePlayersnumber(){
        return this.activePlayers.size();
    }

    public int getPlayingPlayersnumber(){
        return this.playingPlayers.size();
    }

    //Returns the highest score
    public int getBestScore() {
        int bestScore = 0;
        for (Player p : this.playingPlayers){
            if (p.getPoints() > bestScore) bestScore = p.getPoints();
        }
        return bestScore;
    }

    //Returns an array of players which score is exactly the best
    public ArrayList<Player> getTop1Players() {
        int bestScore = this.getBestScore();

        ArrayList<Player> result = new ArrayList<>();

        for (Player p : this.playingPlayers) {
            if (p.getPoints() == bestScore) result.add(p);
        }

        return result;
    }

    //returns all the players ordered by their score
    public ArrayList<String> getBestPlayers() {
        HashMap<Player, Integer> topPlayers = new HashMap<>();
        for (Player p : this.playingPlayers) topPlayers.put(p, p.getPoints());

        ArrayList<Player> result = new ArrayList<>(topPlayers.keySet());
        Collections.sort(result);

        ArrayList<String> res2 = new ArrayList<>();

        for (Player p : result) res2.add(p.getName());

        return res2;
    }

    //Operations
    public void addPlayer(Player p) {
        this.players.add(p);
    }
    
    public void addPlayer(String n){
        Player p = new Player(n);
        this.players.add(p);
        this.activePlayers.add(p);
    }

    public void addPlayingPlayer(String n) {
        Player p = new Player(n);
        this.playingPlayers.add(p);
    }

    public void resetPlayer(Player p) {
        this.players.remove(p);
    }

    public void delActivePlayer(String nom) {
        boolean done = false;

        for (int i = 0; i < this.activePlayers.size() && !done; ++i) {
            if (this.activePlayers.get(i).getName().equals(nom)) {
                this.activePlayers.remove(i);
                done = true;
            }
        }
    }

    public void delPlayingPlayer(String nom) {
        boolean done = false;

        for (int i = 0; i < this.playingPlayers.size() && !done; ++i) {
            if (this.playingPlayers.get(i).getName().equals(nom)) {
                this.playingPlayers.remove(i);
                done = true;
            }
        }
    }
}
