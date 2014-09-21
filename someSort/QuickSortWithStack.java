import java.util.Stack;

/**
 *非递归的方式排序， 通过栈来代替递归
 */
public class QuickSortWithStack{

    /**
	 *@param a  需要排序的数组
	 */
	public void sort(int a[])throws Exception{

		if(null==a||0>=a.length)
			throw new Exception("需要排序的数组不能为空");
        //用来存储需要排序的 数组片段
        Stack<NextData>   nextDatas= new Stack<NextData>();
        
		nextDatas.push(new NextData(0,a.length-1));  //首先将下标为[0,a.length-1]的字段片段放入到栈中
        
		while(!nextDatas.empty()){
	        NextData  data = nextDatas.pop();
  	        int k = data.start,h=data.start-1; 
			for(;k<data.end;k++){
			 
		        if(a[k]<a[data.end]){
			        h++;
					if(a[k]!=a[h]){
					    a[k]=a[k]^a[h];
						a[h]=a[k]^a[h];
						a[k]=a[k]^a[h];
					}	
				}  	
			}
           
			if(a[h+1]!=a[data.end]){
				a[h+1]=a[h+1]^a[data.end];
				a[data.end]=a[h+1]^a[data.end];
				a[h+1]=a[h+1]^a[data.end];
			}

			if(data.start<h){
			    nextDatas.push(new NextData(data.start,h));
			}
            
			if(h+2<data.end){
				nextDatas.push(new NextData(h+2,data.end));
			}
		}
	}

	public static void main(String args[]){
          QuickSortWithStack  quickSort  = new QuickSortWithStack();
		  int a[]= {100,233,1,2,3,0,-1,2};
		  try{
		  quickSort.sort(a);
		  for(int i=0;i<a.length;i++){
			  System.out.print(a[i]+" ");
		  }
		  }catch(Exception e){
			  System.out.print(e.getMessage());
		  }
	}

	class NextData{
       public  int  start;
	   public 	int end;
	   public NextData(int start,int end){
	       this.start=start;
		   this.end= end;
	   }
	}
}
