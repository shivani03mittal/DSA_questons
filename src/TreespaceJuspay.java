import java.util.*;

public class TreespaceJuspay {
    public static class Node {
        public String v;
        public List<Node> links;
        public Node parent;
        public int anc_locked, dec_locked, uid;
        public boolean isLocked;

        public Node(String x, Node p) {
            v = x;
            parent = p;
            anc_locked = 0;
            dec_locked = 0;
            uid = 0;
            isLocked = false;
        }

        public static void addLinks(List<String> l, Node p) {
            List<Node> links = new ArrayList<Node>();
            for (String i : l) {
                links.add(new Node(i, p));
            }
        }
    }




    public void printTree(Node r){
        System.out.println("Parent: " + r.v);
        System.out.println("Child: ");
        for(Node k : r.links){
            System.out.println(k.v + " anc_locked: " + k.anc_locked
                    + " dec_locked:" + k.dec_locked + " isLocked:"
                    + k.isLocked + " uid:" + k.uid);
        }
        System.out.println();
        for(Node k : r.links){
            printTree(k);
        }
    }




    public static Node buildTree(Node root, int m, List<String> s){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int st = 1;
        while(!q.isEmpty()){
            Node r = q.poll();
            if(st >= s.size()) continue;
            List<String> temp = new ArrayList<>();
            for(int i = st; i < st + m; i++)
                temp.add(s.get(i));
            r.addLinks(temp,r);
            st += m;
            for(Node k: r.links)
                q.add(k);
        }
        return root;
    }


   static class Tree{
        private Node root;
        private HashMap<String, Node> vton;

        public Tree(Node r){ root = r;}

        public Node getRoot() { return root; }

        public void fillVtoN(Node r){
            if(r == null) return;
            vton.put(r.v, r);
            for(Node k : r.links)
                fillVtoN(k);
        }

        public void informDecendants(Node r, int val){
            for(Node k: r.links){
                k.anc_locked += val;
                informDecendants(k,val);
            }

        }

        public boolean verifyDecendants(Node r, int id, ArrayList<Node> v){
            if(r.isLocked){
                if(r.uid != id) return false;
                v.add(r);
            }
            if(r.dec_locked == 0) return true;

            boolean ans = true;
            for(Node k: r.links){
                ans &= verifyDecendants(k,id,v);
                if(ans == false) return false;
            }
            return ans;
        }

        public boolean lock(String v, int id){
            Node t = vton.get(v);
            if(t.isLocked) return false;

            if(t.anc_locked != 0) return false;
            if(t.dec_locked != 0) return false;

            Node cur = t.parent;
            while(cur != null){
                cur.dec_locked++;
                cur = cur.parent;
            }
            informDecendants(t,1);
            t.isLocked = true;
            t.uid = id;
            return true;
        }

        public boolean unlock(String v, int id){
            Node t = vton.get(v);
            if(!t.isLocked) return false;
            if(t.isLocked && t.uid != id) return false;

            Node cur = t.parent;
            while(cur != null){
                cur.dec_locked--;
                cur = cur.parent;
            }
            informDecendants(t,-1);
            t.isLocked = false;
            return true;
        }

        public boolean upgrade(String v, int id){
            Node t = vton.get(v);
            if(t.isLocked) return false;

            if(t.anc_locked != 0) return false;
            if(t.dec_locked == 0) return false;

            ArrayList<Node> vec = new ArrayList<Node>();
            if(verifyDecendants(t,id,vec)){
                for(Node k : vec){
                    unlock(k.v,id);
                }
            }else return false;
            lock(v,id);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        List<String> s = new ArrayList<>(n);
//        String[] s = new String[n];
        for(int i = 0; i < n; i++)
            s.add(sc.nextLine());
//            s[i] = sc.nextLine();

        Node r = new Node(s.get(0),null);
        r = buildTree(r,m,s);
        //printTree(r);

        Tree t = new Tree(r);
        t.fillVtoN(t.getRoot());

        int op,uid;
        String sq;
        for(int i = 0; i < q; i++){
            op = sc.nextInt();
            sq = sc.next();
            uid = sc.nextInt();
            switch(op){
                case 1:	if(t.lock(sq,uid)){
                    System.out.println("true");
                    //printTree(r);
                }else
                    System.out.println("false");
                    break;
                case 2:	if(t.unlock(sq,uid))
                    System.out.println("true");
                else
                    System.out.println("false");
                    break;
                case 3:	if(t.upgrade(sq,uid)){
                    System.out.println("true");
                    //printTree(r);
                }else
                    System.out.println("false");
                    break;
            }
        }
    }
}
