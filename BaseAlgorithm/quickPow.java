public class quickPow {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        //输出5的100次幂
        System.out.println("5的100次幂是：" + quickPow(5, 100));
    }
    //快速幂， a的b次幂
    public static long quickPow(long a, long b) {
        long ans = 1;
        while(b > 0) {
            if((b & 1) == 1) {
                ans *= a;
                ans %= mod;
            }
            a *= a;
            a %= mod;
            b >>= 1;
        } 
        return ans;
    }
}

//5的100次幂是：146981449
