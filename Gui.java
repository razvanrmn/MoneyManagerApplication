import javax.swing.*;
import java.awt.*;

public class Gui {
    JFrame frame;
    JPanel incomePanel;
    String[] categories = {"Salary", "Scholarship", "Pension", "Other"};
    JComboBox category;
    JButton addIncome;
    JRadioButton card;
    JRadioButton cash;
    JLabel incomeAmount;
    JLabel incomeAccount;
    JLabel incomeCategory;
    JTextField amountField;
    Font myFont = new Font("SimSun", Font.PLAIN, 15);
    Color bgColor= new Color(204,243,212);
    ImageIcon myImage= new ImageIcon("C:\\Users\\BOGI\\Desktop\\Downloads\\piggy.jpg");
    //JFreeChart chart = ChartF

    public Gui() {
        frame= new JFrame();
        incomePanel = new JPanel();
        incomePanel.setBackground(bgColor);
        category = new JComboBox(categories);
        category.setFont(myFont);
        category.setBounds(97, 100, 100, 20);
        addIncome = new JButton("Add");
        addIncome.setBounds(10, 210, 100, 20);
        card= new JRadioButton("Card");
        cash=new JRadioButton("Cash");

        JLabel label = new JLabel();
        label.setIcon(myImage);
        label.setBounds(10, 200, 300, 300);
        incomePanel.add(label);
        cash.setFont(myFont);
        //card.setFont(myFont);
        card.setFont(myFont);
        card.setOpaque(false);
        cash.setOpaque(false);
        card.setBounds(97, 20, 100, 20);
        cash.setBounds(97, 50, 100, 20);
        amountField = new JTextField(20);
        incomeAccount = new JLabel("Account");

        incomeAmount= new JLabel("Amount");
        incomeCategory= new JLabel("Category");
        incomeAccount.setBounds(10, 20, 70, 20);
        incomeCategory.setBounds(10, 100, 70, 20);
        incomeCategory.setFont(myFont);
        incomeAccount.setFont(myFont);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(card);
        buttonGroup.add(cash);

        frame.setSize(400, 550);
        frame.setContentPane(incomePanel);
        incomePanel.add(category);
        incomePanel.add(addIncome);
        incomePanel.add(cash);
        incomePanel.add(card);
        incomePanel.add(incomeAccount);
        incomePanel.add(incomeAmount);
        incomePanel.add(incomeCategory);
        incomePanel.add(amountField);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
