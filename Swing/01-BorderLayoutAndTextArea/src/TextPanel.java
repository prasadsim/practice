import java.awt.BorderLayout;
import java.awt.Scrollbar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

	private JTextArea ta;
	public TextPanel() {
		
		ta = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(ta),BorderLayout.CENTER);
		
	}
	
	public void appentText(String text) {
		ta.append(text);
	}

}
