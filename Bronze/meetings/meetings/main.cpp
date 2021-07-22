
#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;

struct cows{
    int weight;
    long long xposition;
    int direction;
    int stat;
};
int willcollide(long long *p1, long long *p2, int d1, int d2);

int main(int argc, const char * argv[]) {
    ifstream fin("meetings.in");
    ofstream fout("meetings.out");
    int n=0;
    long long l=0;
    fin >> n >> l;
    cows cow[n];
    long long totalweight=0, cweight=0;
    for (int i=0; i<n; i++) {//get info
        fin >> cow[i].weight >> cow[i].xposition >> cow[i].direction;
        totalweight += cow[i].weight;
        cow[i].stat=1;
    }
    long long meets=0;
    int j=0,k=0;
    for (int i=0; (long long)2*cweight < totalweight; i++) {
        for (j=0; j<n-1; j++) {//check meet
            for (k=j+1; k<n; k++) {
                if (willcollide(&cow[j].xposition, &cow[k].xposition, cow[j].direction, cow[k].direction)) {
                    cow[j].direction *= -1;
                    cow[k].direction *= -1;
                    meets++;
                }
            }
        }
        for (j=0; j<n; j++) {//move
            cow[j].xposition+=cow[j].direction;
        }
        for (j=0; j<n; j++) {//check barn
            if (cow[j].xposition==0 || cow[j].xposition==l) {
                cow[j].direction=0;
                cweight+=cow[j].weight;
            }
        }
    }
    
    fout << meets << endl;
    
    fin.close();
    fout.close();
    return 0;
}
int willcollide(long long *p1, long long *p2, int d1, int d2){
    if (abs(*p1-*p2)==1) {
        if (*p1>*p2 && d1-d2==-2) {
            *p1+=d1;
            *p2+=d2;
            return 1;
        }else if (*p2>*p1 && d2-d1==-2){
            *p1+=d1;
            *p2+=d2;
            return 1;
        }
    }else if (abs(*p1-*p2)==0){
        return 1;
    }
    return 0;
}
