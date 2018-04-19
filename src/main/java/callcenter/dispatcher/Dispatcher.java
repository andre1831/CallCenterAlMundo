package callcenter.dispatcher;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import callcenter.models.Call;
import callcenter.models.Employee;
import callcenter.models.initializers.EmployeesInitializer;
/**
 * @author Andrea
 *
 */
public class Dispatcher implements Runnable{
	
	public static int callsAnswered=0;
	List<Employee> employees= EmployeesInitializer.getEmployees();
	List<Call> calls;
	ReadWriteLock  lock = new ReentrantReadWriteLock();
	
	
	 /** metodo que busca el empleado que este disponible para atender la llamada
	 * @return
	 */
	private Employee findAvailableEmployee(){
		return this.employees.stream()
				.filter(callReplier-> callReplier.isAvailable().get() == true )
				.sorted(Comparator.comparing(callReplier -> callReplier.getType()))
				.findFirst().get();
	}

	 
	
	@Override
	public void run() {
		try {
			this.dispatchCall();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**metodo para agregar las llamadas que se deben responder
	 * @param call
	 */
	public void setCalls(List<Call> call) {
		this.calls = call;
	}

	/**metodo manejador de las llamadas
	 * @throws InterruptedException
	 */
	private void dispatchCall() throws InterruptedException{
			lock();
			Employee callReplier = 	findAvailableEmployee();
			callReplier.isAvailable().set(false);
			Call call = calls.remove(0);
			unLock();
			attendCall(callReplier,call);
	}

	/** metodo que atiende las llamadas
	 * @param callReplier           empleado que deber� contesrar la llamada
	 * @param call					llamada que debe ser contestada
	 * @throws InterruptedException
	 */
	private void attendCall(Employee callReplier,Call call) throws InterruptedException{
		System.out.println(buildMessage(callReplier.getName(),call.getCustomerName(),call.getDuration()));
		Thread.sleep(call.getDuration());
		callsAnswered++;
		callReplier.isAvailable().set(true);
	}
	
	/**Construcci�n del mensaje que se imprime cuando se contesta la llamada
	 * @param callReplierName    nombre del empleado que recibe la llamada
	 * @param customerName		 nombre de la persona que llama
	 * @param callDuration		 duraci�n de la llamada en milisegundos
	 * @return
	 */
	private String buildMessage(String callReplierName, String customerName, int callDuration){
		String message= callReplierName+" atendi� a:"+customerName +" y tard�: s"+callDuration+" miliSegundos";
		return message;
	}
	
	/**metodo que bloquea un proceso
	 * 
	 */
	private void lock(){
		lock.writeLock().lock();
		lock.readLock().lock();
	}
	
	/**metodo que desbloquea un proceso
	 * 
	 */
	private void unLock(){
		lock.writeLock().unlock();
		lock.readLock().unlock();
	}

}
