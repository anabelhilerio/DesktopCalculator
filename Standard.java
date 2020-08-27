import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * It initializes the frame and the panels for the calculator. In addition, it
 * itinitalizes the standard operation buttons as well as the giving them actions.
 * In addition, a method that decides whether the standard buttons should be seen
 * or not.
 *
 * @author Anabel Hilerio
 * @version version 1
 */
public class Standard 
{
    //instance variables
    protected JTextArea text;
    protected JTextArea scope;
    protected JButton[] numButtons;
    protected JButton[] opButtons;
    protected JButton[] typeButtons;
    protected JPanel p1;
    protected JPanel p2;
    protected JPanel p3;
    protected JPanel p4;
    protected String temp = "0";
    protected boolean operationFlag;
    protected String operation = "";
    protected Font xLargeFont = null;
    protected Font largeFont = null;
    protected Font midFont = null;
    
    //class constructor
    Standard(){
        //creastes the jframe and initializes it
        JFrame frame = new JFrame("Calculator");
        
        //initializes the JPanels
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        
        //makes the frame visible
        frame.setVisible(true);
        
        //sets the dimensions of the frame
        Dimension size = new Dimension(500, 500);
        frame.setSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //intializes the fonts
        xLargeFont = new Font("Quivira", Font.PLAIN, 52);
        largeFont = new Font("Quivira", Font.PLAIN, 24);
        midFont = new Font("Quivira", Font.PLAIN, 18);
        
        //sets the layout for p1
        p1.setLayout(new BorderLayout());
    
        //initializes text areas and customizes it
        text = new JTextArea("", 1,25);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setFont(xLargeFont);
        p1.add(text,BorderLayout.PAGE_START);
        
        scope = new JTextArea("",1,25);
        scope.setBackground(Color.BLACK);
        scope.setForeground(Color.WHITE);
        scope.setFont(xLargeFont);
        p1.add(scope,BorderLayout.PAGE_END);
        
        //creates a string array of the calculator numbers
        String[] num ={"1","2","3","4","5","6","7","8","9","\u232b", "0", "."};
        
        //sets the layout for p2 and customizes it
        p2.setLayout(new GridLayout(4,3));
        p2.setBorder(new EmptyBorder(0,-1,0,-1));
        p2.setBackground(Color.BLACK);
        
        //initializes JButton array and filling in the array
        numButtons = new JButton[num.length];
        for(int i = 0; i < numButtons.length; i++){
            numButtons[i] = new JButton(num[i]);
            numButtons[i].setBackground(Color.RED);
            numButtons[i].setFont(largeFont);
            p2.add(numButtons[i]);
            numButtons[i].addActionListener(new StandardHandler());//calls the actionListener
        }
        
        //adds the second JPanel to the first one
        p1.add(p2,BorderLayout.CENTER);
        
        //creates a string array of the standard calculator operation
        String[] operations = {"CE","=", "+", "-", "x", "\u00F7"};
        //sets the layout for p2 and customizes it
        p3.setLayout(new GridLayout(11,1));
        p3.setBackground(Color.ORANGE);
        
        //initializes JButton array and filling in the array
        opButtons = new JButton[operations.length];
        for(int i = 0; i < opButtons.length; i++){
            opButtons[i] = new JButton(operations[i]);
            opButtons[i].setBorder(new EmptyBorder(10,10,10,10));
            opButtons[i].setBackground(Color.ORANGE);
            opButtons[i].setFont(largeFont);
            p3.add(opButtons[i]);
            opButtons[i].addActionListener(new StandardHandler()); //calls the actionListener
        }
        
        //adds the third JPanel to the first one
        p1.add(p3,BorderLayout.LINE_END);
        
        //sets the layout for p2 and customizes it
        p4.setLayout(new GridLayout(3,1));
        p4.setBackground(Color.BLACK);
        
        //creates the standard JButton, sets the layout and customizes the fourth JPanel
        JButton standard = new JButton("Standard");
        p4.setLayout(new GridLayout(3,1));
        p4.setBackground(Color.BLACK);
        
        //sets the standard JButton background, adds it to fourth JPanel 
        standard.setBackground(Color.GRAY);
        p4.add(standard);
        standard.addActionListener(new StandardHandler());//adds an ActionListener
        
        p1.add(p4, BorderLayout.LINE_START); //adds fourth JPanel to the first
        
        //adds the main JPanel to the frame
        frame.add(p1);
    }
    
    //creates a new class to allow a scope of just this class for ActionListener 
    class StandardHandler implements ActionListener{
          public void actionPerformed(ActionEvent e){
                //creates variables 
                String newValue = "";
                String view = ""; 
                String num = text.getText();
                double result = 0.0;
                
                JButton buttonPressed = (JButton) e.getSource();
                String buttonValue = buttonPressed.getLabel();
                
                //checks to see if there are any numbers entered when checking "="
                if(buttonValue.equals("=") && num.equals("")){
                    scope.setText("No value set");
                    return;
                }
                else {
                    scope.setText("");
                }
                
                //Gives all the numbers and standard operations actions
                if(buttonValue.equals("=")){
                    //call method for summation
                    double var1 = Double.parseDouble(temp);
                    double var2 = Double.parseDouble(num);
                    if(operation.equals("+")){
                        result = var1 + var2;
                    }
                    else if(operation.equals("-")){
                        result = var1 - var2;
                    }
                    else if(operation.equals("x")){
                        result = var1 * var2;
                    }
                    else{
                        result = var1 / var2;
                    }
                    view = temp + operation + num + " = ";
                    temp = String.valueOf(result);
                    text.setText(temp);
                    scope.setText(view);
                }
                else if(buttonValue.equals("CE")){
                    temp = "0";
                    text.setText("");
                    scope.setText("");
                    operationFlag = false;
                }
                else if(buttonValue.equals("+")){
                    //call method for addition
                    temp = num;
                    operation = "+";
                    operationFlag = true;
                }
                else if(buttonValue.equals("-")){
                    temp = num;
                    operation = "-";
                    operationFlag = true;
                }
                else if(buttonValue.equals("x")){
                    temp = num;
                    operation = "x";
                    operationFlag = true;
                }
                else if(buttonValue.equals("\u00F7")){
                    temp = num;
                    operation = "/";
                    operationFlag = true;
                }
                else if(buttonValue.equals("Standard")){
                    showButtons();
                    Financial financialObj = (Financial)Standard.this;
                    financialObj.hideButtons1();
                    Scientific scientificObj = (Scientific)Standard.this;
                    scientificObj.hideButtons2();
                }
                
                else if(buttonValue.equals("\u232b")){
                    newValue = num.substring(0,num.length()-1);
                    text.setText(newValue);
                }
                else if(operationFlag){
                    newValue = num;
                    operationFlag = false;
                    text.setText(buttonValue);
                }
                else{
                    newValue = num + buttonValue;
                    text.setText(newValue);
                }
          }
    }
    
    //show the standard operation buttons
    public void showButtons(){
        for(int i = 0; i < opButtons.length; i++){
            opButtons[i].setVisible(true);   
        }
    }
}
