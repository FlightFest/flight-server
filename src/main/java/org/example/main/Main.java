package src.main.java.org.example.main;

import src.main.java.org.example.controllers.PlayerController;
import src.main.java.org.example.entities.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PlayerController contP = new PlayerController();

        Player p1 = new Player("Juan", 3.f, 6.f);
        Player p2 = new Player("Ana", -3.5f, 16.f);
        Player p3 = new Player("Man", 20.f, -4.f);

        p1.addPoints(100);
        p2.addPoints(50);
        p3.addPoints(30);

        contP.addPlayer(p1);
        contP.addPlayer(p3);
        contP.addPlayer(p2);

        System.out.println(contP.getNumPlayers());

        for (Player p : contP.getBestPlayers()) {
            System.out.println(p.getName());
        }

        contP.delPlayer(p2);

        System.out.println(contP.getNumPlayers());

        for (Player p : contP.getBestPlayers()) {
            System.out.println(p.getName());
        }
    }
}