class LRUCache {

    //queue 

    Map<Integer, CacheEntry> cache = new HashMap<>();
    CacheEntry head = new CacheEntry(-1, -1, null, null); //dummy head, so that we no need to check null
    
    CacheEntry tail = new CacheEntry(-1, -1, null, null); //dummy tail, so that we no need to check null
    
    int capacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        //nothing added, so link head and tail
        head.next = tail; 
        head.previous = null; // this is just for code readability
        tail.previous = head;
        tail.next = null;// this is just for code readability
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            CacheEntry toBeMovedtoTail = cache.get(key);
            remove(toBeMovedtoTail);
            addToTail(toBeMovedtoTail);
            return cache.get(key).value;
        }
        return -1;
    }
    
    

    public void put(int key, int value) {

        if(!cache.containsKey(key)) {
            if(cache.size() < capacity) {
                CacheEntry addedToTail = addToTail(key, value);
                cache.put(key, addedToTail);
            } else {
                CacheEntry removedHead = removeHead();
                cache.remove(removedHead.key);
                CacheEntry newOne = addToTail(key, value);
                cache.put(newOne.key, newOne);
            }
        }
        else {
            if(cache.size() < capacity) {
                CacheEntry tobeRemoved = cache.get(key);
                remove(tobeRemoved);
                cache.remove(tobeRemoved.key);
                CacheEntry newEntry = addToTail(key, value);  
                cache.put(newEntry.key, newEntry);

            } else {
                CacheEntry tobeRemoved = cache.get(key);
                remove(tobeRemoved);
                cache.remove(tobeRemoved.key);
                CacheEntry newEntry = addToTail(key, value);  
                cache.put(newEntry.key, newEntry);
            }
        } 
        return;
        
    }

    private CacheEntry addToTail(int key, int value) {
        CacheEntry lastEntry = tail.previous;
        CacheEntry newEntry = new CacheEntry(key, value, lastEntry, tail);
        tail.previous = newEntry;
         lastEntry.next = newEntry;
        return newEntry;
    }

    private void addToTail(CacheEntry entry) {
        CacheEntry lastEntry = tail.previous;
        entry.previous = lastEntry;
        entry.next = tail;
        tail.previous = entry;
        lastEntry.next = entry;
    }


    private void remove(CacheEntry entry) {
        CacheEntry curEntryNext  = entry.next;
        CacheEntry curEntryPrevious  = entry.previous;
        curEntryPrevious.next = curEntryNext;
        curEntryNext.previous = curEntryPrevious;
    }

    private CacheEntry removeHead() {
        CacheEntry curHeadPointingTo = head.next;
        curHeadPointingTo.next.previous = head;
        head.next = curHeadPointingTo.next;
        return curHeadPointingTo;
    }


}

class CacheEntry {
    public int key;
    public int value;
    public CacheEntry previous;
    public CacheEntry next;
    
    public CacheEntry(int key, int value, CacheEntry previous, CacheEntry next) {
        this.key = key;
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}


