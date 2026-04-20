/* ******************************************
 * File:   main.cpp
 * Author: Whit Allee
 * The implementation for main() which is
 * a test script for the Data Stack class.
 * ******************************************/

#include "main.h"

int main(int argc, char **argv) {
    int result = 0;
    if (argc != 2) {
        cout << "Usage: pass a single integer parameter (stack size, 2 or greater) on the command line." << endl;
        result = 1;
    } else {
        int stackSize = -1;
        try {
            size_t pos;
            std::string arg(argv[1]);
            stackSize = std::stoi(arg, &pos); // convert string to int and store position of last character converted
            if (pos != arg.length()) { // if position is not the length of the string, set stack size to -1
                stackSize = -1;
            }
        } catch (...) {
            stackSize = -1; // if exception is thrown, set stack size to -1
        }
        if (stackSize < 2) { // if stack size is less than 2, set result to 1
            cout << "Usage: pass a single integer parameter (stack size, 2 or greater) on the command line." << endl;
            result = 1;
        } else {

            srand(static_cast<unsigned>(time(NULL)));
            if (test_invalid_constructor() == 1) {
                cout << "Invalid constructor test failed." << endl;
                result = 1;
            } else {
                cout << "Invalid constructor test passed." << endl;
            }
            Stack stack(stackSize);
            cout << "Stack created (size " << stack.getSize() << ")." << endl;
            cout << "Beginning tests..." << endl;

            if (test_underflow_from_empty(stack) == 1) {
                cout << "Underflow from empty test failed." << endl;
                result = 1;
            } else {
                cout << "Underflow from empty test passed." << endl;
            }
            if (test_overflow(stack) == 1) {
                cout << "Overflow test failed." << endl;
                result = 1;
            } else {
                cout << "Overflow test passed." << endl;
            }
            if (test_underflow_from_full(stack) == 1) {
                cout << "Underflow from full test failed." << endl;
                result = 1;
            } else {
                cout << "Underflow from full test passed." << endl;
            }
            if (test_mid_stack(stack) == 1) {
                cout << "Mid-stack test failed." << endl;
                result = 1;
            } else {
                cout << "Mid-stack test passed." << endl;
            }
            test_random(stack);
            cout << "Random test passed." << endl;
        }
        cout << "Testing complete." << endl;
    }
    return result;
}
