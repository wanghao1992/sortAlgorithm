package base;

/**
 * Created by veblon.wang on 2016/12/10.
 */
public abstract class BaseSort implements Sortable{
    private long startTime;
    private long endTime;

    protected void noteDownStartTime() {
        startTime = System.currentTimeMillis();
    }

    protected void nodeDownEndTime() {
        endTime = System.currentTimeMillis();
    }

    public long getTime() {
        return endTime - startTime;
    }

    @Override
    public int[] sort(int[] originalData) {
        noteDownStartTime();
        int[] sortData = startSort(originalData);
        nodeDownEndTime();
        return sortData;
    }

    public abstract int[] startSort(int[] originalData);

    public abstract String getSortName();
}
