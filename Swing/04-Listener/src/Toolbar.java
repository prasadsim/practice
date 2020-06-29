import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton helloButton, byeButton;
	private StringListener textListener;

	public Toolbar() {
		helloButton = new JButton("Hello");
		byeButton = new JButton("Bye");

		helloButton.addActionListener(this);
		byeButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloButton);
		add(byeButton);
	}

	public void setStringListener(StringListener sl) {
		this.textListener = sl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();

		if (clicked == helloButton)
			textListener.textEmitted("\nHello");
		else
			textListener.textEmitted("\nBye");
	}

}
