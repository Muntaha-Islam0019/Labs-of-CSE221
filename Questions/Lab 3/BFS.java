import java.util.*;
public class BFS{
  
  // an array of ArrayList
  // You can also use a arraylist of arraylist
  ArrayList [] g;
  // level array is to store the level of each vertex
  int [] level;
  // parent array is to store the parent of each vertex
  int [] parent;
  // we will be using the java's built in queue
  Queue q;
  
  // constructor
  //@ parameter pass the array of arraylist of the graph
  public BFS(ArrayList [] arr){
    // save the arraylist globally 
    // TO DO
    
    // create the level and parent array 
    // TO DO
    
    // Queue object created 
    // Queue will use linked list as underlying data structure
    q = new LinkedList<Integer>();
    
    // initializing the level and parent arrays with -1
    // This is done to keep track which vertices are unvisited
    // you might have different techniques
    for(int i = 0;i<g.length;i++){
      level[i] = -1;
      parent[i] = -1;
    }
  }
  
  // This method runs BFS
  // @parameter the source
  public void runBfs(int source){
    // set the level of source to 0 and add it to Queue
    // TO DO
   
    // run the loop while queue not empty
    while(!(q.isEmpty())){
      // dequeue vertex
      // TO DO
      
      // for each adjacent vertex of u
      for(int i = 0;i<g.length;i++){
        // check if visited
        
        if(/* TO DO */){
          // The visit status of each vertex is checked using the the values of level
          // -1 indicated unvisted 
          if(level[i]==-1){
            // increment level
            // TO DO 
          
            // add parent
            // TO DO
          
            // enque in the queue
            // TO DO
          }
        }
      }
    }
    
    // The following is done for you
    // this prints the path of every vertex from the source
    for(int i = 0;i<g.length;i++){
 
      String ans = "";
      if (parent[i]==-1){
         System.out.println(i+" is the Source.");
      }else{
        ans = ""+i;
        int j = i;
        //int x = ();
        while(parent[j]!=-1){
          
          j = parent[j];
          //System.out.println(j);
          ans = j +">"+ ans;
        }
        System.out.println(ans);
      }
    }
    
  }
}