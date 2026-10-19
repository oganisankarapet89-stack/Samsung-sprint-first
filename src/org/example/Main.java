package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) { // я добавил цикл бесконечный и каждый раз он берёт переменную answer и смотрит если он равен 0, то игра заканчивается. Если равен 1, то продолжает игру
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("----------------------------------------------"); // сделал покрасивее интерфейс
            System.out.println("Введите 1, если хотите продолжить(начать) игру" + "\n" + "Введите 0, если хотите закончить игру.");
            System.out.println("----------------------------------------------");
            int answer = scanner.nextInt();
            if (answer != 1) { // вот и сама проверка этого цикла while (true)
                System.out.println("Вы вышли из игры");
                break;
            }
            int sizeBoard = 5;
            int step = 0;

            Person person = new Person(0, sizeBoard - 1);
            Castle castle = new Castle(random.nextInt(sizeBoard - 1), 0); // создаю замок
            Doctor doctor = new Doctor(2, random.nextInt(0, sizeBoard - 1)); // создаю нового персонажа доктора

            String[][] board = new String[sizeBoard][sizeBoard];

            Monster monster = new Monster();
            Monster bigMonster = new BigMonster();

            for (int y = 0; y < sizeBoard; y++) {
                for (int x = 0; x < sizeBoard; x++) {
                    board[y][x] = " ";
                }
            }
            for (int i = 0; i < sizeBoard * 2; i++) {
                if (random.nextBoolean()) {
                    board[random.nextInt(sizeBoard - 2)]
                            [random.nextInt(sizeBoard - 1)] = monster.getImage();
                } else {
                    board[random.nextInt(sizeBoard - 2)]
                            [random.nextInt(sizeBoard - 1)] = bigMonster.getImage();
                }
            }

            board[castle.getY()][castle.getX()] = castle.getImage(); //картинка замка
            board[person.getY()][person.getX()] = person.getImage();
            board[doctor.getY()][doctor.getX()] = doctor.getImage(); //картинка доктора

            do {
                drawBoard(board);
                System.out.println("Ваше количество жизней: " + person.getLives()); // Каждый раз при отрисовке игрового поля вывожу количество жизней, чтобы быть в курсе

                System.out.println("Введите направление хода:\n" +
                        "0 - влево вверх\n" +
                        "1 - вверх\n" +
                        "2 - вправо вверх\n" +
                        "3 - влево\n" +
                        "4 - вправо\n" +
                        "5 - влево вниз\n" +
                        "6 - вниз\n" +
                        "7 - вправо вниз\n");
                int choice = scanner.nextInt();
                int x = person.getX();
                int y = person.getY();
                if (person.move(choice, sizeBoard)) {
                    if (board[person.getY()][person.getX()].equals("#")) {
                        int t = monster.taskGenerator(person);
                        person.setLives(t);
                    } else if (board[person.getY()][person.getX()].equals("!")) {
                        int t = bigMonster.taskGenerator(person);
                        person.setLives(t);
                    } else if (board[person.getY()][person.getX()].equals("^")) {
                        System.out.println("Поздравляю! Вы выиграли.");
                        break;
                    } else if (board[person.getY()][person.getX()].equals(":)")) {
                        person.setLives(person.getLives() + 1); // здесь доктор хилит нашего персонажа
                        System.out.println("Ваше количество жизней увеличилось на 1, и стало: " + person.getLives()); // добавил главную возможность доктора, когда встречаешься с ним он тебя лечит
                    }
                    board[y][x] = " ";
                    board[person.getY()][person.getX()] = "*";
                    step++;
                } else {
                    System.out.println("Некорретный ход. Вы вышли за пределы поля.");
                    person.setLives(person.getLives() - 1);
                }
            } while (person.getLives() > 0);
            System.out.println("-------------"); //Улучшил интерфейс, сделал покрасивее)
            System.out.println("Вы проиграли(");
            System.out.println("Ваш счет: " + step);
            System.out.println("-------------");
        }
    }

    static void drawBoard(String[][] board) { // тут без изменений
        String block = "| ";
        String wall = "+ — + — + — + — + — +";

        for (String[] row : board) {
            System.out.println(wall);

            for (String cell : row) {
                System.out.print(block + cell + " ");
            }

            System.out.println(block);
        }
        System.out.println(wall);
    }
}

