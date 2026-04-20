class TimeMap {

    private class tuple{
        String value;
        int timestamp;

        public tuple(String value,int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, ArrayList<tuple>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new tuple(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        ArrayList<tuple> list = map.get(key);

        int s = 0;
        int e = list.size()-1;
        String res = "";

        while(s <= e){
            int m = s + (e-s)/2;

            if(list.get(m).timestamp <= timestamp){
                res = list.get(m).value;
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }

        return res;
    }
}