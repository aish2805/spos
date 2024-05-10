class Next {
    static void nextFit(int blockSize[], int m, int processSize[], int n) {
        int allocation[] = new int[n];

        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // Variable to store the index of the last block where a process was allocated
        int lastAllocated = 0;

        for (int i = 0; i < n; i++) {
            // Start searching for a suitable block from the last allocated block
            for (int j = lastAllocated; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    // Allocate the process to this block
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    lastAllocated = j; // Update the lastAllocated index
                    break; // Break once allocation is done
                }
            }
        }

        // Print allocation details
        System.out.println("\nProcess no , \tprocess size , \tblock no");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + " " + processSize[i] + " ");
            if (allocation[i] != -1)
                System.out.println(allocation[i] + 1);
            else
                System.out.println("not allocated");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int blockSize[] = {100, 200, 300, 500};
        int processSize[] = {21, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;

        nextFit(blockSize, m, processSize, n);
    }
}

