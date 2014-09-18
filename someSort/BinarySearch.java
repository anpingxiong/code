


public class BinarySearch{
	public static int  doSearch(int a[],int start,int end,int key){
			  
             int middle =0;
			  while(start<=end){
			  			middle=(start+end)/2;
						if(key==a[middle]){
						return middle;	
						}
						
						if(a[middle]>key){
						    end = middle-1;
						}
						
						

						if(a[middle]<key){
                           start=middle+1;
				     	}

			  }

				  return  -1;
	}


	
	public static  int  search(int a[],int key) throws Exception{
	       if(null==a || 0>=a.length){
                throw new Exception("数组的长度不能小于0");
		   }

		   return  doSearch(a,0,a.length-1,key);
	} 

	public static void main(String args[]){
		int array[]={1,3,4,50,100,304949};
		try{
		System.out.print(search(array,304949));
		}catch(Exception e){
            System.out.print(e.getMessage());
		}
	}

}
