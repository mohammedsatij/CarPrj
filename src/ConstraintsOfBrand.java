import java.util.List;
import java.util.Scanner;

public class ConstraintsOfBrand {
    private static final Scanner sc = new Scanner(System.in);
    //Ham nhap String khong rong
    public String inputNonBlankString(String msg){
        System.out.println(msg);
        while(true){
            String result = sc.nextLine();
            if(result.length() == 0 || result.trim().isEmpty()){
                System.out.println("String is emty!!! Please enter again!!!");
               
            }
            else{
            return result;
        }
    }
    }
    
    public String inputToUpdateBrandID(String msg, List<Brand> listBrand){
            String id = inputNonBlankString(msg);
            return id;
    }
    //Ham kiem tra brandID bi trung
    public String inputBrandID(String msg, List<Brand> listBrand){
        while(true){
        String id = inputNonBlankString(msg); //nhap id
        boolean isDuplicated = false;
        for (Brand word : listBrand){
            if(word.getBrandID().equals(id)){
                System.out.println("Brand ID can not be duplicated!!! Please enter again!!!");
               isDuplicated = true;
               break;
            }
        }
        if(!isDuplicated){
            return id;
        }
    }
}
    //Ham tao so > 0
   public double inputPrice(String msg, double min, double max) {
    while (true) {
        String result = inputNonBlankString(msg);
        try {
            double num = Double.parseDouble(result);
            if (num < min || num > max) {
                System.out.println("The number must be between " + min + " and " + max + "!!! Please enter again!!!");
            } else {
                return num;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
}
