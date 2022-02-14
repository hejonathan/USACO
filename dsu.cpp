#include <iostream>
#include <vector>
using namespace std;
class dsu{
public:
    vector<int> e;
    vector<int> h;
    explicit dsu(int n){
        e = vector<int>(n,-1);
        h = vector<int>(n,1);
    }
    int get(int a){
        if(e[a]==-1) return a;
        return e[a] = get(e[a]);
    }
    void merge(int a, int b){
        a = get(a);
        b = get(b);
        if(a==b) return;
        if(h[a] > h[b]) swap(a,b);
        h[b] += h[a];
        e[a] = b;
    }
};
int main(){
    int n,q;
    cin>>n>>q;
    dsu d(n);
    for(int i=0;i<q;i++){
        int temp, u, v;
        cin>>temp>>u>>v;
        if(temp) cout << (d.get(u) == d.get(v)) << endl;
        else d.merge(u,v);
    }
}