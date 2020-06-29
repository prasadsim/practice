import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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

		tb.setStringListener(new StringListener() {
			
			@Override
			public void textEmitted(String text) {
				tp.appentText(text);
			}
		});

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tp.appentText("\nHello Mofo");
			}
		});

		add(fp,BorderLayout.WEST);
		add(tb, BorderLayout.NORTH);
		add(tp, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}
