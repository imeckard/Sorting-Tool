package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = "none";

        String command = "natural";

        Sorter sorter = null;
        
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-sortingType")) {
                command = args[i + 1];
            }

            if (args[i].equals("-dataType")) {
                dataType = args[i + 1];
            }
        }
        
        switch (dataType) {
            case "word":
                sorter = new SorterWord();
                break;
            case "line":
                sorter = new SorterLine();
                break;
            case "long":
                sorter = new SorterLong();
                break;
            default:
                sorter = new SorterWord();
                System.out.println("DataType argument was missing???");
        }


        sorter.createList();


        switch (command) {
            case "natural":
                sorter.printNaturalSort();
                break;
            case "byCount":
                sorter.printByCountSort();
                break;
            default:
                sorter.printArrayInfo();
                System.out.println("Command argument was missing???");
        }


    }

}
