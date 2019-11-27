// this program wil solve the knapsack problem recurs

public class KnapsackRecursive {

    public static void main(String args[]) {
        int[] value = new int[]{50, 10, 100, 200};
        int[] weight = new int[]{10, 70, 40, 100};
        int maxWeight = 50;
        int len = value.length;// answer should be 150 for the approaches
        System.out.println(KnapsackRecursive(maxWeight, weight, value, len));
        System.out.println(KnapsackDp(maxWeight,weight,value,len));

        int[] value2 = new int[]{100, 700, 100, 300};
        int[] weight2 = new int[]{10, 30, 40, 50};
        int maxWeight2 = 70;
        int len2 = value.length;// answer should be 800 for the approaches
        System.out.println(KnapsackRecursive(maxWeight2,weight2,value2,len2));
        System.out.println(KnapsackDp(maxWeight2,weight2,value2,len2));


    }
    //this method necessary both approaches because it returns the max of 2 integers
    public static int max(int a, int b)
    {
        if (a>b )
        {
            return a;
        }
        else{
            return b;
        }
    }

// recursive approach
    public static int KnapsackRecursive(int capacity,int weight[],int value[], int n) {

        if(n == 0|| capacity== 0)// if either the capacity or the length is zero, the answer will be zero/Base case
        {
            return 0;
        }

        if( weight[n-1] > capacity)// if the weight of the nth term is more the the maxW/capicty, that item cannot be used
        {
            //first recursive call
            return KnapsackRecursive(capacity,weight,value,n-1);
        }
        else// so now u return the max of either case, where the term is included or not included
        {
            return max(value[n-1] + KnapsackRecursive(capacity-weight[n-1],weight,value,n-1),
                    KnapsackRecursive(capacity,weight,value,n-1));

        }


    }

    //DP aprroach
    //Running in is O(n^2) because it is a nested for loop
    public static int KnapsackDp(int capacity,int weight[],int value[], int n)
    {
        //becuase using dynamic programming using a multidemsional is best
        int Knap[][] = new int [n+1][capacity+1];

        for(int i = 0; i <=n; i++)//O(n)
        {
            for(int j=0;j<= capacity; j++)
            {
                //Base case
                if((i==0) || (j==0))
                {
                    Knap[i][j] = 0;
                }
                else if(weight[i-1] <= j)// if any element of weight is is great than int j
                {
                    Knap[i][j] = max(value[i-1] + Knap[i-1][j-weight[i-1]], Knap[i-1][j]);
                }
                else
                {
                    Knap[i][j] = Knap[i-1][j];
                }
            }
        } return Knap[n][capacity];

    }

}