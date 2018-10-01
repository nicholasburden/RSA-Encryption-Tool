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



public class DecryptBox extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static boolean filesInvalid = false;
    TextFiles files;
    String messagePath;
    String filePath;
    JButton done = new JButton("Done");
    JComboBox<String> dropBoxPath;
    JComboBox<String> dropBoxFile;
    JLabel fp = new JLabel("Key Path: ");
    JLabel m = new JLabel("Message Path: ");
    public DecryptBox(){
        this.setTitle("Decrypting");
        files = new TextFiles();
        ArrayList<String> pathNames = files.getFiles();
        String[] array = new String[pathNames.size()];
        array = pathNames.toArray(array);
        dropBoxPath = new JComboBox<String>(array);
        if(array.length != 0){
            dropBoxPath.setSelectedIndex(0);
        }
        ArrayList<String> messageNames = files.getFiles();
        String[] array2 = new String[messageNames.size()];
        array = messageNames.toArray(array);
        dropBoxFile = new JComboBox<String>(array);
        if(array2.length != 0){
            dropBoxFile.setSelectedIndex(0);
        }
        JPanel panel = new JPanel();
        add(panel);

        panel.add(m);
        panel.add(dropBoxFile);
        panel.add(fp);
        panel.add(dropBoxPath);
        panel.add(done);
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        done.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        messagePath = RSA.directory + (String) dropBoxFile.getSelectedItem();
        filePath = RSA.directory + (String) dropBoxPath.getSelectedItem();
        RSA rsa = new RSA();
        rsa.decrypt(messagePath, filePath);
        if(!filesInvalid){
            dispose();

            displayDecryptedMessage();
        }



    }

    public void displayDecryptedMessage(){
        Read r = new Read();
        r.openTextFile(RSA.directory + "Decrypted Message.txt");
        String text = r.readLine();
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JLabel l = new JLabel(text);
        p.add(l);
        f.setSize(new Dimension(200, 100));
        f.add(p);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        f.setVisible(true);


    }

}