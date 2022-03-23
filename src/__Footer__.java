

import javax.swing.*;
import java.awt.*;

public class __Footer__ extends JPanel {
    Colors colors =new Colors();
   public JLabel file, status;
    public __Footer__() {

        this.setPreferredSize(new Dimension(100, 30));
        this.setBackground(colors.BG);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));//this flow lay out makes items to align to left.

        //what file is opened at the footer
        file = new JLabel("No file is created");
        status = new JLabel("Word Status: No word is written");

        //Setting font for the navigation items
        file.setFont(new Font("MV Bali",Font.PLAIN,18));
        status.setFont(new Font("MV Bali",Font.PLAIN,18));

        //Setting color for the navigation items
        file.setForeground(colors.TEXT);
        status.setForeground(colors.TEXT);
        this.setLayout(new BorderLayout());
        this.add(file,BorderLayout.WEST);
        this.add(status,BorderLayout.EAST);
    }
    public void setText(String string ){
        file.setText(string);
    }
    public  String getText(){
        return this.file.getText();
    }
}

