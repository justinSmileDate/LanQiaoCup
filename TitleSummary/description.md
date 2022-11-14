
## 1 [蓝桥杯 2013 省 AB] 错误票据

## 题目背景

某涉密单位下发了某种票据，并要在年终全部收回。

## 题目描述

每张票据有唯一的 ID 号，全年所有票据的 ID 号是连续的，但 ID 的开始数码是随机选定的。因为工作人员疏忽，在录入 ID 号的时候发生了一处错误，造成了某个 ID 断号，另外一个 ID 重号。

你的任务是通过编程，找出断号的 ID 和重号的 ID。

数据保证断号不可能发生在最大和最小号。

## 输入格式

一个整数 $N(N<100)$ 表示后面数据行数，接着读入 $N$ 行数据，每行数据长度不等，是用空格分开的若干个（不大于 $100$ 个）正整数（不大于 $10^5$），每个整数代表一个 ID 号。

## 输出格式

要求程序首先输入要求程序输出 $1$ 行，含两个整数 $m$，$n$，用空格分隔，其中，$m$ 表示断号 ID，$n$ 表示重号 ID。

## 样例 #1

### 样例输入 #1

```
2
5 6 8 11 9
10 12 9
```

### 样例输出 #1

```
7 9
```

## 样例 #2

### 样例输入 #2

```
6
164 178 108 109 180 155 141 159 104 182 179 118 137 184 115 124 125 129 168 196
172 189 127 107 112 192 103 131 133 169 158
128 102 110 148 139 157 140 195 197
185 152 135 106 123 173 122 136 174 191 145 116 151 143 175 120 161 134 162 190
149 138 142 146 199 126 165 156 153 193 144 166 170 121 171 132 101 194 187 188
113 130 176 154 177 120 117 150 114 183 186 181 100 163 160 167 147 198 111 119
```

### 样例输出 #2

```
105 120
```

这道题思路很清晰，重点是在于输入的问题：Scanner类的nextInt和nextLine会出现冲突
- 原因是nextLine会把nextInt的结束换行符当成字符给输入进去
- 解决的办法是在二者之间加一个nextLine,吸收nextInt的换行符。
  

普及一下这几个方法

- hasNext（）是检测还有没有下一个输入
- next（）是指针移动到当前下标，并取出下一个输入
- nextLine（）把指针移动到下一行 让然后取出当前这一行的输入
- hasNextLine（）是检测下一行有没有输入

### 题解
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[100001];
        int index = 0;
        in.nextLine();//吃掉n后面的换行符
        for(int i = 0; i < n; i ++) {//按行输入
            Scanner inn = new Scanner(in.nextLine());
            while(inn.hasNext()) {
                nums[index ++] = inn.nextInt();
            }
        }
        Arrays.sort(nums, 0, index);
        int M = 0, N = 0;
        //0到index进行计算
        for(int i = 1; i <= index; i ++) {
            if(nums[i] - nums[i - 1] == 2) N = nums[i] - 1;
            if(nums[i] - nums[i - 1] == 0) M = nums[i];
        }
        System.out.println(N + " " + M);
        
    }
}

```

## 2 [蓝桥杯 2020 省 AB1] 解码

## 题目描述

小明有一串很长的英文字母，可能包含大写和小写。

在这串字母中，有很多连续的是重复的。小明想了一个办法将这串字母表达得更短：将连续的几个相同字母写成字母 + 出现次数的形式。 例如，连续的 $5$ 个 `a`，即 `aaaaa`，小明可以简写成 `a5`（也可能简写成 `a4a`、`aa3a` 等）。

对于这个例子：`HHHellllloo`，小明可以简写成 `H3el5o2`。为了方便表达，小明不会将连续的超过9个相同的字符写成简写的形式。

现在给出简写后的字符串，请帮助小明还原成原来的串。

## 输入格式

输入一行包含一个字符串。

## 输出格式

输出一个字符串，表示还原后的串。

## 样例 #1

### 样例输入 #1

```
H3el5o2
```

### 样例输出 #1

```
HHHellllloo
```

## 提示

对于所有评测用例，字符串由大小写英文字母和数字组成，长度不超过 $100$。请注意原来的串长度可能超过 $100$。

蓝桥杯 2020 第一轮省赛 A 组 F 题（B 组 G 题）。

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //字符串的输入
        String s = in.next();
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                for(int j = 0; j < s.charAt(i) - '0' - 1; j ++) {
                    //注意println(换行输出)和print(不换行)的区别
                    System.out.print(s.charAt(i - 1));
                }
            }else {
                System.out.print(s.charAt(i));
            }
        }
    }
}
```