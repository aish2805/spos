import java.util.*;

public class LRUPageReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of frames: ");
        int numFrames = scanner.nextInt();

        System.out.print("Enter the number of pages: ");
        int numPages = scanner.nextInt();

        System.out.print("Enter the page reference string: ");
        int[] pageString = new int[numPages];
        for (int i = 0; i < numPages; i++) {
            pageString[i] = scanner.nextInt();
        }

        LinkedList<Integer> frames = new LinkedList<>();
        int pageFaults = 0;

        System.out.println("\nPage Replacement Steps:");
        for (int i = 0; i < numPages; i++) {
            int currentPage = pageString[i];
            System.out.println("\nPage " + currentPage + " requested");

            if (!frames.contains(currentPage)) {
                if (frames.size() == numFrames) {
                    frames.removeFirst(); // Remove the least recently used page
                }
                frames.addLast(currentPage); // Add the current page to the end of the list
                pageFaults++;
            } else {
                frames.remove((Integer) currentPage); // Remove the existing page
                frames.addLast(currentPage); // Move the page to the end to indicate it was recently used
            }

            System.out.print("Current frames: ");
            for (int page : frames) {
                System.out.print(page + " ");
            }
            System.out.println();
        }

        System.out.println("\nTotal page faults: " + pageFaults);
    }
}
