
public class InsertSortArray{


	public static void main(String args[]) throws Exception{
	    int a[]={2,1,0,22};

		sort(a);

		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		
		}
	
	}
	public static void sort(int a[]) throws Exception{
               
		if(null==a||0>=a.length)
			throw new Exception("你输入的数组长度不能小于0");

		for(int i=0;i<a.length-1;i++){

             if(a[i]>a[i+1]){
				  
				   for(int j=i+1;j>0;j--){
					 if(a[j-1]<=a[j]){
						 break;
					 }
                          
					 a[j]=a[j]^a[j-1];
                     a[j-1]=a[j]^a[j-1]; 
                     a[j]=a[j]^a[j-1];
				 
				  }
			 
			 }
		
		}
	}
}
