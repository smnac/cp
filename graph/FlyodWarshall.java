/*

https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-floyd-warshall

*/

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
       
       for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==-1)
                    matrix[i][j]=(int)1e9;
            }
        
        for(int via=0;via<n;via++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }
        
         for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==(int)1e9)
                    matrix[i][j]=-1;
            }
    }
}


/*

https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

*/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    dist[i][j]=0;
                else
                    dist[i][j]=(int)(1e9);
            }
        }
        
        int m=edges.length;
        for(int i=0;i<m;i++){
            dist[edges[i][0]][edges[i][1]]=edges[i][2];
            dist[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        
        for(int via=0;via<n;via++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }
        
        int citycount=n+1;
        int city=0;
         for(int i=0;i<n;i++)
        {
             int count=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=distanceThreshold)
                    count++;
            }
             
             if(count<=citycount){
                 citycount=count;
                 city=i;
                     
                 }
         }
        
        return city;
        
        
    }
}
