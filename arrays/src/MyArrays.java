import java.util.HashMap;
import java.util.Set;

public class MyArrays {
    public boolean arrayContains(int[] array, int value) {
        for (int v : array)
            if (v == value)
                return true;

        return false;
    }

    public int[] setToIntArray(Set<Integer> set) {
        int[] array = new int[set.size()];
        int index = 0;

        for (Integer i : set) {
            array[index++] = i;
        }

        return array;
    }

    // 349. Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1)
            return null;

        int[] small = nums1.length < nums2.length ? nums1 : nums2;
        int[] big = nums1.length < nums2.length ? nums2 : nums1;

        var map = new HashMap<Integer, Integer>();

        for (int number : small) {
            if (map.containsKey(number) == false) {
                if (arrayContains(big, number))
                    map.put(number, 0);
            }
        }

        return setToIntArray(map.keySet());
    }
}
