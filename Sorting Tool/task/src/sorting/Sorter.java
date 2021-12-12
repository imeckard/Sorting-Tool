package sorting;

import java.util.*;

import static java.util.Collections.*;

public interface Sorter {
    Scanner scan = new Scanner(System.in);

    public void createList();

    public void setList(List input);

    public List getSortableList();

    public <E> E getLargest();

    public default int getNumberOfRepeats(String current) {

        int count = 0;
        for (Object str : getSortableList()) {
            if (current.equals(str)) {
                count++;
            }
        }
        return count;
    }

    public default int getRepeatPercentage(String current) {
        double percent = (double) getNumberOfRepeats(current) / (double) getSortableList().size();
        return (int) Math.round(percent * 100);
    }

    public default void naturalSort() {
        sort(getSortableList());
    }

    public default Map<String, Integer> byCountSort() {

        Map<String, Integer> countSortMap = new TreeMap<>();

        for (int i = 0; i < getSortableList().size(); i++) {
            countSortMap.putIfAbsent((String) getSortableList().get(i), getNumberOfRepeats((String) getSortableList().get(i)));
        }

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(countSortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public void printArrayInfo();

    public void printNaturalSort();

    public void printByCountSort();

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

/*
    @Override
    public int getNumberOfRepeats(String current) {

        int count = 0;
        for (String str : sortableList) {
            if (current.equals(str)) {
                count++;
            }
        }
        return count;
    }
*/

/*    public void naturalSort() {
        sort(sortableList);
    }*/

/*    @Override
    public Map<String, Integer> byCountSort() {

        Map<String, Integer> countSortMap = new TreeMap<>();

        for (int i = 0; i < sortableList.size(); i++) {
            countSortMap.putIfAbsent(sortableList.get(i), getNumberOfRepeats(sortableList.get(i)));
        }

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(countSortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }*/


    public void printArrayInfo() {
        System.out.printf("Total words: %d", sortableList.size());
        System.out.printf("\nThe longest word: %s (%d time(s), %d%%)",
                getLargest(), getNumberOfRepeats(getLargest()), getRepeatPercentage(getLargest()));
    }


    public void printNaturalSort() {
        StringBuilder sortedData = new StringBuilder("Sorted data:");

        for (int i = 0; i < sortableList.size(); i++) {
            sortedData.append(" ").append(sortableList.get(i));
        }

        System.out.printf("Total words: %d.\n", sortableList.size());
        System.out.println(sortedData.toString());

    }

    public void printByCountSort() {
        Map<String, Integer> countSortMap = byCountSort();

        System.out.printf("Total words: %d.\n", sortableList.size());
        for (String key : countSortMap.keySet()) {
            System.out.printf("\n%s: %d time(s), %d%%", key, countSortMap.get(key), getRepeatPercentage(key));
        }

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

/*
    @Override
    public int getNumberOfRepeats(String current) {

        int count = 0;
        for (String str : sortableList) {
            if (current.equals(str)) {
                count++;
            }
        }
        return count;
    }
*/


/*    @Override
    public Map<String, Integer> byCountSort() {

        Map<String, Integer> countSortMap = new TreeMap<>();

        for (int i = 0; i < sortableList.size(); i++) {
            countSortMap.putIfAbsent(sortableList.get(i), getNumberOfRepeats(sortableList.get(i)));
        }

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(countSortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;

    }*/



    public void printArrayInfo() {
        System.out.printf("Total lines: %d", sortableList.size());
        System.out.print("\nThe longest line:\n");
        System.out.println(getLargest());
        System.out.printf("(%d time(s), %d%%)", getNumberOfRepeats(getLargest()), getRepeatPercentage(getLargest()));
    }

    public void printNaturalSort() {
        StringBuilder sortedData = new StringBuilder("Sorted data:");

        for (int i = 0; i < sortableList.size(); i++) {
            sortedData.append("\n").append(sortableList.get(i));
        }

        System.out.printf("Total lines: %d.\n", sortableList.size());
        System.out.println(sortedData);

    }
    public void printByCountSort() {
        Map<String, Integer> countSortMap = byCountSort();

        System.out.printf("Total lines: %d.\n", sortableList.size());
        for (String key : countSortMap.keySet()) {
            System.out.printf("\n%s: %d time(s), %d%%", key, countSortMap.get(key), getRepeatPercentage(key));
        }

    }

}

class SorterLong implements Sorter {

    public static List<String> sortableList = new ArrayList<>(0);

    @Override
    public void createList() {
        List<Long> tempList = new ArrayList<>();
        while (scan.hasNextLong()) {
            tempList.add(scan.nextLong());
        }
        sort(tempList);

        System.out.println(tempList);
        for (Long aLong : tempList) {
            sortableList.add(Long.toString(aLong));
        }
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
        return sortableList.get(sortableList.size() - 1);
    }

/*
    @Override
    public int getNumberOfRepeats(String current) {

        int count = 0;
        for (String num : sortableList) {
            if (current.equals(num)) {
                count++;
            }
        }
        return count;
    }
*/

/*    public Map<String, Integer> byCountSort() {

        Map<String, Integer> countSortMap = new TreeMap<>();

        for (int i = 0; i < sortableList.size(); i++) {
            countSortMap.putIfAbsent(sortableList.get(i), getNumberOfRepeats(sortableList.get(i)));
        }

        List<Map.Entry<Long, Integer> > list =
                new LinkedList<Map.Entry<Long, Integer> >(countSortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Integer> >() {
            public int compare(Map.Entry<Long, Integer> o1,
                               Map.Entry<Long, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Long, Integer> temp = new LinkedHashMap<Long, Integer>();

        for (Map.Entry<Long, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;

    }*/


    public void printArrayInfo() {

        System.out.printf("Total numbers: %d", sortableList.size());
        System.out.printf("\nThe greatest number: %s (%d time(s), %d%%)",
                getLargest(), getNumberOfRepeats(getLargest()), getRepeatPercentage(getLargest()));
    }

    public void printNaturalSort() {
        StringBuilder sortedData = new StringBuilder("Sorted data:");

        for (int i = 0; i < sortableList.size(); i++) {
            sortedData.append(" ").append(sortableList.get(i));
        }

        System.out.printf("Total numbers: %d.\n", sortableList.size());
        System.out.println(sortedData.toString());

    }

    public void printByCountSort() {
        Map<String, Integer> countSortMap = byCountSort();

        System.out.printf("Total numbers: %d.", sortableList.size());
        for (String key : countSortMap.keySet()) {
            System.out.printf("\n%s: %d time(s), %d%%", key, countSortMap.get(key), getRepeatPercentage(key));
        }

    }

}