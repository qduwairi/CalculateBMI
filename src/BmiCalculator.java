import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BmiCalculator extends JFrame implements ActionListener {
    private double weightInPounds, heightInInches, weightInKilograms, heightInMeters, result;
    final double INCH_IN_METER = 0.0254;
    final double POUND_IN_KILOGRAMS = 0.45359237;

    //JText for entering weight in pounds
    JTextField weightPoundText = new JTextField(5);

    //JText for entering height in inches
    JTextField heightInchesText = new JTextField(5);

    //calculate button
    JButton calculateBmi = new JButton("Calculate BMI");

    //result label
    JLabel resultLabel = new JLabel();
    JLabel intrepretation = new JLabel();

    public BmiCalculator(){
        setTitle("BMI Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400, 250);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5, 5, 5);

        add(new JLabel("Enter weight in pounds: "), gbc);

        gbc.gridx = 1;
        add(weightPoundText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Enter height in inches: "),gbc);

        gbc.gridx = 1;
        add(heightInchesText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(calculateBmi, gbc);
        calculateBmi.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 3;
        Font font = new Font("Arial", Font.BOLD, 14);
        intrepretation.setFont(font);
        add(intrepretation, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate BMI")){
            try {
                weightInPounds = Double.parseDouble(weightPoundText.getText());
                heightInInches = Double.parseDouble(heightInchesText.getText());


                weightInKilograms = calculateWeightInKilograms();
                heightInMeters = calculateHeightInMeters();


                if (calculateBmi() < 18.5) {
                    intrepretation.setForeground(Color.orange);
                    intrepretation.setText("Underweight");
                }
                else if (calculateBmi() < 25) {
                    intrepretation.setForeground(Color.GREEN);
                    intrepretation.setText("Normal");
                }
                else if (calculateBmi() < 30) {
                    intrepretation.setForeground(Color.orange);
                    intrepretation.setText("Overweight");
                }
                else if (calculateBmi() >= 30){
                    intrepretation.setForeground(Color.red);
                    intrepretation.setText("Obese");
                }
            } catch (NumberFormatException ex){
                resultLabel.setText("Invalid Input");
            }
        }
    }

    public static void main(String[] args) {
        BmiCalculator bmi = new BmiCalculator();
    }

    public double calculateWeightInKilograms(){
        return weightInPounds * POUND_IN_KILOGRAMS;
    }

    public double calculateHeightInMeters(){
        return heightInInches * INCH_IN_METER;
    }

    public double calculateBmi(){
        result = weightInKilograms / (heightInMeters * heightInMeters);
        return this.weightInKilograms / (this.heightInMeters * this.heightInMeters);
    }
}
