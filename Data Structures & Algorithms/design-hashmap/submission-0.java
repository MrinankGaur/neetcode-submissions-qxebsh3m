class MyHashMap {
    ArrayList<Pair> list;
    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int check = contains(key);
        if(check == -1){
            list.add(new Pair(key,value));
            return;
        }
        list.get(check).value = value;
    }
    
    public int get(int key) {
        int check = contains(key);
        if(check == -1){
            return -1;
        }
        return list.get(check).value;
    }
    
    public void remove(int key) {
        int check = contains(key);
        if(check == -1){           
            return;
        }
        list.remove(check);
    }
    private int contains(int key){
        int i =0;
        for(Pair it:list){
            if(it.key == key) return i;
            i++;
        }
        return -1;
    }
}
class Pair{
    int key;
    int value;
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */