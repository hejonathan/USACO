#include <iostream>
#include <vector>
#define INT_MAX 2147483647
using namespace std;

int main(){
    freopen("snakes.in","r",stdin);
    freopen("snakes.out","w",stdout);
    int n,k; cin>>n>>k;
    vector<int> a(n);
    for(auto& e:a) cin>>e;
    vector<vector<int>> dp(k+1,vector<int>(n,INT_MAX));
    vector<vector<int>> minimumLost(n,vector<int>(n,INT_MAX));
    for(int i=0;i<n;i++){
        int mx = a[i];
        int tot = 0;
        for(int j=i;j>=0;j--){
            if(a[j] > mx){
                tot += (a[j]-mx) * (i-j);
                mx = a[j];
            }else{
                tot += mx - a[j];
            }
            minimumLost[j][i] = tot;
        }
    }
    for(int r = 0;r<n;r++){
        dp[0][r]=minimumLost[0][r];
    }
    for(int i=1;i<k+1;i++){
        for(int r=0;r<n;r++){
            for(int l=i;l<=r;l++){
                int temp = minimumLost[l][r];
                dp[i][r] = min(dp[i][r], dp[i-1][l-1] + temp);
            }
        }
    }
    int ans = INT_MAX;
    for(int i=0;i<k+1;i++){
        ans = min(ans, dp[i][dp[i].size()-1]);
    }
    cout << ans << endl;
}