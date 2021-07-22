#include <string>
#include <fstream>
#include <iostream>
#include <vector>
#include <cmath>
#include <stack>
#include <cstring>
using namespace std;
#define ll long long

struct friends{
    ll start, end;
    char type;
};
bool visited[100000]={false};
vector<ll> cow[100000];
int dfs(ll start, ll end, stack<ll> *s);
ll n=0, m=0;

int main(int argc, const char * argv[]) {
    stack<ll> s;
    ifstream fin("milkvisits.in");
    ofstream fout("milkvisits.out");
    fin >> n >> m;
    string t;
    fin >> t;
    char tycow[n+1];
    for (int i=1; i<=n; i++) tycow[i]=t[i-1];
    
    for (int i=0; i<n-1; i++) {
        ll a, b;
        fin >> a >> b;
        cow[a].push_back(b);
        cow[b].push_back(a);
    }
    friends fri[m];
    for (int i=0; i<m; i++) {
        fin >> fri[i].start >> fri[i].end >> fri[i].type;
    }
    
    for (int i=0; i<m; i++) {
        if (tycow[fri[i].start]==fri[i].type || tycow[fri[i].end]==fri[i].type) {
            fout << "1";
        }else{
            memset(visited, false, 100000*sizeof(bool));
            dfs(fri[i].start, fri[i].end, &s);
            int happy=0;
            while (!s.empty()) {
                if (tycow[s.top()]==fri[i].type) {
                    happy=1;
                    break;
                }
                s.pop();
            }
            while (!s.empty()) s.pop();
            fout << happy;
        }
    }
    
    fout << endl;
    fin.close();
    fout.close();
    return 0;
}

int dfs(ll start, ll end, stack<ll> *s){
    visited[start]=true;
    s->push(start);
    if (start==end) {
        return 1;
    }
    for (int i=0; i<cow[start].size(); i++) {
        if (visited[cow[start].at(i)]==false) {
            if (dfs(cow[start].at(i), end, s)) {
                return 1;
            }
        }
    }
    s->pop();
    return 0;
}
