// Given two 1d vectors, implement an iterator to return their elements alternately.

// For example, given two 1d vectors:

// v1 = [1, 2]
// v2 = [3, 4, 5, 6]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next
// should be: [1, 3, 2, 4, 5, 6].

// Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Your ZigzagIterator object will be instantiated and called as such: 
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class ZigZagIterator {
    private Iterator<Integer> itr1;
    private Iterator<Integer> itr2;
    private Iterator<Integer> tempItr;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        itr1 = v1.iterator();
        itr2 = v2.iterator();
    }

    public int next() {
        if(itr1.hasNext()) {
            tempItr = itr1;
            itr1 = itr2;
            itr2 = tempItr;
        }
        return itr2.next();
    }

    public boolean hasNext() {
        return itr1.hasNext() || itr2.hasNext();
    }

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(3);
        ls1.add(4);
        ls1.add(5);
        ls1.add(6);
        ZigZagIterator i = new ZigZagIterator(ls1, ls1);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

