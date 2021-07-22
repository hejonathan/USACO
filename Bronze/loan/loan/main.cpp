#include <cmath>
#include <fstream>
#include <iostream>
using namespace std;

long long n=0, m=0, k=0;
long long x=0;
bool works(long long x);

int main(int argc, const char * argv[]) {
    ifstream fin("loan.in");
    ofstream fout("loan.out");
    fin >> n >> k >> m;
    
    long long low=1, high=powl(10, 12);
    while (low < high) {
        x=(low+high+1)/2;
        if (works(x)) {
            low = x;
        }else{
            high = x-1;
        }
    }
    
    fout << low << endl;
    fin.close();
    fout.close();
    return 0;
}
bool works(long long x){
    long long g=0;
    long long t=0;
    long long y=0;
    while (t<k) {
        y = (n-g)/x;
        if (y <= m) {
            g += (k-t)*m;
            break;
        }
        long long dtc=(n-g)%x/y+1;
        g += dtc*y;
        t += dtc;
    }
    return g>=n;
}
