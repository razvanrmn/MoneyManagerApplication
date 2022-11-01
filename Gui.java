import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;;

public class Gui {
    // variables for income window
    JFrame incomeFrame;
    JPanel incomePanel;
    String[] categories = { "-Select-", "Salary", "Scholarship", "Pension", "Other" };
    JComboBox category;
    JButton addIncome;
    JRadioButton card;
    JRadioButton cash;
    JLabel incomeAmountLabel;
    JLabel incomeAccountLabel;
    JLabel incomeCategoryLabel;
    JLabel incomeTitle;
    JTextField amountField;
    Font myFont = new Font("SimSun", Font.BOLD, 15);
    Font titleFont = new Font("SimSun", Font.PLAIN, 30);
    Color bgColor = new Color(204, 243, 212);
    Color buttonColor = new Color(35, 186, 81);
    Color fontColor = new Color(1, 115, 35);
    Color fieldColor = new Color(230, 252, 237);
    ImageIcon myImage;
    ArrayList<Income> incomes = new ArrayList<>();
    int i;
    JButton back;

    // variables for choice window
    JFrame choiceFrame;
    JPanel choicePanel;
    JButton incomeButton;
    JButton expenseButton;
    JFrame frameExpenseWindow;
    JPanel expensePanel;
    JRadioButton expenseRadioCash;
    JRadioButton expenseRadioCard;
    ButtonGroup expenseButtons;

    String[] expenseCategories = { "-Select-", "Food", "Bills", "Entertainment", "Other" };
    JComboBox expenseCombo;
    ImageIcon loginImage = new ImageIcon("MoneyManagerApplication-main/img/porcusorLogin.png");
    ImageIcon expenseImage = new ImageIcon("MoneyManagerApplication-main/img/porcusorExpense.png");
    JLabel imageLabelExpense;
    JTextField expenseField;
    JLabel expenseLabel;
    JLabel expenseAccountLabel;
    JLabel expenseCategoryLabel;
    JButton expenseAddButton;
    int j = 0;
    // Frame Login / frame expense
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
    JLabel expenseTitle;
    ArrayList<Expense> expenses = new ArrayList<>();

    JLabel balanceLabel;
    JLabel totalInc;
    JLabel totalExp;
    ArrayList<JLabel> incExp = new ArrayList<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Gui constructor
    public Gui() {
        createLoginGui();
        createChoiceWindow();
        createIncomeWindow();
        createExpenseGui();
        FileSingleton.getInstance().writeMsg("All windows were successfully created");
    }

    public void createIncomeWindow() {
        incomeFrame = new JFrame("Income");
        incomePanel = new JPanel();

        System.out.println(System.getProperty("user.dir"));


        // dropdown
        category = new JComboBox(categories);
        category.setFont(myFont);
        category.setBounds(97, 170, 120, 20);
        category.setBackground(fieldColor);
        category.setForeground(fontColor);

        // labels
        incomeTitle = new JLabel("Income");
        incomeTitle.setBounds(137, 12, 273, 93);
        incomeTitle.setForeground(fontColor);
        incomeTitle.setFont(titleFont);

        incomeAccountLabel = new JLabel("Account:");
        incomeAmountLabel = new JLabel("Amount:");
        incomeCategoryLabel = new JLabel("Category:");

        incomeAccountLabel.setBounds(10, 100, 70, 20);
        incomeCategoryLabel.setBounds(10, 170, 100, 20);
        incomeAmountLabel.setBounds(10, 210, 70, 20);

        incomeAmountLabel.setFont(myFont);
        incomeCategoryLabel.setFont(myFont);
        incomeAccountLabel.setFont(myFont);

        incomeAccountLabel.setForeground(fontColor);
        incomeAmountLabel.setForeground(fontColor);
        incomeCategoryLabel.setForeground(fontColor);

        // field
        amountField = new JTextField(30);
        amountField.setBounds(97, 210, 100, 20);
        amountField.setBackground(fieldColor);
        amountField.setForeground(fontColor);

        // buttons
        addIncome = new JButton("Add");
        addIncome.setBounds(54, 240, 60, 20);
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
        card.setBounds(97, 100, 100, 20);
        cash.setBounds(97, 130, 100, 20);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(card);
        buttonGroup.add(cash);
        back = new JButton("Back");
        back.setFont(myFont);
        back.setBackground(buttonColor);
        back.setForeground(Color.white);
        back.setBounds(40, 443, 70, 20);

        // image
        JLabel label = new JLabel();
        myImage = new ImageIcon("img/porcusorExpense.png");
        label.setIcon(myImage);
        label.setBounds(100, 220, 300, 300);

        addIncome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incomes.add(new Income());
                transaction(incomes);
                incomes.get(i).transaction();
                incomes.get(i).total();
                totalInc.setText("Total incomes: " + Income.total);
                Expense.balance += incomes.get(i).getAmount();
                System.out.println(incomes.get(i).toString());
                i++;
                amountField.setText("");
                FileSingleton.getInstance().writeMsg(dtf.format(LocalDateTime.now()) + " Add income button pressed ");
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceFrame.setVisible(true);
                incomeFrame.setVisible(false);
                balanceLabel.setText("Your current balance is " + Income.balance);
                list();
                choiceFrame.repaint();
                FileSingleton.getInstance()
                        .writeMsg(dtf.format(LocalDateTime.now()) + " Back button from Income window pressed");
            }
        });

        incomePanel.setBackground(bgColor);
        incomeFrame.setSize(400, 550);
        incomeFrame.setContentPane(incomePanel);
        incomePanel.add(incomeTitle);
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
        incomeFrame.setLocationRelativeTo(null);
        incomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createChoiceWindow() {
        choiceFrame = new JFrame("Add income/expense");
        choicePanel = new JPanel();
        expenseButton = new JButton("Expense");
        incomeButton = new JButton("Income");
        expenseButton.setFont(myFont);
        incomeButton.setFont(myFont);
        expenseButton.setForeground(Color.white);
        incomeButton.setForeground(Color.white);
        expenseButton.setBackground(buttonColor);
        incomeButton.setBackground(buttonColor);
        incomeButton.setBorderPainted(false);
        incomeButton.setFocusPainted(false);
        expenseButton.setBounds(80, 450, 100, 30);
        expenseButton.setBorderPainted(false);
        expenseButton.setFocusPainted(false);
        incomeButton.setBounds(210, 450, 100, 30);
        balanceLabel = new JLabel("Your current balance is " + Income.balance);
        balanceLabel.setBounds(70, 35, 300, 20);
        balanceLabel.setForeground(fontColor);
        balanceLabel.setFont(myFont);

        totalInc = new JLabel("Total incomes: " + Income.total);
        totalInc.setForeground(fontColor);
        totalInc.setFont(myFont);
        totalInc.setBounds(10, 75, 300, 20);

        totalExp = new JLabel("Total expenses: " + Expense.total);
        totalExp.setForeground(fontColor);
        totalExp.setFont(myFont);
        totalExp.setBounds(10, 250, 300, 20);

        incomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incomeFrame.setVisible(true);
                choiceFrame.setVisible(false);
                FileSingleton.getInstance()
                        .writeMsg(dtf.format(LocalDateTime.now()) + " Add Income button from Choice Window pressed");
            }
        });
        expenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameExpenseWindow.setVisible(true);
                choiceFrame.setVisible(false);
                FileSingleton.getInstance()
                        .writeMsg(dtf.format(LocalDateTime.now()) + " Expense button from Choice Window pressed");
            }
        });

        choiceFrame.setSize(400, 550);
        choiceFrame.setContentPane(choicePanel);
        choicePanel.setBackground(bgColor);
        choicePanel.add(expenseButton);
        choicePanel.add(incomeButton);
        choicePanel.add(balanceLabel);
        choicePanel.add(totalInc);
        choicePanel.add(totalExp);
        choiceFrame.setLayout(null);
        choiceFrame.setVisible(false);
        choiceFrame.setResizable(false);
        choiceFrame.setLocationRelativeTo(null);
        choiceFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void transaction(ArrayList<Income> incomes) {
        if ((!card.isSelected() && !cash.isSelected())
                || category.getItemAt(category.getSelectedIndex()).equals("-Select-")
                || amountField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(incomeFrame, "All fields are required!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
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
                    FileSingleton.getInstance()
                            .writeMsg(dtf.format(LocalDateTime.now()) + " Number format exception transaction Income");
                    amountField.setText("");
                }
        }
    }

    public void createLoginGui() {
        // New login Frame and Panel
        frameLogin = new JFrame("Login");
        loginPanel = new JPanel();
        loginPanel.setBackground(bgColor);
        // Login Labels
        // - Title Label
        titleLabel = new JLabel();
        titleLabel.setBounds(135, 53, 273, 93);
        titleLabel.setText("Welcome");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(fontColor);
        // - Username label
        userLabel = new JLabel();
        userLabel.setBounds(40, 200, 200, 20);
        userLabel.setText("Username");
        userLabel.setFont(myFont);
        userLabel.setForeground(fontColor);
        // - Password label
        passwordLabel = new JLabel();
        passwordLabel.setBounds(40, 230, 200, 20);
        passwordLabel.setText("Password");
        passwordLabel.setFont(myFont);
        passwordLabel.setForeground(fontColor);
        // - Background image Label
        imageLabelLogin = new JLabel();
        imageLabelLogin.setIcon(loginImage);
        imageLabelLogin.setBounds(110, 233, 300, 300);
        // - Alert Label
        alertText = new JLabel();
        alertText.setSize(200, 200);
        alertText.setBounds(100, 350, 500, 50);
        // Username input TextField
        user = new JTextField(15);
        user.setBounds(118, 200, 100, 20);
        user.setBackground(fieldColor);
        user.setForeground(fontColor);
        // Password input PasswordField
        pass = new JPasswordField(15);
        pass.setBounds(118, 230, 100, 20);
        pass.setBackground(fieldColor);
        pass.setForeground(fontColor);
        // Login button
        btnLoginSubmit = new JButton("Login");
        btnLoginSubmit.setFont(myFont);
        btnLoginSubmit.setBounds(95, 280, 80, 20);
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
                    JOptionPane.showMessageDialog(incomeFrame, "Fields cannot be left empty", "Blank fields",
                            JOptionPane.ERROR_MESSAGE);
                } else if (username.isBlank() && username.isEmpty()) {
                    JOptionPane.showMessageDialog(incomeFrame, "Username field is empty", "Empty username",
                            JOptionPane.ERROR_MESSAGE);
                } else if (password.isBlank() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(incomeFrame, "Password field is empty", "Empty password",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    choiceFrame.setVisible(true);
                    frameLogin.setVisible(false);
                    FileSingleton.getInstance().writeMsg(dtf.format(LocalDateTime.now()) + " Login button pressed");
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
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createExpenseGui() {
        // New Expense Frame and Field
        frameExpenseWindow = new JFrame("Expense");
        expensePanel = new JPanel();
        expensePanel.setBackground(bgColor);
        expenseField = new JTextField(30);
        expenseField.setBounds(97, 210, 100, 20);
        expenseField.setBackground(fieldColor);
        expenseField.setForeground(fontColor);

        // Epense Title
        expenseTitle = new JLabel("Expense");
        expenseTitle.setBounds(137, 12, 273, 93);
        expenseTitle.setForeground(fontColor);
        expenseTitle.setFont(titleFont);

        // Account Label
        expenseAccountLabel = new JLabel("Account:");
        expenseAccountLabel.setBounds(10, 100, 70, 20);
        expenseAccountLabel.setFont(myFont);
        expenseAccountLabel.setForeground(fontColor);

        // Category Label
        expenseCategoryLabel = new JLabel("Category:");
        expenseCategoryLabel.setBounds(10, 170, 100, 20);
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
        expenseCombo.setBounds(97, 170, 120, 20);
        expenseCombo.setFont(myFont);
        expenseCombo.setBackground(fieldColor);
        expenseCombo.setForeground(fontColor);

        // Expense buttons
        // - Cash button
        expenseRadioCash = new JRadioButton("Cash");
        expenseRadioCash.setBounds(97, 130, 100, 20);
        expenseRadioCash.setOpaque(false);
        expenseRadioCash.setFont(myFont);
        expenseRadioCash.setForeground(fontColor);

        // - Card button
        expenseRadioCard = new JRadioButton("Card");
        expenseRadioCard.setBounds(97, 100, 100, 20);
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
        expenseAddButton.setBounds(54, 240, 60, 20);
        expenseAddButton.setBorderPainted(false);
        expenseAddButton.setFocusPainted(false);
        // - Back button
        backTo = new JButton("Back");
        backTo.setFont(myFont);
        backTo.setBorderPainted(false);
        backTo.setFocusPainted(false);
        backTo.setBackground(buttonColor);
        backTo.setForeground(Color.white);
        backTo.setBounds(40, 443, 70, 20);

        // Add expense button clicked
        expenseAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expenses.add(new Expense());
                transactionExpense(expenses);
                expenses.get(j).transaction();
                expenses.get(j).total();
                totalExp.setText("Total expenses: " + Expense.total);
                Income.balance -= expenses.get(j).getAmount();
                System.out.println(expenses.get(j).toString());
                j++;
                expenseField.setText("");
                FileSingleton.getInstance()
                        .writeMsg(dtf.format(LocalDateTime.now()) + " Add Expense button was pressed");
            }
        });
        // Back button clicked
        backTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceFrame.setVisible(true);
                frameExpenseWindow.setVisible(false);
                balanceLabel.setText("Your current balance is " + Expense.balance);
                list();
                choiceFrame.repaint();
                FileSingleton.getInstance()
                        .writeMsg(dtf.format(LocalDateTime.now()) + " Back button from Expense window pressed");
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
        expensePanel.add(expenseTitle);
        frameExpenseWindow.setLayout(null);
        frameExpenseWindow.setResizable(false);
        frameExpenseWindow.setVisible(false);
        frameExpenseWindow.setLocationRelativeTo(null);
        frameExpenseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void transactionExpense(ArrayList<Expense> expenseTransaction) {
        if ((!expenseRadioCard.isSelected() && !expenseRadioCash.isSelected()
                || expenseCombo.getItemAt(expenseCombo.getSelectedIndex()).equals("-Select-"))
                || expenseField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameExpenseWindow, "All fields are required!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            if (expenseRadioCard.isSelected()) {
                expenseTransaction.get(j).setAccount("Card");
            } else if (expenseRadioCash.isSelected()) {
                expenseTransaction.get(j).setAccount("Cash");
            }
            if (!expenseCombo.getItemAt(expenseCombo.getSelectedIndex()).equals("-Select-")) {
                expenseTransaction.get(j).setCategory((String) expenseCombo.getItemAt(expenseCombo.getSelectedIndex()));
            }
            if (!expenseField.getText().isEmpty()) {
                try {
                    expenseTransaction.get(j).setAmount(Double.parseDouble(expenseField.getText()));
                    JOptionPane.showMessageDialog(frameExpenseWindow, "Expense added successfully!");
                } catch (NumberFormatException ex) {
                    System.out.println("Number format exception");
                    FileSingleton.getInstance().writeMsg(
                            dtf.format(LocalDateTime.now()) + " Number format exception transaction Expense window");
                    expenseField.setText("");
                }
            }
        }
    }

    public void list() {
        ArrayList<JLabel> incExp = new ArrayList<>();
        int i;
        for (i = 0; i < incomes.size(); i++) {
            incExp.add(new JLabel("Income: " + incomes.get(i).toString()));
            incExp.get(i).setBounds(10, 105 + 20 * i, 400, 20);
            incExp.get(i).setFont(myFont);
            incExp.get(i).setForeground(fontColor);
            choicePanel.add(incExp.get(i));
        }
        for (int j = 0; j < expenses.size(); j++) {
            incExp.add(new JLabel("Expense: " + expenses.get(j).toString()));
            incExp.get(i).setBounds(10, 280 + 20 * j, 400, 20);
            incExp.get(i).setFont(myFont);
            incExp.get(i).setForeground(fontColor);
            choicePanel.add(incExp.get(i));
            i++;
        }
        choiceFrame.repaint();
    }
}
