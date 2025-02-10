import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = new int[]{1,4,3,2};
        int h = 9;

        KokoEatingBananas k = new KokoEatingBananas();

        System.out.println(k.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            // 1 + 3 / 2 = 2
            // 1 + 2 + 2 + 1 = 6 ч
            int k = l + (r - l) / 2;
            long time = 0;
            for (int p : piles) {
                time += (long) Math.ceil((double) p / k);
            }

            if (time <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
