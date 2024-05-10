import java.util.Scanner;

public class PriorityScheduling {
    public static void main(String args[]) {
        int i, no_p, burst_time[], priority[], TT[], WT[], avg_wait = 0, avg_TT = 0;
        burst_time = new int[50];
        priority = new int[50];
        TT = new int[50];
        WT = new int[50];
        WT[0] = 0;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the number of processes:");
        no_p = s.nextInt();
        
        System.out.println("Enter the burst time and priority for processes:");
        for (i = 0; i < no_p; i++) {
            System.out.print("Process " + (i + 1) + " Burst Time: ");
            burst_time[i] = s.nextInt();
            System.out.print("Process " + (i + 1) + " Priority: ");
            priority[i] = s.nextInt();
        }
        
        // Sort processes based on priority
        for (i = 0; i < no_p - 1; i++) {
            for (int j = 0; j < no_p - i - 1; j++) {
                if (priority[j] > priority[j + 1]) {
                    int temp = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = temp;
                    temp = burst_time[j];
                    burst_time[j] = burst_time[j + 1];
                    burst_time[j + 1] = temp;
                }
            }
        }
        
        for (i = 1; i < no_p; i++) {
            WT[i] = WT[i - 1] + burst_time[i - 1];
            avg_wait += WT[i];
        }
        
        for (i = 0; i < no_p; i++) {
            TT[i] = WT[i] + burst_time[i];
            avg_TT += TT[i];
        }
        
        avg_wait /= no_p;
        avg_TT /= no_p;
        
        System.out.println("_________________________________________________________");
        System.out.println("Processes\tBurst Time\tWaiting Time\tTurnaround Time");
        System.out.println("_________________________________________________________");
        for (i = 0; i < no_p; i++) {
            System.out.println("P" + (i + 1) + "\t\t" + burst_time[i] + "\t\t" + WT[i] + "\t\t" + TT[i]);
        }
        System.out.println("_________________________________________________________");
        System.out.println("\nAverage Waiting Time: " + avg_wait);
        System.out.println("Average Turnaround Time: " + avg_TT + "\n");
    }
}
