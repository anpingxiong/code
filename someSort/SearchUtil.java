import java.util.*;

public class SearchUtil{

	public static int  binarySearch(int a[],int k )throws Exception{
     
		 if(null==a||0>=a.length)
			 throw new Exception("您输入的数组长度不能为0 ");
		 else 
		   return Arrays.binarySearch(a,k);
	}

	public static void main(String args[]){

		int[] array= {1,22};

		int key  = 10000;

		try{
		 int a = binarySearch(array,key);

		System.out.print(a);
	     }catch(Exception e){
		    System.out.print(e.getMessage());
		 }
	}
}
