/*
Similar questions on leetcode
1552. Magnetic Force Between Two Balls
1870. Minimum Speed to Arrive on Time
875.  Koko Eating Bananas
1011. Capacity To Ship Packages Within D Days
1283. Find the Smallest Divisor Given a Threshold
1482. Minimum Number of Days to Make m Bouquets
2064. Minimized Maximum of Products Distributed to Any Store
1231. Divide Chocolate
774.  Minimize Max Distance to Gas Station
410.  Split Array Largest Sum

*/
import java.util.*;
class Solution {
    static boolean isPossible(int a[], int n, int cows, int minDist) {
        int cntCows = 1;
        int lastPlacedCow = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = a[i];
            }
        }
        if (cntCows >= cows) return true;
        return false;
    }
    public static void main(String args[]) {
        int n = 5, cows = 3;
        int a[]={1,2,8,4,9};
        Arrays.sort(a);

        int low = 1, high = a[n - 1] - a[0];

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (isPossible(a, n, cows, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("The largest minimum distance is " + high);


    }
}
