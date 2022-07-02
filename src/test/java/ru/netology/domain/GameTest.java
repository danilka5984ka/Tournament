package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();
    Player player1 = new Player(1, "Bob", 30);
    Player player2 = new Player(2, "Tom", 35);
    Player player3 = new Player(3, "Steve", 40);
    Player player4 = new Player(4, "Tim", 35);

    @Test
    public void shouldRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Player[] actual = game.findAll().toArray(new Player[0]);
        Player[] expected = {player1, player2, player3, player4};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredExceptionOne(){
        game.register(player1);
        game.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Steve", "Tim");
        });
    }

    @Test
    public void shouldNotRegisteredExceptionTwo(){
        game.register(player3);
        game.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Bob", "Tom");
        });
    }

    @Test
    public void shouldNotRegisteredExceptionThree(){
        game.register(player3);
        game.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Steve", "Tom");
        });
    }

    @Test
    public void shouldRoundOne() {
        game.register(player1);
        game.register(player2);

        int actual = game.round("Bob", "Tom");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundTwo() {
        game.register(player3);
        game.register(player4);

        int actual = game.round("Steve", "Tim");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundThree() {
        game.register(player2);
        game.register(player4);

        int actual = game.round("Tom", "Tim");
        int expected = 0;
        assertEquals(expected, actual);
    }
}