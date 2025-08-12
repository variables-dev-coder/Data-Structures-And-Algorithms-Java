package Queue.CircularQueue;


/*
Concept – Round Robin with Circular Queue
Round Robin is a time-sharing CPU scheduling algorithm where:
Each process gets a fixed time slice (quantum).
Processes are scheduled in a circular fashion.
If a process is not finished in its time slice, it goes back to the queue’s rear.

Why Circular Queue?
Because when we reach the end of the queue, we can loop back to the front without wasting
space — just like a circular track.

 */

class Task {
    String name;
    int burstTime; // Time required to finish the task

    public Task(String name, int burstTime) {
        this.name = name;
        this.burstTime = burstTime;
    }
}

class CircularQueue4 {
    Task[] queue;
    int front, rear, size, capacity;

    public CircularQueue4(int capacity) {
        this.capacity = capacity;
        queue = new Task[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Task task) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = task;
        size++;
    }

    public Task dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Task task = queue[front];
        front = (front + 1) % capacity;
        size--;
        return task;
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        int quantum = 4; // Time slice for each task

        CircularQueue4 cq = new CircularQueue4(5);
        cq.enqueue(new Task("Task1", 8));
        cq.enqueue(new Task("Task2", 5));
        cq.enqueue(new Task("Task3", 12));
        cq.enqueue(new Task("Task4", 6));

        System.out.println("Round Robin Scheduling:");
        while (!cq.isEmpty()) {
            Task current = cq.dequeue();

            if (current.burstTime > quantum) {
                System.out.println(current.name + " executed for " + quantum + " units.");
                current.burstTime -= quantum;
                cq.enqueue(current); // Put back to queue for next round
            } else {
                System.out.println(current.name + " executed for " + current.burstTime + " units and finished.");
            }
        }
    }
}


/*
Round Robin Scheduling:
Task1 executed for 4 units.
Task2 executed for 4 units.
Task3 executed for 4 units.
Task4 executed for 4 units.
Task1 executed for 4 units and finished.
Task2 executed for 1 units and finished.
Task3 executed for 4 units.
Task4 executed for 2 units and finished.
Task3 executed for 4 units and finished.
 */

/*
Dry Run

Input:
Task1 → 8
Task2 → 5
Task3 → 12
Task4 → 6
Quantum = 4

Execution Order:
Task1 → 4 units (Remaining: 4) → goes back to queue
Task2 → 4 units (Remaining: 1) → goes back
Task3 → 4 units (Remaining: 8) → goes back
Task4 → 4 units (Remaining: 2) → goes back
Task1 → 4 units (Finished)
Task2 → 1 unit (Finished)
Task3 → 4 units (Remaining: 4) → goes back
Task4 → 2 units (Finished)
Task3 → 4 units (Finished)

Use Cases:
OS CPU Scheduling (fair time sharing)
Network packet processing
Call center queue simulation

 */