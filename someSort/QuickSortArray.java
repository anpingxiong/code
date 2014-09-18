

public class QuickSortArray{

	public  static void doSort(int a[],int start,int end){
	      
		  int  k =start,h=start-1;
          for(int i =start;i<end;i++){
		     
			  if(a[k]<a[end]){
				  ++h;
				  //避免同一个数据交换
				  if(a[h]!=a[k]){
			      a[h]=a[k]^a[h];
				  a[k]=a[h]^a[k];
				  a[h]=a[h]^a[k];
				     }
		     	 }
             
			  k++;

		  }

		  //避免同一个数据
           if(a[h+1]!=a[end]){ 
		       a[h+1]=a[h+1]^a[end];
		       a[end]=a[h+1]^a[end];
		       a[h+1]=a[h+1]^a[end];
		   }
		  if(start<h){
		  doSort(a,start,h);
		  }
		  if(h+2<end){
			 doSort(a,h+2,end);
		  }
	}


	public static void sort(int a[]) throws Exception{
	   if(null==a||0>=a.length){
	      throw new Exception("你输入的数组长度不能小于0");
	   }
   
	   doSort(a,0,a.length-1);
	}

   
	public static void main(String args[]){
            int a[]={-129,0,12,3,29,79,3,1,1,100000,-1};	
	        try{
			sort(a);
			for(int i =0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
			}catch(Exception e){
				System.out.print(e.getMessage());
			}
	}


}
