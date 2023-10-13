/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VICTUS
 */
public class Brand {
    String BrandID;
    String brandName;
    String soundBrand;
   double price;
   public Brand(){
}

    public Brand(String BrandID, String brandName, String soundBrand, double price) {
        this.BrandID = BrandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Brand{" + "BrandID=" + BrandID + ", brandName=" + brandName + ", soundBrand=" + soundBrand + ", price=" + price + '}';
    }
   
   
}
