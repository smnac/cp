import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 * */
 

public class FreqElementInTree {
	
int maxCount = 1;
    
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> hm = new HashMap<>();
        helper(root, hm);
        
        int[] result = new int[hm.size()];
        int index = 0;
        for(Integer key: hm.keySet()){
            if(hm.get(key) == maxCount){
                result[index++] = key;
            }
        }
        
        return Arrays.copyOf(result, index);
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map){
        if(root == null) {
            return;
        } else if(map.containsKey(root.val)) {
            int count = map.get(root.val)+1;
            map.put(root.val, count);
            maxCount = Math.max(maxCount, count);
        } else {
            map.put(root.val, 1);
        }
        
        helper(root.left, map);
        helper(root.right, map);
    }


}
