package twentyfive.march.twentytwo;

public class TownJudge {
    public static void main(String[] args) {
        int[][] tr = {{1, 2}};
        findJudge(2, tr);
    }

    public static int findJudge(int n, int[][] trust) {

        int[] trustCount = new int[n];
        boolean[] doesTrust = new boolean[n];

        for (int[] ints : trust) {
            int trusts = ints[0];
            int trusted = ints[1];
            trustCount[trusted - 1]++;
            doesTrust[trusts - 1]=true;
        }

        for (int i = 0; i <= n - 1; i++) {

            if (trustCount[i] == n - 1 && !doesTrust[i]) {
                return i + 1;
            }
        }
        return -1;
    }

}
