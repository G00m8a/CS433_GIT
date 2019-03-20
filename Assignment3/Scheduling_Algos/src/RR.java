import java.util.*;


public class RR implements Algorithm {
	
	private List<Task> queue = new ArrayList<Task>();
	
	//constructor takes list of tasks as argument
	public RR(List<Task> queue){
		this.queue = queue;
	}
	public void schedule() {
		while(queue.isEmpty() == false){
			Task task = pickNextTask();
			int slice = 0;
			CPU.run(task, slice);
			quant(task);
		}
	}

	public Task pickNextTask() {
		return queue.remove(0);
	}
	
	public void quant(Task task){
		int burst = task.getBurst();
		burst = burst - 10;
		if(burst > 0){
			task.setBurst(burst);
			queue.add(task);
		}
		else{
			System.out.println("Task "+ task.getName() + " finished.\n");
		}	
	}

}
