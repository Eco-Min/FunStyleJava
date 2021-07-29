package com.asm;

public class Stud {
    String name;
    int id;
    int score;

    Stud(String name, int id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    String getName() {
        return this.name;
    }

    int getId() {
        return this.id;
    }

    int getScore() {
        return this.score;
    }

    public String toString() {
        return String.format(
                "[Name:%3s,  ID:%2d,  Score:%3d]",
                this.name, this.id, this.score);
    }
}
