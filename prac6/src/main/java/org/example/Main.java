package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Log logger;

    public static void main(String[] args) {
        logger = new Log(Main.class.getSimpleName());
        Jail jail = new Jail(logger);

        while (true) {
            try {
                System.out.print("\nВыберите функции, которые хотите использовать:\n1.Выбрать обед\n2.Узнать название тюрьмы\n3.Сменить камеру\n4.Выйти из тюрьмы\n5.Выбрать количество людей в вашей камере\n6.Узнать информацию о себе\n7.Заварить чай\n8.Прилечь поспать\n9.Завершить программу\n ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        logger.logInfo("Выбрали функцию");
                        jail.ChoiseBreakFast();
                        break;
                    case 2:
                        logger.logInfo("Выбрали функцию");
                        jail.NameJail();
                        break;
                    case 3:
                        logger.logInfo("Выбрали функцию");
                        jail.SmenaCameri();
                        break;
                    case 4:
                        logger.logInfo("Выбрали функцию");
                        jail.ExitJailBreak();
                        break;
                    case 5:
                        logger.logInfo("Выбрали функцию");
                        jail.AmountInCamera();
                        break;
                    case 6:
                        logger.logInfo("Выбрали функцию");
                        jail.Info();
                        break;
                    case 7:
                        logger.logInfo("Выбрали функцию");
                        jail.DrinkTea();
                        break;
                    case 8:
                        logger.logInfo("Выбрали функцию");
                        jail.sleep();
                        break;
                    case 9:
                        logger.logInfo("Выбрали функцию");
                        logger.logInfo("Программа завершена");
                        jail.closeLog(); 
                        System.exit(0);
                        break;
                    default:
                        logger.logError("Сделан неверный выбор: " + choice);
                        System.out.println("Вы выбрали несуществующую функцию!");
                }
            } catch (Exception e) {
                logger.logError("Ошибка в Main: " + e);
            }
        }
    }
}

class Prisoner {
    private String name;
    private String country;
    private int age;
    private String crime;

    public Prisoner(String name, String country, int age, String crime) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.crime = crime;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public String getCrime() {
        return crime;
    }
}

class Jail {
    private Log logger;
    private Prisoner prisoner;

    public Jail(Log logger) {
        this.logger = logger;
        this.logger.logInfo("Инициализация Jail");
        this.prisoner = new Prisoner("Чарльз Бронсон", "Великобритания", 27, "ограбление почтового отделения \n");
    }


    public void ChoiseBreakFast() {
        try {
            System.out.print("Выберите обед:\n1. Гречка с сосисками\n2. Макароны по-флотски\n3. Куриный супчик\n");
            Scanner vibor = new Scanner(System.in);
            int viborka = vibor.nextInt();

            String obeda;
            switch (viborka) {
                case 1:
                    obeda = "Гречку с сосисками";
                    System.out.printf("Вы выбрали %s\n", obeda);
                    logger.logInfo("Обед выбран: " + obeda);
                    break;
                case 2:
                    obeda = "Макароны по-флотски";
                    System.out.printf("Вы выбрали %s\n", obeda);
                    logger.logInfo("Обед выбран: " + obeda);
                    break;
                case 3:
                    obeda = "Куриный супчик";
                    System.out.printf("Вы выбрали %s\n", obeda);
                    logger.logInfo("Обед выбран: " + obeda);
                    break;
                default:
                    logger.logError("Сделан неверный выбор: " + viborka);
                    System.out.print("Такого выбора нет!\n");
            }
        } catch (Exception e) {
            logger.logError("Ошибка в ChoiseBreakFast: " + e);
        }
    }


    public void NameJail() {
        try {
            System.out.print("Вы находитесь в тюрьме удовольствия --- Prison of pleasure\n ");
            logger.logInfo("Отобразилось название тюрьмы");
        } catch (Exception e) {
            logger.logError("Ошибка в NameJail: " + e);
        }
    }

    public void SmenaCameri() {
        try {
            System.out.print("Выберите камеру в которую хотите переместиться (от 1 до 100)\n");
            Scanner camera = new Scanner(System.in);
            int ViborCameri = camera.nextInt();
            if (ViborCameri > 0 && ViborCameri <= 100) {
                logger.logInfo("Успешно перешел в камеру номер: " + ViborCameri);
                System.out.print("Вы переместились в камеру под номером: " + ViborCameri);
            } else {
                logger.logError("Сделан неверный выбор: " + ViborCameri);
                System.out.print("Ты дурачок, камеры есть с 1 по 100");
            }
        } catch (Exception e) {
            logger.logError("Ошибка в SmenaCameri: " + e);
        }
    }

    public void ExitJailBreak() {
        try {
            System.out.print("Куда вы планируете выйти:\n1.На улицу \n2.В туалет\n3.Работать\n");
            Scanner ExitJail = new Scanner(System.in);
            int Exit = ExitJail.nextInt();

            switch (Exit) {
                case 1:
                    logger.logInfo("Успешно вышел на улицу");
                    System.out.print("Вы вышли на улицу\nВы видите баскетбольную площадку\nВаши действия:\n1.Пойти туда\n2.Дышать свежим воздухом\n");
                    Scanner vibor = new Scanner(System.in);
                    int bascet = vibor.nextInt();
                    if (bascet == 1) {
                        new Play(logger).Bascetball();
                    } else if (bascet == 2) {
                        new FreshAir(logger).Vozdux();
                    } else {
                        logger.logError("В ExitJailBreak сделан неверный выбор: " + bascet);
                        System.out.println("Некорректный выбор!");
                    }
                    break;
                case 2:
                    logger.logInfo("Вышел в туалет");
                    System.out.print("Вы вышли в туалет");
                    break;
                case 3:
                    logger.logInfo("Вышел для работы");
                    System.out.print("Вы пошли работать");
                    break;
                default:
                    logger.logError("В ExitJailBreak сделан неверный выбор: " + Exit);
                    System.out.print("Такого выбора нет!");
            }
        } catch (Exception e) {
            logger.logError("Ошибка в ExitJailBreak: " + e);
        }
    }

    public void AmountInCamera() {
        try {
            System.out.print("Выберите количество людей, сколько будет в вашей камере\n");
            Scanner AmountPeople = new Scanner(System.in);
            int AmountPeopleCamera = AmountPeople.nextInt();

            if (AmountPeopleCamera < 0) {
                logger.logError("Выбрано отрицательное количество людей: " + AmountPeopleCamera);
                System.out.print("Количество людей не может быть отрицательным!\n");
            } else {
                System.out.print("В вашей камере будут жить: " + AmountPeopleCamera + " человек\n");
                logger.logInfo("Выбрано количество человек в камере: " + AmountPeopleCamera);
            }
        } catch (Exception e) {
            logger.logError("Ошибка в AmountInCamera: " + e);
        }
    }


    public void Info() {
        try {
            System.out.print("Вас зовут: " + prisoner.getName() + "\nВы из: " + prisoner.getCountry() + "\nВам " + prisoner.getAge() + " лет\nВас посадили за: " + prisoner.getCrime());
            logger.logInfo("Отображаемая информация о заключенном");
        } catch (Exception e) {
            logger.logError("Ошибка в Info: " + e);
        }
    }

    public void DrinkTea() {
        try {
            System.out.print("У вас есть на выбор чай, который вы хотите заварить:\n1.Greenfield\n2.Пуэр\n3.Зеленый чай Матча\n4.Молочный улун\n5.Цейлонский чай\n6.Earl Grey\n");
            Scanner TeaVibor = new Scanner(System.in);
            int Tea = TeaVibor.nextInt();
            switch (Tea) {
                case 1:
                    System.out.print("Вы заварили Greenfield");
                    break;
                case 2:
                    System.out.print("Вы заварили Пуэр");
                    break;
                case 3:
                    System.out.print("Вы заварили Зеленый чай Матча");
                    break;
                case 4:
                    System.out.print("Вы заварили Молочный улун");
                    break;
                case 5:
                    System.out.print("Вы заварили Цейлонский чай");
                    break;
                case 6:
                    System.out.print("Вы заварили Earl Grey");
                    break;
                default:
                    logger.logError("Сделан неверный выбор: " + Tea);
                    System.out.print("Такого чая нету.");
                    return; // Возвращаемся из метода после обработки ошибки
            }
            logger.logInfo("Выбор чая сделан удачно");
        } catch (InputMismatchException e) {
            logger.logError("Ошибка ввода: " + e);
            System.out.println("Сделан неверный выбор");
        } catch (Exception e) {
            logger.logError("Ошибка в DrinkTea: " + e);
        }
    }

    public void sleep() {
        try {
            System.out.print("У вас есть на выбор две койки: верхняя и нижняя\nВаши действия\n1.Лечь сверху\n2.Лечь снизу\n");
            Scanner viborkoika = new Scanner(System.in);
            int koika = viborkoika.nextInt();
            if (koika == 1) {
                System.out.print("Вы легли спать на верхнюю койку \n");
            } else if (koika == 2) {
                System.out.print("Вы легли спать на нижнюю койку \n");
            } else {
                logger.logError("Сделан неверный выбор койки: " + koika);
                System.out.print("Такого варианта нет!");
                return;
            }
            logger.logInfo("Кровать выбрана удачно: " + (koika == 1 ? "верхняя" : "нижняя"));
        } catch (Exception e) {
            logger.logError("Ошибка в sleep: " + e);
        }
    }


    public void closeLog() {
        logger.close();
    }
}

abstract class Activity {
    protected Log logger;

    public Activity(Log logger) {
        this.logger = logger;
    }

    abstract void perform();
}

class Play extends Activity {
    public Play(Log logger) {
        super(logger);
    }

    @Override
    void perform() {
        Bascetball();
    }

    void Bascetball() {
        logger.logInfo("Игра в баскетбол началась");
        System.out.println("Вы видите там 3 человек и предлагаете сыграть в стрит (Баскетбол на одно кольцо)\nВдруг сокамерник говорит: Что на просто-так скучно играть и предлагает сыграть на пачку сигарет\nВы соглашаетесь\nИдет игра и вы с легкостью побеждаете, забрав награду.");
    }
}

class FreshAir extends Activity {
    public FreshAir(Log logger) {
        super(logger);
    }

    @Override
    void perform() {
        Vozdux();
    }

    void Vozdux() {
        logger.logInfo("Вышли подышать свежим воздухом");
        System.out.println("Вы идете мимо баскетбольной площадки, наслаждаясь прекрасным, свежим воздухом");
    }
}
