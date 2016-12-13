package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;
import utils.Utils;

/**
 * Created by veblon.wang on 2016/12/10.
 * 直接插入排序
 */
public class StraightInsertionSort extends BaseSort {

    @Override
    public int[] startSort(int[] originData) {

        int[] sortData = originData.clone();

        for (int i = 1; i < sortData.length; i++) {
            if (sortData[i] < sortData[i - 1])//0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
            {
                int temp = sortData[i];//保存第i位的值
                int k = i - 1;
                for (int j = k; j >= 0 && temp < sortData[j]; j--)//从第i-1位向前遍历并移位，直至找到小于第i位值停止
                {
                    sortData[j + 1] = sortData[j];
                    k--;
                }
                sortData[k + 1] = temp;//插入第i位的值
            }
        }
        return sortData;
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_STRAIGHT_ISERTION;
    }
}
