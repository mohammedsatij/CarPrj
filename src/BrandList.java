

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BrandList extends ArrayList <Brand> {
    private String brandID, brandName, soundBrand;
    private double price;
    private int pos;
    Scanner scanner = new Scanner(System.in);
    PrintWriter pw;
    BufferedReader br;
    ConstraintsOfBrand check;
     ArrayList <Brand> list;
    public BrandList(){
        list = new ArrayList<>();
    }
    public boolean loadFromFile (String fileName) throws IOException{
        try {
            br = new BufferedReader(new FileReader(fileName));
            String [] arr;
            String line = br.readLine();
            while ((line != null)) {
                arr = line.split(",");
                brandID = arr[0].trim();
                brandName = arr[1].trim();
                soundBrand = arr[2].split(":")[0].trim();
                price = Double.parseDouble(arr[2].split(":")[1].trim());
                this.add(new Brand(brandID, brandName, soundBrand, price));
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found !");
        }
        return false;
    }

    public boolean saveToFile (String fileName) {
        try {
            pw = new PrintWriter(new FileWriter(fileName));
            for (Brand i: this) {
                pw.println(i);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Open the file based on the filename to write data in line-by-line text format
    public int searchID (String bID) {
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) {
                return i;
            }
        }
        return -1;
    }

    //Transform the list to a menu, the user will choose a brand from this menu
    public Brand getUserChoice () {
        Menu menu = new Menu();
        return (Brand) menu. ref_getChoice(this);
    }

    //Add a new Brand to the list
    public void addBrand () {
        String id = check.inputBrandID("Enter Brand ID", list);
       String brandName = check.inputNonBlankString("Enter Brand Name: ");
       String soundBrand = check.inputNonBlankString("Enter sound Brand: ");
       double price = check.inputPrice("Enter price: ", 0, 1000000);
       
       Brand newProduct = new Brand(id, brandName, soundBrand, price);
       list.add(newProduct);
        System.out.println("Added successfully!!!");
    }

    //Update brand_name, sound_brand, price of an existed brand
    public void updateBrand () {
         String brandID = check.inputNonBlankString("Enter Brand ID to update: ");
        int pos = SearchBrandByID(brandID);
        if(pos == -1){
            System.out.println("Not Found!!!");
        }
        else{
            String id = check.inputToUpdateBrandID("Enter Brand ID: ", list);
            String brandName = check.inputNonBlankString("Enter Brand Name: ");
            String soundBrand = check.inputNonBlankString("Enter sound Brand: ");
            double price = check.inputPrice("Enter price: ", 0, 1e9);
            
            Brand find = list.get(pos);
            find.setBrandID(id);
            find.setBrandName(brandName);
            find.setSoundBrand(soundBrand);
            find.setPrice(price);
            
            
            System.out.println("Update Successfully!!!");
        }
    }

    //Show the list of the brands
    public void listBrands() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
}
