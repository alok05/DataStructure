package array;// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


import java.util.ArrayList;
import java.util.List;

class Interval {

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ArrayInsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }

        intervals.add(i, newInterval);

        return intervals;
    }

    public static void main(String[] args) {
        ArrayInsertInterval arrayInsertInterval = new ArrayInsertInterval();
        List<Interval> intervalList = new ArrayList<>();
        Interval interval = new Interval(1, 3);
        intervalList.add(interval);
        interval = new Interval(6, 9);
        intervalList.add(interval);
        interval = new Interval(2, 5);
        arrayInsertInterval.insert(intervalList, interval)
            .stream()
            .forEach(interval1 -> System.out.println(interval1.start + " " + interval1.end));
        intervalList.clear();
        interval = new Interval(1, 2);
        intervalList.add(interval);
        interval = new Interval(3, 5);
        intervalList.add(interval);
        interval = new Interval(6, 7);
        intervalList.add(interval);
        interval = new Interval(8, 10);
        intervalList.add(interval);
        interval = new Interval(12, 16);
        intervalList.add(interval);
        interval = new Interval(4, 9);
        arrayInsertInterval.insert(intervalList, interval)
            .stream()
            .forEach(interval1 -> System.out.println(interval1.start + " " + interval1.end));
    }
}
