package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;
import utils.Utils;

/**
 * Created by veblon.wang on 2016/12/10.
 */
public class QuickSort extends BaseSort {

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();
        quickSort(sortData, 0, sortData.length - 1);
        return sortData;
    }

    private void quickSort(int[] data, int start, int end) {
        if (start >= end || start >= data.length - 1 || end <= 0) {
            return;
        }
        int keyNum = data[start];
        int keyNumPosition = start;
        for (int i = start + 1; i <= end; i++) {
            int iPostitionData = data[i];//记录下标为i处数据
            if (data[i] < keyNum) {
                for (int j = i; j > keyNumPosition; j--) {
                    data[j] = data[j - 1];
                }
                data[keyNumPosition] = iPostitionData;
                keyNumPosition += 1;
            }
        }
        quickSort(data, start, keyNumPosition - 1);
        quickSort(data, keyNumPosition + 1, end);
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_QUICK;
    }
}
