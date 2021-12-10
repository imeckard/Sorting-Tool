package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = "word";

        String command = "info";

        Sorter sorter = null;

        ArrayList<String> dataTypeOptions = new ArrayList<>(Arrays.asList("word", "long", "line"));
        
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-sortIntegers")) {
                dataType = "long";
                command = "sort";
                break;
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
        sorter.printSortedStats();

        sorter.createList();

        switch (command) {
            case "info":
                sorter.printArrayInfo();
                break;
            case "sort":
                sorter.printSortedStats();
                break;
            default:
                sorter.printArrayInfo();
                System.out.println("Command argument was missing???");
        }


    }

}
