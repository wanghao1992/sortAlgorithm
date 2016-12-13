package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;
import utils.Utils;

/**
 * Created by veblon.wang on 2016/12/10.
 * 希尔排序
 */
public class ShellSort extends BaseSort {

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();
        int gap = sortData.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < sortData.length; j += gap) {
                    if (sortData[j] < sortData[j - gap]) {
                        int temp = sortData[j];
                        int k = j - gap;
                        while (k >= 0 && sortData[k] > temp) {
                            sortData[k + gap] = sortData[k];
                            k -= gap;
                        }
                        sortData[k + gap] = temp;
                    }
                }
            }
        }
        return sortData;
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_SHELL;
    }
}
