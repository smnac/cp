package cp.interview;


import java.util.ArrayList;
import java.util.List;

class Room
{
    int id;
    int x,y;
    List<Room> rooms;
    boolean isConnectedLobby;
    public Room(int id1,int x1,int y1,List<Room> r,boolean iscl)
    {
        id=id1;
        x=x1;
        y=y1;
        rooms=r;
        isConnectedLobby=iscl;

    }
}


public class Museum {

    public static void main(String[] args) {
      
        Room r1 = new Room(1, 0, 0, null, true);
        List<Room> rl = new ArrayList<>();
        rl.add(r1);
        Room r2 = new Room(2,0,1,rl,false);

        Room r3 = new Room(3,0,2,rl,false);
        Room r4 = new Room(4,0,3,rl,false);
        findPath()



        
    }
    boolean[] visited;
    
    public List<Integer> findPath(Room room)
    {
        List<Integer> path=new ArrayList<>();
        boolean isFound=DFS(room,path);
        return path;
        

    }
    
    public boolean DFS(Room room, List<Integer> path)
    {


       if(room!=null && room.isConnectedLobby)
       {  path.add(room.id);
           return true;
       }

           visited[room.id]=true;
           path.add(room.id); // 1,2,3 => 
           for(Room r:room.rooms)
           {
               if(!visited[r.id]){
               if(DFS(r,path))
               return true;
               path.remove(path.size()-1);

           }

    }

    return false;
}
}

    /* 5 Rooms

    1->2,3
    2->3,4,1
    4-> 2,5, L
    3->2,1,5,L
    5->4,3

    //input is 1
    */

    
    

    


