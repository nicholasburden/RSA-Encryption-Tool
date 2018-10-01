import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EncryptBox extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static boolean fileInvalid = false;

    TextFiles files;
    String message;
    String filePath;
    JButton done = new JButton("Done");
    JComboBox<String> dropBoxPath;
    JTextField text = new JTextField(50);
    JLabel fp = new JLabel("File Path: ");
    JLabel m = new JLabel("Message: ");

    public EncryptBox(){
        this.setTitle("Encrypting");
        files = new TextFiles();
        ArrayList<String> fileNames = files.getFiles();
        String[] array = new String[fileNames.size()];
        array = fileNames.toArray(array);
        dropBoxPath = new JComboBox<String>(array);
        if(array.length != 0){
            dropBoxPath.setSelectedIndex(0);
        }
        done.addActionListener(this);
        JPanel panel = new JPanel();
        add(panel);
        panel.add(fp);
        panel.add(dropBoxPath);
        panel.add(m);
        panel.add(text);
        panel.add(done);
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        message = text.getText();
        if(dropBoxPath.getSelectedItem() == null){
            return;
        }
        try{
            filePath = RSA.directory + (String) dropBoxPath.getSelectedItem();
        }
        catch(NullPointerException x){
            return;
        }
        RSA rsa = new RSA();
        rsa.encrypt(message, filePath);
        if(!fileInvalid){
            dispose();
        }




    }

}
