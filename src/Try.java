import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Try {

    static class Node {
        String v;
        List<Node> links;
        Node parent;
        int anc_locked, dec_locked, uid;
        boolean isLocked;

        public Node(String x, Node p) {
            v = x;
            parent = p;
            anc_locked = 0;
            dec_locked = 0;
            uid = 0;
            isLocked = false;
            links = new ArrayList<Node>();
        }

        public void addLinks(List<String> l, Node p) {
            for (String i : l) {
                links.add(new Node(i, p));
            }
        }
    }

    private static void printTree(Node root) {
        System.out.println("Parent: " + root.v);
        System.out.println("Child:");
        for (Node k : root.links) {
            System.out.println(k.v + " anc_locked: " + k.anc_locked
                    + " dec_locked:" + k.dec_locked + " isLocked:"
                    + k.isLocked + " uid:" + k.uid);
        }
        System.out.println();
        for (Node k : root.links) {
            printTree(k);
        }
    }

    private static Node buildTree(Node root, int m, List<String> s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int st = 1;
        while (!q.isEmpty()) {
            Node r = q.poll();

            if (st >= s.size()) continue;

            List<String> temp = new ArrayList<>();
            for (int i = st; i < st + m; i++)
                temp.add(s.get(i));
            r.addLinks(temp, r);
            st += m;

            for (Node k : r.links)
                q.offer(k);
        }

        return root;
    }

    static class Tree {
        private Node root;
//        private HashMap<String, Node> vton = new HashMap<String, Node>();
    private ConcurrentHashMap<String, Node> vton = new ConcurrentHashMap<String, Node>();
        public Tree(Node r) {
            root = r;
        }

        public Node getRoot() {
            return root;
        }

        public void fillVtoN(Node r) {
            if (r == null)
                return;
            vton.put(r.v, r);
            for (Node k : r.links) {
                fillVtoN(k);
            }
        }

//        public void informDecendants(Node r, int val) {
//            for (Node k : r.links) {
//                k.anc_locked += val;
//                informDecendants(k, val);
//            }
//        }
        public boolean check_ansc(Node root){
            Node t = root.parent;
            while (t!= null){
                if(t.isLocked) {
//                    t.anc_locked +=1;
                    return false;
                }
                t = t.parent;
            }
            return true;
        }
        public boolean verifyDecendants(Node r, int id, List<Node> v) {
            if (r.isLocked) {
                if (r.uid != id)
                    return false;
                v.add(r);
            }
            if (r.dec_locked == 0)
                return true;

            boolean ans = true;
            for (Node k : r.links) {
                ans &= verifyDecendants(k, id, v);
                if (ans == false)
                    return false;
            }
            return ans;
        }

        public boolean lock(String v, int id) {
            Node t = vton.get(v);
            if(t == null) return false;
            if (t.isLocked)
                return false;

//            if (t.anc_locked != 0)
//                return false;
            if(!check_ansc(t)) return  false;
            if (t.dec_locked != 0)
                return false;

            Node cur = t.parent;
            while (cur != null) {
                cur.dec_locked++;
                cur = cur.parent;
            }
//            informDecendants(t, 1);
            t.isLocked = true;
            t.uid = id;
            return true;
        }

        public boolean unlock(String v, int id) {
            Node t = vton.get(v);
            if (!t.isLocked) return false;
            if (t.isLocked && t.uid != id) return false;

            Node cur = t.parent;
            while (cur != null) {
                cur.dec_locked--;
                cur = cur.parent;
            }
//            informDecendants(t, -1);
            t.isLocked = false;
            return true;
        }

        public boolean upgrade(String v, int id) {
            Node t = vton.get(v);
            if (t.isLocked) return false;

//            if (t.anc_locked != 0) return false;
            if(!check_ansc(t)) return  false;
            if (t.dec_locked == 0) return false;

            ArrayList<Node> vec = new ArrayList<Node>();
            if (verifyDecendants(t, id, vec)) {
                for (Node k : vec) {
                    unlock(k.v, id);
                }
            } else {
                return false;
            }
            lock(v, id);
            return true;
        }
    }

static class Worker extends Thread{
        Tree tree= null;
        String s;
        int id;
        int op;
        public Worker(Tree tree, String s, int id, int op){
            this.tree = tree;
            this.s= s;
            this.id = id;
            this.op=op;
        }

        public void run(){
            switch (op) {
                case 1:
//
                    if (tree.lock(s,id)) {
                        System.out.println( Thread.currentThread().getName()+ "true");
                    } else {
                        System.out.println(Thread.currentThread().getName()+"false");
                    }
                    break;
                case 2:
                    if (tree.unlock(s, id)) {
                        System.out.println(Thread.currentThread().getName()+"true");
                    } else {
                        System.out.println(Thread.currentThread().getName()+"false");
                    }
                    break;
                case 3:
                    if (tree.upgrade(s, id)) {
                        System.out.println(Thread.currentThread().getName()+"true");
                    } else {
                        System.out.println(Thread.currentThread().getName()+"false");
                    }
                    break;
            }
        }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        Vector<String> s = new Vector<String>(n);
        for (int i = 0; i < n; i++) {
            s.add(sc.next());
        }

        Node r = new Node(s.get(0), null);
        r = buildTree(r, m, s);
//        printTree(r);
//
        Tree t = new Tree(r);
        t.fillVtoN(t.getRoot());
        List<Thread> threads = new ArrayList<>();

//
        int op, uid;
        String sq;
        ArrayList<String> queries= new ArrayList<>();
//        queries.add("1 World 9");
//        queries.add("1 India 9");
//        queries.add("2 World 9");
        queries.add("1 India 9");
        queries.add("1 India 9");
        queries.add("3 Asia 9");
        queries.add("2 India 9");
        queries.add("2 Asia 9");
        for (int i = 0; i < q; i++) {
//            op = sc.nextInt();
//            sq = sc.next();
//            uid = sc.nextInt();
            String[] splitted = queries.get(i).split(" ");
            op = Integer.parseInt(splitted[0]);
            sq = splitted[1];
            uid= Integer.parseInt(splitted[2]);
//            System.out.println(op + sq+uid);

            Worker w = new Worker(t,sq,uid,op);
            w.start();
            threads.add(w);
//            switch (op) {
//                case 1:
////                    Thread t1 = new Thread(() -> t.lock(sq, uid));
////                    t1.start();
////                    threads.add(t1);
//                    if (t.lock(sq, uid)) {
//                        System.out.println("true");
//                    } else {
//                        System.out.println("false");
//                    }
//                    break;
//                case 2:
//                    if (t.unlock(sq, uid)) {
//                        System.out.println("true");
//                    } else {
//                        System.out.println("false");
//                    }
//                    break;
//                case 3:
//                    if (t.upgrade(sq, uid)) {
//                        System.out.println("true");
//                    } else {
//                        System.out.println("false");
//                    }
//                    break;
//            }
        }
//        System.out.println(threads);
//
//        for (Thread th : threads) {
//            try {
//                th.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
