class Product{
    private int productID;
    private String productName;
    private double productPrice;
    private int productQuantity;
    public Product(int ID, String N, double p, int q) {
        productID =  ID;
        productName = N;
        productPrice = p;
        productQuantity = q;
    }
    public int getproductID() { 
        return productID; 
    }
    public void setproductId(int ID) { 
        productID = ID; 
    }
    public String getproductName() { 
        return productName; 
    }
    public void setproductName(String N) {
        productName = N; 
    }
    public double getproductPrice(){
        return productPrice; 
    }
    public void setproductPrice(double p){
        productPrice = p; 
    }
    public int getproductQuantity(){
        return productQuantity; 
    }
    public void setproductQuantity(int q){
        productQuantity = q; 
    }
    public void displayProductInfo(){
        System.out.println("Product ID: " + productID);
        System.out.println("Name:" + productName);
        System.out.println("Price:" + productPrice);
        System.out.println("Quantity:" + productQuantity);
    }
}
