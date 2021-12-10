package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.*;

public interface Sorter {
    Scanner scan = new Scanner(System.in);

    public void createList();

    public void setList(List input);

    public List getSortableList();

    public <E> E getLargest();

    public int getNumberOfRepeats();

    public default int getRepeatPercentage() {
        double percent = (double) getNumberOfRepeats() / (double) getSortableList().size();
        return (int) Math.round(percent * 100);
    }


    public void printArrayInfo();


    public void printSortedStats();

}

class SorterWord implements Sorter {

    public static List<String> sortableList = new ArrayList<>(0);

    @Override
    public void createList() {
        while (scan.hasNext()) {
            sortableList.add(scan.next());
        }
        sort(sortableList);
    }

    @Override
    public void setList(List input) {
        sortableList = input;
    }

    @Override
    public List getSortableList() {
        return sortableList;
    }

    @Override
    public String getLargest() {
        String largest = sortableList.get(0);
        for (String str : sortableList) {
            if (!largest.equals(str) && largest.length() < str.length()) {
                largest = str;
            }
        }
        return largest;
    }

    @Override
    public int getNumberOfRepeats() {
        String largest = getLargest();
        int count = 0;
        for (String str : sortableList) {
            if (largest.equals(str)) {
                count++;
            }
        }
        return count;
    }

    public void printArrayInfo() {
        System.out.printf("Total words: %d", sortableList.size());
        System.out.printf("\nThe longest word: %s (%d time(s), %d%%)",
                getLargest(), getNumberOfRepeats(), getRepeatPercentage());
    }

    @Override
    public void printSortedStats() {

    }

}

class SorterLine implements Sorter {

    public static List<String> sortableList = new ArrayList<>(0);

    @Override
    public void createList() {
        while (scan.hasNextLine()) {
            sortableList.add(scan.nextLine());
        }
        sort(sortableList);
    }

    @Override
    public void setList(List input) {
        sortableList = input;
    }

    @Override
    public List getSortableList() {
        return sortableList;
    }

    @Override
    public String getLargest() {
        String largest = sortableList.get(0);
        for (String str : sortableList) {
            if (!largest.equals(str) && largest.length() < str.length()) {
                largest = str;
            }
        }
        return largest;
    }

    @Override
    public int getNumberOfRepeats() {
        String largest = getLargest();
        int count = 0;
        for (String str : sortableList) {
            if (largest.equals(str)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void printSortedStats() {
    }

    public void printArrayInfo() {
        System.out.printf("Total lines: %d", sortableList.size());
        System.out.print("\nThe longest line:\n");
        System.out.println(getLargest());
        System.out.printf("(%d time(s), %d%%)", getNumberOfRepeats(), getRepeatPercentage());
    }


}

class SorterLong implements Sorter {

    public static List<Long> sortableList = new ArrayList<>(0);

    @Override
    public void createList() {
        while (scan.hasNextLong()) {
            sortableList.add(scan.nextLong());
        }
        sort(sortableList);
    }

    @Override
    public void setList(List input) {
        sortableList = input;
    }

    @Override
    public List getSortableList() {
        return sortableList;
    }

    @Override
    public Long getLargest() {
        return sortableList.get(sortableList.size() - 1);
    }

    @Override
    public int getNumberOfRepeats() {
        Long largest = getLargest();
        int count = 0;
        for (Long num : sortableList) {
            if (largest == num) {
                count++;
            }
        }
        return count;
    }


    public void printArrayInfo() {

        System.out.printf("Total numbers: %d", sortableList.size());
        System.out.printf("\nThe greatest number: %d (%d time(s), %d%%)",
                getLargest(), getNumberOfRepeats(), getRepeatPercentage());
    }

    @Override
    public void printSortedStats() {
        StringBuilder sortedData = new StringBuilder("Sorted data:");

        for (int i = 0; i < sortableList.size(); i++) {
            sortedData.append(" ").append(sortableList.get(i));
        }

        System.out.printf("Total numbers: %d.\n", sortableList.size());
        System.out.println(sortedData.toString());

    }

}