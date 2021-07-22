
#include <iostream>
#include <fstream>
using namespace std;
int n=0;
struct cows{
    int start;
    int end;
};
int mx=0;
int cmax=0;

int main(int argc, const char * argv[]) {
    ifstream fin("lifeguards.in");
    ofstream fout("lifeguards.out");
    
    fin >> n;
    struct cows cow[n];
    for (int i=0; i<n; i++) fin >> cow[i].start >> cow[i].end;
    
    for (int i=0; i<n; i++) {
        cmax=0;
        for (int j=0; j<=1000; j++) {
            for (int k=0; k<n; k++) {
                if (k!=i && j>=cow[k].start && j<cow[k].end) {
                    cmax++;
                    break;
                }
            }
        }
        mx=max(mx, cmax);
    }
    
    fout << mx << endl;
    fin.close();
    fout.close();
    return 0;
}
