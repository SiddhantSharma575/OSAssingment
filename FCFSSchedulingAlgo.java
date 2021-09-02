import java.util.Scanner;

public class FCFSSchedulingAlgo {
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
        float avgwt = 0;
        float avgtt = 0;
        for (int i=0; i<n; i++){
            System.out.println("Enter Processes " + (i+1) + " arrival time: ");
            AT[i] = sc.nextInt();
            System.out.println("Enter Processes " + (i+1) + " Burst Time");
            BT[i] = sc.nextInt();
            pid[i] = i+1;
        }
        SortAccordingToArrival(pid,AT,BT,n);
        findCompletionTurtWaitTime(AT,BT,CT,TT,WT,n);

        System.out.println("\npid  Arrival    Brust     Complete    Turn    Waiting");
        for (int i=0; i<n; i++){
            System.out.println(pid[i]+"    " + AT[i] + "    " + BT[i] + "   " + CT[i] + "   " + TT[i] + "   " + WT[i]);
        }
        sc.close();
        for (int i=0; i<n; i++){
            avgtt += TT[i];
            avgwt += WT[i];
        }
        System.out.println("Average TurnArround Time : " + (avgtt/n));
        System.out.println("Average TurnArround Time : " + (avgwt/n));
    }

    private static void findCompletionTurtWaitTime(int[] at, int[] bt, int[] ct, int[] tt, int[] wt, int n) {
        for (int i=0; i<n; i++){
            if (i == 0){
                ct[i] = at[i] + bt[i];
            }else{
                if (at[i] > ct[i-1]){
                    ct[i] = at[i] + bt[i];
                }else {
                    ct[i] = ct[i-1] + bt[i];
                }
            }
            tt[i] = ct[i] - at[i];
            wt[i] = tt[i] - bt[i];
        }
    }

    private static void SortAccordingToArrival(int[] pid, int[] at, int[] bt,int n){
        int temp;
        for (int i=0; i<n; i++){
            for (int j=0; j<n-(i+1); j++){
                if (at[j] > at[j+1]){
                 temp = at[j];
                 at[j] = at[j+1];
                 at[j+1] = temp;

                 temp = bt[j];
                 bt[j] = bt[j+1];
                 bt[j+1] = temp;

                 temp = pid[j];
                 pid[j] = pid[j+1];
                 pid[j+1] = temp;
                }
            }
        }
    }

}
