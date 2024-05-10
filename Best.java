class Best {
    static void bestFit(int blockSize[], int m, int processSize[], int n) {
        int allocation[] = new int[n];

        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        for (int i = 0; i < n; i++) {
            // Find the best fit block for the current process
            int bestFitIndex = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestFitIndex == -1 || blockSize[j] < blockSize[bestFitIndex]) {
                        bestFitIndex = j;
                    }
                }
            }

            // If a suitable block is found, allocate the process to it
            if (bestFitIndex != -1) {
                allocation[i] = bestFitIndex;
                blockSize[bestFitIndex] -= processSize[i];
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
        int processSize[] = {90, 50 ,30,40};
        int m = blockSize.length;
        int n = processSize.length;

        bestFit(blockSize, m, processSize, n);
    }
}
