package exception;

public class EmptyQueueException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyQueueException(){
		super("队列已经为空了!");
	}
}
