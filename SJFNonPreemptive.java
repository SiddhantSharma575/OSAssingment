import java.util.Scanner;

public class SJFNonPreemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Process");
        int n = sc.nextInt();
        int[] pid = new int[n];
        int[] AT = new int[n];
        int[] BT = new int[n];
        int[] CT = new int[n];
        int[] TT = new int[n];
        int[] WT = new int[n];
        int[] f = new int[n];  //flag to check process completed or not
        float avgwt = 0;
        float avgtt = 0;
        for (int i=0; i<n; i++){
            System.out.println("Enter Processes " + (i+1) + " arrival time: ");
            AT[i] = sc.nextInt();
            System.out.println("Enter Processes " + (i+1) + " Burst Time");
            BT[i] = sc.nextInt();
            pid[i] = i+1;
            f[i] = 0;
        }

        calcAll(AT,BT,CT,TT,WT,f);

    }

    private static void calcAll(int[] at, int[] bt, int[] ct, int[] tt, int[] wt, int[] f) {
        int st = 0 , tot = 0;
        boolean a = true;

    }
}
