package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void register(Player player){
        players.add(player);
    }

    public List<Player> findAll() {
        return players;
    }

    public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String name1, String name2) {
        int playerName1 = findByName(name1);
        int playerName2 = findByName(name2);

        if (playerName1 == -1 || playerName2 == -1) {
            throw new NotRegisteredException("One of the players is not registered");
        }
        int strength1 = players.get(playerName1).getStrength();
        int strength2 = players.get(playerName2).getStrength();

        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 < strength2) {
            return 2;
        }
        return 0;
    }

}

