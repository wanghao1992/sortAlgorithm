package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;

/**
 * Created by veblon.wang on 2016/12/13.
 */
public class RadixSort extends BaseSort {

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();
        int maxDigit = getMaxDigit(sortData);
        sort(sortData, maxDigit);
        return sortData;
    }

    private int getMaxDigit(int[] data) {
        int maxDigit = 0;
        for (int i = 0; i < data.length; i++) {
            int digit = getDigit(data[i]);
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }
        return maxDigit;
    }

    private int getDigit(int number) {
        int digit = 1;
        while (number / 10 >= 1 || number / 10 <= -1) {
            number /= 10;
            digit++;
        }
        return digit;
    }

    public void sort(int[] number, int maxDigit) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= maxDigit) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_RADIX;
    }
}
