package org.example;

import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "#";

    public Monster () {
        return;
    }

    public String getImage() {
        return image;
    }

    public int taskGenerator(Person person) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int a = random.nextInt(400);
        int b = random.nextInt(400);
        int trueAnswer = a + b;

        System.out.print("Ты повстречал монстра! Реши пример, чтобы выжить: \n" +
                a + " + " + b + ": ");
        do {
            int answer = scanner.nextInt();
            if (answer == trueAnswer) {
                System.out.println("Ты победил! Двигайся дальше.");
                return person.getLives();
            } else {
                person.setLives(person.getLives() - 1);
                System.out.println("Неверно! Попробуй снова.");
            }
        } while (person.getLives() > 0);
        System.out.println("О нет! Вы проиграли.");
        return 0;
    }
}
