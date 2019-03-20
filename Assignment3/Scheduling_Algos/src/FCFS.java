import java.util.*;

public class FCFS implements Algorithm {
	private List<Task> queue = new ArrayList<Task>();
	
	//constructor takes list of tasks as argument
	public FCFS(List<Task> queue){
		this.queue = queue;
	}
	
	public void schedule() {
		while(queue.isEmpty() == false){
			Task task = pickNextTask();
			int slice = 0;
			CPU.run(task, slice);
		}
	}
	
	public Task pickNextTask() {
		return queue.remove(0);
	}

}
