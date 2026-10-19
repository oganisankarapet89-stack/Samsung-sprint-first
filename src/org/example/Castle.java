package org.example;

public class Castle {
    private int x;
    private int y;
    private String image = "^";

    public Castle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImage() {
        return image;
    }
}