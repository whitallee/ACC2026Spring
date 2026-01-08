/*File Layout07.java Copyright, R.G.Baldwin
Revised 10/29/97 to make it fit on the printed 
page better.

This program is designed to be compiled and run under 
JDK 1.1

This program illustrates use of the CardLayout manager.

A top-level Frame object is created which contains two 
Panel objects.

One of the panels is a control panel that will be discussed
in more detail later.

The other panel is a display panel that is used to display
each of the following "cards" which are added to the panel
using a CardLayout manager.

Button("First card is a Button object")
Label("Second card is a Label object")
Label("Third card is also a Label object")
Label("Fourth card is a label object")
timePanel,"time panel");  (see note below)
TextField("Last card is a TextField Object")

Except for the card identified as a "timePanel", each of 
the cards is an object of the type indicated and is 
passive (no event listener objects registered).

The card identified as a "time panel" is a Panel object to
which has been added a Button object and a Label object.  
This card is not passive.  Rather, an ActionListener 
object is instantiated and registered on the button such 
that clicking the button causes the current date and time 
to be displayed in the Label object.

As mentioned earlier, the Frame object contains two 
panels.  The display panel is described above.  The other 
panel is a control panel which contains five buttons 
labeled as shown below: 

"Next"
"Previous"
"First"
"Last"
"Show Time Panel"

These buttons are all active (have ActionListener objects 
registered on them). The buttons are used to iterate 
through the deck of cards on the display panel.  The 
action of each button is indicated by its label (for 
example, the button labeled "Next" causes the next card
in the deck to be displayed.)

A windowClosing() event listener object is instantiated 
and registered on the frame to terminate the program when 
the frame is closed.

The program was tested using JDK 1.1 running under Win95.
*/
//=======================================================//

import java.awt.*;
import java.awt.event.*;
import java.util.*;
//=======================================================//
public class Layout07 {
  public static void main(String[] args){
    GUI gui = new GUI();
  }//end main
}//end class Layout07
//=======================================================//

class GUI {
  public GUI(){//constructor

    //Build a card with GUI components to be added to a 
    // deck of cards using a CardLayout manager. 
        
    Label timeLabel = new Label(
                           "____________________________");
        
    Button timeButton = new Button(
                                 "Display Date and Time");
    Panel timePanel = new Panel();
    timePanel.add(timeButton);
    timePanel.add(timeLabel);
    
    //Instantiate ActionListener object and register it on
    // the button This event handler will display the date
    // and time.
    timeButton.addActionListener(
                       new TimeActionListener(timeLabel));

    //===Build a display panel for the deck of cards===
    
    //Instantiate a layout manager object to be used with 
    // a Panel object
    CardLayout myCardLayout = new CardLayout();

    //Instantiate a display Panel object that will be 
    // composited onto a Frame object.
    Panel displayPanel = new Panel();
    
    //Specify a CardLayout manager for the Panel object
    displayPanel.setLayout(myCardLayout);
    //make the display panel visible
    displayPanel.setBackground(Color.yellow);

    //Add objects to the display panel using the specified
    // CardLayout manager
    displayPanel.add(new Button(
                 "First card is a Button object"),"first");
    displayPanel.add(new Label(
                "Second card is a Label object"),"second");
    displayPanel.add(new Label(
             "Third card is also a Label object"),"third");
    displayPanel.add(new Label(
                "Fourth card is a label object"),"fourth");
    //special panel defined earlier                
    displayPanel.add(timePanel,"time panel");
    displayPanel.add(new TextField(
               "Last card is a TextField Object"),"sixth");


    //======== Build the control panel ======//

    //Instantiate button objects that will be used to 
    // iterate through the cards in the deck.
    Button nextButton = new Button("Next");
    Button prevButton= new Button("Previous"); 
    Button firstButton= new Button("First"); 
    Button lastButton= new Button("Last"); 
    Button showButton= new Button("Show Time Panel");

    //Instantiate action listener objects and register on 
    // the buttons
    firstButton.addActionListener(
             new FirstListener(myCardLayout,displayPanel));
    nextButton.addActionListener(
              new NextListener(myCardLayout,displayPanel));
    prevButton.addActionListener(
              new PrevListener(myCardLayout,displayPanel));
    lastButton.addActionListener(
              new LastListener(myCardLayout,displayPanel));
    showButton.addActionListener(
              new ShowListener(myCardLayout,displayPanel));


    //Instantiate a control Panel object using default 
    // FlowLayout and place the Button objects on it.  
    // These buttons are functional because ActionListener
    // objects have been registered on them.
    Panel controlPanel = new Panel();
    controlPanel.add(firstButton);
    controlPanel.add(nextButton);
    controlPanel.add(prevButton);  
    controlPanel.add(lastButton);
    controlPanel.add(showButton);


    //== Build the Top-Level User-Interface Object ==

    //Instantiate a Frame object 
    Frame myFrame = new Frame(
                            "Copyright, R.G.Baldwin");
    
    //Add the display panel and the control panel objects 
    // to the Frame object to create the composite 
    // user-interface object.
    myFrame.add(displayPanel,"North");
    myFrame.add(controlPanel,"South");

    myFrame.setSize(500,150);//set the size
    myFrame.setVisible(true);//make it visible

    
    //Instantiate and register a window listener to 
    // terminate the program when the Frame is closed.    
    myFrame.addWindowListener(new Terminate());
  }//end constructor
}//end class GUI definition
//=======================================================//

//An object of this ActionListener class is registered on 
// the Button object on the Time panel which is one of the
// cards in the deck of cards.  When an event occurs, this
// handler causes the date and time to be displayed on a 
// Label object on the same panel.

    class TimeActionListener implements ActionListener{
      Label myLabelObject;
      
      TimeActionListener(Label inLabel){//constructor
        myLabelObject = inLabel;
      }//end constructor
      
      public void actionPerformed(ActionEvent e){
        myLabelObject.setText(new Date().toString());  
      }//end actionPerformed()
    }//end class TimeActionListener    

//=======================================================//

//Objects of the next five ActionListener classes are 
// registered on the Button objects on the control panel.
// When an event occurs, the event handler causes a card 
// in the deck of cards to be displayed on the display 
// panel.  For example, an object of the following class 
// causes the first card in the deck to be displayed.  All
// five of the classes are very similar, differing only by
// one statement in the overridden ActionPerformed 
// method which specifies the action to be taken.

class FirstListener implements ActionListener{
  Panel myPanelObject;
  CardLayout myCardLayoutObject;
  
  //constructor
  FirstListener(CardLayout inCardLayout,Panel inPanel){
    myCardLayoutObject = inCardLayout;
    myPanelObject = inPanel;
  }//end constructor
  
  public void actionPerformed(ActionEvent e){
    myCardLayoutObject.first(myPanelObject);
  }//end actionPerformed()
}//end class NextListener
//=======================================================//

//See comments above in class FirstListener
class NextListener implements ActionListener{
  Panel myPanelObject;
  CardLayout myCardLayoutObject;
  
  //constructor
  NextListener(CardLayout inCardLayout,Panel inPanel){
    myCardLayoutObject = inCardLayout;
    myPanelObject = inPanel;
  }//end constructor
  
  public void actionPerformed(ActionEvent e){
    myCardLayoutObject.next(myPanelObject);
  }//end actionPerformed()
}//end class NextListener
//=======================================================//

//See comments above in class FirstListener
class PrevListener implements ActionListener{
  Panel myPanelObject;
  CardLayout myCardLayoutObject;
  
  //constructor
  PrevListener(CardLayout inCardLayout,Panel inPanel){
    myCardLayoutObject = inCardLayout;
    myPanelObject = inPanel;
  }//end constructor
  
  public void actionPerformed(ActionEvent e){
    myCardLayoutObject.previous(myPanelObject);
  }//end actionPerformed()
}//end class NextListener
//=======================================================//

//See comments above in class FirstListener
class LastListener implements ActionListener{
  Panel myPanelObject;
  CardLayout myCardLayoutObject;
  
  //constructor
  LastListener(CardLayout inCardLayout,Panel inPanel){
    myCardLayoutObject = inCardLayout;
    myPanelObject = inPanel;
  }//end constructor
  
  public void actionPerformed(ActionEvent e){
    myCardLayoutObject.last(myPanelObject);
  }//end actionPerformed()
}//end class NextListener

//=======================================================//

//See comments above in class FirstListener
class ShowListener implements ActionListener{
  Panel myPanelObject;
  CardLayout myCardLayoutObject;
  
  //constructor
  ShowListener(CardLayout inCardLayout,Panel inPanel){
    myCardLayoutObject = inCardLayout;
    myPanelObject = inPanel;
  }//end constructor
  
  public void actionPerformed(ActionEvent e){
    //The following method invocation will display the 
    // card whose name matches the second parameter.
    myCardLayoutObject.show(myPanelObject,"time panel");
  }//end actionPerformed()
}//end class NextListener

//=======================================================//

class Terminate extends WindowAdapter{
  public void windowClosing(WindowEvent e){
    //terminate the program when the window is closed  
    System.exit(0);
  }//end windowClosing
}//end class Terminate
//=======================================================//