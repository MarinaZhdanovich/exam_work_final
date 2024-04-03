import Model.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            AnimalRegistry registry = new AnimalRegistry();

            while (true) {
                printMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    addAnimal(scanner, registry);
                } else if (choice == 2) {
                    registry.displayAnimals();
                } else if (choice == 3) {
                    listCommands(scanner, registry);
                } else if (choice == 4) {
                    teachAnimal(scanner, registry);
                } else if (choice == 5) {
                    return;
                } else {
                    System.out.println("Вы ввели неправильную команду. Попробуйте еще раз");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Показать всех животных");
        System.out.println("3. Увидеть список команд, которое выполняет животное");
        System.out.println("4. Обучить животное новым командам");
        System.out.println("5. Выйти из программы");
        System.out.print("Выберите команду: ");
    }

    private static void addAnimal(Scanner scanner, AnimalRegistry registry) {
        System.out.print("Введите тип животного (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
        String type = scanner.nextLine().toLowerCase();

        if (!type.equals("dog") && !type.equals("cat") && !type.equals("hamster") &&
                !type.equals("horse") && !type.equals("camel") && !type.equals("donkey")) {
            System.out.println("Вы ввели неправильный тип животного.");
            return;
        }
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного (гггг-мм-дд): ");
        String birthDateString = scanner.nextLine();
        Date birthDate = null;
        try {
            birthDate = java.sql.Date.valueOf(birthDateString);
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильный ввод даты рождения.");
            return;
        }
        System.out.print("Введите команды, которые выполняет животное: ");
        String commands = scanner.nextLine();

        if (type.equals("dog")) {
            registry.addAnimal(new Dog(registry.getCounterValue() + 1, "Pets", type, name, birthDate, commands));
        } else if (type.equals("cat")) {
            registry.addAnimal(new Cat(registry.getCounterValue() + 1, "Pets", type, name, birthDate, commands));
        } else if (type.equals("hamster")) {
            registry.addAnimal(new Hamster(registry.getCounterValue() + 1, "Pets", type, name, birthDate, commands));
        } else if (type.equals("horse")) {
            registry.addAnimal(new Horse(registry.getCounterValue() + 1, "Pack animals", type, name, birthDate, commands));
        } else if (type.equals("camel")) {
            registry.addAnimal(new Camel(registry.getCounterValue() + 1, "Pack animals", type, name, birthDate, commands));
        } else if (type.equals("donkey")) {
            registry.addAnimal(new Donkey(registry.getCounterValue() + 1, "Pack animals", type, name, birthDate, commands));
        }
    }



    private static void listCommands(Scanner scanner, AnimalRegistry registry) {
        System.out.print("Введите id животного для получения его команд: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index > 0 && index <= registry.getAnimals().size()) {
            Animals animal = registry.getAnimals().get(index - 1);
            if (animal instanceof Pets) {
                Pets pet = (Pets) animal;
                if (pet instanceof Dog) {
                    Dog dog = (Dog) pet;
                    System.out.println( dog.getType() + ": " + dog.getName() + ", команды: " + dog.getCommands());
                } else if (pet instanceof Cat) {
                    Cat cat = (Cat) pet;
                    System.out.println(cat.getType() + ": " + cat.getName() + ", команды: " + cat.getCommands());
                } else if (pet instanceof Hamster) {
                    Hamster hamster = (Hamster) pet;
                    System.out.println(hamster.getType() + ": " + hamster.getName() + ", команды: " + hamster.getCommands());
                }
            } else if (animal instanceof PackAnimals) {
                PackAnimals packAnimal = (PackAnimals) animal;
                if (packAnimal instanceof Horse) {
                    Horse horse = (Horse) packAnimal;
                    System.out.println(horse.getType() + ": " + horse.getName() + ", команды: " + horse.getCommands());
                } else if (packAnimal instanceof Camel) {
                    Camel camel = (Camel) packAnimal;
                    System.out.println(camel.getType() + ": " + camel.getName() + ", команды: " + camel.getCommands());
                } else if (packAnimal instanceof Donkey) {
                    Donkey donkey = (Donkey) packAnimal;
                    System.out.println(donkey.getType() + ": " + donkey.getName() + ", команды: " + donkey.getCommands());
                }
            } else {
                System.out.println("Неизвестный тип животного.");
            }
        }
    }

    private static void teachAnimal(Scanner scanner, AnimalRegistry registry) {
        System.out.print("Введите id животного, которого нужно обучить новым командам: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index > 0 && index <= registry.getAnimals().size()) {
            Animals animal = registry.getAnimals().get(index - 1);
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.print("Введите новые команды: ");
                String newCommands = scanner.nextLine();
                String existingCommands = dog.getCommands();
                dog.setCommands(existingCommands + ", " + newCommands);
                System.out.println("Собака с id " + index + " обучена новым командам: " + newCommands);
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.print("Введите новые команды: ");
                String newCommands = scanner.nextLine();
                String existingCommands = cat.getCommands();
                cat.setCommands(existingCommands + ", " + newCommands);
                System.out.println("Кошка с id " + index + " обучена новым командам: " + newCommands);
            } else if (animal instanceof Hamster) {
                Hamster hamster = (Hamster) animal;
                System.out.print("Введите новые команды: ");
                String newCommands = scanner.nextLine();
                String existingCommands = hamster.getCommands();
                hamster.setCommands(existingCommands + ", " + newCommands);
                System.out.println("Хомяк с id " + index + " обучен новым командам: " + newCommands);
            } else if (animal instanceof Horse) {
                Horse horse = (Horse) animal;
                System.out.print("Введите новые команды: ");
                String newCommands = scanner.nextLine();
                String existingCommands = horse.getCommands();
                horse.setCommands(existingCommands + ", " + newCommands);
                System.out.println("Лошадь с id " + index + " обучена новым командам: " + newCommands);
            } else if (animal instanceof Camel) {
                Camel camel = (Camel) animal;
                System.out.print("Введите новые команды: ");
                String newCommands = scanner.nextLine();
                String existingCommands = camel.getCommands();
                camel.setCommands(existingCommands + ", " + newCommands);
                System.out.println("Верблюд с id " + index + " обучен новым командам: " + newCommands);
            } else if (animal instanceof Donkey) {
                Donkey donkey = (Donkey) animal;
                System.out.print("Введите новые команды: ");
                String newCommands = scanner.nextLine();
                String existingCommands = donkey.getCommands();
                donkey.setCommands(existingCommands + ", " + newCommands);
                System.out.println("Осел с id " + index + " обучен новым командам: " + newCommands);
            }
        } else {
            System.out.println("Животное с номером " + index + " не найдено.");
        }
    }
}

