#include <fstream>
#include <iostream>
using namespace std;
struct msm{
    int day;
    int cow;
    int del;
};
int main(int argc, const char * argv[]) {
    ifstream fin("measurement.in");
    ofstream fout("measurement.out");
    int n=0,g=0;
    fin>>n>>g;
    msm mea[n];
    for(int i=0;i<n;i++)fin>>mea[i].day>>mea[i].cow>>mea[i].del;
    int cows[]
    fin.close();
    fout.close();
    return 0;
}
