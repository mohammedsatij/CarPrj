
import java.util.*;

public class myUtils {
    public static int getRandomInt(){
        Random rand= new Random();
        return rand.nextInt();
    }
    public static int getRandomInRange(int min,int max){
        Random random=new Random();
        int randomNumber = random.nextInt(max - min +1) + min;
        return randomNumber;
    }
    public static String getRandomColor(){
        String[] color ={"red", "blue", "green", "yellow", "purple", "orange", "pink", "brown", "black", "white"};
        return color[getRandomInRange(0,color.length-1)];
    }
    
    
}
