import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        InventoryManager m = new InventoryManager();
        Product p = new Product(102, "HB Pencil", 2.25, 12);
        PerishableProduct pp = new PerishableProduct(201, "Bread", 2.00, 6, "01-01-2026");

        try {
            m.AddProduct(p);
            m.AddProduct(pp);

            System.out.println("View all products:");
            m.ViewAllProducts();

            System.out.println("\nSearch for the product with ID: 201.");
            m.SearchProduct(201);

            System.out.println("\nUpdate product with the ID 102.");
            m.UpdateProduct(102, "Flamingo HB Pencil", 4.50, 20);

            System.out.println("\nView products after update:");
            m.ViewAllProducts();

            System.out.println("\nDelete product with the ID 201.");
            m.DeleteProduct(201);

            System.out.println("\nView all products after deleting some:");
            m.ViewAllProducts();
        }
        catch (InvalidInputException | ProductNotFoundException x) {
            System.out.println("Error: " + x.getMessage());
        }

        p.displayProductInfo();
        System.out.println();
        pp.displayProductInfo();

        Scanner sc = new Scanner(System.in);
        InventoryManager menuManager = new InventoryManager();

        while (true) {
            try {
                System.out.println("\n====== Inventory Management System ======");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Search Product by ID");
                System.out.println("6. Exit");
                System.out.println("7. Sort Products by Price");  // <-- ADDED
                System.out.print("Enter your choice: ");

                String input = sc.nextLine();

                if (input.isBlank()) {
                    throw new InvalidInputException("Input cannot be empty!");
                }

                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException x) {
                    throw new InvalidInputException("You must enter a number only, not text!");
                }

                if (choice == 1) {
                    try {
                        System.out.print("Enter Product ID: ");
                        String idInput = sc.nextLine();
                        if (idInput.isBlank()) throw new InvalidInputException("ID cannot be empty!");
                        int id = Integer.parseInt(idInput);

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();
                        if (name.isBlank()) throw new InvalidInputException("Name cannot be empty!");

                        System.out.print("Enter Product Price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        System.out.print("Enter Product Quantity: ");
                        int qty = Integer.parseInt(sc.nextLine());

                        System.out.print("Is it perishable? (y/n): ");
                        String ans = sc.nextLine().toLowerCase();

                        if (ans.equals("y")) {
                            System.out.print("Enter Expiry Date (DD-MM-YYYY): ");
                            String exp = sc.nextLine();

                            PerishableProduct newPP = new PerishableProduct(id, name, price, qty, exp);
                            menuManager.AddProduct(newPP);
                        } else {
                            Product newP = new Product(id, name, price, qty);
                            menuManager.AddProduct(newP);
                        }

                    } catch (Exception x) {
                        System.out.println("Error: " + x.getMessage());
                    }
                }

                else if (choice == 2) {
                    menuManager.ViewAllProducts();
                }

                else if (choice == 3) {
                    try {
                        System.out.print("Enter ID to update: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new price: ");
                        double newPrice = Double.parseDouble(sc.nextLine());

                        System.out.print("Enter new quantity: ");
                        int newQty = Integer.parseInt(sc.nextLine());
                        menuManager.UpdateProduct(id, newName, newPrice, newQty);
                    } catch (Exception x) {
                        System.out.println("Error: " + x.getMessage());
                    }
                }

                else if (choice == 4) {
                    try {
                        System.out.print("Enter ID to delete: ");
                        int id = Integer.parseInt(sc.nextLine());
                        menuManager.DeleteProduct(id);

                    } catch (Exception x) {
                        System.out.println("Error: " + x.getMessage());
                    }
                }

                else if (choice == 5) {
                    try {
                        System.out.print("Enter ID to search: ");
                        int id = Integer.parseInt(sc.nextLine());
                        menuManager.SearchProduct(id);

                    } catch (Exception x) {
                        System.out.println("Error: " + x.getMessage());
                    }
                }

                else if (choice == 6) {
                    System.out.println("Exiting the program.");
                    break;
                }

                else if (choice == 7) {
                    System.out.println("\nSorting products by price...");
                    menuManager.sortProductPrice();       
                    menuManager.ViewAllProducts();   
                }

                else {
                    System.out.println("Invalid choice. Please choose between 1–7.");
                }

            } catch (InvalidInputException x) {
                System.out.println("Error: " + x.getMessage());
            }
        }
        sc.close();
    }
}
