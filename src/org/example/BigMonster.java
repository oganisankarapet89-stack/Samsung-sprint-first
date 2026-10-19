package org.example; // без изменений

import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {

    private String image = "!";

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public int taskGenerator(Person person) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int a = random.nextInt(100);
        int b = random.nextInt(100);
        int c = random.nextInt(100);
        int trueAnswer = a * b - c;

        System.out.print("Ты повстречал страшного монстра! Реши пример, чтобы выжить: \n" +
                a + " * " + b + " - " + c + ": ");
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

