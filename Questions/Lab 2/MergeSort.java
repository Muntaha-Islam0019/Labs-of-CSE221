import java.util.Arrays;
public class MergeSort{
  
  //int farray [];
  public void mergeSort(int [] a){
    if (a.length==1){
      return;
    }else{
      int mid = a.length/2;
      int ar1[] = new int [mid];
      // create the second half with a.lenght-mid
      // copy the first half to ar1
      // copy the second half to ar2
     mergeSort(ar1);
      // call mergeSort on the second half
      // then merge the 2 subarrays
    }
  }
  
}