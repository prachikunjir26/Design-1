// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    
    LinkedList<Starting>[] map;
    public static int size = 1000;
    
    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int bucket = key % size;
        if(map[bucket] == null){
            map[bucket] = new LinkedList<Starting>();
            map[bucket].add(new Starting(key, value));
        }
        else{
            for(Starting i: map[bucket]){
                if(i.key == key){
                    i.val = value;
                    return;
                }
            }
            map[bucket].add(new Starting(key, value));
        }
    }
    
    public int get(int key) {
        int bucket = key % size;
        LinkedList<Starting> start = map[bucket];
        if(start == null) return -1;
        for(Starting i : start){
            if(i.key == key){
                return i.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = key % size;
        Starting toRemove = null;
        if(map[bucket] == null) return;
        else{
            for(Starting i: map[bucket]){
                if(i.key == key){
                    toRemove = i; 
                }
            }
            if(toRemove == null) return;
            map[bucket].remove(toRemove);
        }
    }
}

class Starting {
    
    public int key;
    public int val;
    
    public Starting(int key, int val){
        this.key = key;
        this.val = val;
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
