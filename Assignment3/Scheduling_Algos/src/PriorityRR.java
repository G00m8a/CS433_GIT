import java.util.*;


public class PriorityRR implements Algorithm {

	private List<Task> queue = new ArrayList<Task>();
	
	//constructor takes list of tasks as argument
	public PriorityRR(List<Task> queue){
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
		Task highestPriority = queue.get(0);
		int indexOfHighest = 0;
		if(queue.size() > 1){
			for(int i = 1; i < queue.size(); i++){
				if(highestPriority.getPriority() < queue.get(i).getPriority()){
					highestPriority = queue.get(i);
					indexOfHighest = i;
				}
			}
		}
		return queue.remove(indexOfHighest);
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
