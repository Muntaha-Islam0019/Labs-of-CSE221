import java.io.*;
import java.util.*;
public class ReadFileExample {
  
  public static void main(String[] args) {
    
    BufferedReader obj= null;
    try {
      String str;
      FileReader fr = new FileReader("text.txt");
      obj = new BufferedReader(fr);
      str = obj.readLine();
      // convert this to int
      int v = Integer.parseInt(str);
      System.out.println(v);
      
      // creat the matrix 
     
      
      while ((str = obj.readLine()) != null) {
       System.out.println(str);
       
      }
      
    } catch (IOException e) {
      
      e.printStackTrace();
      
    } 
  }
}
