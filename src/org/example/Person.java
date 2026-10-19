package org.example; // я немного поменял концепцию жизней у персонажа

import java.util.Random;
import java.util.Scanner;

public class Person {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    private int answer = random.nextInt(1, 8); // здесь выдаётся рандомное число и сохраняю в перменную answer.
    private String image = "*";
    private int lives = answer; // и значение переменной answer сверху передаю в переменную жизни и теперь у нашего персонажа рандомное количесвто жизней от 1 до 8
    private int x;
    private int y;

    public String getImage() {
        return image;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Person() {
        this.x = 0;
        this.y = 0;
    }

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean move(int choice, int sizeBoard) { // это движение(без именений)
        int x = this.x;
        int y = this.y;

        switch (choice) {
            case 0:
                x = this.x - 1;
                y = this.y - 1;
                break;
            case 1:
                x = this.x;
                y = this.y - 1;
                break;
            case 2:
                x = this.x + 1;
                y = this.y - 1;
                break;
            case 3:
                x = this.x - 1;
                y = this.y;
                break;
            case 4:
                x = this.x + 1;
                y = this.y;
                break;
            case 5:
                x = this.x - 1;
                y = this.y + 1;
                break;
            case 6:
                x = this.x;
                y = this.y + 1;
                break;
            case 7:
                x = this.x + 1;
                y = this.y + 1;
                break;
            default:
                System.out.println("Некорретный ход. Попробуйте снова");
        }
        if (x != -1 && x != sizeBoard && y != -1 && y != sizeBoard) {
            this.x = x;
            this.y = y;
            return true;
        }
        return false;
    }
}

