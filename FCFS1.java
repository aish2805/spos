import java.util.Scanner;

public class FCFS1 {
    public static void main(String args[]) {
        int i, no_p, burst_time[], TT[], WT[], avg_wait = 0, avg_TT = 0;
        burst_time = new int[50];
        TT = new int[50];
        WT = new int[50];
        WT[0] = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        no_p = s.nextInt();
        System.out.println("Enter the burst time for processes:");
        for (i = 0; i < no_p; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            burst_time[i] = s.nextInt();
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
