#include <fstream>
#include <iostream>
#include <vector>
using namespace std;
#define mx 1001
int n=0;
bool grid[mx][mx];
vector<bool> cline;
int nex(int x){
    if (x==n) {
        return 1;
    }
    return x+1;
}
bool ctype=false;
int checkline();
int row=0, col=0;
int main(int argc, const char * argv[]) {
    ifstream fin("leftout.in");
    ofstream fout("leftout.out");
    fin >> n;
    int i=1, j=1;
    for (i=1; i<=n; i++) {
        for (j=1; j<=n; j++) {
            char a;
            fin >> a;
            (a=='R')? grid[i][j]=true:grid[i][j]=false;
        }
    }
    for (i=1; i<=n; i++) {
        cline.clear();
        for (j=1; j<=n; j++) {
            if (grid[i][j]==grid[nex(i)][j]) {
                cline.push_back(true);
            }else{
                cline.push_back(false);
            }
        }
        int a=checkline();
        if (a!=-1) {
            col=a;
            cline.clear();
            for (int k=1; k<=n; k++) {
                if (grid[k][a]==grid[k][nex(a)]) {
                    cline.push_back(true);
                }else{
                    cline.push_back(false);
                }
            }
            row=checkline();
            break;
        }
    }
    
    (row<1 || col<1)? fout<<"-1\n" : fout << row << " " << col << endl;
    fin.close();
    fout.close();
    return 0;
}
int checkline(){
    if (cline.size()<=2) {
        return 1;
    }
    int tue=0, fal=0;
    for (int i=0; i<n; i++) {
        if (cline[i]) {
            tue++;
        }else{
            fal++;
        }
    }
    bool a;
    if (tue!=n && fal!=n) {
        if (tue>fal) {
            a=false;
        }else if (fal>tue){
            a=true;
        }else{
            return 1;
        }
        for (int i=0; i<n; i++) {
            if (cline[i]==a) {
                return i+1;
            }
        }
    }
    return -1;
}
