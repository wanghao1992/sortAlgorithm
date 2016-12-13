package algorithm;

import base.BaseSort;
import base.Sortable;
import config.Constants;
import utils.Utils;

/**
 * Created by veblon.wang on 2016/12/10.
 */
public class HeapSort extends BaseSort {
//    二叉堆是完全二叉树或者是近似完全二叉树。
//
//    二叉堆满足二个特性：
//
//            1．父结点的键值总是大于或等于（小于或等于）任何一个子节点的键值。
//
//            2．每个结点的左子树和右子树都是一个二叉堆（都是最大堆或最小堆）。
//
//    当父结点的键值总是大于或等于任何一个子节点的键值时为最大堆。当父结点的键值总是小于或等于任何一个子节点的键值时为最小堆。
//
//    一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。它的左右子结点下标分别为2 * i + 1和2 * i + 2。如第0个结点左右子结点下标分别为1和2。

    @Override
    public int[] startSort(int[] originData) {
        int[] sortData = originData.clone();
        //建最大堆
        adjustHeap(sortData, originData.length);

        //对堆排序
        for (int i = sortData.length - 1; i > 0; i--) {
            maxDown(sortData, i);
            adjustHeap(sortData, i);
        }

        return sortData;
    }

    private void adjustHeap(int[] data, int length) {
        for (int i = length - 1; i > 0; i--) {
            int k = (i - 1) / 2;
            if (data[i] > data[k]) {
                Utils.swap(data, i, k);
            }
        }
    }

    private void maxDown(int[] data, int n) {
        Utils.swap(data, 0, n);
    }

    @Override
    public String getSortName() {
        return Constants.SORT_NAME_HEAP;
    }
}
