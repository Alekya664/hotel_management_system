import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
class HotelManagementSystem2 extends Frame {
    private TextArea foodDetailsArea;
    private TextArea roomAvailabilityArea;
    private TextArea NewIntroductionsArea;
    private TextField guestNameField;
    private TextField roomNumberField;
    private TextField FeedbackField;
    private Button generateBillButton;

    public void getRoom(){
        String RoomNo = "45";

    }
    public HotelManagementSystem2() {
        setTitle("Hotel Management System");
        setLayout(new GridLayout(2,3));

        // Create components for the left panel
        Panel leftPanel = new Panel();
        leftPanel.setLayout(new BorderLayout());

        foodDetailsArea = new TextArea();
        foodDetailsArea.setEditable(false);
        leftPanel.add(new Label("Food Details:"), BorderLayout.NORTH);
        leftPanel.add(foodDetailsArea, BorderLayout.CENTER);

        // Create components for the right panel
        Panel rightPanel = new Panel();
        rightPanel.setLayout(new BorderLayout());

        roomAvailabilityArea = new TextArea();
        roomAvailabilityArea.setEditable(false);
        rightPanel.add(new Label("Room Availability:"), BorderLayout.NORTH);
        rightPanel.add(roomAvailabilityArea, BorderLayout.CENTER);

        Panel centerPanel = new Panel();
        centerPanel.setLayout(new BorderLayout());

        NewIntroductionsArea = new TextArea();
        NewIntroductionsArea.setEditable(false);
        centerPanel.add(new Label("latest introductions in Our Hotel : "), BorderLayout.NORTH);
        centerPanel.add(NewIntroductionsArea, BorderLayout.CENTER);

        

        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new FlowLayout());

        Label guestNameLabel = new Label("Guest Name:");
        guestNameField = new TextField(10);
        Label roomNumberLabel = new Label("Room Number:");
        roomNumberField = new TextField(4);
        Label FeedbackLabel = new Label("Your feedback/complaints :");
        FeedbackField = new TextField(10);

        generateBillButton = new Button("Generate Bill");

        bottomPanel.add(guestNameLabel);
        bottomPanel.add(guestNameField);
        bottomPanel.add(roomNumberLabel);
        bottomPanel.add(roomNumberField);
        bottomPanel.add(FeedbackLabel);
        bottomPanel.add(FeedbackField);
        bottomPanel.add(generateBillButton);

        rightPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add panels to the frame
        add(leftPanel);
        add(rightPanel);
        add(centerPanel);

        // Set frame properties
        setSize(800, 400);
        setVisible(true);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                dispose();
                System.exit(0);
            }
        });

        // Register event listener for the generate bill button
        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });
    }

    public void updateFoodDetails(String foodDetails) {
        foodDetailsArea.setText(foodDetails);
    }

    public void updateRoomAvailability(String roomAvailability) {
        roomAvailabilityArea.setText(roomAvailability);
    }

    public void updateNewIntroductions(String NewIntroductions) {
        NewIntroductionsArea.setText(NewIntroductions);
    }

    public void generateBill() {
        String guestName = guestNameField.getText();
        String roomNumber = roomNumberField.getText();

        // Perform bill generation logic here
        // ...

        String bill = "Bill\n";
        bill += "-------------------\n";
        bill += "Guest Name: " + guestName + "\n";
        bill += "Room Number: " + roomNumber + "\n";
        bill += "Total Amount Spent: $250\n";
        bill += "-------------------\n";

        // Display the bill in a dialog
        showMessageDialog("Bill", bill);
    }

    private void showMessageDialog(String title, String message) {
        Dialog dialog = new Dialog(this, title, true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(okButton);
        dialog.setSize(500, 200);
        dialog.setVisible(true);
    }

}
 public class Hms{
 public static void main(String[] args) {
       Login l = new Login();
		l.setBounds(400,200,400,300);
		l.setVisible(true);	
 }}
class Login extends JFrame{
	JTextField t1,t2;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	Login(){
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("Guest Credentials");
		l1.setFont(new Font("Roboto",Font.BOLD,30));
		l1.setForeground(Color.GRAY);
		l1.setBounds(100,10,300,30);
		add(l1);
		t1 = new JTextField(60);
		t2 = new JPasswordField(60);
		b1 = new JButton("Sign In");
		b2 = new JButton("New user?");
		t1.setBounds(100,60,120,30);
		t2.setBounds(100,100,120,30);
		b1.setBounds(120,140,80,30);
		b2.setBounds(120,170,120,30);
		l2 = new JLabel("");
		l2.setBounds(250,80,300,30);
		l3 = new JLabel("Guest Name : ");
		l3.setBounds(20,60,70,30);
		add(l3);
		l4 = new JLabel("Password :");
		l4.setBounds(20,100,70,30);
		add(l4);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				boolean match = false;
				String uname = t1.getText().toString();
				String pwd = t2.getText().toString();
				try{
					FileReader fr = new FileReader("login.txt");
					BufferedReader br = new BufferedReader(fr);
					String str;
					while((str=br.readLine())!=null){
						if(str.equals(uname+"\t"+pwd)){
							match = true;
							break;
						}
					}
					fr.close();
				}catch(Exception e){}
				if(match){
					dispose();
					 HotelManagementSystem2 obj =new HotelManagementSystem2();
        String foodDetails = "Food Menu:\n";
        foodDetails += "Breakfast: Continental, Indian\n";
        foodDetails += "Lunch: Indian, Chinese, Italian\n";
        foodDetails += "Dinner: Indian, Continental\n";
        obj.updateFoodDetails(foodDetails);

        // Simulate the hotel providing room availability
        String roomAvailability = "Room Availability:\n";
        roomAvailability += "Room 101: Occupied\n";
        roomAvailability += "Room 102: Available\n";
        roomAvailability += "Room 103: Available\n";
        roomAvailability += "allocated Room : 45 ";
        obj.updateRoomAvailability(roomAvailability);

        String NewIntroductions = "New Introductions in our Hotel : \n";
        NewIntroductions += "Italian Cuisine\n";
        NewIntroductions += "Japanese Cuisine\n";
        NewIntroductions += "Turkish Cuisine\n";
        NewIntroductions += "and Much more......!";
        obj.updateNewIntroductions(NewIntroductions);
				}
				else{
					l2.setText("Invalid Username or Password!!");
				}
			}
				
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SignUp s = new SignUp();
				s.setVisible(true);
				s.setBounds(200,200,500,400);
			}
		});
		
	}
}
class SignUp extends JFrame{
	JTextField t1,t2,t3,t4;
	JLabel l1,l3,l4,l2,l5;
	JButton b1,b2;
	SignUp(){
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l1 = new JLabel("SignUp");
		l1.setFont(new Font("Times new Roman",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(40,10,100,30);
		add(l1);
		t1 = new JTextField(60);
		t2 = new JTextField(60);
		t3 = new JTextField(60);
		t4 = new JTextField(60);
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		t1.setBounds(100,50,80,30);
		t2.setBounds(100,90,80,30);
		t3.setBounds(100,130,80,30);
		t4.setBounds(100,170,150,30);
		l2 = new JLabel("Mobile No.");
		l2.setBounds(20,130,80,30);
		add(l2);
		add(t3);
		add(t4);
		l5 = new JLabel("Aadhar Number : ");
		l5.setBounds(20,170,70,30);
		add(l5);
		l3 = new JLabel("UserName");
		l3.setBounds(20,50,70,30);
		add(l3);
		l4 = new JLabel("Password");
		l4.setBounds(20,90,70,30);
		add(l4);
		b1.setBounds(100,210,80,30);
		b2.setBounds(100,250,80,30);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()||t3.getText().toString().isEmpty()||t4.getText().toString().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please Fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
				}else{
				try{
					FileWriter fw = new FileWriter("login.txt",true);
					fw.write(t1.getText()+"\t"+t2.getText()+"\n");
					fw.close();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Registration Completed");
					dispose();
				}catch(Exception e){}
			}
		}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();	
			}
		});
	}
}
