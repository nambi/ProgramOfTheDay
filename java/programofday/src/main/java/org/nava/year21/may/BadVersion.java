package org.nava.year21.may;

public class BadVersion {

    private int badVersion;

    public BadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int v) {
        return (v >= this.badVersion);
    }

    //divide and conquer, since versions are sequential, its sorted, we can just do binary search to find out the version
    // which will result in O(log n) instead of O (n);

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //Brute force O(n)
    int firstBadVersion(int noOfVersion, int currentVersion) {

        boolean isBad = isBadVersion(currentVersion);
        if (noOfVersion == 1) {
            if (isBad) {
                return noOfVersion;
            } else {
                return -1;
            }
        }
        if (isBad) {
            //bad should be smaller
            return firstBadVersion(noOfVersion, --currentVersion);
        } else {
            return currentVersion + 1;
        }

    }

    static boolean test2() {
        BadVersion bv = new BadVersion(1);
        int output = bv.firstBadVersion(1, 1);
        boolean result = (output == 1);
        System.out.println("test2 result " + result);
        return false;
    }

    static boolean test1() {
        BadVersion bv = new BadVersion(4);
        int output = bv.firstBadVersion(7);
        boolean result = (output == 4);
        System.out.println("test1 result " + result);
        return false;
    }

    public static void main(String[] args) {

        test1();
        test2();
    }

}
