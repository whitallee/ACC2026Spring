/* ******************************************
 * File:   stack.cpp
 * Author: Whit Allee
 * The implementation for a Data Stack class.
 * The purpose of this class is to provide a
 * stack data structure for Data objects.
 * ******************************************/

#include "stack.h"

Stack::Stack(int size) {
    /* ****************************************
    Constructor

    @param size (int) : the size of the stack
    @return none
    @exception none
    @note if size is less than MINSTACKSIZE,
        throw an invalid_argument exception
    *********************************************/
    if (size < MINSTACKSIZE) {
        throw std::invalid_argument("Size must be greater than or equal to " + std::to_string(MINSTACKSIZE));
    } else {
        this->size = size;
        this->top = -1;
        this->stack = new Data*[size];
    }
}

Stack::~Stack() {
    /* ****************************************
    Destructor

    @param none
    @return none
    @exception none
    @note deallocate anything left on the stack, then the stack itself
    *********************************************/
    for (int i = 0; i <= top; i++) {
        delete stack[i];
    }
    delete[] stack;
}

bool Stack::isEmpty() {
    /* ****************************************
    isEmpty

    @param none
    @return true if the stack is empty, false otherwise
    @exception none
    @note check if the stack is empty
    *********************************************/
    return top == -1;
}

int Stack::getSize() {
    /* ****************************************
    getSize

    @param none
    @return the size of the stack
    @exception none
    @note return the size of the stack
    *********************************************/
    return size;
}

bool Stack::peek(Data& dataStructRef) {
    /* ****************************************
    peek

    @param dataStructRef (Data&) : ref to peek data into
    @return true if the peek was successful, false otherwise
    @exception none
    @note return the top element of the stack,
        if the stack is empty, set the dataStructRef to -1 and empty string and return false
    *********************************************/
    bool peeked = false;
    if (top > -1) {
        dataStructRef = *stack[top];
        peeked = true;
    } else {
        dataStructRef.id = -1;
        dataStructRef.information = "";
    }
    return peeked;
}

bool Stack::pop(Data& dataStructRef) {
    /* ****************************************
    pop

    @param dataStructRef (Data&) : ref to pop data into
    @return true if the pop was successful, false otherwise
    @exception none
    @note pop the top element of the stack,
        if the stack is empty, set the dataStructRef to -1 and empty string and return false
    *********************************************/
    bool popped = false;
    if (top > -1) {
        dataStructRef = *stack[top];
        delete stack[top];
        top--;
        popped = true;
    } else {
        dataStructRef.id = -1;
        dataStructRef.information = "";
    }
    return popped;
}

bool Stack::push(int id, string* informationRef) {
    /* ****************************************
    push

    @param id (int) : the id to push
    @param informationRef (string*) : ref to the information to push
    @return true if the push was successful, false otherwise
    @exception none
    @note push the data onto the stack,
        if the stack is full, id is not positive,
        or *informationRef is an empty string, return false
    *********************************************/
    bool pushed = false;
    if (top < size - 1 && id > 0 && *informationRef != "") {
        stack[++top] = new Data{id, *informationRef};
        pushed = true;
    }
    return pushed;
}