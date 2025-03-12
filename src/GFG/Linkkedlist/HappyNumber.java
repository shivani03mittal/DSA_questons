package GFG.Linkkedlist;

public class HappyNumber {
    //cycle problem
    //sum of square of digits till it become 1
    //if cycle exits between the squares then not happy number
    public boolean ishappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow= findSquare(slow);
            fast = findSquare(findSquare(fast));

        }while (slow!= fast);
        if (slow==1) return true;
        else
            return false;
    }

    public int findSquare(int n){
        int ans =0;
        while (n>0){
            int rem = n%10;
            ans += rem*rem;
            n = n/10;
        }
        return ans;
    }
}
