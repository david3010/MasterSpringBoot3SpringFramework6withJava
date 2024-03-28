package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("go up");
    }

    @Override
    public void down() {
        System.out.println("go down");
    }

    @Override
    public void left() {
        System.out.println("go left");
    }

    @Override
    public void right() {
        System.out.println("go right");
    }
}
