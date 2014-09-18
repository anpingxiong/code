

public class SecondMaxDataUtil{
    
	//返回第二大的值
	public   static int   getSecondMaxData(int data[]){
		int max  = data[0],min = data[0],temp=data[0] ;
		for( int i = 1 ;i<data.length;i++){
			if(data[i]>max){
				 temp=max;
				 max=data[i];
			}
	 
			if(data[i-1]!=max && (data[i-1]>min|| temp!=max)){
			
				 min  =   temp!=max?temp>min?temp:min:data[i-1];
				 min  = min>data[i-1]?min:data[i-1];

           	}
		}
        
		if(min<data[data.length-1] && max!=data[data.length-1]){
			min = data[data.length-1];
		}
		return min;
	}

	public static void  main(String args[]){
		int data[]={98,23,22,2,96,4,10,99,97,33,-1,31};
        
        System.out.print(getSecondMaxData(data));	
	}
}
