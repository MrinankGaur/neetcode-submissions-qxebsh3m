class MyHashSet {
    int[] arr;
    int n = 0;
    public MyHashSet() {
        arr = new int[10];
        Arrays.fill(arr,-1);
    }
    
    public void add(int key) {
        if(contains(key)) return;
        if(n<arr.length)
            arr[n++] = key;
        else{
            increaseSize();
            arr[n++] = key;
        }
    }
    public void remove(int key) {
        for(int i =0;i<n;i++){
            if(arr[i]==key) arr[i] = -1;
        }
    }
    
    public boolean contains(int key) {
        for(int it:arr){
            if(it==key) return true;
        }
        return false;
    }
    public void increaseSize(){
        int[] temp = new int[2*n];
        for(int i = 0;i<2*n;i++){
            if(i<n) temp[i]=arr[i];
            else temp[i] = -1;
        }
        arr = temp;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */