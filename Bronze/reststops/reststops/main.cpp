#include <fstream>
#include <iostream>
using namespace std;
int l=0, n=0, rf=0, rb=0;
long long start=0, tasty=0;
int dist = 0;
struct stops{
    int x;
    int c;
}stop[100000];

bool findtas(int begin){
    int mx=0;
    tasty=0;
    bool found=false;
    dist = 0;
    int st = 0;
    for (int i=0; i<n; i++) {
        if (stop[i].x > begin && stop[i].c >= mx) {
            mx = stop[i].c;
            dist = stop[i].x-start;
            st = stop[i].x;
            found = true;
        }
    }
    start = st;
    tasty = mx;
    return found;
}

int main(int argc, const char * argv[]) {
    ifstream fin("reststops.in");
    ofstream fout("reststops.out");
    fin >> l >> n >> rf >> rb;
    for (int i=0; i<n; i++) fin >> stop[i].x >> stop[i].c;
    int a = rf-rb;
    long long tu=0;
    
    while (1) {
        if (findtas(start)) {
            tu += tasty*a*dist;
        }else{
            break;
        }
    }
    
    fout << tu << endl;
    
    
    fin.close();
    fout.close();
    return 0;
}
