package revision3;

import java.util.*;

public class MinRefuelStops {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int stops = 0;
        int i = 0;

        while (fuel < target) {

            // Add all reachable stations
            while (i < stations.length && stations[i][0] <= fuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }

            // If no fuel available
            if (maxHeap.isEmpty()) return -1;

            // Refuel with max fuel
            fuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }

    public static void main(String[] args) {

        int target = 100;
        int startFuel = 10;

        int[][] stations = {
                {10, 60},
                {20, 30},
                {30, 30},
                {60, 40}
        };

        int result = minRefuelStops(target, startFuel, stations);

        System.out.println("Minimum Stops: " + result);
    }
}
