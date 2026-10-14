// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         HashMap<Integer, List<Integer>> map = new HashMap<>();
//         for(int i = 1;i<=n;i++){
//             map.put(i,new ArrayList<>());
//         }
//         for(int[] trus: trust){
//             int a = trus[0];
//             int b = trus[1];
//             map.get(a).add(b);
//         }
//         for(int i = 1;i<=n;i++){
//             List<Integer> list = map.get(i);
//             if(list.isEmpty()){
//                 int check = 0;
//                 for(int j = 1;j<=n;j++){
//                     if(j==i) continue;
//                     if(map.get(j).contains(i)) check++;
//                 }
//                 if(check==n-1) return i;
//             }
//         }
//         return -1;
//     }
// }
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n + 1];
        int[] outgoing = new int[n + 1];

        for (int[] t : trust) {
            outgoing[t[0]]++;
            incoming[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outgoing[i] == 0 && incoming[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}