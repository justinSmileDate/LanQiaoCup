package Demo;

import java.util.Arrays;
 
 
public class Euler {
        public static void main(String[] args) {
            //建立一个bool类型的数组，以下标为要判断的数字 以该下标的值为素数的标志,
            //若i是素数 则 isPrime[i]=true
            boolean[] isPrime = new boolean[101];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;//数字0和1都不是素数，所以赋false
     
            int[] Prime = new int[100];//存放素数的数组
            int t = 0;
            Prime[t++] = 2;//把2放进素数表
            for (int i = 2; i < 100; i++) {
                if (isPrime[i])//若当前数是素数
                    Prime[t++] = i;//则存入素数数组
                for (int j = 0; j < t && Prime[j] * i < 100; j++) {
                    isPrime[i * Prime[j]] = false;
                    if (i % Prime[j] == 0)
                        break;//避免重筛,使得程序更有效率
                }
            }
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " " + isPrime[i]);
            }
        }
}
