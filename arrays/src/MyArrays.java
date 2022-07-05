import java.util.ArrayList;
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

    // 350. Intersection of Two Arrays II
    public int[] intersect(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        var list = new ArrayList<Integer>();

        for (int i : nums1) {
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }

        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size();i++)
            ret[i] = list.get(i);

        return ret;
    }
}
