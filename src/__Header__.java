

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class __Header__ extends JPanel implements ActionListener,KeyListener {

    //Public space to name attributes
    Colors colors =new Colors();
    __Footer__ footer;
    JButton Make, Open ,Save, Close,Search;//NAVIGATION BUTTON...THEY WILL BE SEEN AS LABEL ...HOVING OVER MAKES CURSOR CHANEG
    JTextField textField;

    //windows reference
    __Wrapper__ wrapper;
    __Content__ content;

    //Absolute path to a file
    String PATH="";

    //file name
    String FILENAME="";

    //SEARCH TERM
    String searchWord="";

    public  __Header__(  ) {

        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(colors.BG);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));//this flow lay out makes items to align to left.

        //Making labels for horizontal menu.
         Make =new JButton("Create");
         Open =new JButton("Open");
         Save =new JButton("Save");
         Close =new JButton("Close");
         Search=new JButton("Replace With");


         //SEARCH AREA
        textField=new JTextField();
        textField.setFont(new Font("MV Bali",Font.PLAIN,16));
        textField.setForeground(colors.TEXT);
        textField.setColumns(18);
        textField.setBackground(colors.TEXTAREA);
        textField.setMargin(new Insets(0, 5, 0, 5));


        //add listener
        textField.addKeyListener(this);


         //borderless button
        Make.setBorderPainted( false );
        Open.setBorderPainted( false );
        Close.setBorderPainted( false );
        Save.setBorderPainted( false );
        Search.setBorderPainted( false );


        //BUTTONS ARE NOT GOOD FOR LOOK
        Make.setFocusPainted(false);
        Make.setMargin(new Insets(0, 0, 0, 0));
        Make.setContentAreaFilled(false);
        Make.setBorderPainted(false);
        Make.setOpaque(false);


        Open.setFocusPainted(false);
        Open.setMargin(new Insets(0, 0, 0, 0));
        Open.setContentAreaFilled(false);
        Open.setBorderPainted(false);
        Open.setOpaque(false);

        Close.setFocusPainted(false);
        Close.setMargin(new Insets(0, 0, 0, 0));
        Close.setContentAreaFilled(false);
        Close.setBorderPainted(false);
        Close.setOpaque(false);

        Save.setFocusPainted(false);
        Save.setMargin(new Insets(0, 0, 0, 0));
        Save.setContentAreaFilled(false);
        Save.setBorderPainted(false);
        Save.setOpaque(false);


        Search.setFocusPainted(false);
        Search.setMargin(new Insets(0, 0, 0, 0));
        Search.setContentAreaFilled(false);
        Search.setBorderPainted(false);
        Search.setOpaque(false);

        //action listener
        Make.addActionListener(this);
        Open.addActionListener(this);
        Save.addActionListener(this);
        Close.addActionListener(this);
        Search.addActionListener(this);


        //We are making an impression of clickable with hand cursor
        Make.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Open.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Setting font for the navigation items
        Make.setFont(new Font("MV Bali",Font.PLAIN,18));
        Open.setFont(new Font("MV Bali",Font.PLAIN,18));
        Save.setFont(new Font("MV Bali",Font.PLAIN,18));
        Close.setFont(new Font("MV Bali",Font.PLAIN,18));
        Search.setFont(new Font("MV Bali",Font.PLAIN,18));

        //Setting color for the navigation items
        Make.setForeground(colors.TEXT);
        Open.setForeground(colors.TEXT);
        Save.setForeground(colors.TEXT);
        Close.setForeground(colors.TEXT);
        Search.setForeground(colors.TEXT);





        //add labels to the panel
        this.add(Make);
        this.add(Open);
        this.add(Save);
        this.add(Close);
        this.add(textField);
        this.add(Search);
    }
    public void setFooter(__Footer__ footer ){
        this.footer=footer;
    }
    public __Footer__ getFooter(  ){
        return this.footer;
    }

    @Override
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==Make){
        String fileName = (String) JOptionPane.showInputDialog(null, "Write a file name", "File Name",
                JOptionPane.PLAIN_MESSAGE, null,null,null);
        try {
           this.getFooter().setText(fileName+".txt");

           /*
              DYNAMIC ABSOLUTE PATH TO WHERE A FILE GETS CREATED.
            */

           String path =System.getProperty("user.dir")+"/"+fileName+".txt";
           this.setPATH(path);
           this.setFILENAME(fileName);
           File file = new File( path);
           file.createNewFile();
           this.getContent().getPane().setText("");
            }
        catch(Exception event) {
            System.out.println("Error, cant open the file.");

        }
    }
    else if(e.getSource()==Open){

        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        this.setPATH(dialog.getDirectory()+dialog.getFile());
        this.setFILENAME(dialog.getFile());
        this.getFooter().setText(file);
        String sum="";
        try {
            File __file__ = new File(dialog.getDirectory()+dialog.getFile());
            Scanner scanner = new Scanner(__file__);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
                sum+=data;
            }
            scanner.close();
        } catch (FileNotFoundException event ) {
            //FILE NOT FOUND ERROR
            System.out.println("FILE NOT FOUND EXECPTION");
        }
        this.getContent().getPane().setText(sum);

    }
    else if(e.getSource()==Save){
        try {
            if(!this.getPATH().equalsIgnoreCase("")){
                FileWriter fileWriter = new FileWriter(this.getPATH());
                fileWriter.write( this.getContent().getTEXT());
                fileWriter.close();
            }
            else{
                JOptionPane.showMessageDialog(this.getWrapper(), "Please make a file first to save!");

            }

        } catch (IOException event) {
            /*
             WRITE CONSOLE "IOException" EXCEPTION IF YOU LIKE....
             POPPING UP WINDOWS WHICH DETAILS THIS MESSAGE IS ....DISPLAYED.....
             */

            System.out.println("SAVING NOT HAPPENED ....SOMETHING CRAZY HAPPENED ....");

        }

    }
    else if(e.getSource()==Close){
        //JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            // NO BUTTON IS CLICKED ....WRITE SOMETHING HERE IF YOU WANT....
        } else if (response == JOptionPane.YES_OPTION) {
            // YES BUTTON IS CLICKED.
            this.getWrapper().dispose();
        } else if (response == JOptionPane.CLOSED_OPTION) {
             //CLOSE POPUP WINDOWS BUTTON IS CLICKED ....WRITE SOMETHING IF YOU WANT....
        }
    }
    else if(e.getSource()==Search){
        this.setSearchWord(this.searchWord.trim());
        if(!this.getSearchWord().equalsIgnoreCase("")){
            String replaceWord = (String) JOptionPane.showInputDialog(null, "Replace "+this.searchWord+
                            " with", "Replace",
                    JOptionPane.PLAIN_MESSAGE, null,null,null);

            try{

                int length =this.getContent().getPane().getDocument().getLength();
                String text = this.getContent().getPane().getDocument().getText(0, length);
                String search = this.getSearchWord();
                int offset = text.indexOf(search);
               if (offset != -1)
                {
                   text=text.replaceAll(search,replaceWord);
                    this.getContent().getPane().setText(text);
                    /*

                    IF WE WANTED TO REPLACE ONLY THE FIRST OCCURRENCE OF A WORD
                    WE WOULD USE 'pane.replaceSelection(replaceWord)' PIECE OF CODE
                    PLUS WE ARE NOT ALLOWING THE REPLACEMENT OF A WORD WITH CASE
                    SENSATIVE.

                    this.getContent().getPane().setSelectionStart(offset);
                    this.getContent().getPane().setSelectionEnd(offset + search.length());
                    this.getContent().getPane().replaceSelection(replaceWord);
                     */
                }
                else{
                    JOptionPane.showMessageDialog(this.getWrapper(), "Sorry we could not find the word "+ search+" to replace with.");
                }

            }catch(Exception exception){
                System.out.println("......###.....ERROR HAPPENED .....");

            }


        }
        else{
            JOptionPane.showMessageDialog(this.getWrapper(), "You have not written a word to replace with.");
        }


    }



    }

    public __Wrapper__ getWrapper() {
        return this.wrapper;
    }

    public void setWrapper(__Wrapper__ wrapper) {
        this.wrapper = wrapper;
    }

    public String getPATH() {
        return this.PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    public String getFILENAME() {
        return this.FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public __Content__ getContent() {
        return this.content;
    }

    public void setContent(__Content__ content) {
        this.content = content;
    }

    public String getSearchWord() {
        return this.searchWord.trim().toLowerCase();
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public void keyPressed(KeyEvent e) {
        //NOT NECESSARY
    }
    public void keyReleased(KeyEvent e) {
        this.setSearchWord(this.textField.getText());

    }
    public void keyTyped(KeyEvent e) {
        // NOT NECESSARY
    }

}
