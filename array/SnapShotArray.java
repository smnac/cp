package cp.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SnapshotArray {
    
    List<TreeMap<Integer,Integer>> list;
    int id;

    public SnapshotArray(int length) {
        list= new ArrayList<>();
        for(int i=0;i<length;i++)
        {
            list.add(new TreeMap<>());
            list.get(i).put(0,0);
            
        }
        id=0;
    }
    
    public void set(int index, int val) {
        list.get(index).put(id,val);
    }
    
    public int snap() {
        return id++;
        
    }
    
    public int get(int index, int snap_id) {
        //Try to get the floorEntry if no entry then we have 0 snap as default
        
        return list.get(index).floorEntry(snap_id).getValue();
        
    }
}

