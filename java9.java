import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class SwingDemo extends JFrame implements ActionListener {
    private JTextField textField;
    private JCheckBox checkBox;
    private JRadioButton radio1, radio2;
    private JComboBox<String> comboBox;
    private JButton button;
    private JLabel label;
    public SwingDemo() {
        setTitle("Swing Components Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label = new JLabel("Enter text:");
        textField = new JTextField(10);
        checkBox = new JCheckBox("Accept Terms");
        radio1 = new JRadioButton("Option 1");
        radio2 = new JRadioButton("Option 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        String[] choices = {"Select", "Java", "Python", "C++"};
        comboBox = new JComboBox<>(choices);
        button = new JButton("Submit");
        button.addActionListener(this);
        add(label);
        add(textField);
        add(checkBox);
        add(radio1);
        add(radio2);
        add(comboBox);
        add(button);
    }
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        boolean isChecked = checkBox.isSelected();
        String selectedRadio = radio1.isSelected() ? "Option 1" : radio2.isSelected() ? "Option 2" : "None";
        String selectedItem = (String) comboBox.getSelectedItem();
        
        JOptionPane.showMessageDialog(this, "Text: " + text + "\nChecked: " + isChecked + "\nRadio: " + selectedRadio + "\nCombo: " + selectedItem);
    }
    public static void main(String[] args) {
        SwingDemo demo = new SwingDemo();
        demo.setVisible(true);
    }
}





