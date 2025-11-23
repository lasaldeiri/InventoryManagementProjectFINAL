public class InventoryManager {
    public Product[] products = new Product[50];
    private int count = 0;
    public void AddProduct(Product item) throws InvalidInputException {
        if (count < products.length) {
            products[count++] = item;
            System.out.println("Product added successfully!");
        } else {
            throw new InvalidInputException("Inventory is full.");
        }
    }
    public void ViewAllProducts() {
        for (int i = 0; i < count; i++) {
            products[i].displayProductInfo();
            System.out.println("----------");
        }
    }
    public void UpdateProduct(int id, String newName, double newPrice, int newQuantity)
            throws ProductNotFoundException {
        for (int i = 0; i < count; i++) {
            if (products[i].getproductID() == id) {
                products[i].setproductName(newName);
                products[i].setproductPrice(newPrice);
                products[i].setproductQuantity(newQuantity);
                System.out.println("Product updated successfully!");
                return;
            }
        }
        throw new ProductNotFoundException(
                "Cannot update — product with ID " + id + " not found.");
    }
    public void DeleteProduct(int id) throws ProductNotFoundException {
        for (int i = 0; i < count; i++) {
            if (products[i].getproductID() == id) {
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[count - 1] = null;
                count--;

                System.out.println("Product deleted successfully!");
                return;
            }
        }
        throw new ProductNotFoundException(
                "Cannot delete — product with ID " + id + " not found.");
    }
    public Product SearchProduct(int id) throws ProductNotFoundException {
        for (int i = 0; i < count; i++) {
            if (products[i].getproductID() == id) {
                System.out.println("Product found: " + products[i].getproductName());
                return products[i];
            }
        }
        throw new ProductNotFoundException(
                "Product with ID " + id + " not found.");
    }
    public void sortProductPrice() {
    if (count == 0) {
        System.out.println("No products to sort.");
        return;
    }
    for (int i = 0; i < count - 1; i++) {
        for (int j = 0; j < count - i - 1; j++) {
            if (products[j].getproductPrice() > products[j + 1].getproductPrice()) {
                Product temp = products[j];
                products[j] = products[j + 1];
                products[j + 1] = temp;
            }
        }
    }
    System.out.println("Products sorted by price (low to high).");
}
}
