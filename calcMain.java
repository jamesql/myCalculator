// Comes from this package
package juice;

// Imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import java.awt.Window.Type;

// Using ActionListener to group all button listners together so it looks real nice.
public class calcMain implements ActionListener , KeyListener{

	// Global Current Number (Used for math)
	int curNum = 0;
	// Used as secondary global current number for math
	// Holds the second number we use for math
	int nextNum = 0;
	
	// Boolean on nextNum or nah
	// This states if we are using our first number in equation or second number
	// if false we are using (1) + 1 = 2 
	// if true we are using 1 + (1) = 2
	boolean nnt = false;
	
	// Boolean Negative
	boolean Neg = false; // Not Used
	// this was added by accident 
	// the font was causing the bug not code
	
	// Button clicks
	// Not used but could be
	int button0 = 0;
	int button1 = 0;
	int button2 = 0;
	int button3 = 0;
	int button4 = 0;
	int button5 = 0;
	int button6 = 0;
	int button7 = 0;
	int button8 = 0;
	int button9 = 0;
	
	// Button Values
	// not used but could be
	int num0 = 0;
	int num1 = 1;
	int num2 = 2;
	int num3 = 3;
	int num4 = 4;
	int num5 = 5;
	int num6 = 6;
	int num7 = 7;
	int num8 = 8;
	int num9 = 9;
	
	// Booleans
	// Used for determining which buttons are pressed
	// used in equals method to determine faster which button is pressed
	// instead of checking which button is disabled / clicked
	// we check these booleans
	boolean plus = false;
	boolean minus = false;
	boolean multiply = false;
	boolean divide = false;
	
	
	
	// Creates stuff (MOST ARE NOT IMPLEMENTED UNTIL FURTHER DOWN)
	// Creates Frame
	private JFrame calcForm;
	// Creates resultBox
	JTextField resultBox = new JTextField();
	// Creates clear button
	JButton clearButton = new JButton("CLEAR");
	// Creates minusButton
	JButton minusButton = new JButton("-");
	// Creates plus button
	JButton plusButton = new JButton("+");
	// Creates multiply button
	JButton multiButton = new JButton("X");
	// Creates Divide button
	JButton divButton = new JButton("/");
	// CREATES BUTTONS 0-9
	JButton oneButton = new JButton("1");
	JButton twoButton = new JButton("2");
	JButton threeButton = new JButton("3");
	JButton fourButton = new JButton("4");
	JButton fiveButton = new JButton("5");
	JButton sixButton = new JButton("6");
	JButton sevenButton = new JButton("7");
	JButton eightButton = new JButton("8");
	JButton nineButton = new JButton("9");
	JButton zeroButton = new JButton("0");
	// CREATES BUTTONS 0-9
	// creates = button
	JButton eqButton = new JButton("=");
	// CREATES THE BASE CONVERSION BUTTONS
	JButton base2Button = new JButton("Base 2");
	JButton base8Button = new JButton("Base 8");
	JButton base16Button = new JButton("Base 16");
	// CREATES THE BASE CONVERSION BUTTONS

	// Launches application
	public static void main(String[] args) {
		// Allows us to run non-static method from my understanding
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Runs the calcMain which runs init which creates everything
					calcMain window = new calcMain();
					// Sets our window to visible from start
					window.calcForm.setVisible(true);
				} catch (Exception e) {
					// uh oh this shouldnt happen
					e.printStackTrace();
				}
			}
		});
	}

	// Run init function
	public calcMain() {
		// runs init()
		initialize();
	}
	
	private void initialize() {
		// creates new form
		calcForm = new JFrame();
		// Sets type to pop up i thought it looked better
		calcForm.setType(Type.POPUP);
		// made it not resizeable cause it looks dumb
		calcForm.setResizable(false);
		// cool title right?
		calcForm.setTitle("James's Calculator");
		// sets our bounds
		calcForm.setBounds(100, 100, 450, 500);
		// sets our close op
		calcForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets absolute layout (null basically anywhere) 
		calcForm.getContentPane().setLayout(null);
		
		// Result Box Code
		resultBox.setEditable(false);
		// its a cool font right?
		resultBox.setFont(new Font("Yu Gothic Medium", Font.BOLD, 30));
		// sets it to horizontal allignment
		resultBox.setHorizontalAlignment(SwingConstants.RIGHT);
		// defaults to 0
		resultBox.setText("0");
		// sets bounds
		resultBox.setBounds(10, 11, 414, 39);
		// adds it to our plane cool
		calcForm.getContentPane().add(resultBox);
		// sets columns (10)
		resultBox.setColumns(10);
		
		// Methods Buttons
		
		// Clear Button
		// Sets bounds
		// bounds are like our size pretty much if you didnt get that
		clearButton.setBounds(335, 399, 89, 51);
		// Adds button to the plane and changes font and size
		calcForm.getContentPane().add(clearButton);
		plusButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		// Plus Button
		// Sets bounds
		plusButton.setBounds(335, 97, 89, 51);
		// Adds button to the plane and changes font and size
		calcForm.getContentPane().add(plusButton);
		minusButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		// Minus Button
		// Sets bounds
		minusButton.setBounds(335, 159, 89, 51);
		// Adds button to plane
		calcForm.getContentPane().add(minusButton);
		// Multiply Button
		// Sets bounds
		multiButton.setBounds(335, 221, 89, 51);
		// Adds button to the plane and changes font and size
		calcForm.getContentPane().add(multiButton);
		divButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		// divButton
		// Sets bounds
		divButton.setBounds(335, 283, 89, 51);
		// Adds button to plane
		calcForm.getContentPane().add(divButton);
		// Equals Button
		// Sets bounds
		eqButton.setBounds(256, 399, 69, 51);
		// Adds button to plane
		calcForm.getContentPane().add(eqButton);
		
		// Base Numbers
		// Base 2 Convert
		// Adds button to plane
		calcForm.getContentPane().add(base2Button);
		// Sets bounds
		base8Button.setBounds(109, 61, 89, 31);
		// Base 8 Convert
		// Adds button to plane
		calcForm.getContentPane().add(base8Button);
		// Sets bounds
		base16Button.setBounds(208, 61, 89, 31);
		// Base 16 (hex) convert
		// Adds button to plane
		calcForm.getContentPane().add(base16Button);
		// Base Numbers
		
		// Methods Buttons
		
		
		// Numbers Buttons
		
		// Zero Button
		// Sets bounds
		zeroButton.setBounds(10, 399, 229, 51);
		// Adds button to plane
		calcForm.getContentPane().add(zeroButton);
		// One Button
		// Sets bounds
		oneButton.setBounds(10, 173, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(oneButton);
		// Two Button
		// Sets bounds
		twoButton.setBounds(96, 173, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(twoButton);
		// Three Button
		// Sets bounds
		threeButton.setBounds(189, 173, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(threeButton);
		// Four Button
		// Sets bounds
		fourButton.setBounds(10, 254, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(fourButton);
		// Five Button
		// Sets bounds
		fiveButton.setBounds(96, 254, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(fiveButton);
		// Six Button
		// Sets bounds
		sixButton.setBounds(189, 254, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(sixButton);
		// Seven Button
		// Sets bounds
		sevenButton.setBounds(10, 337, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(sevenButton);
		// Eight Button
		// Sets bounds
		eightButton.setBounds(96, 337, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(eightButton);
		// Nine Button
		// Sets bounds
		nineButton.setBounds(189, 337, 50, 51);
		// Adds button to plane
		calcForm.getContentPane().add(nineButton);
		// Sets bounds
		base2Button.setBounds(10, 61, 89, 31);
		
		// Number Buttons
		
		
		// Action Listener Additions
		// These make it so we can listen for events from these buttons.
		// Also it looks satisfying like this ;)
		clearButton.addActionListener(this);
		plusButton.addActionListener(this);
		minusButton.addActionListener(this);
		multiButton.addActionListener(this);
		divButton.addActionListener(this);
		eqButton.addActionListener(this);
		// Number
		zeroButton.addActionListener(this);
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
		fourButton.addActionListener(this);
		fiveButton.addActionListener(this);
		sixButton.addActionListener(this);
		sevenButton.addActionListener(this);
		eightButton.addActionListener(this);
		nineButton.addActionListener(this);
		// Base Numbers
		base2Button.addActionListener(this);
		base8Button.addActionListener(this);
		base16Button.addActionListener(this);
		KeyListenStart();
		// Action Listener Additions
	}
	
	// This is our keyListener
	public void KeyListenStart() {
		
		// Adds a key listener just like out buttons
		calcForm.addKeyListener(this);
		// forms that use key listeners need to be focusable
		calcForm.setFocusable(true);
		// allows us yo use shifted keys
		calcForm.setFocusTraversalKeysEnabled(true);
		// these are not needed but for some reason they are here
		// they do the same thing but have no effect
		calcForm.getContentPane().addKeyListener(this);
		calcForm.getContentPane().setFocusable(true);
		calcForm.getContentPane().setFocusTraversalKeysEnabled(true);
	}
	
	// Runs when clear button is clicked
	public void buttonClickClear() {	
		// Resets Buttons
		plus = false;
		minus = false;
		multiply = false;
		divide = false;
		// Resets all buttons
		plusButton.setEnabled(true);
		minusButton.setEnabled(true);
		multiButton.setEnabled(true);
		divButton.setEnabled(true);
		// Resets Displayed Number
		resultBox.setText("0");
		// Resets Math Num
		curNum = 0;
		// resets next num
		nextNum = 0;
		nnt = false;
	}
	
	// Gets triggered when zero button is hit and nnt = false
	public void zeroButton() {
		resultBox.setText(resultBox.getText() + "0");
		curNum = Integer.valueOf(resultBox.getText());
	}
	// Gets triggered when 1 button is hit and nnt = false
	public void oneButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("1");
			curNum = 1;
		}else{
		resultBox.setText(resultBox.getText() + "1");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 2 button is hit and nnt = false
	public void twoButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("2");
			curNum = 2;
		}else{
		resultBox.setText(resultBox.getText() + "2");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 3 button is hit and nnt = false
	public void threeButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("3");
			curNum = 3;
		}else{
		resultBox.setText(resultBox.getText() + "3");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 4 button is hit and nnt = false
	public void fourButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("4");
			curNum = 4;
		}else{
		resultBox.setText(resultBox.getText() + "4");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 5 button is hit and nnt = false
	public void fiveButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("5");
			curNum = 5;
		}else{
		resultBox.setText(resultBox.getText() + "5");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 6 button is hit and nnt = false
	public void sixButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("6");
			curNum = 6;
		}else{
		resultBox.setText(resultBox.getText() + "6");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 7 button is hit and nnt = false
	public void sevenButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("7");
			curNum = 7;
		}else{
		resultBox.setText(resultBox.getText() + "7");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 8 button is hit and nnt = false
	public void eightButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("8");
			curNum = 8;
		}else{
		resultBox.setText(resultBox.getText() + "8");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	// Gets triggered when 9 button is hit and nnt = false
	public void nineButton() {
		// If it is 0 it will del the first 0 essentially
		if (curNum == 0) {
			resultBox.setText("9");
			curNum = 9;
		}else{
		resultBox.setText(resultBox.getText() + "9");
		curNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(curNum));
	}
}
	
	
	// THESE ARE THE ALT BUTTONS
	// Gets triggered when zero button is hit and nnt = true
	public void zeroButtonb() {
		resultBox.setText(resultBox.getText() + "0");
		nextNum = Integer.valueOf(resultBox.getText());
	}
	// Gets triggered when 1 button is hit and nnt = true
	public void oneButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("1");
			nextNum = 1;
		}else{
		resultBox.setText(resultBox.getText() + "1");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 2 button is hit and nnt = true
	public void twoButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("2");
			nextNum = 2;
		}else{
		resultBox.setText(resultBox.getText() + "2");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 3 button is hit and nnt = true
	public void threeButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("3");
			nextNum = 3;
		}else{
		resultBox.setText(resultBox.getText() + "3");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 4 button is hit and nnt = true
	public void fourButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("4");
			nextNum = 4;
		}else{
		resultBox.setText(resultBox.getText() + "4");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 5 button is hit and nnt = true
	public void fiveButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("5");
			nextNum = 5;
		}else{
		resultBox.setText(resultBox.getText() + "5");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 6 button is hit and nnt = true
	public void sixButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("6");
			nextNum = 6;
		}else{
		resultBox.setText(resultBox.getText() + "6");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 7 button is hit and nnt = true
	public void sevenButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("7");
			nextNum = 7;
		}else{
		resultBox.setText(resultBox.getText() + "7");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 8 button is hit and nnt = true
	public void eightButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("8");
			nextNum = 8;
		}else{
		resultBox.setText(resultBox.getText() + "8");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	// Gets triggered when 9 button is hit and nnt = true
	public void nineButtonb() {
		// If it is 0 it will del the first 0 essentially
		if (nextNum == 0) {
			resultBox.setText("9");
			nextNum = 9;
		}else{
		resultBox.setText(resultBox.getText() + "9");
		nextNum = Integer.valueOf(resultBox.getText());
		System.out.println(Integer.toString(nextNum));
	}
}
	
	// THESE ARE THE ALT BUTTONS
	
	
	// Does this thing I call math
	public void equals() {
		if (plus) {
			curNum = curNum + nextNum;
			nextNum = 0;
			resultBox.setText(Integer.toString(curNum));
			nnt = false;
			// Resets all buttons
			plusButton.setEnabled(true);
			minusButton.setEnabled(true);
			multiButton.setEnabled(true);
			divButton.setEnabled(true);
			plus = false;
		}
		if (minus) {
			curNum = curNum - nextNum;
			nextNum = 0;
			resultBox.setText(Integer.toString(curNum));
			nnt = false;
			// Resets all buttons
			plusButton.setEnabled(true);
			minusButton.setEnabled(true);
			multiButton.setEnabled(true);
			divButton.setEnabled(true);
			minus = false;
		}
		if (multiply) {
			curNum = curNum * nextNum;
			nextNum = 0;
			resultBox.setText(Integer.toString(curNum));
			nnt = false;
			// Resets all buttons
			plusButton.setEnabled(true);
			minusButton.setEnabled(true);
			multiButton.setEnabled(true);
			divButton.setEnabled(true);
			multiply = false;
		}
		if (divide) {
			curNum = curNum / nextNum;
			nextNum = 0;
			resultBox.setText(Integer.toString(curNum));
			nnt = false;
			// Resets all buttons
			plusButton.setEnabled(true);
			minusButton.setEnabled(true);
			multiButton.setEnabled(true);
			divButton.setEnabled(true);
			divide = false;
		}
		// Print result to console for debugging
		System.out.println("Result : " + resultBox.getText());
	}
	
	
	// BASE CONVERSION
	
	public void base2() {
		// Converts current number to binary
		String convert = Integer.toBinaryString(curNum);
		// SETS RESULT TO THIS CONVERTED NUMBER
		resultBox.setText(convert);
		// Disable math buttons until reset is hit
		plusButton.setEnabled(false);
		minusButton.setEnabled(false);
		multiButton.setEnabled(false);
		divButton.setEnabled(false);
	}
	
	public void base8() {
		// Converts current number to octal
		String convert = Integer.toOctalString(curNum);
		// SETS RESULT TO THIS CONVERTED NUMBER
		resultBox.setText(convert);
		// Disable math buttons until reset is hit
		plusButton.setEnabled(false);
		minusButton.setEnabled(false);
		multiButton.setEnabled(false);
		divButton.setEnabled(false);
	}
	
	public void base16() {
		// Converts current number to hex
		String convert = Integer.toHexString(curNum);
		// SETS RESULT TO THIS CONVERTED NUMBER
		resultBox.setText(convert);
		// Disable math buttons until reset is hit
		plusButton.setEnabled(false);
		minusButton.setEnabled(false);
		multiButton.setEnabled(false);
		divButton.setEnabled(false);
	}
	
	// BASE CONVERSION
	
	
	
	// Plus button function
	public void PlusButton() {
		if (plus == true) {
			return;
		}
		if (plus == false) {
			plusButton.setEnabled(false);
			plus = !plus;
			nnt = true;
			resultBox.setText("0");
		}
		if (minus) {
			minus = !minus;
			minusButton.setEnabled(true);
			plusButton.setEnabled(false);
			plus = !plus;
		}
		if (multiply) {
			multiply = !multiply;
			multiButton.setEnabled(true);
			plusButton.setEnabled(false);
			plus = !plus;
		}
		if (divide) {
			divide = !divide;
			divButton.setEnabled(true);
			plusButton.setEnabled(false);
			plus = !plus;
		}
	}
	
	// Minus button function
	public void MinusButton() {
		if (minus == true) {
			return;
		}
		if (minus == false) {
			minusButton.setEnabled(false);
			minus = !minus;
			nnt = true;
			resultBox.setText("0");
		}
		if (plus) {
			plus = !plus;
			plusButton.setEnabled(true);
			minusButton.setEnabled(false);
			minus = !minus;
		}
		if (multiply) {
			multiply = !multiply;
			multiButton.setEnabled(true);
			minusButton.setEnabled(false);
			minus = !minus;
		}
		if (divide) {
			divide = !divide;
			divButton.setEnabled(true);
			minusButton.setEnabled(false);
			minus = !minus;
		}
	}
	
	// Multiply button function
	public void MultiplyButton() {
		if (multiply == true) {
			return;
		}
		if (multiply == false) {
			multiButton.setEnabled(false);
			multiply = !multiply;
			nnt = true;
			resultBox.setText("0");
		}
		if (plus) {
			plus = !plus;
			plusButton.setEnabled(true);
			multiButton.setEnabled(false);
			multiply = !multiply;
		}
		if (minus) {
			minus = !minus;
			minusButton.setEnabled(true);
			multiButton.setEnabled(false);
			multiply = !multiply;
		}
		if (divide) {
			divide = !divide;
			divButton.setEnabled(true);
			multiButton.setEnabled(false);
			multiply = !multiply;
		}
	}
	
	// Divide button function
	public void DivisionButton() {
		if (divide == true) {
			return;
		}
		if (divide == false) {
			divButton.setEnabled(false);
			divide = !divide;
			nnt = true;
			resultBox.setText("0");
		}
		if (plus) {
			plus = !plus;
			plusButton.setEnabled(true);
			divButton.setEnabled(false);
			divide = !divide;
		}
		if (minus) {
			minus = !minus;
			minusButton.setEnabled(true);
			divButton.setEnabled(false);
			divide = !divide;
		}
		if (multiply) {
			multiply = !multiply;
			multiButton.setEnabled(true);
			divButton.setEnabled(false);
			divide = !divide;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent thisevent) {
		
		// Event triggered for clear button
		if (thisevent.getSource().equals(clearButton)) {
			// goes to the clear button method
			// resets calculator
			buttonClickClear();
		}
		
		// Triggered for zero button
		if (thisevent.getSource().equals(zeroButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				// goes to b method
				zeroButtonb();
			}else {
				// goes to a method
			zeroButton();
			}
		}
		
		// Triggered for one button
		if (thisevent.getSource().equals(oneButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				oneButtonb();
			}else {
			oneButton();
			}
		}
		// Triggered for 2 button
		if (thisevent.getSource().equals(twoButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				twoButtonb();
			}else {
			twoButton();
			}
		}
		// Triggered for 3 button
		if (thisevent.getSource().equals(threeButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				threeButtonb();
			}else {
			threeButton();
			}
		}
		// Triggered for 4 button
		if (thisevent.getSource().equals(fourButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				fourButtonb();
			}else {
			fourButton();
			}
		}
		// Triggered for 5 button
		if (thisevent.getSource().equals(fiveButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				fiveButtonb();
			}else {
			fiveButton();
			}
		}
		// Triggered for 6 button
		if (thisevent.getSource().equals(sixButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				sixButtonb();
			}else {
			sixButton();
			}
		}
		// Triggered for 7 button
		if (thisevent.getSource().equals(sevenButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				sevenButtonb();
			}else {
			sevenButton();
			}
		}
		// Triggered for 8 button
		if (thisevent.getSource().equals(eightButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				eightButtonb();
			}else {
			eightButton();
			}
		}
		// Triggered for 9 button
		if (thisevent.getSource().equals(nineButton)) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				nineButtonb();
			}else {
			nineButton();
			}
		}
		// Triggered when the = button is pressed
		if (thisevent.getSource().equals(eqButton)) {
			equals();
		}
		// Base 2 button
		if (thisevent.getSource().equals(base2Button)) {
			base2();
		}
		// Base 8 button
		if (thisevent.getSource().equals(base8Button)) {
			base8();
		}
		// Base 16 button
		if (thisevent.getSource().equals(base16Button)) {
			base16();
		}
		// Plus Button
		if (thisevent.getSource().equals(plusButton)) {
			PlusButton();
		}
		// Triggered When Minus Button Gets Clicked
		if (thisevent.getSource().equals(minusButton)) {
			MinusButton();
		}
		// Triggered when multiply button gets clicked
		if (thisevent.getSource().equals(multiButton)) {
			MultiplyButton();
		}
		// Triggered when division button gets clicked 
		if (thisevent.getSource().equals(divButton)) {
			DivisionButton();
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent thisevent) {
		// Retrieves Key Code from event
		
		int c = thisevent.getKeyCode();
		// Checks keys
		// Checks if key pressed is enter
		if (c == KeyEvent.VK_ENTER) {
			// presses equal button
			equals();
		}
		// checks if the key is "c"
		if (c == KeyEvent.VK_C) {
			// clicks clear
			buttonClickClear();
		}
		// Checks if key is Equals or + button // enter is used as = so we dont need that key
		if (c == KeyEvent.VK_EQUALS || c == KeyEvent.VK_PLUS) {
			// presses plus button
			PlusButton();
		}
		// checks if key is the minus key
		if (c == KeyEvent.VK_MINUS) {
			// presses the minus key
			MinusButton();
		}
		// checks if the key is X
		if (c == KeyEvent.VK_X) {
			// presses X button
			MultiplyButton();
		}
		// Checks if the key is /
		if (c == KeyEvent.VK_SLASH) {
			// presses division button
			DivisionButton();
		}
		// checks if the key is 0
		if (c == KeyEvent.VK_0) {
			// Checks if the next num is enabled
			if (nnt) {
				// if we are using the secondary number we goto a seperate method
				zeroButtonb();
			}else{
				// else go to the normal method
				zeroButton();
			}
		}
		// if the 1 key is pressed then trigger
		if (c == KeyEvent.VK_1) {
			// checks second num
			if (nnt) {
				// if we are using the secondary number we goto a seperate method
				oneButtonb();
			}else{ // else goto normal number function
				oneButton();
			}
		}
		// checks for number 2 is pressed
		if (c == KeyEvent.VK_2) {
			// checks if the second num is enabled
			if (nnt) {
				// goes to b method
				twoButtonb();
			}else{ // else goto a method
				twoButton();
			}
		}
		// triggers when 3 key is pressed
		if (c == KeyEvent.VK_3) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				// goes to b method
				threeButtonb();
			}else{
				// goes to a method
				threeButton();
			}
		}
		// checks if the 4 key is pressed
		if (c == KeyEvent.VK_4) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				// goes to b method
				fourButtonb();
			}else{
				// goes to a method
				fourButton();
			}
		}
		// checks if 5 key is pressed
		if (c == KeyEvent.VK_5) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				// goes to b method
				fiveButtonb();
			}else{
				// goes to a method
				fiveButton();
			}
		}
		// checks if 6 key is pressed
		if (c == KeyEvent.VK_6) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				// goes to b method
				sixButtonb();
			}else{
				// goes to a method
				sixButton();
			}
		}
		// Checks if 7 key is pressed
		if (c == KeyEvent.VK_7) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				// goes to b method
				sevenButtonb();
			}else{
				// goes to a method
				sevenButton();
			}
		}
		// checks if 9 key is pressed
		if (c == KeyEvent.VK_8) {
			// if we are using the secondary number we goto a seperate method
			if (nnt) {
				// goes to b method
				eightButtonb();
			}else{
				// goes to a method
				eightButton();
			}
		}
		// checks if 9 key is pressed
		if (c == KeyEvent.VK_9) {
			// if we are using the secondary number we goto a seperate methoda
			if (nnt) {
				// goes to b method
				nineButtonb();
			}else{
				// goes to a method
				nineButton();
			}
		}
	}

	// Not used because it is not needed
	@Override
	public void keyReleased(KeyEvent releasedEvent) {
	}

	// Is not used because it is not needed
	@Override
	public void keyTyped(KeyEvent typeEvent) {
	}
}
