import java.util.*;

public class LIFOPageReplacement {
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

        int[] frames = new int[numFrames];
        Arrays.fill(frames, -1); // Initialize frames with -1 to indicate empty

        int pageFaults = 0;
        int currentIndex = numFrames - 1; // Start from the last frame

        System.out.println("\nPage Replacement Steps:");
        for (int i = 0; i < numPages; i++) {
            int currentPage = pageString[i];
            System.out.println("\nPage " + currentPage + " requested");

            boolean pageFound = false;
            for (int j = 0; j < numFrames; j++) {
                if (frames[j] == currentPage) {
                    pageFound = true;
                    break;
                }
            }

            if (!pageFound) {
                System.out.println("Page " + currentPage + " is not in frames, page fault occurred");

                frames[currentIndex] = currentPage;
                currentIndex = (currentIndex - 1 + numFrames) % numFrames; // Move to the previous frame

                pageFaults++;
            } else {
                System.out.println("Page " + currentPage + " is already in frames");
            }

            System.out.print("Current frames: ");
            for (int j = 0; j < numFrames; j++) {
                System.out.print(frames[j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nTotal page faults: " + pageFaults);
    }
}
