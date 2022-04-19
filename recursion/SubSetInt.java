import java.util.ArrayList;
import java.util.List;

public class SubSetInt {

	public static void main(String[] args) {
		int[] num= {1,2,3};
		
		generateSubSet(num,0,new ArrayList<Integer>());
		System.out.println(generateSubSetRet(num,0,new ArrayList<Integer>()).toString());
		

	}

	
	
	private static void generateSubSet(int[] num, int index,ArrayList<Integer> ans) {
		
		 if(index==num.length)
		 {
			
			 System.out.println(ans);
			
			 return;
		 }
		 int item=num[index];
		 
		 ans.add(item);
		 generateSubSet(num,index+1,ans);
		 ans.remove(ans.size()-1); //very important backtrack
		 generateSubSet(num,index+1,ans);
		
			 
		
	}
	
	private static List<List<Integer>> generateSubSetRet(int[] num, int index,ArrayList<Integer> ans) {
		
		 if(index==num.length)
		 {
			 List<List<Integer>> res = new ArrayList<>();
			 res.add(new ArrayList<>(ans));
			 return res;
		 }
		 int item=num[index];
		 
		 ans.add(item);
		 List<List<Integer>> left=generateSubSetRet(num,index+1,ans);
		 ans.remove(ans.size()-1); //very important backtrack
		 List<List<Integer>> right=generateSubSetRet(num,index+1,ans);
		 left.addAll(right);
		 return left;
		
			 
		
	}
	

}
