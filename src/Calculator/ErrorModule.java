package Calculator;

/**
 * Created by Pranav on 30-04-2015.
 */

import javax.swing.*;

public class ErrorModule {

    public static void displayError(String s)
    {

        JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);

    }
}
