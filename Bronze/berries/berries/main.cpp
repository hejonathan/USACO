
#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    int n=0, k=0;
    ifstream fin("berries.in");
    ofstream fout("berries.out");
    fin >> n >> k;
    vector<int> berries(n);
    for (int i=0; i<n; i++) {
        fin >> berries[i];
    }
    sort(berries.begin(), berries.end(), greater<int>());
    
    int mx=0;
    
    for (int i=1; i<=min(berries[0], 1000); i++) {
        int fb=0;
        vector<int> Rem;
        int c_get=0;
        for (int j=0; j<n; j++) {
            fb+=berries[j]/i;
            Rem.push_back(berries[j]%i);
        }
        if (fb>=k) {
            c_get=.5*k*i;
        }else if (fb >= .5*k && fb < k){
            sort(Rem.begin(), Rem.end(), greater<int>());
            c_get=(fb-.5*k)*i;
            for (int j=0; j<k-fb && j<n; j++) {
                c_get+=Rem[j];
            }
        }else{
            break;
        }
        mx=max(mx, c_get);
    }
    fout << mx << endl;
    
    fin.close();
    fout.close();
    return 0;
}
