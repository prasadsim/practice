import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {

	private TextPanel tp;
	private JButton b;
	private Toolbar tb;
	private FormPanel fp;

	public MainFrame() {
		super("ASH");

		setLayout(new BorderLayout());

		tb = new Toolbar();
		tp = new TextPanel();
		b = new JButton("Click me");
		fp = new FormPanel();

		setJMenuBar(createJMenuBar());

		tb.setStringListener(new StringListener() {
			@Override
			public void textEmitted(String text) {
				tp.appentText(text);
			}
		});

		fp.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory();
				String empCat = e.getEmpCat();
				String taxId = e.getTaxId();
				boolean isCitizen = e.getIsCiziten();
				String gender = e.getGender();
				tp.appentText(name + ": " + occupation + ": " + ageCat + ": " + empCat + ": American: " + isCitizen
						+ ": TaxId: " + taxId + ": Gender: " + gender + "\n");
			}
		});

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tp.appentText("\nHello Mofo");
			}
		});

		add(fp, BorderLayout.WEST);
		add(tb, BorderLayout.NORTH);
		add(tp, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private JMenuBar createJMenuBar() {
		JMenuBar menubar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exportItem = new JMenuItem("Export Data...");
		JMenuItem importItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = JOptionPane.showInputDialog(MainFrame.this, "Enter your user name.",
						"Enter user name", JOptionPane.OK_OPTION | JOptionPane.QUESTION_MESSAGE);

				System.out.println(username);
				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Do you really want to exit the application?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_CANCEL_OPTION) {
					System.exit(0);
				}
			}
		});

		fileMenu.add(exportItem);
		fileMenu.add(importItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showItem = new JCheckBoxMenuItem("Person Form");
		showItem.setSelected(true);

		showMenu.add(showItem);
		windowMenu.add(showMenu);

		menubar.add(fileMenu);
		menubar.add(windowMenu);

		showItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				fp.setVisible(menuItem.isSelected());
			}

		});

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		return menubar;
	}

}
