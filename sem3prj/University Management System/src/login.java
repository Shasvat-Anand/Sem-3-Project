import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame  implements ActionListener{
    JButton login, cancel;
    JTextField tfusername;


    JPasswordField tfpassword ;


    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username= new JLabel("Username");
        username.setBounds(40 ,40 ,100 ,20);
        add(username);


        tfusername =new JTextField();
        tfusername.setBounds( 150,40,150,20);
        add(tfusername);



        JLabel password=new JLabel("Password");
        password.setBounds(40,80,100,20);
        add(password);


        tfpassword =new JPasswordField();
        tfpassword.setBounds( 150,80,150,20);
        add(tfpassword);

        login =new JButton("Login");
        login.setBounds( 40,140,120,30);
        login.setBackground( Color.green);
        login.setForeground( Color.black);
        login.addActionListener(this);
        add(login);



        cancel =new JButton("Cancel");
        cancel.setBounds( 200 ,140,120,30);
        cancel.setBackground( Color.green);
        cancel.setForeground( Color.black);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image1/loginicon.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(350,20,100,100);
        add(img);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("image1/loginback.jpeg"));
        Image i22=i11.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image=new JLabel(i33);
        image.setBounds(0,0,500,300);
        add(image);




        setSize( 500,300);
        setLocation(500 ,250);
        setLayout( null);
        setVisible( true);


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "SELECT * from login where username='"+username+"'and password='"+password+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery(query);

                if (rs.next()){
                    System.out.println("Login Succesful");
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}



