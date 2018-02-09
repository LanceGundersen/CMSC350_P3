import javax.swing.*;

class GeneralException extends Exception {

    GeneralException(String message, String title) {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
