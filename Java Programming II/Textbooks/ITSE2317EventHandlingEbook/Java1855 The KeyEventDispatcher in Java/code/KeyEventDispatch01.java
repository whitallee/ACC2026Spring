//34567890123456789012345678901234567890123456789
//Note: this is wide format for small fonts.
//=============================================//

/*File KeyEventDispatch01.java
Copyright,R.G.Baldwin
Revised 07/27/04

This program illustrates the use of an
alternate KeyEventDispatcher.

A JFrame object appears on the screen containing
three JTextField objects.  The initial text in
the three JTextField objects is respectively:

Field A
Field B
Field C

Two alternative KeyEventDispatcher objects are
registered on the current KeyboardFocusManager
in the following order:

AlternateDispatcherA
AlternateDispatcherB

When a key event occurs, the curent
KeyboardFocusManager delivers that event to
AlternateDispatcherA for dispatching.  If the
owner of the focus at that point in time is
Field A, the AlternateDispatcherA object
re-dispatches that event to Field C and returns
true.  That causes keystrokes entered into
Field A to appear in Field C instead.  Returning
true prevents any further dispatching of the
event.

If the owner of the focus at that point in time
is not Field A, the AlternateDispatcherA object
returns false.  This causes the current
KeyboardFocusManager to deliver the event to
AlternateDispatcherB for dispatching.  If the
owner of the focus at that point in time is
Field B, the AlternateDispatcherB object
re-dispatches that event to Field C and returns
true.  That causes keystrokes entered into
Field B to appear in Field C instead.  Returning
true prevents any further dispatching of the
event.

If the owner of the focus at that point in time
is not Field B, the AlternateDispatcherB object
returns false.  This causes the current
KeyboardFocusManager to dispatch the event to
the component that owns the focus.  In this
simple program, that would have to be Field C
because it has already been determined that
neither Field A nor Field B own the focus.

That causes keystrokes entered into Field C to
appear in Field C as is normally the case.

Thus, all keystrokes entered into any of the
three fields in the GUI will appear in field C.

Tested using J2SE 1.4.2 under WinXP.
************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeyEventDispatch01{
  public static void main(String[] args){
    new GUI();
  }//end main
}//end class KeyEventDispatch01
//=============================================//

class GUI extends JFrame{
  JTextField fieldA =
                    new JTextField("Field A",12);
  JTextField fieldB =
                    new JTextField("Field B",12);
  JTextField fieldC =
                    new JTextField("Field C",12);

  KeyboardFocusManager manager;

  GUI(){//constructor
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(fieldA);
    getContentPane().add(fieldB);
    getContentPane().add(fieldC);

    setSize(390,100);
    setTitle("Copyright, R.G. Baldwin");
    setDefaultCloseOperation(
                           JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    manager = KeyboardFocusManager.
                getCurrentKeyboardFocusManager();

    manager.addKeyEventDispatcher(
                        new AlternateDispatcherA(
                         fieldA,fieldC,manager));
    manager.addKeyEventDispatcher(
                        new AlternateDispatcherB(
                         fieldB,fieldC,manager));

  }//end constructor
}//end class GUI
//=============================================//

class AlternateDispatcherA
                   implements KeyEventDispatcher{
  JTextField fieldA;
  JTextField fieldC;
  KeyboardFocusManager manager;

  //Constructor
  AlternateDispatcherA(
                   JTextField fieldA,
                   JTextField fieldC,
                   KeyboardFocusManager manager){
    this.fieldA = fieldA;
    this.fieldC = fieldC;
    this.manager = manager;
  }//end constructor

  public boolean dispatchKeyEvent(KeyEvent e){
    if(e.getSource() == fieldA){
      manager.redispatchEvent(fieldC,e);
      return true;
    }else{
      return false;
    }//end else
  }//end dispatchKeyEvent
}//end class AlternateDispatcherA
//=============================================//

class AlternateDispatcherB
                   implements KeyEventDispatcher{
  JTextField fieldB;
  JTextField fieldC;
  KeyboardFocusManager manager;

  //Constructor
  AlternateDispatcherB(
                   JTextField fieldB,
                   JTextField fieldC,
                   KeyboardFocusManager manager){
    this.fieldB = fieldB;
    this.fieldC = fieldC;
    this.manager = manager;
  }//end constructor

  public boolean dispatchKeyEvent(KeyEvent e){
    if(e.getSource() == fieldB){
      manager.redispatchEvent(fieldC,e);
      return true;
    }else{
      return false;
    }//end else
  }//end dispatchKeyEvent
}//end class AlternateDispatcherB