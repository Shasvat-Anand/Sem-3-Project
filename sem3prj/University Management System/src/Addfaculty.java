import com.toedter.calendar.JDateChooser;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Addfaculty extends JFrame implements ActionListener {
    JTextField textname,tfname,taddr,tphn,emtext,m10text,m12text,adhtext;
    JLabel tEmpid;
    JComboBox coursebox;
    JComboBox depbox;
    JDateChooser cdob;
    JButton submit;
    JButton cancel;
    Random ran=new Random();
    long f4 = Math.abs((ran.nextLong()%9000L)+1000L);
    Addfaculty(){
        getContentPane().setBackground(new Color(0, 200, 220));

        JLabel heading=new JLabel("New Teacher Details ");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(50,150,180,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textname=new JTextField();
        textname.setBounds(200,150,200,30);
        add(textname);

        //father name;
        JLabel fathername=new JLabel("Father Name");
        fathername.setBounds(450,150,180,30);
        fathername.setFont(new Font("serif",Font.BOLD,20));
        add(fathername);

        tfname=new JTextField();
        tfname.setBounds(600,150,200,30);
        add(tfname);

        //empid
        JLabel empid=new JLabel("Employee Id");
        empid.setBounds(50,200,180,30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);

        tEmpid =new JLabel(""+f4);
        tEmpid.setBounds(200,200,180,30);
        tEmpid.setFont(new Font("serif",Font.BOLD,20));
        add(tEmpid);
        // date of birth
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(450,200,180,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob=new JDateChooser();
        cdob.setBounds(600,200,180,30);
        add(cdob);

        //address
        JLabel address=new JLabel("Address");
        address.setBounds(50,250,180,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        taddr=new JTextField();
        taddr.setBounds(200,250,200,30);
        add(taddr);
        //phone
        JLabel phone=new JLabel("Phone");
        phone.setBounds(450,250,180,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        tphn=new JTextField();
        tphn.setBounds(600,250,200,30);
        add(tphn);
        //email
        JLabel email=new JLabel("Email");
        email.setBounds(50,300,180,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add( email);

        emtext=new JTextField();
        emtext.setBounds(200,300,200,30);
        add(emtext);
        //class 10 marks
        JLabel m10=new JLabel("Class X {%}");
        m10.setBounds(450,300,180,30);
        m10.setFont(new Font("serif",Font.BOLD,20));
        add( m10);

        m10text=new JTextField();
        m10text.setBounds(600,300,200,30);
        add( m10text);
        //class 12
        JLabel m12=new JLabel("Class XII {%}");
        m12.setBounds(50,350,180,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add( m12);

        m12text=new JTextField();
        m12text.setBounds(200,350,200,30);
        add( m12text);

        //adharnumber
        JLabel adhar=new JLabel("Adhar No.");
        adhar.setBounds(450,350,180,30);
        adhar.setFont(new Font("serif",Font.BOLD,20));
        add( adhar);

        adhtext=new JTextField();
        adhtext.setBounds(600,350,200,30);
        add( adhtext);
        //qualification
        JLabel qualf=new JLabel("Qualification");
        qualf.setBounds(50,400,180,30);
        qualf.setFont(new Font("serif",Font.BOLD,20));
        add( qualf);

        String course[]={"B.Tech","BBA","BSC","MSC","MBA","MCA","M.Com","MA","BA"};
        coursebox=new JComboBox(course);
        coursebox.setBounds(200,400,200,30);
        coursebox.setBackground(Color.WHITE);
        add(coursebox);
        //deparment
        JLabel depar=new JLabel("Department");
        depar.setBounds(450,400,180,30);
        depar.setFont(new Font("serif",Font.BOLD,20));
        add( depar);

        String dep[]={"Computer Science","IT","Civil","Electrical","Mechinical"};        depbox=new JComboBox(dep);
        depbox.setBounds(600,400,200,30);
        depbox.setBackground(Color.WHITE);
        add(depbox);
        // submit
        submit=new JButton("Submit");
        submit.setBackground(Color.GREEN);
        submit.setBounds(250,550,120,30);
        submit.addActionListener(this);
        add(submit);


        cancel=new JButton("Cancel");
        cancel.setBackground(Color.yellow);
        cancel.setBounds(500,550,120,30);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String name=textname.getText();
            String fname=tfname.getText();
            String empId=tEmpid.getText();
            String dob=((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String  address=taddr.getText();
            String  phone=tphn.getText();
            String email=emtext.getText();
            String x=m10text.getText();
            String xii=m12text.getText();
            String  adhar=adhtext.getText();
            String  course=(String) coursebox.getSelectedItem();
            String department=(String) depbox.getSelectedItem();
        try {
            String q="insert into teacher values('"+name+"','"+fname+"','"+empId+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+adhar+"','"+course+"','"+department+"')";
            Conn c=new Conn();
            c.statement.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Details Inserted");
            setVisible(false);
        }
        catch (Exception E){
            E.printStackTrace();
        }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String []args){
        new Addfaculty();
    }
}
