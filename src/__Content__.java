
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

public class __Content__ extends JPanel  implements KeyListener, DocumentListener {
    Colors colors =new Colors();
    __Footer__ footer;
    __Header__ header;
    JTextPane pane;
    String TEXT="";
    Document document;
    String File;
    //INDEX FROM THE DOCUMENT
    int start, end;
    //THE LATEST WORD FROM THE DOCUMENT
    String latestWord;
    public __Content__() throws BadLocationException{


        //set up
        pane = new JTextPane();
        Document doc = pane.getStyledDocument();
        doc.addDocumentListener(this);

        this.setPane(pane);
        this.setDocument(doc);

        pane.setBackground(colors.TEXTAREA);
        pane.setFont(new Font("MV Bali",Font.PLAIN,20));
        pane.setForeground(colors.TEXT);
        pane.setMargin(new Insets(7, 15, 7, 7));


        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        //StyleConstants.setBold(attributeSet, true);
        pane.setCharacterAttributes(attributeSet, true);
       // pane.setText("Welcome");
        doc.insertString(doc.getLength(), "", attributeSet);


        attributeSet = new SimpleAttributeSet();
        //StyleConstants.setItalic(attributeSet, true);
        StyleConstants.setForeground(attributeSet, colors.ERROR);
        doc.insertString(doc.getLength(), "", attributeSet);


        attributeSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attributeSet, colors.EDITABLE);
        doc.insertString(doc.getLength(), "", attributeSet);
        pane.addKeyListener(this);
        JScrollPane scrollPane = new JScrollPane(pane);
        this.setLayout(new BorderLayout());
        this.add(scrollPane);

    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {
        this.setTEXT(this.pane.getText()); // we grab text from 'JTEXTPANE' and put that back in the TEXT VAR

        String[] words = this.getTEXT().split(" |\\.");

        //IF THERE IS NO WORD-ITEM THEN WE DON'T CARE TO LOOP.
       if(words.length!=0){
            try{
                for(String word:words){
                    SimpleAttributeSet attributeSet;
                    Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(this.getFile());
                    boolean matchFound = matcher.find();
                    if(matchFound) {
                        attributeSet = new SimpleAttributeSet();
                        this.getPane().setCharacterAttributes(attributeSet, true);
                        this.getDocument().insertString(this.getDocument().getLength(), word, attributeSet);
                    }
                    else {
                        attributeSet = new SimpleAttributeSet();
                        StyleConstants.setForeground(attributeSet, this.colors.ERROR);
                        this.getDocument().insertString(this.getDocument().getLength(), word, attributeSet);
                    }
                }
            }catch (Exception  event ){
                //SPITS DOCUMENT NOT HANDLED ERROR
               // System.out.println("ERROR HAPPENED.....");
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    public void setFooter(__Footer__ footer ){
        this.footer=footer;
    }
    public __Footer__ getFooter(  ){
        return this.footer;
    }

    public void setPane(JTextPane pane){
        this.pane=pane;
    }
    public JTextPane getPane() {
        return this.pane;
    }

    public __Header__ getHeader() {
        return this.header;
    }

    public void setHeader(__Header__ header) {
        this.header = header;
    }

    public String getTEXT() {
        return this.TEXT;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
    public String getFile(){
        return this.File;
    }
    public void setFile (){
        String readingWholeFile = "";
        try {
            readingWholeFile= new String(Files.readAllBytes(Paths.get("words.txt")));
        }
        catch (Exception exception) { exception.printStackTrace(); }
         this.File=readingWholeFile.toLowerCase();
    }


    public  boolean isValid (String  text){

        final String file = "words.txt";
        String line = null;
        ArrayList<String> fileContents = new ArrayList<>();

        try {
            FileReader fReader = new FileReader(file);
            BufferedReader fileBuff = new BufferedReader(fReader);
            while ((line = fileBuff.readLine()) != null) {
                fileContents.add(line.toLowerCase().trim());
            }
            fileBuff.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fileContents.contains(text.toLowerCase().trim());

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            int start = Utilities.getWordStart(pane, pane.getCaretPosition());
            int end = Utilities.getWordEnd(pane, pane.getCaretPosition());
            String text = pane.getDocument().getText(start, end - start).toLowerCase().trim();
            this.setStart(start);
            this.setEnd(end);
            this.setLatestWord(text);

            //IF THERE IS NO WORD-ITEM THEN WE DON'T CARE TO LOOP.
            if(!text.equalsIgnoreCase("")){
                try{

                    SimpleAttributeSet attributeSet;
                    attributeSet = new SimpleAttributeSet();
                    if(this.isValid(text)){
                        this.getPane().setCharacterAttributes(attributeSet, true);
                        StyleConstants.setForeground(attributeSet, this.colors.ERROR);
                        System.out.println("the word exists");

                        this.footer.status.setText("Word Status: Does Exist");
                    }else{
                        this.getPane().setCharacterAttributes(attributeSet, true);
                        StyleConstants.setForeground(attributeSet, this.colors.ERROR);
                        this.footer.status.setText("Word Status: Does not Exist");
                        System.out.println("the word does not exist");
                    }
                    //this.getDocument().insertString(this.getDocument().getLength(), text, attributeSet);
                }catch (Exception  event ){
                    //SPITS DOCUMENT NOT HANDLED ERROR
                    // System.out.println("ERROR HAPPENED.....");
                }
            }
            if(this.getPane().getText().trim().equalsIgnoreCase("")){
                this.footer.status.setText("Word Status: No word is written");
            }

        }catch (Exception event ) {
            event.printStackTrace();
        }

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try {
            int start = Utilities.getWordStart(pane, pane.getCaretPosition());
            int end = Utilities.getWordEnd(pane, pane.getCaretPosition());
            String text = pane.getDocument().getText(start, end - start).toLowerCase().trim();
            this.setStart(start);
            this.setEnd(end);
            this.setLatestWord(text);

            //IF THERE IS NO WORD-ITEM THEN WE DON'T CARE TO LOOP.
            if(!text.equalsIgnoreCase("")){
                try{

                    SimpleAttributeSet attributeSet;
                    attributeSet = new SimpleAttributeSet();
                    if(this.isValid(text)){
                        this.getPane().setCharacterAttributes(attributeSet, true);
                        StyleConstants.setForeground(attributeSet, this.colors.ERROR);
                        System.out.println("the word exists");

                        this.footer.status.setText("Word Status: Does Exist");
                    }else{
                        this.getPane().setCharacterAttributes(attributeSet, true);
                        StyleConstants.setForeground(attributeSet, this.colors.ERROR);
                        this.footer.status.setText("Word Status: Does not Exist");
                        System.out.println("the word does not exist");
                    }
                    //this.getDocument().insertString(this.getDocument().getLength(), text, attributeSet);
                }catch (Exception  event ){
                    //SPITS DOCUMENT NOT HANDLED ERROR
                    // System.out.println("ERROR HAPPENED.....");
                }
            }
            if(this.getPane().getText().trim().equalsIgnoreCase("")){
                this.footer.status.setText("Word Status: No word is written");
            }

        }catch (Exception event ) {
            event.printStackTrace();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
         //NOT NECESSARY TO IMPLEMENT ........
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getLatestWord() {
        return this.latestWord;
    }

    public void setLatestWord(String latestWord) {
        this.latestWord = latestWord;
    }
}
