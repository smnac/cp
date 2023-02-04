/*
https://leetcode.com/problems/online-stock-span/
901. Online Stock Span

*/

class StockSpanner {
    Stack<int[]> s;
    int index;
    public StockSpanner() {
        s=new Stack<>();
        index=-1;
    }
    
    public int next(int price) {
        
        index++;
        while(!s.isEmpty() && s.peek()[1]<=price)
            s.pop();
        if(s.isEmpty())
        {
            s.push(new int[]{index,price});
            return index+1;
        }
        int result = s.peek()[0];
        s.push(new int[]{index,price});
        return index-result;
        
    }
}
