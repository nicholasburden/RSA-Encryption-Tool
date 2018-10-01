import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton deleteFiles = new JButton("Delete All Files");
    JButton genKeys = new JButton("Generate Keys");
    JButton encryptMessage = new JButton("Encrypt a Message");
    JButton decryptMessage = new JButton("Decrypt a Message");
    public MainFrame(){
        this.setTitle("RSA Encryption");
        JPanel panel = new JPanel();
        panel.add(deleteFiles);
        panel.add(genKeys);
        panel.add(encryptMessage);
        panel.add(decryptMessage);
        add(panel);

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);

        deleteFiles.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new TextFiles().deleteFiles();
            }
        });
        genKeys.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new GenerateKeys();
            }
        });
        encryptMessage.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new EncryptBox();
            }
        });
        decryptMessage.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new DecryptBox();
            }
        });

    }
}
