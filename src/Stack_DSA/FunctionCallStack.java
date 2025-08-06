package Stack_DSA;

// Processing Function Calls – Demonstrating Call Stack with Recursion

public class FunctionCallStack {
    public static void printCountdown(int n) {
        if (n == 0) {
            System.out.println("Blastoff!");
            return;
        }
        System.out.println("Calling: " + n);
        printCountdown(n - 1);
        System.out.println("Returning from: " + n);
    }

    public static void main(String[] args) {
        printCountdown(3);
    }
}
