package Leetcode;

public class removeduplicate_q26 {
    public static void main(String[] args) {

    }

        public int removeDuplicates(int[] arr) {
            int count=1;
            int match= arr[0];
            int s=1, end;
            for(int i=1;i<arr.length;i++)
            {

                if(arr[i] != match)
                {
                    end=i;
                    int temp = arr[s];
                    arr[s]= arr[end];
                    arr[end]= temp;
                    match = arr[s];
                    count++;
                    s++;
                }

            }

            return count;
        }

}
