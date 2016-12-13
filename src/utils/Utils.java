package utils;

import base.BaseSort;
import config.Constants;

import java.util.List;
import java.util.Random;
import java.util.logging.ConsoleHandler;

/**
 * Created by veblon.wang on 2016/12/10.
 */
public class Utils {

    public static int[] generateRandomNumbers(int count) {
        int[] nums = new int[count];
        Random random =  new Random();
        for (int i = 0; i < count - 1; i ++) {
            nums[i] = random.nextInt(count);
        }
        return nums;
    }

    public static void swap(int[] originData, int targetPosition, int comparePosition) {
        int temp = originData[targetPosition];
        originData[targetPosition] = originData[comparePosition];
        originData[comparePosition] = temp;
    }

    public static void printData(int[] data) {
        if (Constants.IS_PRINT_DATA) {
            System.out.print("\t");
            for (int i = 0; i < data.length; i++) {
                if (i != 0) {
                    System.out.print(",");
                }
                System.out.print(data[i]);
            }
        }
    }

    public static void sortAndPrint(BaseSort sortAlgorithm, int[] originalData) {
        System.out.print(sortAlgorithm.getSortName());
        int[] sortData = sortAlgorithm.sort(originalData);
        printData(sortData);
        System.out.println("\t用时：" + sortAlgorithm.getTime());
    }
}
