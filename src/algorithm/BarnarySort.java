package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;

/**
 * Created by veblon.wang on 2016/12/10.
 * 二分法插入排序
 */
public class BarnarySort extends BaseSort {

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();
        for (int i = 1; i < sortData.length; i++) {
            if (sortData[i] < sortData[i - 1]) {
                int position = findRightPosition(sortData, i, 0, i - 1);
                insert(sortData, i, position);
            }
        }
        return sortData;
    }

    private void insert(int[] data, int targetPosition, int rightPosition) {
        int temp = data[targetPosition];
        for (int i = targetPosition; i > rightPosition; i--) {
            data[i] = data[i - 1];
        }
        data[rightPosition] = temp;//插入第i位的值
    }

    private int findRightPosition(int[] data, int targetPosition, int low, int high) {
        int middlePosition = (low + high) / 2;
        if (low > high) {
            return low;
        }

        if (data[targetPosition] > data[middlePosition]) {
            return findRightPosition(data, targetPosition, middlePosition + 1, high);
        } else {
            return findRightPosition(data, targetPosition, 0, middlePosition - 1);
        }
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_BARNARY;
    }
}
