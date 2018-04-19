package callcenter.dispatcher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import callcenter.models.Call;

/**
 * @author Andrea
 *
 */
public class CallCenter {
	
	private ExecutorService executor = Executors.newFixedThreadPool(10);
	
	/** metodo que crea la tarea  la ejecuta de acuerdo a lacantidad de llamadas
	 * @param calls  llamadas que deben ser atendidas
	 */
	public void AttendCalls(List<Call> calls){
		Dispatcher answerCallsTask= new  Dispatcher();
		answerCallsTask.setCalls(calls);
		for(Call call:calls){
			executor.submit(answerCallsTask);
		}
		executor.shutdown();
		
	}

}
