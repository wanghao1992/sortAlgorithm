package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;
import utils.Utils;

/**
 * Created by veblon.wang on 2016/12/9.
 */
public class BubbleSort extends BaseSort {
//    冒泡排序算法的运作如下：（从后往前）
//    比较相邻的元素。如果第一个比第二个大，就交换他们两个。
//    对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
//    针对所有的元素重复以上的步骤，除了最后一个。
//    持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();
        for (int i = 0; i < sortData.length - 1; i++) {
            for (int j = 0; j < sortData.length - 1 - i; j++) {
                int targetNum = sortData[j];
                int compareNum = sortData[j + 1];
                if (targetNum > compareNum) {
                    Utils.swap(sortData, j, j + 1);
                }
            }
        }
        return sortData;
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_BUBBLE;
    }
}
