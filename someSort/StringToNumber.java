import java.math.*;

public class StringToNumber{

	/**
	 *
	 * 将字符串String 转化为字符串
	 * */
	public static int  integerParseInt(String  data) throws Exception{
          int result  =0; //返回值
		  int initType  = 1; //用来标示正和负 
          int i=0; //遍历字符的首
		  if(null==data)
			  throw  new Exception("字符串转化异常");
         
          if('-'==data.charAt(0)){
			  initType=-1;
			  i++;
		   }else if(0<=data.charAt(0)||9>=data.charAt(0))
			  initType=1;
		  else
			  throw new Exception("字符串转化异常");


          while(i<data.length()){
		     char  getOneData = data.charAt(i);
  			 if('0'>getOneData||'9'<getOneData)
				 throw new Exception("字符串转化异常");
           
             if(initType==-1)
				 result+=(getOneData-48)*(Math.pow(10,data.length()-i-1));
			 else
				 result+=(getOneData-48)*(Math.pow(10,data.length()-i-1));
		    
			 i++;
		  }   
            
		  return result*initType;
	}

	
	public static void main(String args[]){
		try{
        int  data = integerParseInt("-84573");
		System.out.print(data);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		
	}

}
