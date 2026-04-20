/* ******************************************
 * File:   functions.cpp
 * Author: Whit Allee
 * Contains the implementation of the test
 * functions as well as the random string generator.
 * ******************************************/


#include "functions.h"

std::string rand_string() {
    /****************************************************
     * creates a ramdom string of characters 
     * of length 10 and return it to the caller
     *
     * @param na : na
     * @return result (std::string) : string of length 10
     * @exception none
     * @note : filled with random A-Z
     * ************************************************* */

    static constexpr int LENGTH = 10;
    static constexpr char FIRST = 'A';
    static constexpr char LAST  = 'Z';

    static std::random_device rd;
    static std::mt19937 gen(rd());
    static std::uniform_int_distribution<int> dist(FIRST, LAST);

    std::string result;
    result.reserve(LENGTH);
    for (int i = 0; i < LENGTH; ++i) {
        result += static_cast<char>(dist(gen));
    }
    return result;
}

int test_invalid_constructor() {
    int caught = 0;
    try {
        Stack s(0);
    } catch (const std::invalid_argument& e) {
        caught++;
    }
    try {
        Stack s(-1);
    } catch (const std::invalid_argument& e) {
        caught++;
    }
    try {
        Stack s(1);
    } catch (const std::invalid_argument& e) {
        caught++;
    }
    return caught == 3 ? 0 : 1;
}

int test_underflow_from_empty(Stack& stack) {
    int is_empty = 0, peeked = 0, popped = 0, pushed = 0, got_size = 0;
    int stackSize = stack.getSize();
    int n = stackSize * MULTIPLIER;
    Data d;
    for (int i = 0; i < n; i++) {
        if (stack.isEmpty()) {
            is_empty++;
        } else {
            is_empty--;
        }
        if (stack.peek(d)) {
            peeked++;
        } else {
            peeked--;
        }
        if (stack.pop(d)) {
            popped++;
        } else {
            popped--;
        }
        string info = rand_string();
        if (stack.push(i + 1, &info)) {
            pushed++;
            if (stack.peek(d)) {
                peeked++;
            } else {
                peeked--;
            }
            if (stack.pop(d)) {
                popped++;
            } else {
                popped--;
            }
        } else {
            pushed--;
        }
        if (stack.getSize() == stackSize) {
            got_size++;
        } else {
            got_size--;
        }
    }
    return (popped == 0 && peeked == 0 && pushed == n && is_empty == n && got_size == n) ? 0 : 1;
}

int test_overflow(Stack& stack) {
    int is_empty = 0, peeked = 0, popped = 0, pushed = 0, got_size = 0;
    int stackSize = stack.getSize();
    int n = stackSize * MULTIPLIER;
    Data d;
    for (int i = 0; i <= stackSize; i++) {
        string info = rand_string();
        stack.push(i + 1, &info);
    }
    for (int i = 0; i < n; i++) {
        if (stack.isEmpty()) {
            is_empty++;
        } else {
            is_empty--;
        }
        if (stack.peek(d)) {
            peeked++;
        } else {
            peeked--;
        }
        if (stack.pop(d)) {
            popped++;
        } else {
            popped--;
        }
        string info = rand_string();
        if (stack.push(stackSize + i + 1, &info)) {
            pushed++;
        } else {
            pushed--;
        }
        string info2 = rand_string();
        if (stack.push(stackSize + i + 1, &info2)) {
            pushed++;
        } else {
            pushed--;
        }
        if (stack.getSize() == stackSize) {
            got_size++;
        } else {
            got_size--;
        }
    }
    return (popped == n && peeked == n && pushed == 0 && -is_empty == n && got_size == n) ? 0 : 1;
}

int test_underflow_from_full(Stack& stack) {
    int is_empty = 0, peeked = 0, popped = 0, pushed = 0, got_size = 0;
    int stackSize = stack.getSize();
    Data d;
    for (int i = 0; i < stackSize + 1; i++) {
        if (stack.isEmpty()) {
            is_empty++;
        } else {
            is_empty--;
        }
        if (stack.peek(d)) {
            peeked++;
        } else {
            peeked--;
        }
        if (stack.pop(d)) {
            popped++;
        } else {
            popped--;
        }
        if (stack.getSize() == stackSize) {
            got_size++;
        } else {
            got_size--;
        }
    }
    return (popped == stackSize - 1 && peeked == stackSize - 1 && pushed == 0 && -is_empty == stackSize - 1 && got_size == stackSize + 1) ? 0 : 1;
}

int test_mid_stack(Stack& stack) {
    int stackSize = stack.getSize();
    int is_empty = 0, peeked = 0, popped = 0, pushed = 0, got_size = 0;
    int n = stackSize * MULTIPLIER;
    Data d;
    for (int i = 0; i < stackSize / 2; i++) {
        string info = rand_string();
        stack.push(i + 1, &info);
    }
    for (int i = 0; i < n; i++) {
        if (stack.isEmpty()) {
            is_empty++;
        } else {
            is_empty--;
        }
        if (stack.peek(d)) {
            peeked++;
        } else {
            peeked--;
        }
        if (stack.pop(d)) {
            popped++;
        } else {
            popped--;
        }
        string info = rand_string();
        int id = (rand() % 2) ? (rand() % (MAX_INT/2) + 1) : -(rand() % (MAX_INT/2) + 1);
        if (id <= 0) {
            id = 1;
        }
        if (stack.push(id, &info)) {
            pushed++;
        } else {
            pushed--;
        }
        if (stack.getSize() == stackSize) {
            got_size++;
        } else {
            got_size--;
        }
    }
    return (popped == n && peeked == n && pushed == n && -is_empty == n && got_size == n) ? 0 : 1;
}

int test_random(Stack& stack) {
    Data d;
    while (!stack.isEmpty()) stack.pop(d);
    int stackSize = stack.getSize();
    for (int i = 0; i < stackSize / 2; i++) {
        string info = rand_string();
        stack.push((rand() % MAX_INT) + 1, &info);
    }
    int choice = rand() % CHOICES + 1;
    for (int i = 0; i < stackSize * RANDOM_MULTIPLIER; i++) {
        switch (choice) {
            case 1:
            case 2: {
                string info = rand_string();
                stack.push((rand() % MAX_INT) + 1, &info);
                break;
            }
            case 3:
            case 4:
                stack.pop(d);
                break;
            case 5:
                stack.peek(d);
                break;
            case 6:
                stack.isEmpty();
                break;
            case 7:
                stack.getSize();
                break;
        }
        choice = rand() % CHOICES + 1;
    }
    return 0;
}