import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Exercise (Chapter 4: GUIs with Swing) — matching a layout.
 *
 * Press ▶ on {@code main} to open the window. Right now every component is
 * crammed into a single row. Rearrange the components in {@link #buildForm()} —
 * using nested panels and layout managers (see 4.2) — so the window matches the
 * target screenshot in the notes: the two labelled text fields stacked
 * vertically, with the "Submit" and "Cancel" buttons centred in a row beneath
 * them.
 *
 * There is no automated test for this exercise: you check it by running it and
 * comparing with the picture. See "4.5 Testing UI code" for why UI layout is
 * usually verified by eye rather than by a test.
 *
 * Relevant reading: 4.1 Creating and showing a window, 4.2 Java Swing visual
 * components.
 */
public class RegistrationForm {

  /**
   * Builds the form panel. Change the layout here — the components you need are
   * all present, but they are arranged in a single row rather than stacked.
   *
   * @return the form's root panel
   */
  public static JPanel buildForm() {
    // Each row is its own panel; FlowLayout keeps a row's components side by side.
    JPanel firstNamePanel = new JPanel(new FlowLayout());
    firstNamePanel.add(new JLabel("First name:"));
    firstNamePanel.add(new JTextField(12));

    JPanel lastNamePanel = new JPanel(new FlowLayout());
    lastNamePanel.add(new JLabel("Last name:"));
    lastNamePanel.add(new JTextField(12));

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(new JButton("Submit"));
    buttonPanel.add(new JButton("Cancel"));

    // The main panel stacks the three rows vertically.
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.add(firstNamePanel);
    mainPanel.add(lastNamePanel);
    mainPanel.add(buttonPanel);
    return mainPanel;
  }

  /** Shows the form in a window so you can compare it with the target picture. */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          JFrame frame = new JFrame("Registration");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setContentPane(buildForm());
          frame.pack();
          frame.setVisible(true);
        });
  }
}
