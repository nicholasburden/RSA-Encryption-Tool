import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GenerateKeys extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int bitLength;
    JTextField text = new JTextField(5);
    Integer[] bitChoices = {64,128,256,512,1024,2056,4096};
    JButton done = new JButton("Done");
    JComboBox<Integer> box = new JComboBox<Integer>(bitChoices);

    public GenerateKeys(){
        box.setSelectedIndex(0);
        done.addActionListener(this);
        JPanel panel = new JPanel();
        add(panel);
        JLabel label = new JLabel("Bitlength: ");
        panel.add(label);
        panel.add(box);
        panel.add(done);
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        bitLength = ((Integer) box.getSelectedItem()).intValue();
        dispose();
        new RSA(bitLength);
    }
}
