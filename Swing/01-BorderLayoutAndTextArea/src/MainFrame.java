import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private TextPanel tp;
	private JButton b;

	public MainFrame() {
		super("ASH");

		setLayout(new BorderLayout());

		tp = new TextPanel();
		b = new JButton("Click me");

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tp.appentText("Hello Mofo\n");
			}
		});

		add(tp, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}
