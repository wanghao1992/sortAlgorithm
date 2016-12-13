package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;

/**
 * Created by veblon.wang on 2016/12/12.
 */
public class MergeSort extends BaseSort {

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();
        int[] tempData = new int[sortData.length];
        mergeSort(sortData, 0, sortData.length - 1, tempData);
        tempData = null;
        return sortData;
    }

    private void mergeSort(int[] data, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(data, first, mid, temp);    //左边有序
            mergeSort(data, mid + 1, last, temp); //右边有序
            mergeArray(data, first, mid, last, temp); //再将二个有序数列合并
        }
    }

    private void mergeArray(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;

        while (i <= m && j <= n) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_MERGE;
    }
}
