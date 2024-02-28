package task2;

import task2.Node.SimpleLinkedList;

import static task2.FileWork.PATHTOMYFILE;

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

        FileWork.addNodeInSimpleLinkedListThroughMyFinishPath(simpleLinkedList);
        FileWork.addFromCodeToFile(simpleLinkedList, PATHTOMYFILE);

        simpleLinkedList.clear();
        simpleLinkedList.add("df");
        simpleLinkedList.add("df");
        simpleLinkedList.add("df");
        simpleLinkedList.add("df");
        simpleLinkedList.showValues();
        System.out.println(simpleLinkedList.getSize());
    }
}