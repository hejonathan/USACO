#include <string>
#include <iostream>
#include <cmath>
#include <vector>
#include <fstream>
#include <cstring>
using namespace std;
#define ll int
#define mx 100001
ll n=0, m=0;
vector<ll> adj[mx];
ll visited[mx];
ll group=0;
char type[mx];
void dfs(int i);
int main(int argc, const char * argv[]) {
    ifstream fin("milkvisits.in");
    ofstream fout("milkvisits.out");
    fin >> n >> m;
    fin >> (type+1);
    int i=1;
    for (i=1; i<=n-1; i++) {
        int s, e;
        fin >> s >> e;
        adj[s].push_back(e);
        adj[e].push_back(s);
    }
    memset(visited, 0, sizeof(visited));
    for (i=1; i<=n; i++) {
        if (visited[i]==0) {
            group++;
            dfs(i);
        }
    }
    
    for (i=0; i<m; i++) {
        int a=0, b=0;
        char c;
        fin >> a >> b >> c;
        if (visited[a]==visited[b] && type[a]!=c) {
            fout << "0";
        }else{
            fout << "1";
        }
    }
    fout << endl;
    fin.close();
    fout.close();
    return 0;
}
void dfs(int i){
    visited[i]=group;
    for (int j=0; j<adj[i].size(); j++) {
        if (visited[adj[i].at(j)]==0 && type[adj[i].at(j)]==type[i]) {
            dfs(adj[i].at(j));
        }
    }
}
