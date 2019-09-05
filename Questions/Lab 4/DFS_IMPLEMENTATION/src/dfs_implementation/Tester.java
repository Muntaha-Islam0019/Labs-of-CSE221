/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs_implementation;

/**
 *
 * @author ramisa.fariha
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author ramisa.fariha
 */
public class Tester {
static int time=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
     File f=new File("input.txt");
     Scanner sc=new Scanner(f);
     int nodes=sc.nextInt();
     
     int edges=sc.nextInt();
     
     int matrix [][]=new int [nodes+1][nodes+1];
     sc.nextLine();
     
     int count=0;
     for(int k=0;k<nodes+1;k++){
         matrix[0][k]=count;
           matrix[k][0]=count;
           count++;
     }
     while(sc.hasNext()){
         String s=sc.nextLine().trim();
         String str []=s.split(" ");
     int node1=Integer.parseInt(str[0]);
     int node2=Integer.parseInt(str[1]);
     matrix[node1][node2]=1;
    }
     for(int i=0;i<nodes+1;i++){
     
     for(int j=0;j<nodes+1;j++){
     System.out.print(matrix[i][j]+" ");
    }
     System.out.println();
     }
    }
    
    public void DFS(int [] [] adj){
        int n=adj.length;
    int color []=new int[n];
    int parent []=new int [n];
    int d []=new int [n];
    int f []=new int [n];
    //initialization
    for(int i=1;i<n;i++){
    color[i]=0;
    parent[i]=-1;
    }
    for(int u=1;u<n;u++){
    if(color[u]==0){
    DFS_VISIT(adj,u,color,parent,d,f);
    }
    
    }
    
    
    }
    public void DFS_VISIT(int [] [] adj,int u, int [] color, int [] parent, int [] d, int [] f){
    
    
    }
}
