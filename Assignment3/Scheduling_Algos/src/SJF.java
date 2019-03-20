import java.util.*;

public class SJF implements Algorithm {

	private List<Task> queue = new ArrayList<Task>();

	
	//constructor takes list of tasks as argument
	public SJF(List<Task> queue){
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
		Task shortest = queue.get(0);
		int indexOfShortest = 0;
		if(queue.size() > 1){
			for(int i = 1; i < queue.size(); i++){
				if(shortest.getBurst() > queue.get(i).getBurst()){
					shortest = queue.get(i);
					indexOfShortest = i;
				}
			}
		}
		return queue.remove(indexOfShortest);
	}
}
