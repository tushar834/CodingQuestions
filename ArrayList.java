
import java.util.Arrays;
import java.util.List;
import java.text.DecimalFormat;  

public class ArrayList {  
   
    static void charPercentage(String input) {  
       
            char ch = input.charAt(0);  
            if (Character.isUpperCase(ch)) {
            	System.out.println("upper");
                 
            }  
            else if (Character.isLowerCase(ch)) {  
            	System.out.println("lower");
            }  
            else if (Character.isDigit(ch)) {  
            	System.out.println("digit");
            }  
            else {  
            	System.out.println("other");
            }  
         
     
    }  
    public static void main(String[] args) {  
        charPercentage("String to chek upper case");  
    }  
   
}  