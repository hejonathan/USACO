#include <algorithm>
#include <iostream>
#include <vector>
#include <fstream>
#include <cstring>
#define mx 100001
#define mw 1000000000
using namespace std;

int n=0, m=0;
ifstream fin("wormsort.in");
ofstream fout("wormsort.out");
vector<vector<int> > adj;
vector<vector<int> > wchart;
int loca[mx];
bool visited[mx];
void bs(int low, int high);
bool works(int min);
bool dfs(int start, int end, int min);
int mid=0;
int main(int argc, const char * argv[]) {
    
    int i=1;
    fin >> n >> m;
    adj.resize(n+1);
    wchart.resize(n+1);
    for (i=1; i<=n; i++) wchart[i].resize(n+1);
    for (i=1; i<=n; i++) {
        fin >> loca[i];
    }
    for (i=1; i<=m; i++) {
        int a, b, w;
        fin >> a >> b >> w;
        adj[a].push_back(b);
        adj[b].push_back(a);
        wchart[a][b]=w;
        wchart[b][a]=w;
    }
    
    mid=-1;
    for (i=1; i<=n; i++) {
        if (loca[i]!=i) {
            bs(1, mw);
            break;
        }
    }
    fout << mid << endl;
    
    fin.close();
    fout.close();
    return 0;
}
void bs(int low, int high){
    mid = (low+high)/2;
    if (low==mid) {
        return;
    }
    if (works(mid)) {
        bs(mid, high);
    }else{
        bs(low, mid);
    }
}
bool works(int min){
    for (int i=1; i<=n; i++) {
        memset(visited, false, sizeof(visited));
        if (dfs(loca[i], i, min)==false) {
            return false;
        }
    }
    return true;
}
bool dfs(int start, int end, int min){
    visited[start]=true;
    if (start==end) {
        return true;
    }
    for (int i=0; i<adj[start].size(); i++) {
        if (visited[adj[start].at(i)]==false && wchart[start][adj[start].at(i)]>=min) {
            if (dfs(adj[start].at(i), end, min)) {
                return true;
            }
        }
    }
    return false;
}
