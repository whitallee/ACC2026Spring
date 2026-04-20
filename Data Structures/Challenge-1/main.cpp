
/* #include copies declarations from system headers so we can call printf, strlen, clock, etc. */
#include <math.h>   /* fmod: floating-point remainder (like % for doubles) */
#include <stdio.h>  /* printf */
#include <string.h> /* strlen */
#include <time.h>   /* clock, clock_t, CLOCKS_PER_SEC */

/*
 * #define NAME value  — the preprocessor replaces NAME with value before compile.
 * Here we pick big loop counts so the timer sees a difference (change if too slow/fast).
 */
#define ITER 100000000
#define STR_REPS 5000000
#define STR_SIZE 4096

/*
 * static (on a function): this function is only visible in this .cpp file, not other files.
 * const (on a pointer parameter): we will not change the characters s points to inside my_strlen.
 * size_t: unsigned integer type used for sizes and array indexes (from the standard library).
 */
static size_t my_strlen(const char *s) {
    size_t n = 0;
    while (s[n] != '\0') {
        n++;
    }
    return n;
}

/*
 * static (on global variables): only this file can see g_hold_d / g_hold_z.
 * volatile: tells the compiler "this value may change in ways you cannot see," so it must
 * really read/write it. We assign the loop results here so the optimizer does not delete
 * the timed loops just because we do not print those values.
 */
static volatile double g_hold_d;
static volatile size_t g_hold_z;

/*
 * int main(void) — void in the parameter list means "this function takes no arguments"
 * (in C; in C++ you can also write int main()).
 */
int main(void) {

    /* clock_t: an arithmetic type that clock() returns (usually like a long integer tick count). */
    clock_t start_time, end_time;
    double time_taken;

    /* ----- Test 1: integer vs float ----- */
    printf("=== 1) Integer vs float operations ===\n");
    printf("(demo) int 5/2 = %d, double 5.0/2.0 = %f\n\n", 5 / 2, 5.0 / 2.0);

    int isum = 0;
    start_time = clock();
    /* long: a wide integer type so i can count past 2 billion if needed. */
    for (long i = 0; i < ITER; i++) {
        /* (int) before i: explicit cast — convert long i to int for this expression. */
        int x = (int)(i % 10000);
        isum += (x * 7 + 13) / 3;
        /* ^= : XOR-assignment; & : bitwise AND (here keeps low 8 bits of x). */
        isum ^= (x & 255);
    }
    end_time = clock();
    /* CLOCKS_PER_SEC: constant from time.h — ticks per second, so division gives seconds. */
    time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;
    printf("Integer loop: %f sec (checksum %d)\n", time_taken, isum);

    /* double: floating-point type with more precision than float; use 0.0 for a double literal. */
    double fsum = 0.0;
    start_time = clock();
    for (long i = 0; i < ITER; i++) {
        double x = (double)(i % 10000);
        fsum += (x * 7.0 + 13.0) / 3.0;
        /* fmod(a,b) is the remainder of a/b for floating-point (like % for integers). */
        fsum += fmod(x, 256.0) * 0.001;
    }
    end_time = clock();
    time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;
    printf("Float loop:   %f sec (checksum %f)\n\n", time_taken, fsum);

    /* ----- Test 2: if inside loop vs if outside (same total work) ----- */
    printf("=== 2) If inside loop vs if moved outside ===\n");
    printf("We use a flag chosen once. Bad: check it every iteration.\n");
    printf("Good: pick the loop body once, no if in the inner loop.\n\n");

    /*
     * volatile int do_add: the compiler must load do_add from memory each time it is used,
     * so it cannot treat the if as "always true" and delete the else branch when optimizing.
     */
    volatile int do_add = 1;
    double sum_bad = 0.0;
    start_time = clock();
    for (long i = 0; i < ITER; i++) {
        double x = (double)(i % 1000);
        if (do_add) {
            sum_bad += x;
        } else {
            sum_bad -= x;
        }
    }
    end_time = clock();
    time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;
    printf("If inside loop:  %f sec\n", time_taken);
    g_hold_d = sum_bad;

    double sum_good = 0.0;
    start_time = clock();
    if (do_add) {
        for (long i = 0; i < ITER; i++) {
            double x = (double)(i % 1000);
            sum_good += x;
        }
    } else {
        for (long i = 0; i < ITER; i++) {
            double x = (double)(i % 1000);
            sum_good -= x;
        }
    }
    end_time = clock();
    time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;
    printf("If outside loop: %f sec\n\n", time_taken);
    g_hold_d = sum_good;

    /* ----- Test 3: library strlen vs my_strlen ----- */
    printf("=== 3) Library strlen vs hand-written loop ===\n");
    /*
     * static char buf[...] inside main: storage lasts for the whole program run (not destroyed
     * each time we would "re-enter" main — main only runs once). The array is not reallocated
     * on every call if this were inside another function.
     */
    static char buf[STR_SIZE + 1];
    for (int i = 0; i < STR_SIZE; i++) {
        buf[i] = (char)('a' + (i % 26));
    }
    buf[STR_SIZE] = '\0';

    size_t total_lib = 0;
    start_time = clock();
    for (long r = 0; r < STR_REPS; r++) {
        total_lib += strlen(buf);
    }
    end_time = clock();
    time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;
    printf("strlen (library): %f sec\n", time_taken);
    g_hold_z = total_lib;

    size_t total_hand = 0;
    start_time = clock();
    for (long r = 0; r < STR_REPS; r++) {
        total_hand += my_strlen(buf);
    }
    end_time = clock();
    time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;
    printf("my_strlen (mine): %f sec\n", time_taken);
    g_hold_z = total_hand;

    /* return 0 tells the OS the program finished normally (0 = success). */
    return 0;
}
