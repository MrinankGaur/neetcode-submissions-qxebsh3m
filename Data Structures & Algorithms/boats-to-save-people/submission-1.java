class Solution {
    public int numRescueBoats(int[] people, int limit) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int p : people) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        int count = 0;

        for (int it : people) {

            if (!map.containsKey(it))
                continue;

            // temporarily remove current person
            if (map.get(it) == 1)
                map.remove(it);
            else
                map.put(it, map.get(it) - 1);

            boolean paired = false;

            for (int j = limit - it; j >= 1; j--) {
                if (map.containsKey(j)) {
                    // pair with j
                    if (map.get(j) == 1)
                        map.remove(j);
                    else
                        map.put(j, map.get(j) - 1);

                    paired = true;
                    break;
                }
            }

            // current person always occupies a boat
            count++;
        }

        return count;
    }
}