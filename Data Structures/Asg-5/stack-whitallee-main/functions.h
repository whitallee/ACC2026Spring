/* ******************************************
 * File:   functions.h
 * Author: Whit Allee
 * Header file for the test functions and the
 * random string generator.
 * ******************************************/

#ifndef STACKS_FUNCTIONS_H
#define STACKS_FUNCTIONS_H

#define MAXSTRSIZE 8
#define MULTIPLIER 1.5 // used to test overflow and underflow
#define MAX_INT 10000000 // random ints to push, 1 - 10000000
#define RANDOM_MULTIPLIER 100000
#define CHOICES 7 // used to pick random operations

#include <random>
#include <string>
#include "stack.h"

std::string rand_string();

int test_invalid_constructor();
int test_underflow_from_empty(Stack&);
int test_overflow(Stack&);
int test_underflow_from_full(Stack&);
int test_mid_stack(Stack&);
int test_random(Stack&);

#endif /* STACKS_FUNCTIONS_H */
