
import java.util.*;
public class SortArray{

     public static void main(String args[]){
	     int a[] ={1,100,20,22,11,189}; 
		 

		 try{
		 
		     sortArray(a);
		 
		 for(int i=0;i<a.length;i++){
			 System.out.print(a[i]+"  ");
		 
		 }
		 }catch(Exception e){
		    System.out.print(e.getMessage());
		 }

		 
	 }

     public static void sortArray(int a[]) throws Exception{
	     if(a==null || a.length<=0){
		      throw new Exception("您输入的数组不能为空");
		 }else{
		      
			 Arrays.sort(a);
		 }
	 }
}
