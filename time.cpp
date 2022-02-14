#include <iostream>
#include <vector>
#define INT_MIN -2147483648
using namespace std;

int main() {
    freopen("time.in","r",stdin);
    freopen("time.out","w",stdout);
    int n,m,c;
    cin>>n>>m>>c;
    vector<vector<int> > dp(502,vector<int>(n,INT_MIN));
    vector<vector<int> > adj(n,vector<int>(0));
    vector<int> weight(n);
    for(auto& e:weight) cin>>e;
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        a--;b--;
        adj[b].push_back(a);
    }
    dp[0][0] = 0;
    for(int i=1;i<dp.size();i++){
        for(int j=0;j<dp[i].size();j++){
            int mx = INT_MIN;
            for(auto e:adj[j]){
                mx = max(mx, dp[i-1][e]);
            }
            if(mx == INT_MIN) continue;
            dp[i][j] = mx + weight[j];
        }
    }
    for(int i=0;i<dp.size();i++) for(auto& e:dp[i]) if(e!=INT_MIN) e -= c*i*i;
    int ans = 0;
    for(auto & i : dp){
        ans = max(ans, i[0]);
    }
    cout << ans << endl;
}
