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
    ArrayList<JLabel> incomesExpenses;

    JFrame frameExpenseWindow;
    JPanel expensePanel;
    JRadioButton expenseRadioCash;
    JRadioButton expenseRadioCard;
    ButtonGroup expenseButtons;

    String[] expenseCategories = {"-Select-", "Food", "Bills", "Entertainment", "Other"};
    JComboBox expenseCombo;

    // JTextField amountField;
    //ImageIcon myImage = new ImageIcon("src\\porc.png");
    ImageIcon loginImage = new ImageIcon("src\\porcusorLogin.png");
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
    JButton backTo;
    ArrayList<Expense>expenses = new ArrayList<>();

    JLabel balanceLabel = new JLabel();

    //Gui constructor
    public Gui() {
        createLoginGui();
        createChoiceWindow();
        createIncomeWindow();
        createExpenseGui();
    }
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
                Expense.balance+= incomes.get(i).getAmount();
                System.out.println(incomes.get(i).toString());
                i++;
                amountField.setText("");
                FileSingleton.getInstance().writeMsg("S-a apasat butonul");
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceFrame.setVisible(true);
                incomeFrame.setVisible(false);
                choiceFrame.remove(balanceLabel);
                balanceLabel = new JLabel("Your current balance is " + Income.balance);
                balanceLabel.setBounds(30, 20, 200, 20);
                balanceLabel.setForeground(fontColor);
                balanceLabel.setFont(myFont);
                choiceFrame.add(balanceLabel);
                choiceFrame.repaint();
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
                choiceFrame.setVisible(false);
            }
        });
        expenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameExpenseWindow.setVisible(true);
                choiceFrame.setVisible(false);
            }
        });

        choiceFrame.setSize(400, 550);
        choiceFrame.setContentPane(choicePanel);
        choicePanel.setBackground(bgColor);
        choicePanel.add(expenseButton);
        choicePanel.add(incomeButton);
        choiceFrame.setLayout(null);
        choiceFrame.setVisible(false);
        choiceFrame.setResizable(false);
        choiceFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void transaction(ArrayList<Income> incomes) {
        if ((!card.isSelected() && !cash.isSelected()) || category.getItemAt(category.getSelectedIndex()).equals("-Select-") || amountField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(incomeFrame, "All fields are required!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (card.isSelected()) {
                incomes.get(i).setAccount("Card");
            } else if (cash.isSelected()) {
                incomes.get(i).setAccount("Cash");
            }
            if (!category.getItemAt(category.getSelectedIndex()).equals("-Select-"))
                incomes.get(i).setCategory((String) category.getItemAt(category.getSelectedIndex()));
            if (!amountField.getText().isEmpty())
                try {
                    incomes.get(i).setAmount(Double.parseDouble(amountField.getText()));
                    JOptionPane.showMessageDialog(incomeFrame, "Income added successfully!");
                } catch (NumberFormatException e) {
                    System.out.println("Number format exception");
                    amountField.setText("");
                }
        }
    }

    public void createLoginGui() {
        // New login Frame and Panel
        frameLogin = new JFrame();
        loginPanel =new JPanel();
        loginPanel.setBackground(bgColor);
        // Login Labels
        // - Title Label
        titleLabel = new JLabel();
        titleLabel.setBounds(200, 13, 273, 93);
        titleLabel.setText("Title");
        titleLabel.setFont(myFont);
        titleLabel.setForeground(fontColor);
        // - Username label
        userLabel = new JLabel();
        userLabel.setBounds(170, 80, 200, 200);
        userLabel.setText("Username");
        userLabel.setFont(myFont);
        userLabel.setForeground(fontColor);
        // - Password label
        passwordLabel = new JLabel();
        passwordLabel.setBounds(170, 150, 200,200);
        passwordLabel.setText("Password");
        passwordLabel.setFont(myFont);
        passwordLabel.setForeground(fontColor);
        // - Background image Label
        imageLabelLogin = new JLabel();
        imageLabelLogin.setIcon(loginImage);
        imageLabelLogin.setBounds(0,245,300,300);
        // - Alert Label
        alertText = new JLabel();
        alertText.setSize(200,200);
        alertText.setBounds(100,350,500,50);
        // Username input TextField
        user = new JTextField(15);
        user.setBounds(170,190,100,20);
        user.setBackground(fieldColor);
        user.setForeground(fontColor);
        // Password input PasswordField
        pass = new JPasswordField(15);
        pass.setBounds(170, 260, 100,20);
        pass.setBackground(fieldColor);
        pass.setForeground(fontColor);
        // Login button
        btnLoginSubmit = new JButton("Login");
        btnLoginSubmit.setFont(myFont);
        btnLoginSubmit.setBounds(160,330,100,20);
        btnLoginSubmit.setBackground(buttonColor);
        btnLoginSubmit.setForeground(Color.WHITE);
        btnLoginSubmit.setBorderPainted(false);
        btnLoginSubmit.setFocusPainted(false);

        // Button action
        btnLoginSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = String.valueOf(pass.getPassword());

                if ((username.isBlank() && username.isEmpty()) && (password.isBlank() && password.isEmpty())) {
                    JOptionPane.showMessageDialog(incomeFrame, "Fields cannot be left empty","Blank fields" , JOptionPane.ERROR_MESSAGE);
                }
                else if (username.isBlank() && username.isEmpty()) {
                    JOptionPane.showMessageDialog(incomeFrame, "Username field is empty","Empty username" , JOptionPane.ERROR_MESSAGE);
                }
                else if (password.isBlank() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(incomeFrame, "Password field is empty","Empty password" , JOptionPane.ERROR_MESSAGE);
                }
                else {
                    choiceFrame.setVisible(true);
                    frameLogin.setVisible(false);
                }
            }
        });

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
        // New Expense Frame and Field
        frameExpenseWindow = new JFrame();
        expensePanel = new JPanel();
        expensePanel.setBackground(bgColor);
        expenseField = new JTextField(30);
        expenseField.setBounds(97, 210, 100, 20);
        expenseField.setBackground(fieldColor);
        expenseField.setForeground(fontColor);

        // Account Label
        expenseAccountLabel = new JLabel("Account:");
        expenseAccountLabel.setBounds(10, 20, 70, 20);
        expenseAccountLabel.setFont(myFont);
        expenseAccountLabel.setForeground(fontColor);

        // Category Label
        expenseCategoryLabel = new JLabel("Category:");
        expenseCategoryLabel.setBounds(10, 100, 100, 20);
        expenseCategoryLabel.setFont(myFont);
        expenseCategoryLabel.setForeground(fontColor);

        // Amount Label
        expenseLabel = new JLabel("Amount:");
        expenseLabel.setBounds(10, 210, 70, 20);
        expenseLabel.setFont(myFont);
        expenseLabel.setForeground(fontColor);

        // Image Label
        imageLabelExpense = new JLabel();
        imageLabelExpense.setIcon(expenseImage);
        imageLabelExpense.setBounds(100, 220, 300, 300);

        // Dropdown expense
        expenseCombo = new JComboBox(expenseCategories);
        expenseCombo.setBounds(97, 100, 120, 20);
        expenseCombo.setFont(myFont);
        expenseCombo.setBackground(fieldColor);
        expenseCombo.setForeground(fontColor);

        // Expense buttons
        // - Cash button
        expenseRadioCash = new JRadioButton("Cash");
        expenseRadioCash.setBounds(97, 50, 100, 20);
        expenseRadioCash.setOpaque(false);
        expenseRadioCash.setFont(myFont);
        expenseRadioCash.setForeground(fontColor);


        // - Card button
        expenseRadioCard = new JRadioButton("Card");
        expenseRadioCard.setBounds(97, 20, 100, 20);
        expenseRadioCard.setFont(myFont);
        expenseRadioCard.setOpaque(false);
        expenseRadioCard.setForeground(fontColor);

        // - Button group
        expenseButtons = new ButtonGroup();
        expenseButtons.add(expenseRadioCash);
        expenseButtons.add(expenseRadioCard);
        // - Add expense button
        expenseAddButton = new JButton("Add");
        expenseAddButton.setFont(myFont);
        expenseAddButton.setBackground(buttonColor);
        expenseAddButton.setForeground(Color.WHITE);
        expenseAddButton.setBounds(10, 240, 100, 20);
        expenseAddButton.setBorderPainted(false);
        expenseAddButton.setFocusPainted(false);
        // - Back button
        backTo = new JButton("Back");
        backTo.setFont(myFont);
        backTo.setBackground(buttonColor);
        backTo.setForeground(Color.white);
        backTo.setBounds(20, 400, 70, 20);

        // Add expense button clicked
        expenseAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expenses.add(new Expense());
                transactionExpense(expenses);
                expenses.get(j).transaction();
                Income.balance-= expenses.get(j).getAmount();
                j++;
            }
        });
        // Back button clicked
        backTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceFrame.setVisible(true);
                frameExpenseWindow.setVisible(false);
                choiceFrame.remove(balanceLabel);
                balanceLabel = new JLabel("Your current balance is " + Expense.balance);
                balanceLabel.setBounds(30, 20, 200, 20);
                balanceLabel.setForeground(fontColor);
                balanceLabel.setFont(myFont);
                choiceFrame.add(balanceLabel);
                choiceFrame.repaint();
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
        expensePanel.add(backTo);
        frameExpenseWindow.setLayout(null);
        frameExpenseWindow.setResizable(false);
        frameExpenseWindow.setVisible(false);
        frameExpenseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void transactionExpense(ArrayList<Expense> expenseTransaction){
        if(expenseRadioCard.isSelected()) {
            expenseTransaction.get(j).setAccount("Card");
        }
        else if (expenseRadioCash.isSelected()){
            expenseTransaction.get(j).setAccount("Cash");
        }
        else if (! (expenseRadioCard.isSelected()) && !(expenseRadioCash.isSelected())) {
            JOptionPane.showMessageDialog(frameExpenseWindow, "Choose an account!","Warning" , JOptionPane.WARNING_MESSAGE);
        }
        if(expenseCombo.getItemAt(expenseCombo.getSelectedIndex()).equals("-Select-")){
            JOptionPane.showMessageDialog(frameExpenseWindow, "Choose a category!","Warning" , JOptionPane.WARNING_MESSAGE);
        }
        else {
            expenseTransaction.get(j).setCategory((String) expenseCombo.getItemAt(expenseCombo.getSelectedIndex()));
        }
        if(expenseField.getText().isEmpty() && expenseField.getText().isBlank()) {
            JOptionPane.showMessageDialog(frameExpenseWindow, "Enter an amount!","Warning" , JOptionPane.WARNING_MESSAGE);
        }
        else{
            try {
                expenseTransaction.get(j).setAmount(Double.parseDouble(expenseField.getText()));
                JOptionPane.showMessageDialog(frameExpenseWindow, "Expense added successfully!");
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frameExpenseWindow, "Invalid amount value", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            if (expenseField.getText().isBlank() || expenseField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frameExpenseWindow, "Fields cannot be left empty", "Empty Field", JOptionPane.WARNING_MESSAGE);
            }
            expenses.get(j).setAmount(Double.parseDouble(expenseField.getText()));
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frameExpenseWindow,"Enter a valid amount","Invalid input",JOptionPane.WARNING_MESSAGE);
            expenseField.setText("");
        }
    }

}
