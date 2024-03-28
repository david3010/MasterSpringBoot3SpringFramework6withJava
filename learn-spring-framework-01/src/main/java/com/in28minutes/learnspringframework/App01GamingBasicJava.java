package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var pacmanGame = new PacmanGame();
        var superContra = new SuperContraGame();
        var gameRunner = new GameRunner(marioGame);
        System.out.println("Running MarioGame");
        gameRunner.run();
        System.out.println("Running SuperContraGame");
        gameRunner = new GameRunner(superContra);
        gameRunner.run();
        System.out.println("Running PacmanGame");
        gameRunner = new GameRunner(pacmanGame);
        gameRunner.run();
    }
}
