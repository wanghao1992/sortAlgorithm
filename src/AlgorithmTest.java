import algorithm.*;
import base.BaseSort;
import config.Constants;
import utils.Utils;

/**
 * Created by veblon.wang on 2016/12/9.
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        //生成原始需要排序的数据
        int[] originalData = Utils.generateRandomNumbers(Constants.RANDOM_NUMBER_COUNT);
        System.out.print("对" + Constants.RANDOM_NUMBER_COUNT + "个随机数进行排序");
        Utils.printData(originalData);

        System.out.println("\n\n排序后：");

        //冒泡排序
        BaseSort bubbleSort = new BubbleSort();
        Utils.sortAndPrint(bubbleSort, originalData);

        //快速排序
        BaseSort quickSort = new QuickSort();
        Utils.sortAndPrint(quickSort, originalData);

        //直接插入排序
        BaseSort straightInsertionSort = new StraightInsertionSort();
        Utils.sortAndPrint(straightInsertionSort, originalData);

        //二分法插入排序
        BaseSort barnarySort = new BarnarySort();
        Utils.sortAndPrint(barnarySort, originalData);

        //希尔排序
        BaseSort shellSort = new ShellSort();
        Utils.sortAndPrint(shellSort, originalData);

        //简单选择排序
        BaseSort simpleSelectSort = new SimpleSelectSort();
        Utils.sortAndPrint(simpleSelectSort, originalData);

        //堆排序
        BaseSort heapSort = new HeapSort();
        Utils.sortAndPrint(heapSort, originalData);

        //归并排序
        BaseSort mergeSort = new MergeSort();
        Utils.sortAndPrint(mergeSort, originalData);

        //基数排序
        BaseSort radixSort = new RadixSort();
        Utils.sortAndPrint(radixSort, originalData);
    }

}
