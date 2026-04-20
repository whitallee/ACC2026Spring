/* ******************************************
 * File:   stack.h
 * Author: Whit Allee
 * The interface for a Data Stack class.
 * The purpose of this class is to provide a
 * stack data structure for Data objects.
 * ******************************************/

#ifndef STACK_H
#define STACK_H

#include <string>
#include <stdexcept>
#include "data.h"

#define MINSTACKSIZE 2

class Stack {

public:

    /**********************
     * Constructors/Destructor
     **********************/
     Stack(int size);
     ~Stack();
 
     /**********************
      * Getters/Accessors
      **********************/
 
     bool isEmpty();
     int getSize();
     bool peek(Data&);
 
     /**********************
      * Setters/Mutators
      **********************/
 
     bool pop(Data&);
     bool push(int, string*);
 
     /**********************
     * Printing
     **********************/
 
     // none
    
private:

    /**********************
    * Methods
    **********************/

    // none

    /**********************
    * Attributes
    **********************/
    int top;
    int size;
    Data **stack;
    
};

#endif //STACK_H
