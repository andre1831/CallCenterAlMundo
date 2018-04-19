package callcenter;

import java.util.ArrayList;
import java.util.List;

import callcenter.dispatcher.CallCenter;
import callcenter.models.Call;



/**
 * Hello world!
 *
 */
public class CallCenterMain 
{
	/** Metodo main crea las llamadas que deberan ser atendidas
	 * @param args
	 */
	public static void main(String [] args)
	{
		List<Call> calls=new ArrayList<Call>();
		for(int i=1;i<=15;i++){
			Call call= new Call("persona "+i);
			calls.add(call);
		}
		CallCenter callCenter= new CallCenter();
		callCenter.AttendCalls(calls);
	}
}
