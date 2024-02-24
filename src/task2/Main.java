package task2;

import task2.Node.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("1");
        simpleLinkedList.add("2");
        simpleLinkedList.add("3");
        simpleLinkedList.add("1");
        simpleLinkedList.add("2");
        simpleLinkedList.add("3");
        simpleLinkedList.add("4");
        simpleLinkedList.add("5");
        simpleLinkedList.add("3");
        simpleLinkedList.add("4");
        simpleLinkedList.add("5");
        simpleLinkedList.add("6");
        simpleLinkedList.add("7");
        simpleLinkedList.add("7");
        simpleLinkedList.add("5");
        simpleLinkedList.add("6");
        simpleLinkedList.add("7");
        simpleLinkedList.add("7");
        simpleLinkedList.add("8");


        simpleLinkedList.removingRepetitions();
        simpleLinkedList.showValues();
        System.out.println("\n" + simpleLinkedList.getSize() + " Size");

        FileWork.addNodeInSimpleLinkedListThroughMyFinishPath("NodesFromFileInCodeSLList", simpleLinkedList);
        FileWork.addFromCodeToFile(simpleLinkedList, "NodesFromCodeInFile");

        simpleLinkedList.clear();
        simpleLinkedList.add("df");
        simpleLinkedList.add("df");
        simpleLinkedList.add("df");
        simpleLinkedList.add("df");
        simpleLinkedList.showValues();
        System.out.println(simpleLinkedList.getSize());
    }
}