class Firstfit 
{
    static void firstfit(int blockSize[], int m, int processSize[], int n)
    {
        int allocation[] = new int[n];

        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }

        System.out.println("\nProcess no , \tprocess size , \tblock no");

        for (int i = 0; i < n; i++)
        {
            System.out.print(" " + (i + 1) + " " + processSize[i] + " ");
            if (allocation[i] != -1)
                System.out.println(allocation[i] + 1);
            else
                System.out.println("not allocated");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int blockSize[] = {100, 200, 300, 500};
        int processSize[] = {21, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;

        firstfit(blockSize, m, processSize, n);
    }
}
