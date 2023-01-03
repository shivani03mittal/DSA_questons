//package GFG;
//
//import java.util.ArrayList;
//
//public class TopView_BT {
//    class Solution
//    {
//        //Function to return a list of nodes visible from the top view
//        //from left to right in Binary Tree.
//        static ArrayList<Integer> topView(Node root)
//        {
//            ArrayList<Integer> arr= new ArrayList<>();
//            if(root == null)
//                return arr;
//            Queue<Pair> q = new LinkedList<Pair>();
//            Map<Integer,Integer> map = new TreeMap<>();
//            q.add(new Pair(0,root));
//            while( !q.isEmpty())
//            {
//                Pair p = q.poll();
//                int level = p.level;
//                Node nn = p.node;
//                // check if that level value is in map
//                if(!map.containsKey(level))
//                    map.put(level,nn.data);
//
//                // elese skip
//                // check for level order left and right
//                if(nn.left!= null)
//                {
//                    q.add(new Pair(level-1, nn.left));
//                }
//                if(nn.right!= null)
//                {
//                    q.add(new Pair(level+1,nn.right));
//                }
//
//
//            }
//
//            // trvaerse the map
//            for(Map.Entry<Integer, Integer> entry: map.entrySet())
//            {
//                arr.add(entry.getValue());
//            }
//            // add your code
//
//            return arr;
//        }
//
//        static class Pair{
//            int level;
//            Node node;
//
//            public Pair(int level, Node node)
//            {
//                this.level= level;
//                this.node = node;
//            }
//
//        }
//    }
//}
