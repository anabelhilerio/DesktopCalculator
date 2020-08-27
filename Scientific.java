import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * It contains a constuctor. It also makes a scientific button as well as 
 * working scientific operation buttons. It determines whether they should 
 * show or not. It extends financial method.
 *
 * @author Anabel Hilerio
 * @version Version 1
 */
public class Scientific extends Financial
{
    //Creates a scientific operation JButton array
    protected JButton[] sciButtons = null;
    Scientific(){
        //Calls the super class
        super();
        
        //creates a String array for the scientific operations
        String[] sci = {"sin", "cos", "tan", "\u221A"};
        
        //initializes the scientific JButton array
        sciButtons = new JButton[sci.length];
        for(int i = 0; i < sciButtons.length; i++){
            sciButtons[i] = new JButton(sci[i]);
            sciButtons[i].setBorder(new EmptyBorder(10,10,10,10));
            //opButtons[i].setBorder(new LineBorder(Color.RED,1));
            sciButtons[i].setBackground(Color.ORANGE);
            sciButtons[i].setFont(largeFont);
            
            p3.add(sciButtons[i]);
            sciButtons[i].addActionListener(new ScientificHandler()); //adds an ActionListener
        }
        
        //creates a JButton for scientific button and customizes it
        JButton scientific = new JButton("Scientific");
        scientific.setBackground(Color.GRAY);
        p4.add(scientific); //adds it to the fourth JPanel
        scientific.addActionListener(new ScientificHandler()); //adds an ActionListener
      
    }
    
    //creates a new class to allow a scope of just this class for ActionListener
    class ScientificHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //creates variables
            String newValue = "";
            String view = ""; 
            String num = text.getText();;
            double result = 0.0;
            
            //checks to see if there are any numbers entered
            if(num.equals("")){
                scope.setText("No value set");
                return;
            }

            
            JButton buttonPressed = (JButton) e.getSource();
            String buttonValue = buttonPressed.getLabel();
            
            //Gives actions to the scientific buttons
            if(buttonValue.equals("sin")){
                //turns degrees into radians
                double degrees = Double.parseDouble(num);
                double radians = Math.toRadians(degrees);
                result = Math.sin(radians);
                //turns it into a long then into a string
                temp = String.valueOf((long)result);
                text.setText(temp);
                view = "sin(" + num + ") = ";
                scope.setText(view);
                operationFlag = true;
            }
            else if(buttonValue.equals("cos")){
                double degrees = Double.parseDouble(num);
                double radians = Math.toRadians(degrees);
                result = Math.cos(radians);
                temp = String.valueOf((long)result);
                text.setText(temp);
                view = "cos(" + num + ") = ";
                scope.setText(view);
                operationFlag = true;
            }
            else if(buttonValue.equals("tan")){
                double degrees = Double.parseDouble(num);
                double radians = Math.toRadians(degrees);
                result = Math.tan(radians);
                temp = String.valueOf((long)result);
                text.setText(temp);
                view = "tan(" + num + ") = ";
                scope.setText(view);
                operationFlag = true;
            }
            else if(buttonValue.equals("\u221A")){
                double var1 = Double.parseDouble(num);
                result = Math.sqrt(var1);
                temp = String.valueOf((long)result);
                text.setText(temp);
                view = "\u221A" + num + " = ";
                scope.setText(view);
                operationFlag = true;
            }
            else if(buttonValue.equals("Scientific")){
                //shows the buttons of standard and scientific
                showButtons2();
                showButtons();
                //creates a financial object to show them
                Financial financialObj = (Financial)Scientific.this;
                financialObj.showButtons1();
            }
        }
    }
    
    //methods that show and hide the scientific buttons
    public void showButtons2(){
        for(int i = 0; i < sciButtons.length; i++){
            sciButtons[i].setVisible(true);
        }
    }
    
    public void hideButtons2(){
        for(int i = 0; i < sciButtons.length; i++){
            sciButtons[i].setVisible(false);
        }
    }
}
