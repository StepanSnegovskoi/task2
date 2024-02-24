package task2;

import task2.Node.SimpleLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWork {
    private static File file;

    public static void addNodeInSimpleLinkedListThroughMyFinishPath(String nameFile, SimpleLinkedList array) {
        file = new File(String.format("C:\\Users\\stepa\\IdeaProjects\\task2\\src\\%s", nameFile));
        addElementsInSimpleLinkedList(array);
    }

    // Добавление через путь пользователя
    public static void addNodeFromFilePathInSimpleLinkedList(String pathToFile, SimpleLinkedList array) {
        file = new File(String.format("%s", pathToFile));
        addElementsInSimpleLinkedList(array);
    }

    // Получение value, с каждой новой строки записывается value в файл
    public static void addFromCodeToFile(SimpleLinkedList array, String fileName) {
        File file = new File(String.format("C:\\Users\\stepa\\IdeaProjects\\task2\\src\\%s", fileName));
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String value = "";
        for (int i = 0; i < array.getSize(); i++) {
            try{
                value = array.get(i).getValue();
            } catch (NullPointerException e){

            }
            printWriter.printf("%s\n", value);
        }
        printWriter.close();
    }

    // Получение values из файла сканером, добавление через метод add в лист. В файле на каждой строке один элемент
    private static void addElementsInSimpleLinkedList(SimpleLinkedList array2) {
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            array2.add(scanner.nextLine());
        }
        scanner.close();
    }
}
