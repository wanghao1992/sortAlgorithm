package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;
import utils.Utils;

/**
 * Created by veblon.wang on 2016/12/10.
 */
public class SimpleSelectSort extends BaseSort {

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();

        for (int i = 0; i < sortData.length; i++) {
            int min = sortData[i];
            int minPosition = i;
            for (int j = i + 1; j < sortData.length; j++) {
                if (sortData[j] < min) {
                    min = sortData[j];
                    minPosition = j;
                }
            }
            Utils.swap(sortData, i, minPosition);
        }
        return sortData;
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_SIMPLE_SELECT;
    }
}
