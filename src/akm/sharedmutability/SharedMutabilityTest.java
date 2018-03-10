package akm.sharedmutability;

import java.util.concurrent.TimeUnit;

/**
 * 
 * 
 * Nand Kishor Mishra,
 * NO:-860360116 ,
 * ASI/GD N K MISHRA  A/O 141 BN  CRPF
 * BADRANCHALAM TELANGANA :- 507111
 * @author ashishkumarmishra
 *
 */

public class SharedMutabilityTest
{
	private static boolean IS_NEED_TO_TERMINATE=false;
	public static void main(String[] args) throws InterruptedException 
	{
		new Thread()
		{
			public  void run()
			{
				int i=0;
				while(!isStopedRequest())
				{
					System.out.println((++i));
				}
			}
		}.start();
		TimeUnit.SECONDS.sleep(1);
		setStopRequest(true);;
	}
	
	private static boolean isStopedRequest()
	{
		return IS_NEED_TO_TERMINATE;
	}
	
	private static void setStopRequest(boolean value)
	{
		IS_NEED_TO_TERMINATE=value;
	}
}
