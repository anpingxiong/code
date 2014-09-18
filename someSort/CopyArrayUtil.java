

import java.util.*;
public class CopyArrayUtil{
	
	public static User[] copy(User a[]) throws Exception{
		if(null==a||0>=a.length)
			throw new Exception("请输入合法的字符数组!");
		else
			return Arrays.copyOf(a,a.length);
	}

	public static void main(String args[]) throws Exception{
	     User user1,user2,user3;
            user1=new User();
			user2=new User();
			user3=new User();

        
            System.out.println(user1);
			System.out.println(user2);
		     System.out.println(user3);
		User a[] ={user1,user2,user3};
        User b[]=null;
		System.out.println("-----------------------"); 
		 try{
		 b=copy(a);
		 for(int i =0 ;i<b.length;i++)
			 System.out.println(b[i]+" ");
	     

		 b=a.clone();

		 System.out.println("-----------------------");
		 for(int i=0;i<b.length;i++)
			 System.out.println(b[i]+" ");
		 }catch(Exception e){
		   System.out.println(e.getMessage());
		}
	}

    static	class User implements Cloneable{
		private int id;	


		public User Clone()  throws Exception{
	           return (User) super.clone();	
		}
	}
}
