package Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain extends JFrame {

    private JPanel mainPanel;
    private JTextArea textAreaForResult;
    private JButton outputInFile;
    private JButton inputFromFile;
    private JButton result;
    private JTextArea textAreaForAddElement;
    private JButton addUp;
    private JTextArea textAreaForDeleteElementByValue;
    private JButton deleteByValue;
    private JButton deleteByIndex;
    private JTextArea textAreaForDeleteByIndex;

    public FrameMain() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        setContentPane(mainPanel);
        setTitle("GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Добавление элементов из файла в список
        inputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWork.addNodeInSimpleLinkedListViaMyFinishPath("NodesFromFileInGUI", simpleLinkedList);
                restartGUIText(simpleLinkedList);
            }
        });

        // Вывод элементов в файл, .addFromCodeToFile
        outputInFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWork.addFromCodeToFile(simpleLinkedList, "NodesFromGUIInFile");
            }
        });

        // Вывод результата в интерфейсе
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpleLinkedList.removingRepetitions();
                textAreaForResult.setText(simpleLinkedList.makeTextForGUI());
                restartGUIText(simpleLinkedList);
            }
        });

        // Добавление в список элемента сверху
        addUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textAreaForAddElement.getText().isEmpty()) {
                    simpleLinkedList.add(textAreaForAddElement.getText());
                }
                restartGUIText(simpleLinkedList);
            }
        });

        // Удаление по value
        deleteByValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < simpleLinkedList.getSize(); i++){
                    if (textAreaForDeleteElementByValue.getText().equals(simpleLinkedList.get(i).getValue())){
                        simpleLinkedList.remove(textAreaForDeleteElementByValue.getText().trim());
                    }
                }
                restartGUIText(simpleLinkedList);
            }
        });

        // Удаление по индексу
        deleteByIndex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpleLinkedList.removeAt(Integer.parseInt(textAreaForDeleteByIndex.getText().trim()));
                restartGUIText(simpleLinkedList);
            }
        });

    }

    // Обновление текста с элементами списка в интерфейсе
    private void restartGUIText(SimpleLinkedList simpleLinkedList){
        textAreaForResult.setText(simpleLinkedList.makeTextForGUI());
    }

    public static void main(String[] args) {
        new FrameMain();
    }
}
