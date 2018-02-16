import javax.swing.*;

/*+----------------------------------------------------------------------
 ||
 ||  Class GeneralException
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Catches all general exceptions so the program runs
 ||                  efficiently. Ideally this would extend to a log.
 ||
 ++-----------------------------------------------------------------------*/

class GeneralException extends Exception {

    GeneralException(String message, String title) {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
