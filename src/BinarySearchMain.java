import javax.swing.*;
import java.awt.event.ActionEvent;

/*=============================================================================
 |   Assignment:  Project 3:  Binary Search Tree
 |       Author:  Lance Gundersen
 |       Grader:  Prof. Lynda Metallo
 |
 |       Course:  CMSC 350
 |   Instructor:  Lynda Metallo
 |     Due Date:  18FEB18
 |
 |  Description:  A program that performs a sort by using a binary search
 |                tree. The program should be able to sort lists of integers
 |                or lists of fractions in either ascending or descending
 |                order. One set of radio buttons should be used to determine
 |                whether the lists contain integers or fractions and a
 |                second set should be used to specify the sort order.
 |
 |     Language:  Java 9
 |
 *===========================================================================*/

public class BinarySearchMain {
    private JRadioButton ascendingRadioButton, descendingRadioButton;
    private JRadioButton integerRadioButton, fractionRadioButton;
    private JTextField expressionEntryField, expressionResultField;

    public static void main(String[] args) {
        BinarySearchMain binarySearch = new BinarySearchMain();
        binarySearch.instantiateGui();
    }

    private void instantiateGui() {
        JFrame window = new JFrame("Binary Search Tree Sort");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel) window.getContentPane();
        window.setLayout(null);

        JLabel promptLabel = new JLabel("Original List");
        promptLabel.setBounds(25, 15, 100, 20);
        panel.add(promptLabel);

        JLabel resultLabel = new JLabel("Sorted List");
        resultLabel.setBounds(25, 70, 100, 20);
        panel.add(resultLabel);

        expressionEntryField = new JTextField("", 30);
        expressionEntryField.setBounds(125, 15, 350, 20);
        panel.add(expressionEntryField);

        expressionResultField = new JTextField("", 30);
        expressionResultField.setBounds(125, 70, 350, 20);
        panel.add(expressionResultField);

        JButton performSortButton = new JButton("Perform Sort");
        performSortButton.setBounds(175, 125, 125, 25);
        performSortButton.addActionListener((ActionEvent e) -> {
            try {
                String entry = expressionEntryField.getText();
                validateUserInput(entry);
                validateUserSelections();
                sortButtonAction(entry);
            } catch (GeneralException | NonNumericException e1) {
                System.out.println("Uncaught Exception: " + e1);
            }
        });
        panel.add(performSortButton);

        JLabel sortMenuLabel = new JLabel("Sort Order");
        sortMenuLabel.setBounds(25, 150, 100, 20);
        panel.add(sortMenuLabel);
        ButtonGroup sortMenuGroup = new ButtonGroup();

        JLabel typeMenuLabel = new JLabel("Numeric Type");
        typeMenuLabel.setBounds(375, 150, 100, 20);
        panel.add(typeMenuLabel);
        ButtonGroup typeMenuGroup = new ButtonGroup();

        ascendingRadioButton = new JRadioButton("Ascending");
        ascendingRadioButton.setBounds(20, 175, 100, 20);
        panel.add(ascendingRadioButton);
        sortMenuGroup.add(ascendingRadioButton);

        descendingRadioButton = new JRadioButton("Descending");
        descendingRadioButton.setBounds(20, 200, 100, 20);
        panel.add(descendingRadioButton);
        sortMenuGroup.add(descendingRadioButton);

        integerRadioButton = new JRadioButton("Integer");
        integerRadioButton.setBounds(370, 175, 100, 20);
        panel.add(integerRadioButton);
        typeMenuGroup.add(integerRadioButton);

        fractionRadioButton = new JRadioButton("Fraction");
        fractionRadioButton.setBounds(370, 200, 100, 20);
        panel.add(fractionRadioButton);
        typeMenuGroup.add(fractionRadioButton);

        window.getRootPane().setDefaultButton(performSortButton);
        window.setSize(500, 275);
        window.setVisible(true);
    }

    private void sortButtonAction(String entry) throws GeneralException {
        BinarySearchTree binarySearchTree;
        String values[] = entry.split(" ");

        // TODO: Optimize
        if (fractionRadioButton.isSelected()) {
            binarySearchTree = new BinarySearchTree(new FractionComparision(values[0]));

            for (int i = 1; i < values.length; i++) {
                if (values[i].split("/").length > 2) {
                    throw new GeneralException("Error. Malformed Fraction", "Malformed Fraction");
                }
                if (!values[i].contains("/")) {
                    Integer.parseInt(values[i]);
                    values[i] = values[i] + "/1";
                }
                binarySearchTree.insert(new FractionComparision(values[i]));
            }
        } else {
            binarySearchTree = new BinarySearchTree(Integer.parseInt(values[0]));
            for (int i = 1; i < values.length; i++) {
                binarySearchTree.insert(Integer.parseInt(values[i]));
            }
        }
        if (ascendingRadioButton.isSelected()) {
            expressionResultField.setText(binarySearchTree.ascendingOrder(binarySearchTree.getRoot()));
        } else {
            expressionResultField.setText(binarySearchTree.descendingOrder(binarySearchTree.getRoot()));
        }
    }

    private void validateUserInput(String entry) throws GeneralException {
        if (entry.equals("")) {
            throw new GeneralException("Please Enter an Expression.", "No Input");
        }

        for (int i = 0; i < entry.length(); i++) {
            char c = entry.charAt(i);
            if (!Character.isDigit(c) && c != '/' && !Character.isWhitespace(c)) {
                throw new NonNumericException("Error: Non numeric input detected.", "Non Numeric Input");
            }
            if (c == '/' && integerRadioButton.isSelected()) {
                throw new GeneralException("Error: List of Integers contains a fraction.", "Fraction Found");
            }
        }
    }

    private void validateUserSelections() throws GeneralException {
        if (!fractionRadioButton.isSelected() && !integerRadioButton.isSelected()) {
            throw new GeneralException("Please Select a Numeric Type", "No Numeric Type");
        }
        if (!ascendingRadioButton.isSelected() && !descendingRadioButton.isSelected()) {
            throw new GeneralException("Please Select a Sort Type", "No Sort Type");
        }
    }
}