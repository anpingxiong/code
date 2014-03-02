package exception;

public class FlowQueueException extends  Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlowQueueException(){ 
    	super("糟糕,队列上溢");
    }
}
