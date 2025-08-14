package Queue.Deque;

/*
Problem Statement

You are given a list of tasks (with task IDs) and you need to process them using a Deque in a scheduling manner.
    Tasks can be added either at the front or rear.
    Processing is always done from the front.
    This simulates a scheduling system where urgent tasks go to the front and normal tasks to the rear.

Example

Input:

Operations:
addRear(A)
addRear(B)
addFront(UrgentTask)
process()
addRear(C)
process()


Output:

Processing UrgentTask
Processing A

Approach

Use Deque to store tasks.
Urgent → addFirst()
Normal → addLast()
Processing → removeFirst()

 */


import java.util.Deque;
import java.util.LinkedList;

public class TaskSchedulerDeque {
    public static void main(String[] args) {
        Deque<String> taskQueue = new LinkedList<>();

        // Add tasks
        taskQueue.addLast("Task-A");       // normal
        taskQueue.addLast("Task-B");       // normal
        taskQueue.addFirst("Urgent-Task"); // urgent

        // Process tasks
        processTask(taskQueue);
        taskQueue.addLast("Task-C");
        processTask(taskQueue);
        processTask(taskQueue);
    }

    public static void processTask(Deque<String> dq) {
        if (dq.isEmpty()) {
            System.out.println("No tasks to process!");
        } else {
            String task = dq.removeFirst();
            System.out.println("Processing: " + task);
        }
    }
}

/*
Dry Run
Start: []
AddLast(Task-A) → [Task-A]
AddLast(Task-B) → [Task-A, Task-B]
AddFirst(Urgent-Task) → [Urgent-Task, Task-A, Task-B]
process() → removes Urgent-Task → prints "Processing: Urgent-Task"
AddLast(Task-C) → [Task-A, Task-B, Task-C]
process() → removes Task-A → prints "Processing: Task-A"
process() → removes Task-B → prints "Processing: Task-B"

 */