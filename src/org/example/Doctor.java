package org.example;  // я тут просто создал нового персонажа в целом. Его главная цель хилить нашего главного персонажа когда он его встречает, это прописано в main(в строке 77)

public class Doctor {
    private String image = "✓";
    private int x;
    private int y;

    public Doctor(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getImage() {
        return image;
    }

}
