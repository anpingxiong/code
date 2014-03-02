package twoItemQueue;

import exception.EmptyQueueException;
import exception.FlowQueueException;

public class TwoItemQueue {
	
	private int queue[]; //双端队列存储于数组中
	
	private int head=0;  //双端队列的头 
	
	private int tail=0; //双端队列的尾
	
	private int flag=0;//用来做标示器，插入是flag = 1 ,删除时flag  =0 
	
	public TwoItemQueue(int size){
		if(size>0) {
			this.queue  = new int[size]; 
		}else{
			//如果长度小于 0 ，抛出构造双端队列失败的原因
			throw new java.lang.NegativeArraySizeException("构造双端队列失败,数组的长度必须大于0");
		}
	}
	
	/**
	 * 从头部插入：
	 *   对于插入，我们先思考边界问题便是上溢
	 * @throws FlowQueueException 
	 *   首先假如没有上溢，那么我们需要从头部插入，接着需要判断的是head-1》=0，不是从head+size地方插入
	 *   并且头部也成了head+size
	 */
	public void  enterQueueFromHead(int property) throws FlowQueueException{
		if(checkTwoItemFull()==false){
			if(head-1<0){
				//此处是为了制造循环
				queue[queue.length-1]=property;
				head=queue.length-1;
			}else{
				queue[head-1]  = property;
				head = head-1;
			}
		}else 
			throw new FlowQueueException();
	}
	
	/**
	 * 从尾部插入
	 * 			从尾部插入同样是需要考虑上溢的问题
	 * @throws FlowQueueException
	 *          如果没有上溢的话，那么我们需要考虑尾部插入循环的问题，需要判断是不是tail+1是不是<=size,
	 *          不是的话则需要从0   开始插入 
	 */
	public void enterQueueFromTail(int property) throws FlowQueueException{
		if(checkTwoItemFull()==false){
			if(tail==queue.length-1){
				queue[tail] = property;
				tail = 0 ;
			}else{
				queue[tail]  = property;
				tail  = tail +1;
			}
			flag=1;
		}else
			throw new FlowQueueException();
	}
	
	/**
	 * 从头部删除
	 * 	需要考虑到的是删除是如果队列已经为empty了，那么就不能被删除,并且抛出队列为空的异常
	 * @throws EmptyQueueException 
	 *  接下来在删除的时候需要判断head是不是在队列的尾部了，如果是在队列的尾部，那么删除的时候需要将head变成0
	 */
	public int deleteQueueFromHead() throws EmptyQueueException{
		
		if(this.checkTwoItemQueueEmpty()==false){
			flag = 0;
			if(head == queue.length-1){
		        int result  =  queue[head];
		        queue[head]=0;
				head = 0 ;
				return result;
			}else{
				int result = queue[head];
				queue[head]=0;
				head = head+1;
				return result;
			}
		}else
			throw new EmptyQueueException();
		
	}
	/**
	 * 从尾部删除
	 *   首先需要判断的也是栈会不会下溢
	 * @throws EmptyQueueException 
	 *   如果删除的尾部到了tail ==0 的时候，需要循环到尾部去
	 */
	public int deleteQueueFromTail() throws EmptyQueueException{
		if(this.checkTwoItemQueueEmpty()==false){
			flag=0;
			if(tail == 0){
				int result=queue[queue.length-1];
				queue[queue.length-1]=0;
				tail = queue.length-1;
				
				return result;
			}else{
				int result = queue[tail-1];
				queue[tail-1]=0;
				tail= tail-1;
				return result;
			}
			
		}else
			throw new EmptyQueueException();
	}
	/**
	 * 判断双端队列是否下溢
	 */
	public boolean checkTwoItemQueueEmpty(){
		if(head==tail&&flag==0){
			return true;	
		}else
			return false;
		
	}
	
	/**
	 * 判断双端队列是否上溢
	 */
	public boolean checkTwoItemFull(){
		if(head==tail && flag ==1){
			return true;
		}else
		  return false;
	}
	public static void main(String[] args) throws EmptyQueueException, FlowQueueException {
		
		 //构造极端的数组是会抛出异常的
		//TwoItemQueue  queue  = new TwoItemQueue(121);
		//System.out.println(queue.toString());
		 //int[]  a   = new  int[-1];
		//TwoItemQueue  queue  = new TwoItemQueue(0);
		//System.out.println(queue);
		//System.out.println(a.toString());
		//int[]  a   = new  int[999999999];
		TwoItemQueue  queue  = new TwoItemQueue(4);
		
		queue.enterQueueFromTail(2);
		queue.enterQueueFromHead(100);
		queue.enterQueueFromTail(-1);
		queue.enterQueueFromTail(-90);
		//queue.enterQueueFromHead(100);
		System.out.println("退出"+queue.deleteQueueFromHead());
		System.out.println("退出"+queue.deleteQueueFromHead());
		//System.out.println("退出"+queue.deleteQueueFromTail());
		System.out.println("退出"+queue.deleteQueueFromTail());
		//System.out.println("退出"+queue.deleteQueueFromTail());	
		for(int i=0 ;i<queue.queue.length;i++){
			System.out.println(queue.queue[i]);
		} 
		
	}
}
