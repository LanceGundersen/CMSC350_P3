import javax.swing.*;

/*+----------------------------------------------------------------------
 ||
 ||  Class NonNumericException
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Catches a non-numeric char and also a number
 ||                  formatting issue such as found in fractions.
 ||
 ++-----------------------------------------------------------------------*/

class NonNumericException extends NumberFormatException {

    NonNumericException(String message, String title) {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}