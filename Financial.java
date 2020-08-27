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
 * It has a constructor and it also extends the standard class. It creates
 * a financial button and the financial operation button. It has the ability
 * to hide the finacial button.
 *
 * @author Anabel Hilerio
 * @version Version 1
 */
public class Financial extends Standard
{
    //Creates a financial operation JButton array
    protected JButton percent = null;
    Financial(){
        //Calls the super class
        super();
        
        //initializes the percent button and adds an actionlistener
        percent = new JButton("%");
        percent.addActionListener(new FinancialHandler());
        
        //customizes the percent button
        percent.setBorder(new EmptyBorder(10,10,10,10));
        percent.setBackground(Color.ORANGE);
        percent.setFont(largeFont);
        
        p3.add(percent); //adds it to the third JPanel
        
        //creates a JButton for scientific button and customizes it
        JButton financial = new JButton("Financial");
        financial.setBackground(Color.GRAY);//sets the buttons background
        p4.add(financial);//adds it to the fourth JPanel
        financial.addActionListener(new FinancialHandler()); //adds an actionlistener
        
    }
    
    //creates a new class to allow a scope of just this class for ActionListener
    class FinancialHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //creates variables
            String newValue = "";
            String view = ""; 
            String num = text.getText();
            double result = 0.0;
            
            JButton buttonPressed = (JButton) e.getSource();
            String buttonValue = buttonPressed.getLabel();
            
            //Gives actions to the financial buttons
            if(buttonValue.equals("=")){
                double var1 = Double.parseDouble(temp);
                double var2 = Double.parseDouble(num);
                result = var1 / var2;
            }
            else if(buttonValue.equals("%")){
                temp = num;
                operation = "%";
                operationFlag = true;
            }
            else if(buttonValue.equals("Financial")){
                //shows the financial buttons
                showButtons1();
                //creates scientific object and hides the scientific buttons
                Scientific scientificObj = (Scientific)Financial.this;
                scientificObj.hideButtons2();
            }
        }
        
    }
    
    //methods that show and hide the financial buttons
    public void showButtons1(){
        percent.setVisible(true);
    }
        
    public void hideButtons1(){
        percent.setVisible(false);
    }
}
