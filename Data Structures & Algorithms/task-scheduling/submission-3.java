class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch:tasks){
            map[ch-'A']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->(y.freq-x.freq));
        for(int i = 0;i<26;i++){
            if(map[i]!=0){
                char ch = (char)(i+'A');
                pq.offer(new Pair(ch,map[i]));
            }
        }
        int time = 0;
        Queue<Pair2> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            if(!pq.isEmpty()){
                Pair curr = pq.poll();
                char task = curr.task;
                int freq = curr.freq;
                if(freq-1!=0) q.offer(new Pair2(new Pair(task,freq-1),time+n));
            }
            if(!q.isEmpty()){
                if(q.peek().time==time){
                Pair2 temp = q.poll();
                pq.offer(temp.pair);
            }
            }
            time++;
        }
        return time;
    }
    
}
private class Pair2{
    Pair pair;
    int time;
    public Pair2(Pair pair,int time){
        this.pair = pair;
        this.time = time;
    }
}
private class Pair{
    char task;
    int freq;
    public Pair(char task,int freq){
        this.task = task;
        this.freq = freq;
    }
}
