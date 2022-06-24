import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    //name function buttons
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    ImageIcon image;

    //custom font
    Font font = new Font("Comic Sans MS", Font.BOLD, 30);

    double num1=0, num2=0, result=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(310, 440);
        frame.setLayout(null);

        image = new ImageIcon("E:/Programming/Java/Projects/Calculator/icons/icon.png");
        frame.setIconImage(image.getImage());

        textField = new JTextField();
        textField.setBounds(0, 0, 300, 50);
        textField.setBackground(Color.white);
        textField.setFont(font);
        textField.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        for(int i = 0; i < 9; i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(font);
            functionButton[i].setFocusable(false); //button outline
        }

        for(int i = 0; i < 10; i++){
            //button text
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setBackground(new Color(0xF3F2F2));
            numberButton[i].setFont(font);
            numberButton[i].setFocusable(false);
        }


        addButton.setBackground(new Color(0xBEBAB3));
        addButton.setForeground(new Color((0xfdfdfd)));
        subButton.setBackground(new Color(0xBEBAB3));
        subButton.setForeground(new Color((0xfdfdfd)));
        mulButton.setBackground(new Color(0xBEBAB3));
        mulButton.setForeground(new Color((0xfdfdfd)));
        divButton.setBackground(new Color(0xBEBAB3));
        divButton.setForeground(new Color((0xfdfdfd)));

        equButton.setBackground(new Color(0xBEBAB3));
        equButton.setForeground(new Color((0xfdfdfd)));
        decButton.setBackground(new Color(0xBEBAB3));
        decButton.setForeground(new Color((0xfdfdfd)));
        negButton.setBounds(0, 350, 100, 50);
        negButton.setBackground(new Color(0xBEBAB3));
        negButton.setForeground(new Color((0xfdfdfd)));
        delButton.setBounds(100, 350, 100, 50);
        clrButton.setBounds(200, 350, 100, 50);
        clrButton.setBackground(new Color(0xFF3D3D));
        clrButton.setForeground(new Color((0xfdfdfd)));
        delButton.setBackground(new Color(0xFF3D3D));
        delButton.setForeground(new Color((0xfdfdfd)));

        panel = new JPanel();
        panel.setBounds(0, 50, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 0, 0));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++){
            //check if the button value is equal to the clicked button
            if(e.getSource() == numberButton[i]){
                //get the textfield
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            //if we want to continue
            num1=result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string =  textField.getText();
            textField.setText("");
            for(int i =0; i < string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negButton){
           double temp = Double.parseDouble(textField.getText());
           temp *= -1;
           textField.setText(String.valueOf(temp));
        }



    }
}