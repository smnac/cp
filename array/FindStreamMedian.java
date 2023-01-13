/*
295. Find Median from Data Stream
https://leetcode.com/problems/find-median-from-data-stream/


*/

class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || num<maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        
        if(maxHeap.size()>minHeap.size()+1)
            minHeap.offer(maxHeap.poll());
        else if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
            
        
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        
        return maxHeap.peek();
        
    }
}
