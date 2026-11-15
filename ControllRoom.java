import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ControllRoom extends JFrame{
    JComboBox<String> comboBox;
    JButton collectInfobtn;
    JCheckBox allClear;
    ControllRoom(){
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
        JPanel panel1=new JPanel();
        JLabel label=new JLabel("Control Room",JLabel.CENTER);
        label.setFont(new Font("",Font.BOLD,15));
        label.setForeground(Color.WHITE);
        panel1.setBackground(Color.BLUE);
        panel1.add(label);
        
        add("North",panel1);
        JPanel panel2=new JPanel(new GridLayout(4,1));
        JPanel panel3=new JPanel(new FlowLayout());
        String[] nameArray={"Select Defence","Helicopter","Tank","Submarine"};
        comboBox=new JComboBox<>(nameArray);
        
        collectInfobtn=new JButton("Collect Information");
        allClear=new JCheckBox("All Clear");
        
        panel3.add(comboBox);
        panel3.add(collectInfobtn);
        panel3.add(allClear);
        panel2.add(panel3);
        
        
        
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        
        add("Center",panel2);
        
        setVisible(true);
    }
}
