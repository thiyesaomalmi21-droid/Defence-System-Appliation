import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Helicopter extends JFrame{
    JLabel areaClearedlbl;
    JSpinner solSpinner;
    JCheckBox position;
    JButton shoot;
    JButton laser;
    JButton missile;
    
    Helicopter(){
        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1));
        
        
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        
        
        JPanel panel1=new JPanel(new GridLayout(1,2));
        areaClearedlbl=new JLabel("Hello");
        
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
        
        add(panel1);
        add(panel2);
        setVisible(true);
        
        
    }
}
