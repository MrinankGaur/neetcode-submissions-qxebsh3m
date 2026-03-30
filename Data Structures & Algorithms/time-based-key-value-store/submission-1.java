class TimeMap {
    private class tuple{
        String key; 
        String value;
        int timestamp;
        public tuple(String key, String value,int timestamp){
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    private ArrayList<tuple> list;

    public TimeMap() {
        list = new ArrayList<>();
    }
    
    public void set(String key, String value, int timestamp) {
        list.add(new tuple(key,value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        for(tuple it:list){
            if(it.key.equals(key)){
                if(it.timestamp<=timestamp){
                    res = it.value;
                }
            }
        }
        return res;
        
    }
}
