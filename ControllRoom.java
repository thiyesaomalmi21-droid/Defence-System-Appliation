import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ControllRoom extends JFrame{
    JComboBox<String> comboBox;
    JButton collectInfobtn;
    JCheckBox allClearCBox;
    JTextArea mainControllerArea;
    JTextArea mainControllerArea2;
    JCheckBox sendPrivateCBox;
    JButton sendBtn;
    
    private Observables[] observers=new Observables[0];
    ControllRoom(){
        setSize(400,400);
        setLocation(400,400);
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
        
        JPanel panel5=new JPanel(new FlowLayout());
        JLabel positionlbl=new JLabel("Position");
        
        JSlider positionSlider=new JSlider(JSlider.HORIZONTAL,0,100,0);
        positionSlider.setMajorTickSpacing(20);
        positionSlider.setMinorTickSpacing(5);
        positionSlider.setPaintTicks(true);
        positionSlider.setPaintLabels(true);
        
        panel5.add(positionlbl);
        panel5.add(positionSlider);
        
        JPanel panel9=new JPanel(new FlowLayout());
        mainControllerArea2=new JTextArea(5,20);
        JScrollPane sPane2=new JScrollPane(mainControllerArea2);
        sPane2.setBounds(50,50,200,100);
        panel9.add(sPane2);
        
        panel2.add(panel3);
        panel2.add(panel4);
        panel2.add(panel5);
        panel2.add(panel9);
        
        
        add("Center",panel2);
        
        sendBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
               String message = mainControllerArea.getText();
               Message obj=new Message("MainController",message);
               sendToOtherObservers(obj);
               
               mainControllerArea.setText("");
            }
        });
        
        setVisible(true);
    }
    public void sendToOtherObservers(Message obj){
        for(Observables obs : observers){
            obs.updateMaincontrollersMessage(obj);
        }
    }
    public void extendObserverArray(){
        if(observers.length==0){
            Observables[] temp=new Observables[observers.length+1];
            observers=temp;
        }else{
            Observables[] temp=new Observables[observers.length+1];
            for(int i=0;i<observers.length;i++){
                temp[i]=observers[i];
            }
            observers=temp; 
        }
    }
    public void addObservers(Observables observer){
        extendObserverArray();
        observers[observers.length-1]=observer;
    }
}
