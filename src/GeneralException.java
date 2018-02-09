import javax.swing.*;

class Exception extends java.lang.Exception {

    Exception(String message, String title) {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
