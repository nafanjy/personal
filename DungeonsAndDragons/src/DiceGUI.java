import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DiceGUI extends JFrame{

	JPanel panel = new JPanel();
	JButton roll = new JButton("Roll!");
	JLabel label = new JLabel("Automatic Dice Roller");
	JLabel typeLabel = new JLabel("Number of Sides:");
	JLabel amountLabel = new JLabel("Number of Dice:");
	JLabel resultsLabel = new JLabel("Results:");
	JLabel sumLabel = new JLabel("Sum:");

	JTextField typeIn = new JTextField("");
	JTextField amountIn = new JTextField("");
	JTextField resultsOut = new JTextField("");
	JTextField sumOut = new JTextField("");

	public static void main(String[] args) {
		new DiceGUI();
	}

	public DiceGUI() {
		super("Dice Rolling App");

		setSize(600, 400);
		setResizable(true);

		panel.setLayout(null);

		label.setBounds(200, 10, 200, 20);
		label.setFont(label.getFont().deriveFont(Font.BOLD, 18));
		panel.add(label);

		typeLabel.setBounds(10, 70, 110, 20);
		typeLabel.setFont(label.getFont().deriveFont(Font.BOLD, 13));
		panel.add(typeLabel);
		typeIn.setBounds(130, 70, 40, 20);
		panel.add(typeIn);

		amountLabel.setBounds(230, 70, 120, 20);
		amountLabel.setFont(label.getFont().deriveFont(Font.BOLD, 13));
		panel.add(amountLabel);
		amountIn.setBounds(340, 70, 40, 20);
		panel.add(amountIn);

		resultsLabel.setBounds(10, 130, 110, 20);
		resultsLabel.setFont(label.getFont().deriveFont(Font.BOLD, 13));
		panel.add(resultsLabel);
		resultsOut.setBounds(10, 150, 560, 20);
		panel.add(resultsOut);

		sumLabel.setBounds(10, 200, 50, 20);
		sumLabel.setFont(label.getFont().deriveFont(Font.BOLD, 13));
		panel.add(sumLabel);
		sumOut.setBounds(60, 200, 80, 20);
		panel.add(sumOut);

		roll.setBounds(250, 280, 100, 40);
		roll.setFont(label.getFont().deriveFont(Font.BOLD, 16));
		panel.add(roll);
		Roll rollAct = new Roll();
		roll.addActionListener(rollAct);

		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class Roll implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int sides = Integer.parseInt(typeIn.getText());
			int number = Integer.parseInt(amountIn.getText());
			ArrayList<Integer> results = new ArrayList<>();
			int sum = 0;

			Dice dice = new Dice(sides);

			for (int i = 0; i < number; i++) {
				int x = dice.roll();
				results.add(x);
			}

			resultsOut.setText(results.toString().replace("[", "").replace("]", ""));

			for (int i = 0; i < results.size(); i++) {
				sum += results.get(i);
			}

			sumOut.setText(String.valueOf(sum));
		}
	}
}
