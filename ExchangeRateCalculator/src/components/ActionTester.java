package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
class PrintHelloAction extends AbstractAction {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final Icon printIcon = new ImageIcon("Print.gif");
  PrintHelloAction() {
    super("Print", printIcon);
    putValue(Action.SHORT_DESCRIPTION, "Hello, World");
  }
  public void actionPerformed(ActionEvent actionEvent) {
    System.out.println("Hello, World");
  }
}
public class ActionTester {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Action Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final Action printAction = new PrintHelloAction();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    menuBar.add(menu);
    menu.add(new JMenuItem(printAction));
    JToolBar toolbar = new JToolBar();
    toolbar.add(new JButton(printAction));
    JButton enableButton = new JButton("Enable");
    ActionListener enableActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        printAction.setEnabled(true);
      }
    };
    enableButton.addActionListener(enableActionListener);
    JButton disableButton = new JButton("Disable");
    ActionListener disableActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        printAction.setEnabled(false);
      }
    };
    disableButton.addActionListener(disableActionListener);
    JButton relabelButton = new JButton("Relabel");
    ActionListener relabelActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        printAction.putValue(Action.NAME, "Changed Action Value");
      }
    };
    relabelButton.addActionListener(relabelActionListener);
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(enableButton);
    buttonPanel.add(disableButton);
    buttonPanel.add(relabelButton);
    frame.setJMenuBar(menuBar);
    frame.add(toolbar, BorderLayout.SOUTH);
    frame.add(buttonPanel, BorderLayout.NORTH);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}