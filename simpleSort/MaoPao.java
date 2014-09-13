

public class MaoPao{
	public static void sort(int a[]) throws Exception{
     	if(null==a|| 0>=a.length){
			throw  new Exception("数组长度不能为0");
		}

		for(int i =0;i<a.length-1;i++){
		
			for(int j=i+1;j<a.length;j++){
			    if(a[i]>a[j]){
				     a[i]=a[i]^a[j];
                     a[j]=a[i]^a[j];
					 a[i]=a[i]^a[j];
				}
			}

		}
	}


	 public static void main(String args[]){

		 int a[]={};
          try{
		 sort(a);

		 for(int i=0;i<a.length;i++){
		   System.out.print(a[i]+" ");
		 }

		 }catch(Exception e){
		    System.out.print(e.getMessage());
		  }
	 }
}
