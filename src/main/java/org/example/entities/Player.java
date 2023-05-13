package org.example.entities;

public class Player implements Comparable<Player> {

    //Player name
    private String name;

    //Points
    private int points;

    //Player Coordinates
    private float x;
    private float y;


    //Empty constructor
    public Player() {
        this.name = "";

        this.points = 0;

        this.x = 0;
        this.y = 0;
    }

    //Constructor with parameters
    public Player(String name) {
        this.name = name;

        this.points = 0;

        this.x = 0;
        this.y = 0;
    }

    public Player(String name, float x, float y){
        this.name = name;

        this.points = 0;

        this.x = x;
        this.y = y;
    }

    //Getters
    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public String getName(){
        return this.name;
    }

    public int getPoints(){
        return this.points;
    }

    //Operations
    public void setName(String name){
        this.name = name;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void moveTo(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void resetPoints() {
        this.points = 0;
    }

    @Override
    public int compareTo(Player otherPlayer) {
        return Integer.compare(otherPlayer.getPoints(), this.getPoints());
    }
}
