import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui {

    //variables for income window
    JFrame incomeFrame;
    JPanel incomePanel;
    String[] categories = {"-Select-","Salary", "Scholarship", "Pension", "Other"};
    JComboBox category;
    JButton addIncome;
    JRadioButton card;
    JRadioButton cash;
    JLabel incomeAmountLabel;
    JLabel incomeAccountLabel;
    JLabel incomeCategoryLabel;
    JTextField amountField;
    Font myFont = new Font("SimSun", Font.PLAIN, 15);
    Color bgColor= new Color(204,243,212);
    Color buttonColor = new Color(35, 186, 81);
    Color fontColor= new Color(1, 115, 35);
    Color fieldColor = new Color(230, 252, 237);
    ImageIcon myImage;
    ArrayList<Income> incomes = new ArrayList<>();
    int i;
    JButton back;

    //variables for choice window
    JFrame choiceFrame;
    JPanel choicePanel;
    JButton incomeButton;
    JButton expenseButton;
    ArrayList<Label> incomesExpenses;

    JFrame frameExpenseWindow;
    JPanel expensePanel;
    JRadioButton expenseRadioCash;
    JRadioButton expenseRadioCard;
    ButtonGroup expenseButtons;

    String[] expenseCategories = {"-Select-", "Food", "Bills", "Entertainment", "Other"};
    JComboBox expenseCombo;

   // JTextField amountField;
    //ImageIcon myImage = new ImageIcon("src\\porc.png");
    ImageIcon logginImage = new ImageIcon("src\\porcusorLogin.png");
    ImageIcon expenseImage = new ImageIcon("src\\porcusorExpense.png");
    JLabel imageLabelExpense;
    JTextField expenseField;
    JLabel expenseLabel;
    JLabel expenseAccountLabel;
    JLabel expenseCategoryLabel;
    JButton expenseAddButton;
    int j = 0;
    //Frame Login / frame expense
    JFrame frameLogin;
    JPanel loginPanel;
    JLabel titleLabel;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField user;
    JPasswordField pass;
    JButton btnLoginSubmit;
    JLabel alertText;
    JLabel imageLabelLogin;

    ArrayList<Expense>expenses = new ArrayList<>();

    public void createIncomeWindow() {
        incomeFrame = new JFrame();
        incomePanel = new JPanel();

        //dropdown
        category = new JComboBox(categories);
        category.setFont(myFont);
        category.setBounds(97, 100, 120, 20);
        category.setBackground(fieldColor);
        category.setForeground(fontColor);

        //labels
        incomeAccountLabel = new JLabel("Account:");
        incomeAmountLabel = new JLabel("Amount:");
        incomeCategoryLabel = new JLabel("Category:");

        incomeAccountLabel.setBounds(10, 20, 70, 20);
        incomeCategoryLabel.setBounds(10, 100, 70, 20);
        incomeAmountLabel.setBounds(10, 210, 70, 20);

        incomeAmountLabel.setFont(myFont);
        incomeCategoryLabel.setFont(myFont);
        incomeAccountLabel.setFont(myFont);

        incomeAccountLabel.setForeground(fontColor);
        incomeAmountLabel.setForeground(fontColor);
        incomeCategoryLabel.setForeground(fontColor);

        //field
        amountField = new JTextField(30);
        amountField.setBounds(97, 210, 100, 20);
        amountField.setBackground(fieldColor);
        amountField.setForeground(fontColor);

        //buttons
        addIncome = new JButton("Add");
        addIncome.setBounds(10, 240, 100, 20);
        addIncome.setBackground(buttonColor);
        addIncome.setForeground(Color.white);
        addIncome.setFont(myFont);
        card = new JRadioButton("Card");
        cash = new JRadioButton("Cash");
        card.setFont(myFont);
        cash.setFont(myFont);
        card.setForeground(fontColor);
        cash.setForeground(fontColor);
        card.setOpaque(false);
        cash.setOpaque(false);
        card.setBounds(97, 20, 100, 20);
        cash.setBounds(97, 50, 100, 20);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(card);
        buttonGroup.add(cash);
        back = new JButton("Back");
        back.setFont(myFont);
        back.setBackground(buttonColor);
        back.setForeground(Color.white);
        back.setBounds(20, 400, 70, 20);

        //image
        JLabel label = new JLabel();
        myImage= new ImageIcon("src\\piggy.png");
        label.setIcon(myImage);
        label.setBounds(100, 220, 300, 300);


        addIncome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incomes.add(new Income());
                transaction(incomes);
                incomes.get(i).transaction();
                System.out.println(incomes.get(i).getBalance());
                i++;
            }

        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incomeFrame.setVisible(false);
                choiceFrame.setVisible(true);
            }
        });

        incomePanel.setBackground(bgColor);
        incomeFrame.setSize(400, 550);
        incomeFrame.setContentPane(incomePanel);
        incomePanel.add(category);
        incomePanel.add(addIncome);
        incomePanel.add(cash);
        incomePanel.add(card);
        incomePanel.add(label);
        incomePanel.add(back);
        incomePanel.add(incomeAccountLabel);
        incomePanel.add(incomeAmountLabel);
        incomePanel.add(incomeCategoryLabel);
        incomePanel.add(amountField);
        incomeFrame.setLayout(null);
        incomeFrame.setResizable(false);
        incomeFrame.setVisible(false);
        incomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void createChoiceWindow(){
        choiceFrame = new JFrame();
        choicePanel = new JPanel();
        expenseButton= new JButton("Expense");
        incomeButton= new JButton("Income");
        expenseButton.setFont(myFont);
        incomeButton.setFont(myFont);
        expenseButton.setForeground(Color.white);
        incomeButton.setForeground(Color.white);
        expenseButton.setBackground(buttonColor);
        incomeButton.setBackground(buttonColor);
        expenseButton.setBounds(80, 450, 100, 30);
        incomeButton.setBounds(210, 450, 100, 30);

        incomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incomeFrame.setVisible(true);

            }
        });

        choiceFrame.setSize(400, 550);
        choiceFrame.setContentPane(choicePanel);
        choicePanel.setBackground(bgColor);
        choicePanel.add(expenseButton);
        choicePanel.add(incomeButton);

        choiceFrame.setLayout(null);
        choiceFrame.setVisible(true);
        choiceFrame.setResizable(false);
        choiceFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void transaction(ArrayList<Income> incomes){
        if(card.isSelected()) {
            incomes.get(i).setAccount("Card");
        }
        else if (cash.isSelected()){
            incomes.get(i).setAccount("Cash");
        }
        else{
            JOptionPane.showMessageDialog(incomeFrame, "Choose an account!","Warning" , JOptionPane.WARNING_MESSAGE);
        }
        if(category.getItemAt(category.getSelectedIndex()).equals("-Select-")){
            JOptionPane.showMessageDialog(incomeFrame, "Choose a category!","Warning" , JOptionPane.WARNING_MESSAGE);
        }
        else {
            incomes.get(i).setCategory((String) category.getItemAt(category.getSelectedIndex()));
        }
        if(amountField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(incomeFrame, "Enter an amount!","Warning" , JOptionPane.WARNING_MESSAGE);
        }
        else{
            incomes.get(i).setAmount(Double.parseDouble(amountField.getText()));
        }
        JOptionPane.showMessageDialog(incomeFrame, "Income added successfully!");

    }

    public void createLoginGui() {
        // Fereastra login
        frameLogin = new JFrame();
        loginPanel =new JPanel();
        loginPanel.setBackground(bgColor);

        titleLabel = new JLabel();
        titleLabel.setBounds(200, 13, 273, 93);
        titleLabel.setText("TITLE");
        titleLabel.setFont(myFont);


        userLabel = new JLabel();
        userLabel.setBounds(170, 80, 200, 200);
        userLabel.setText("USERNAME");
        userLabel.setFont(myFont);

        passwordLabel = new JLabel();
        passwordLabel.setBounds(170, 150, 200,200);
        passwordLabel.setText("PASSWORD");
        passwordLabel.setFont(myFont);

        user = new JTextField(15);
        user.setBounds(170,190,100,20);
        user.setForeground(Color.black);


        pass = new JPasswordField(15);
        pass.setBounds(170, 260, 100,20);
        pass.setForeground(Color.black);

        btnLoginSubmit = new JButton("SUBMIT");
        btnLoginSubmit.setFont(myFont);
        btnLoginSubmit.setBounds(160,330,100,20);
        btnLoginSubmit.setBorderPainted(false);
        btnLoginSubmit.setFocusPainted(false);

        alertText = new JLabel();
        alertText.setSize(200,200);
        alertText.setBounds(100,350,500,50);

        btnLoginSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = String.valueOf(pass.getPassword());

                if ((username.isBlank() && username.isEmpty()) && (password.isBlank() && password.isEmpty())) {
                    alertText.setText("Username and password cannot be empty");
                }
                else if (username.isBlank() && username.isEmpty()) {
                    alertText.setText("Empty name");
                }
                else if (password.isBlank() && password.isEmpty()) {
                    alertText.setText("Empty pass");
                }
            }
        });

        imageLabelLogin = new JLabel();
        imageLabelLogin.setIcon(logginImage);
        imageLabelLogin.setBounds(0,245,300,300);

        frameLogin.setSize(400, 550);
        frameLogin.setContentPane(loginPanel);
        loginPanel.add(titleLabel);
        loginPanel.add(userLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(user);
        loginPanel.add(pass);
        loginPanel.add(btnLoginSubmit);
        loginPanel.add(alertText);
        loginPanel.add(imageLabelLogin);
        frameLogin.setLayout(null);
        frameLogin.setResizable(false);
        frameLogin.setVisible(true);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createExpenseGui() {
        frameExpenseWindow = new JFrame();
        expensePanel = new JPanel();
        expensePanel.setBackground(bgColor);

        expenseAccountLabel = new JLabel("Account:");
        expenseAccountLabel.setBounds(15,30,100,20);
        expenseAccountLabel.setFont(myFont);

        expenseRadioCash = new JRadioButton("Cash");
        expenseRadioCash.setBounds(75,25,100,30);
        expenseRadioCash.setOpaque(false);
        expenseRadioCash.setFont(myFont);
        expenseRadioCard = new JRadioButton("Card");
        expenseRadioCard.setBounds(75,50,100,30);
        expenseRadioCard.setFont(myFont);
        expenseRadioCard.setOpaque(false);

        expenseButtons = new ButtonGroup();
        expenseButtons.add(expenseRadioCash);
        expenseButtons.add(expenseRadioCard);

        expenseCategoryLabel = new JLabel("Category:");
        expenseCategoryLabel.setBounds(0,95,100,20);
        expenseCategoryLabel.setFont(myFont);

        expenseCombo = new JComboBox(expenseCategories);
        expenseCombo.setBounds(75, 95, 120, 20);
        expenseCombo.setFont(myFont);

        imageLabelExpense = new JLabel();
        imageLabelExpense.setIcon(expenseImage);
        imageLabelExpense.setBounds(40,245,300,300);


        expenseField = new JTextField(20);
        expenseField.setBounds(75, 145,120,20);

        expenseLabel = new JLabel("Amount:");
        expenseLabel.setBounds(20,145,100,20);
        expenseLabel.setFont(myFont);

        expenseAddButton = new JButton("Add");
        expenseAddButton.setFont(myFont);
        expenseAddButton.setBounds(80,180,100,20);
        expenseAddButton.setBorderPainted(false);
        expenseAddButton.setFocusPainted(false);

        expenseAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expenses.add(new Expense());
                String str = expenseField.getText();
                if (expenseRadioCash.isSelected()) {
                    expenses.get(j).setAccount("Cash");
                }
                else if (expenseRadioCard.isSelected()) {
                    expenses.get(j).setAccount("Card");
                }
                if (expenseCombo.getItemAt(expenseCombo.getSelectedIndex()).equals("-Select-")) {
                    //
                }
                else {
                    expenses.get(j).setCategory((String) expenseCombo.getItemAt(expenseCombo.getSelectedIndex()));
                }
                if (str.isBlank() && str.isEmpty()) {
                    JOptionPane.showMessageDialog(frameExpenseWindow,"Enter a amount","Empty field",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    //
                }
                j++;
            }

        });

        frameExpenseWindow.setSize(400, 550);
        frameExpenseWindow.setContentPane(expensePanel);
        expensePanel.add(expenseRadioCash);
        expensePanel.add(expenseRadioCard);
        expensePanel.add(imageLabelExpense);
        expensePanel.add(expenseCombo);
        expensePanel.add(expenseField);
        expensePanel.add(expenseLabel);
        expensePanel.add(expenseAccountLabel);
        expensePanel.add(expenseCategoryLabel);
        expensePanel.add(expenseAddButton);
        frameExpenseWindow.setLayout(null);
        frameExpenseWindow.setResizable(false);
        frameExpenseWindow.setVisible(true);
        frameExpenseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
