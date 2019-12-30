package com.math;

/**
 * 计算博饼各种点数的概率
 */
public class BobingNumber {

    public static void main(String[] args) {

        int [] numbers = new int[6];
        int totalCnt   = 0;
        int yiXiuCnt   = 0;
        int erJucnt    = 0;
        int sanHongcnt = 0;
        int siJincnt   = 0;
        int zhuangYuancnt = 0;
        int chaJinHuaCnt  = 0;
        int duitangCnt = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    for (int l = 1; l <= 6; l++) {
                        for (int m = 1; m <= 6; m++) {
                            for (int n = 1; n <= 6; n++) {
                                totalCnt++;
                                numbers[0] = i;
                                numbers[1] = j;
                                numbers[2] = k;
                                numbers[3] = l;
                                numbers[4] = m;
                                numbers[5] = n;
                                if (isYiXiu(numbers)) {
                                    yiXiuCnt++;
                                }
                                if (isErJu(numbers)) {
                                    erJucnt++;
                                }
                                if (isSanHong(numbers)) {
                                    sanHongcnt++;
                                }
                                if (isSiJin(numbers)) {
                                    siJincnt++;
                                }
                                if (isZhuangYuan(numbers)) {
                                    zhuangYuancnt++;
                                }
                                if (isChaJinHua(numbers)) {
                                    chaJinHuaCnt++;
                                }
                                if (isDuiTang(numbers)) {
                                    duitangCnt = duitangCnt + 1;
                                }
                            }

                        }
                    }
                }
            }

        }
        System.out.println("一秀的概率是:" + yiXiuCnt + "/" + totalCnt + " = " + ((double)yiXiuCnt*100/(double)totalCnt) + "%");
        System.out.println("二举的概率是:" + erJucnt + "/" + totalCnt + " = " + ((double)erJucnt*100/(double)totalCnt) + "%");
        System.out.println("三红的概率是:" + sanHongcnt + "/" + totalCnt + " = " + ((double)sanHongcnt*100/(double)totalCnt) + "%");
        System.out.println("四进的概率是:" + siJincnt + "/" + totalCnt + " = " + ((double)siJincnt*100/(double)totalCnt) + "%");
        System.out.println("对堂的概率是:" + duitangCnt + "/" + totalCnt + " = " + ((double)duitangCnt*100/(double)totalCnt) + "%");
        System.out.println("状元的概率是:" + zhuangYuancnt + "/" + totalCnt + " = " + ((double)zhuangYuancnt*100/(double)totalCnt) + "%");
        System.out.println("状元插金花的概率是:" + chaJinHuaCnt + "/" + totalCnt + " = " + ((double)chaJinHuaCnt*100/(double)totalCnt) + "%");
    }

    private static void printAllNumbers(int [] numbers) {

        for (int number : numbers) {
            System.out.print(number);
        }
        System.out.println();
    }

    /**
     * 判断是否是一秀
     * @return
     */
    private static boolean isYiXiu(int [] numbers) {

        boolean result = false;
        if (countNumber4(numbers) == 1) {
            result = true;
        }
        return result;
    }

    /**
     * 判断是否是二举
     * @return
     */
    public static boolean isErJu(int [] numbers) {

        boolean result = false;
        if (countNumber4(numbers) == 2) {
            result = true;
        }
        return result;
    }

    /**
     * 判断是否是三红
     * @return
     */
    public static boolean isSanHong(int [] numbers) {

        boolean result = false;
        if (countNumber4(numbers) == 3) {
            result = true;
        }
        return result;
    }

    /**
     * 判断是否是对堂
     * @return
     */
    public static boolean isDuiTang(int [] numbers) {

        boolean result = false;

        if ((countNumber(numbers, 1) == 1)
                && (countNumber(numbers, 2) == 1)
                && (countNumber(numbers, 3) == 1)
                && (countNumber(numbers, 4) == 1)
                && (countNumber(numbers, 5) == 1)
                && (countNumber(numbers, 6) == 1)
        ) {
            result = true;
        }

        return result;

    }

    /**
     * 计算有多少个4
     * @param numbers
     * @return 4的个数
     */
    private static int countNumber4(int [] numbers) {

        return countNumber(numbers, 4);
    }

    /**
     * 计算有多少个2
     * @param numbers
     * @return 2的个数
     */
    private static int countNumber2(int [] numbers) {

        return countNumber(numbers, 2);
    }

    /**
     * 计算有多少个1
     * @param numbers
     * @return 1的个数
     */
    private static int countNumber1(int [] numbers) {

        return countNumber(numbers, 1);
    }

    /**
     * 计算有多少个num
     * @param numbers
     * @return num的个数
     */
    private static int countNumber(int [] numbers, int num) {

        int cnt = 0;
        for (int number : numbers) {
            if (number == num) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * 计算是否有n个数字相同的骰子
     * @param numbers
     * @return
     */
    private static boolean ifHasSameNumber(int [] numbers, int n) {

        boolean result = false;
        for (int i = 1; i <= numbers.length; i++) {
            if (countNumber(numbers, i) == n) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 计算是否有4个数字相同的骰子
     * @param numbers
     * @return
     */
    private static boolean ifHas4SameNumber(int [] numbers) {
        return ifHasSameNumber(numbers, 4);
    }

    /**
     * 计算是否有5个数字相同的骰子
     * @param numbers
     * @return
     */
    private static boolean ifHas5SameNumber(int [] numbers) {
        return ifHasSameNumber(numbers, 5);
    }

    /**
     * 计算是否是四进
     * @param numbers
     * @return
     */
    public static boolean isSiJin(int [] numbers) {

        return ifHas4SameNumber(numbers) && countNumber4(numbers) != 4;
    }

    /**
     * 计算是否是状元
     * @param numbers
     * @return
     */
    public static boolean isZhuangYuan(int [] numbers) {

        return countNumber4(numbers) >= 4;
    }

    /**
     * 计算是否是状元插金花
     * @param numbers
     * @return
     */
    public static boolean isChaJinHua(int [] numbers) {

        return countNumber4(numbers) == 4 && countNumber1(numbers) == 2;
    }
}
