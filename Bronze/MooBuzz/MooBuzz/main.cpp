//
/*
ID: 77617781
LANG: C
TASK: exp
*/

#include <iostream>
#include <stdio.h>
#include <fstream>
using namespace std;

int main(int argc, const char * argv[]) {
    ifstream fin("moobuzz.in");
    ofstream fout("moobuzz.out");
    long long n=0;
    long long k=0;
    fin >> n;
    long long a=n/8;
    n=n%8;
    for (int i=0; i<n;k=k+1) {
        if ((int)k%3!=0 && (int)k%5!=0) {
            i++;
        }
    }
    k = 15*a+k-1;
    fout << k;
    
    fin.close();
    fout.close();
    return 0;
}
