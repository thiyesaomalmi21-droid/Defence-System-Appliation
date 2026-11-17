import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Helicopter extends JFrame implements Observables{
    JLabel areaClearedlbl;
    JSpinner solSpinner;
    JCheckBox position;
    JButton shoot;
    JButton laser;
    JButton missile;
    JTextArea area;
    JTextField field;
    JButton sendbtn;
    JSlider energylSlider;
    private Message[] messageArray=new Message[0];
    private String name="Helicopter";
    private String positionCheckedOrNot="Not";
    Helicopter(){
        setSize(400,400);
        setResizable(false);
        setLocation(0,0);
        setTitle("Helicopter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(5,1));
        
        JPanel panel1=new JPanel(new GridLayout(1,2));
        areaClearedlbl=new JLabel("");
        
        JPanel panel6=new JPanel(new GridLayout(2,2));
        JLabel lblSolcount=new JLabel("Soldier Count");
        JLabel lblAmmocount=new JLabel("Ammo Count");
        SpinnerModel numberModel = new SpinnerNumberModel(1000, 0, 1000, 1);
        JSpinner solSpinner = new JSpinner(numberModel);
        SpinnerModel numberModel1 = new SpinnerNumberModel(1000, 0, 1000, 1);
        JSpinner ammoSpinner = new JSpinner(numberModel1);
        
        panel6.add(lblSolcount);
        panel6.add(solSpinner);
        panel6.add(lblAmmocount);
        panel6.add(ammoSpinner);
        
        panel1.add(areaClearedlbl);
        panel1.add(panel6);
        
        JPanel panel2=new JPanel(new GridLayout(1,2));
        JPanel panelx=new JPanel(new GridLayout(2,2));
        JPanel panelA=new JPanel(new FlowLayout());
        JPanel panelB=new JPanel(new FlowLayout());
        JPanel panelC=new JPanel(new FlowLayout());
        //JPanel panelD=new JPanel(new FlowLayout());
        shoot=new JButton("Shoot");
        laser=new JButton("Laser");
        missile=new JButton("Missile");
        panelA.add(shoot);
        panelB.add(laser);
        panelC.add(missile);
        
        position=new JCheckBox("Position");
        panelx.add(panelA);
        panelx.add(panelB);
        panelx.add(panelC);
        
        panel2.add(panelx);
        panel2.add(position);
        
        JPanel panel3=new JPanel(new FlowLayout());
        area=new JTextArea(5,20);
        JScrollPane sPane=new JScrollPane(area);
        sPane.setBounds(50,50,200,100);
        panel3.add(sPane);
        
        JPanel panel4=new JPanel(new FlowLayout());
        field=new JTextField(20);
        sendbtn=new JButton("Send");
        
        panel4.add(field);
        panel4.add(sendbtn);
        
        JPanel panel5=new JPanel(new FlowLayout());
        
        energylSlider=new JSlider(JSlider.HORIZONTAL,0,100,0);
        energylSlider.setMajorTickSpacing(20);
        energylSlider.setMinorTickSpacing(5);
        energylSlider.setPaintTicks(true);
        energylSlider.setPaintLabels(true);
        
        panel5.add(energylSlider);
        
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        
        sendbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String message=field.getText();
                Message obj=new Message(name,message);
                ControllRoom.getMessages(obj);
                
                field.setText("");
            }
        });
        position.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(position.isSelected()){
                    positionCheckedOrNot="Positioned";
                }else{
                    positionCheckedOrNot="Not";
                }
            }
        });
        setVisible(true);
        
        
    }
    public void exetendMessageArray(){
        if(messageArray.length==0){
            Message[] temp=new Message[messageArray.length+1];
            messageArray=temp;
        }else{
            Message[] temp=new Message[messageArray.length+1];
            for(int i=0;i<messageArray.length;i++){
                temp[i]=messageArray[i];
            }
            messageArray=temp;
        }
    }
    public void updateMaincontrollersMessage(Message obj){
        exetendMessageArray();
        messageArray[messageArray.length-1]=obj;
        showMessageinArea();
    }
    public void showMessageinArea(){
        area.setText("");
        String text="";
        for(Message mess : messageArray){
            text+=mess.name+" : "+mess.message+"\n";
        }
        
        area.setText(text);
    }
    public String getName(){
        return name;
    }
}
