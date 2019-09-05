import java.io.*;
import java.util.*;
public class CreateGraph {
  
  public static void main(String[] args) {
    int [][] graph;
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
        // tokenize = a,b
        StringTokenizer st = new StringTokenizer(str," ");
        int token1 = Integer.parseInt(st.nextToken());
        
        int token2 = Integer.parseInt(st.nextToken());
        
        //connect graph [a][b] = 1 graph[b][a] = 1
       
      }
      
      LinkedList [] al = new LinkedList[v];
      for (int i= 0;i<al.length;i++){
        al[i] = new LinkedList<String>();
      }
      
    } catch (IOException e) {
      
      e.printStackTrace();
      
    }
//     for (int i= 0;i<graph.length;i++){
//    for(int j = 0;j < graph[0].length;j++){
//      // print
//    }
//  }
  }
  
 
}
