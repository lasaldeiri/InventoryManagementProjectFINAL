class PerishableProduct extends Product {

    private String expiryDate;
    
    public PerishableProduct(int PpID, String PpN, double Ppp, int Ppq, String exp) {
        super(PpID, PpN,  Ppp, Ppq);
        expiryDate = exp;
    }
    public String getExpiryDate(){
        return expiryDate;
    }
    public void setExpiryDate(String exp){
        expiryDate = exp;
    }
    @Override
    public void displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Expiry Date: " + expiryDate);
    }
}
