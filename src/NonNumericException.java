import javax.swing.*;

class NonNumericException extends NumberFormatException {

    NonNumericException(String message, String title) {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}