class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, n = events.length;
        int count = 0;

        // Find the last day to process
        int lastDay = 0;
        for (int[] e : events) {
            lastDay = Math.max(lastDay, e[1]);
        }

        for (int day = 1; day <= lastDay; day++) {
            // Add events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove events that already expired
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend an event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solver = new Solution();

        System.out.print("Enter number of events: ");
        int n = sc.nextInt();
        int[][] events = new int[n][2];

        System.out.println("Enter each event's start and end day:");
        for (int i = 0; i < n; i++) {
            events[i][0] = sc.nextInt(); // start day
            events[i][1] = sc.nextInt(); // end day
        }

        int maxEvents = solver.maxEvents(events);
        System.out.println("Maximum number of events that can be attended: " + maxEvents);

        sc.close();
    }
}
