# Asg 5 Data Struct Stack

This repo contains a Stack implementation that holds a simple Struct called Data, as well as a driver program that tests the dynamically-allocated ADT by running every operation on the stack in every possible state.

## Features

- Stack ADT: dynamically allocated Data array, push/pop/peek/isEmpty/getSize
- Size of Stack determined by CLI user input
- Automated tests: underflow, neither underflow nor overflow, and overflow states
- Randomized tests: applies random operations to the stack, weighted towards more destructive methods
- RNG seeded with current time for varied runs

## Build and run (Linux)

From the project directory:

```bash
g++ -I ./ *.cpp
./a.out 10 # change this number to the desired size of the stack to test
```

## Requirements

- C++ compiler (my version of g++ is using gcc 15.2.1 20251112 (GCC))

## File Summary

- `main.cpp`, `main.h` — Test driver;
- `functions.cpp`, `functions.h` — Testing functions and random string generator helper function
- `stack.cpp`, `stack.h` — Stack implementation (dynamically allocated based on CLI input)
- `data.h` — Simple struct for each element of the stack

## Credit

Assignment 5 by Whit Allee, completed 2/27/2026
- Professor: Alexander Katrompas
- COSC-2436-002