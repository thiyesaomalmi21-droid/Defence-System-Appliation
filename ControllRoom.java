import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ControllRoom extends JFrame{
    JComboBox<String> comboBox;
    JButton collectInfobtn;
    JCheckBox allClearCBox;
    JTextArea mainControllerArea;
    JCheckBox sendPrivateCBox;
    JButton sendBtn;
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
        allClearCBox=new JCheckBox("All Clear");
        
        panel3.add(comboBox);
        panel3.add(collectInfobtn);
        panel3.add(allClearCBox);
        panel2.add(panel3);
        
        
        
        JPanel panel4=new JPanel(new GridLayout(1,2));
        JPanel panel6=new JPanel(new GridLayout(2,2));
        JPanel panel7=new JPanel(new GridLayout(2,1));
        
        JLabel label1=new JLabel("Soldier Count");
        JLabel solCountlbl=new JLabel("");
        JLabel label2=new JLabel("Ammo Count");
        JLabel ammoCountlbl=new JLabel("");
        
        panel6.add(label1);
        panel6.add(solCountlbl);
        panel6.add(label2);
        panel6.add(ammoCountlbl);
        
        panel4.add(panel6);
        
        mainControllerArea=new JTextArea(5,20);
        JScrollPane sPane1=new JScrollPane(mainControllerArea);
        sPane1.setBounds(50,50,200,100);
        panel7.add(sPane1);
        JPanel panel8=new JPanel(new FlowLayout());
        sendPrivateCBox=new JCheckBox("send Private");
        sendBtn=new JButton("Send");
        panel8.add(sendPrivateCBox);
        panel8.add(sendBtn);
        
        panel7.add(panel8);
        panel4.add(panel7);
        
        
        
        panel2.add(panel4);
        JPanel panel5=new JPanel();
        
        add("Center",panel2);
        
        setVisible(true);
    }
}
