import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PlushToy {
    private String name;
    private double price;
    private int quantity;

    public PlushToy(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price + " tenge, Quantity: " + quantity;
    }
}

class Inventory {
    private List<PlushToy> plushToys;

    public Inventory() {
        plushToys = new ArrayList<>();
    }

    public void addPlushToy(PlushToy plushToy) {
        plushToys.add(plushToy);
    }

    public void removePlushToy(int index) {
        plushToys.remove(index);
    }

    public List<PlushToy> getPlushToys() {
        return plushToys;
    }

    public PlushToy getPlushToy(int index) {
        return plushToys.get(index);
    }

    public int getSize() {
        return plushToys.size();
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        inventory.addPlushToy(new PlushToy("Teddy Bear", 2499.99, 10));
        inventory.addPlushToy(new PlushToy("Unicorn", 2149.99, 15));
        inventory.addPlushToy(new PlushToy("Penguin", 3199.99, 20));
        System.out.println("╭─━─━─━─━─━─━─━─━─≪✠≫━─━─━─━─━─━─━─━─━╮\n \uD83D\uDED2 Welcome to Our Plush Toys Store! \uD83D\uDED2");
        while (true) {
            displayMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        viewInventory();
                        break;
                    case 2:
                        addNewPlushToy();
                        break;
                    case 3:
                        removePlushToy();
                        break;
                    case 4:
                        updatePlushToyDetails();
                        break;
                    case 5:
                        purchasePlushToy();
                        break;
                    case 6:
                        System.out.println("Thank you for visiting the Plush Toys Store!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("━─━───────────────༺༻───────────────━─━" +
                "\n| [1]: View Inventory                 |");
        System.out.println("| [2]: Add New Plush Toy              |");
        System.out.println("| [3]: Remove Plush Toy               |");
        System.out.println("| [4]: Update Plush Toy Details       |");
        System.out.println("| [5]: Purchase Plush Toy             |");
        System.out.println("| [6]: Exit Application               |\n" +
                "╰─━─━─━─━─━─━─━─━─≪✠≫─━─━─━─━─━─━─━─━─╯\n" +
                "➥ Choose an action: ");
    }

    private static void viewInventory() {
        System.out.println("Our Inventory:");
        List<PlushToy> plushToys = inventory.getPlushToys();
        for (int i = 0; i < plushToys.size(); i++) {
            System.out.println((i + 1) + ". " + plushToys.get(i));
        }
    }

    private static void addNewPlushToy() {
        System.out.println("Add New Plush Toy:");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");

        double price = 0;
        try {
            price = scanner.nextDouble();
        } catch (Exception e){
            System.out.println("Price should be a number!");
            return;
        }
        System.out.print("Enter quantity: ");
        int quantity = 0;
        try {
            quantity = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Quantity should be a valid integer!");
            return;
        }
        inventory.addPlushToy(new PlushToy(name, price, quantity));
        System.out.println("New plush toy added to inventory.");
    }

    private static void removePlushToy() {
        System.out.println("Remove Plush Toy:");
        viewInventory();
        System.out.print("Enter the index of the plush toy to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > inventory.getSize()) {
            System.out.println("Invalid index. Please try again.");
            return;
        }

        inventory.removePlushToy(index - 1);
        System.out.println("Plush toy removed from inventory.");
    }

    private static void updatePlushToyDetails() {
        System.out.println("Update Plush Toy Details:");
        viewInventory();
        System.out.print("Enter the index of the plush toy to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > inventory.getSize()) {
            System.out.println("Invalid index");
            return;
        }

        PlushToy plushToy = inventory.getPlushToy(index - 1);
        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            plushToy.setName(newName);
        }

        System.out.print("Enter new price (leave blank to keep current): ");
        String priceInput = scanner.nextLine();
        if (!priceInput.isEmpty()) {
            double newPrice = Double.parseDouble(priceInput);
            plushToy.setPrice(newPrice);
        }

        System.out.print("Enter new quantity (leave blank to keep current): ");
        String quantityInput = scanner.nextLine();
        if (!quantityInput.isEmpty()) {
            int newQuantity = Integer.parseInt(quantityInput);
            plushToy.setQuantity(newQuantity);
        }

        System.out.println("Plush toy details updated successfully.");
    }

    private static void purchasePlushToy() {
        System.out.println("Purchase Plush Toy:");
        viewInventory();
        System.out.print("Enter the index of the plush toy to purchase: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > inventory.getSize()) {
            System.out.println("Invalid index");
            return;
        }

        PlushToy plushToy = inventory.getPlushToy(index - 1);
        if (plushToy.getQuantity() == 0) {
            System.out.println("Sorry, this plush toy is out of stock.");
        } else {
            System.out.println("Are you sure you want to buy " + plushToy.getName() + " for " + plushToy.getPrice() + " tenge?\n0 - No, 1 - Yes");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Purchase canceled");
                    break;
                case 1:
                    plushToy.setQuantity(plushToy.getQuantity() - 1);
                    System.out.println("You have purchased one " + plushToy.getName() + ".");
                    break;
                default:
                    System.out.println("Invalid choice. Purchase canceled.");
            }
        }
    }
}
