package org.example;
import java.util.ArrayList;
import java.util.Scanner;

class Watch {
    private String brand;
    private String model;

    public Watch(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return model + " - " + brand;
    }
}

class Buyer {
    private String fullName;
    private String email;
    private String phoneNumber;
    private Watch watch;

    public Buyer(String fullName, String email, String phoneNumber, Watch watch) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.watch = watch;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Watch getWatch() {
        return watch;
    }
}

class Order {
    private Buyer buyer;

    public Order(Buyer buyer) {
        this.buyer = buyer;
    }

    public Buyer getBuyer() {
        return buyer;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] brands = {"Rolex", "Casio", "Omega"};
        String[][] models = {
                {"DAYTONA", "Explorer", "Cosmograph"},
                {"G-SGOCK", "SHEEN", "Edifice"},
                {"DIVER", "TRÉSOR", "PRESTIGE"}
        };

        ArrayList<Buyer> buyers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Ввод информации о покупателях и заказах
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите данные о покупателе " + (i + 1) + ":");
            System.out.print("ФИО: ");
            String fullName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Номер телефона: ");
            String phoneNumber = scanner.nextLine();

            // Вывод списка доступных позиций
            System.out.println("Доступные позиции в магазине:");
            for (int j = 0; j < brands.length; j++) {
                System.out.println(brands[j] + ":");
                for (String model : models[j]) {
                    System.out.println(" - " + model);
                }
            }

            System.out.print("Выберите бренд: ");
            int brandIndex = Integer.parseInt(scanner.nextLine()) - 1;
            String brand = brands[brandIndex];

            System.out.print("Выберите модель: ");
            int modelIndex = Integer.parseInt(scanner.nextLine()) - 1;
            String model = models[brandIndex][modelIndex];

            Watch watch = new Watch(brand, model);

            System.out.print("Введите количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Buyer buyer = new Buyer(fullName, email, phoneNumber, watch);
            buyers.add(buyer);

            Order order = new Order(buyer);
            orders.add(order);
        }

        // Вывод информации о заказах
        System.out.println("Информация о заказах:");
        for (Order order : orders) {
            Buyer buyer = order.getBuyer();
            System.out.println("Покупатель: " + buyer.getFullName());
            System.out.println("Email: " + buyer.getEmail());
            System.out.println("Номер телефона: " + buyer.getPhoneNumber());
            System.out.println("Позиция товара: " + buyer.getWatch());
            System.out.println();
        }
    }
}