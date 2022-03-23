

/*

THE GENERAL CONVENTIONS

IF A BLUEPRINT (CLASS) IS A WRAPPER COMPONENT, THEN THE GENERAL CONVENTION TO NAME A WRAPPER COMPONENT IS DOUBLE
UNDERSCORE, NAME OF A COMPONENT, AND THEN DOUBLE UNDERSCORE. FOR EXAMPLE: __Wrapper__.java.  THIS IS TO DIFFERENTIATE
WRAPPER COMPONENTS FROM LOGIC COMPONENTS. FROM THIS TIME ON, WE WILL USE BLUEPRINT INSTEAD OF CLASS BECAUSE
BLUEPRINT MAKES MORE SENSE BECAUSE AFTER ALL WE MAKE AN OBJECT FROM A BLUEPRINT.

NOTE

  # WRAPPER COMPONENT:
               IS A JAVA OBJECT TO WHICH OTHER COMPONENTS ARE ADDED.A WRAPPER COMPONENT CAN INCORPORATE BOTH WRAPPER
               AND LOGIC COMPONENTS. THE FOCUS HERE IS DESIGN AND WRAP (FRONT END).

  # LOGIC COMPONENT:
               LOGIC IS NOT INTERESTED IN DESIGN, ALL IT DOES IS PLAY WITH ALGORITHM BEHIND THE DOOR (BACK END)


SINCE THE DEFAULT ACCESS MODIFIER FOR A BLUEPRINT IN JAVA IS PUBLIC WE WILL NOT NAME A BLUEPRINT LIKE

          Public class COMPANYEMPLOYESS {
          ...Content goes here
          }

          INSTEAD WE WILL NAME IT LIKE

          class COMPANYEMPLOYESS {
          ...Content goes here
          }
THIS THE SAME CONVENTION APPLIES TO ATTRIBUTES (PROPERTIES) INSIDE THE BLUEPRINTS AND MAY BE FOR OTHER THINGS.
WHEN NECESSARY WE WILL EXPLAIN WHAT A LINE OF CODES IS DOING.


 */



import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class __Wrapper__ extends JFrame {
      //colors
     Colors colors =new Colors();

     //design components
    __Header__ header=new __Header__();
    __Footer__ footer=new __Footer__() ;
    __Content__ content ;

    //self referencing
    __Wrapper__ wrapper;

    public  __Wrapper__( ){
        try {
            content=new __Content__();


        }catch( Exception event) {}

        //setting
         header.setFooter(footer);
         header.setWrapper(this.getWrapper());
         content.setFooter(footer);
         content.setHeader(header);
         header.setContent(content);





         //Icon for the header
         ImageIcon headerIcon =new ImageIcon("./icons/Noter.jpg");
         this.setIconImage(headerIcon.getImage());

         //Setting title
         this.setTitle("Noter");

         //Background mesh or color of the whole pane /windows frame
         this.getContentPane().setBackground(colors.BG);


         //adding the layout

         this.add(this.header, BorderLayout.NORTH);
         this.add( this.footer,BorderLayout.SOUTH );
         this.add( this.content,BorderLayout.CENTER);
         this.add(new __MarginRight__(), BorderLayout.EAST);
         this.add(new __MarginLeft__(), BorderLayout.WEST);


         //The following set of codes pops up windows
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(new Dimension(700,600));
         this.setVisible(true);

     }

    public __Wrapper__ getWrapper() {
        return this.wrapper;
    }

    public void setWrapper(__Wrapper__ wrapper) {
        this.wrapper = wrapper;
    }

    //THIS IS DOING A LINEAR SEARCH .... WE COULD ALSO DO A BINARY SEARCH... OR EVEN OTHER COMPLEX SEARCHES
    //SINCE THIS IS NOT A DEPLOYABLE APPLICATION WE AIN'T GONNA WORRY ABOUT THE PERFORMANCE PER THE APP.
    public boolean isValidWord (String word){
        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine().trim().toLowerCase();
                if(word.trim().equalsIgnoreCase(data)) return true;

            }
            scanner.close();
        } catch (FileNotFoundException event ) {
           //FILE NOT FOUND ERROR
        }
        return false;
    }
    public static void main (String[] prop){

        __Wrapper__ wrapper=  new __Wrapper__();
        wrapper.setWrapper(wrapper);
        wrapper.header.setWrapper(wrapper.getWrapper());

        //document
        Document document=wrapper.content.getDocument();
        //pane
        JTextPane pane=wrapper.content.getPane();


        //String[] words = wrapper.content.getTEXT().split(" \\.");

        //IF THERE IS NO WORD ITEM THEN WE DON'T CARE TO LOOP
      /*  if(words.length!=0){
            System.out.println("hooray");
            try{
                for(String word:words){
                    SimpleAttributeSet attributeSet;
                    if(wrapper.isValidWord(word)){
                         attributeSet = new SimpleAttributeSet();
                        //StyleConstants.setBold(attributeSet, true);
                        pane.setCharacterAttributes(attributeSet, true);
                        //pane.setText(word);
                        document.insertString(document.getLength(), word, attributeSet);
                    }else{
                        attributeSet = new SimpleAttributeSet();
                        //StyleConstants.setItalic(attributeSet, true);
                        StyleConstants.setForeground(attributeSet, wrapper.colors.ERROR);
                        document.insertString(document.getLength(), word, attributeSet);
                    }

                     //attributeSet = new SimpleAttributeSet();
                    //StyleConstants.setForeground(attributeSet, wrapper.colors.EDITABLE);
                  //  document.insertString(document.getLength(), "World", attributeSet);

                }

            }catch (Exception  event ){
                //SPITS DOCUMENT NOT HANDLED ERROR
            }


        }*/

    }
}
