import java.util.*;
import java.io.*;

public class Solution{

    public static void main (String args[]){
        try(Scanner sc = new Scanner(System.in)){
            int t = sc.nextInt();
            for(int i=0;i<t;i++){
               int count = countFragment(sc.next());
               System.out.println("Case "+"#"+(i+1)+": "+count);
               
            }
            
        }
    }
    private static int countFragment(String str){
        int count=0;
        for(int j=0; j<str.length()-8;j++){
        	//count++;
            if(str.substring(j,j+4).equals("KICK")){
                for(int k=j+4; k<str.length()-4;k++){
                    if(str.substring(k,k+5).equals("START")){
                        count++;
                    }
                }      
            }
        } 
        return count;
    }
}