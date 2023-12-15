
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

class InventoryManagementSystem {
    private ArrayList<Product> inventory;
    private Scanner scanner;

    public InventoryManagementSystem() {
        inventory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product product = new Product(name, quantity);
        inventory.add(product);

        System.out.println("Product added to inventory.");
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Product product : inventory) {
                System.out.println(product.name + ": " + product.quantity);
            }
        }
    }

    public void updateQuantity() {
        System.out.print("Enter product name to update quantity: ");
        String name = scanner.nextLine();

        Product product = findProduct(name);
        if (product != null) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            product.quantity = newQuantity;
            System.out.println("Quantity updated for " + product.name);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    private Product findProduct(String name) {
        for (Product product : inventory) {
            if (product.name.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n1. Add Product\n2. Display Inventory\n3. Update Quantity\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    ims.addProduct();
                    break;
                case 2:
                    ims.displayInventory();
                    break;
                case 3:
                    ims.updateQuantity();
                    break;
                case 4:
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}