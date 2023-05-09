import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Juspay {
    static class Node{
        String str;
        List<Node> links;
        Node parent;
        int locked_ancCount, locked_decCount, uid;
        boolean isLocked;

        public Node(String x, Node parent){
            str= x;
            this.parent = parent;
            locked_ancCount =0;
            locked_decCount =0;
            uid =0;
            isLocked = false;
            links = new ArrayList<Node>();
        }

        // functiom to add edges/ links of tree among nodes
        public void addEdge(List<String> list, Node parent){
            for( String s : list){
                links.add(new Node(s, parent));
            }
        }
    }

    // function to build tree
    public static Node buildNarrayTree(Node root, int m, List<String> s){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count =1;
        while( ! queue.isEmpty()){
            Node curr = queue.remove();
            if(count >= s.size()) continue;

            List<String> temp = new ArrayList<>();
            for(int i = count;i <count +m;i++){
                temp.add(s.get(i));
            }

            curr.addEdge(temp, curr);
            count += m;

            // add all childs to queue
            for(Node k: curr.links){
                queue.add(k);
            }
        }
        return root;
    }

    // function to print tree
    public static void printTree( Node root){
        System.out.println("Parent node: " + root.str);
        System.out.println("Child: ");
        for(Node k : root.links){
            System.out.println(k.str+ "locked ancs: "+ k.locked_ancCount + "locked desc: "+ k.locked_decCount+ "is Locked: "+ k.isLocked+ "user id :"+ k.uid);
        }

        System.out.println();
        //print all children
        for(Node child : root.links)
            printTree(child);
    }

    // class for that Narary tree
    static class Ntree{
        private Node root;
//        private HashMap<String, Node> status = new HashMap<String, Node>();
    private ConcurrentHashMap<String, Node> status = new ConcurrentHashMap<String, Node>();
        // to prevent trversal of entire tree again and again to get str and the coonet node has an hasmap to make fetching eaier since each string is unique , having a n array tree in this sense
        public Ntree(Node root){
            this.root = root;
        }

        public Node getRootNode(){
            return root;
        }

        // fill the status map
        public void fillStatus(Node root){
            if(root == null) return;
            status.put(root.str, root);
            // add status for all child
            for(Node child : root.links){
                fillStatus(child);
            }
        }

        // need to have a function in order to tell if ancsestors nodes are locked to the descendents

//        public void lockedCountsToDescendends(Node root, int value){
//            for(Node child: root.links){
//                child.locked_ancCount += value;
//                // send to their child too
//                lockedCountsToDescendends(child, value);
//            }
//        }

        public boolean check_ansc(Node root) {
            Node t = root.parent;
            while (t != null) {
                if (t.isLocked) {
//                    t.locked_ancCount +=1;
                    return false;
                }
                t = t.parent;
            }
            return true;
        }
        public boolean validDecendants(Node root, int id, List<Node> list){
            if(root.isLocked){
                if(root.uid != id) {
                    return false;
                }

                list.add(root);
            }
            if(root.locked_decCount ==0 ){
                return true;
            }

            boolean ans = true;
            for(Node child : root.links){
                ans &= validDecendants(child , id, list);
                if(ans == false) return false;
            }

            return ans;
        }
        String currProcessingNodename = "";
        String currProParent ="";

        // lock function
        //exclusive access on subtree rooted at x,
        //lock(a,yid)-->fail if a is desc of x
        //lock(b,yuid)-->fail if x is dec of B
        //locked fails if alreday locked

//        public Node getNodetolock(String str){
//            Node nn = status.get(str);
//            if(currProcessingNodename == "" && currProcessingNodename == "") {
//                currProcessingNodename = nn.str;
//                currProParent = nn.parent.str;
//            }
//            else {
//                if(currProcessingNodename.equals(nn.str) || currProcessingNodename.equals(nn.parent.str) || currProParent.equals(nn.str)) return null;
//            }
//
//            return nn;
//        }
        public boolean lock(String str, int id){
            Node nn = status.get(str);
//            Node nn = getNodetolock(str);
            if(nn== null ) return false;
            if(nn.isLocked) return false;

            // if any asc locked then false also if any desc locked then false
//            if(nn.locked_ancCount !=0 ) return false;
            if(!check_ansc(nn)) return false;
            if(nn.locked_decCount != 0) return false;

            Node curr = nn.parent;
            while(curr != null){
                curr.locked_decCount++;
                curr= curr.parent;
//

            }

//            lockedCountsToDescendends(nn, 1);
            nn.isLocked =true;
            nn.uid = id;

//            thread_lock =0;
//            currProcessingNodename ="";
//            currProParent ="";
            return true;
        }

        public boolean unlock(String str, int id){
            Node nn = status.get(str);
            // if not locked then false
            // if locked by diff id then false
            if( !nn.isLocked) return false;
            if(nn.isLocked && nn.uid != id) return false;

            Node curr = nn.parent;
            while(curr != null){
                curr.locked_decCount --;
                curr = curr.parent;

            }
//            lockedCountsToDescendends(nn, -1);
            nn.isLocked= false;
            return true;
        }

        // function to upgrade
        public boolean upgrade(String str, int id){
            Node nn = status.get(str);
            //if locked -> false
            //if locked desc ==0 -> false
            //if any ancs locked -> false

            if(nn.isLocked) return false;
            if(nn.locked_decCount ==0 ) return false;
            if(!check_ansc(nn)) return false;
//            if(nn.locked_ancCount !=0 )return false;

            ArrayList<Node> arr = new ArrayList<Node>();
            if(validDecendants(nn, id, arr)){
                for(Node k: arr){
                    unlock(k.str, id);
                }

            }
            else{
                return false;
            }
            lock(str, id);
            return true;
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner scn =new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int q = scn.nextInt();

        ArrayList<String> str_array= new ArrayList<String>(n);
        for(int i =0 ;i< n;i++){
            str_array.add(scn.next());
        }

        Node root = new Node(str_array.get(0), null);
        root = buildNarrayTree(root, m ,str_array);

        // printTree(root);

        Ntree tree = new Ntree(root);
        tree.fillStatus(tree.getRootNode());

        int options, user_id;
        String nodename;

        for(int i=0;i< q;i++){
            options= scn.nextInt();
            nodename = scn.next();
            user_id= scn.nextInt();

//switch cases for 1,2,3:
//1: for lock node
//2: for unlocking node
// 3 : for upgrading lock on node

            switch(options){
                case 1: if(tree.lock(nodename, user_id)){
                    System.out.println("true");
                } else{
                    System.out.println("false");
                }
                    break;
                case 2: if(tree.unlock(nodename, user_id)){
                    System.out.println("true");

                }else{
                    System.out.println("false");
                }
                    break;
                case 3: if(tree.upgrade(nodename, user_id)){
                    System.out.println("true");
                } else{
                    System.out.println("false");
                }

                    break;
            }
        }
    }
}
