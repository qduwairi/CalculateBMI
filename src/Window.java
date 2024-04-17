/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private JTextField weightPoundText = new JTextField(5);
    private JTextField heightInchesText = new JTextField(5);
    private JLabel resultLabel = new JLabel();

    public Window() {
        setTitle("BMI Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300, 150);

        add(new JLabel("Enter weight in pounds: "));
        add(weightPoundText);
        add(new JLabel("Enter height in inches: "));
        add(heightInchesText);

        JButton calculateButton = new JButton("Calculate BMI");
        calculateButton.addActionListener(this);
        add(calculateButton);

        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate BMI")) {
            try {
                double weightInPounds = Double.parseDouble(weightPoundText.getText());
                double heightInInches = Double.parseDouble(heightInchesText.getText());
                double bmi = calculateBmi(weightInPounds, heightInInches);
                resultLabel.setText("BMI: " + bmi);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        }
    }

    private double calculateBmi(double weightInPounds, double heightInInches) {
        final double INCH_IN_METER = 0.0254;
        final double POUND_IN_KILOGRAMS = 0.45359237;
        double weightInKilograms = weightInPounds * POUND_IN_KILOGRAMS;
        double heightInMeters = heightInInches * INCH_IN_METER;
        return weightInKilograms / (heightInMeters * heightInMeters);
    }

    public static void main(String[] args) {
        new Window();
    }
}
*/