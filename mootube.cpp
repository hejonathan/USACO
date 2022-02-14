#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>

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
    bool is_same(int a, int b){
        return get(a) == get(b);
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
    freopen("mootube.in","r",stdin);
    freopen("mootube.out","w",stdout);
    int n, q;
    cin >> n >> q;
    deque<pair<int,pair<int,int>>> connections;
    for(int i=0;i<n-1;i++){
        pair<int,pair<int,int>> temp;
        cin >> temp.second.first >> temp.second.second >> temp.first;
        temp.second.first--; temp.second.second--;
        connections.push_back(temp);
    }
    sort(connections.begin(), connections.end(), [](pair<int,pair<int,int>> a, pair<int,pair<int,int>> b){
        return a.first > b.first;
    });
    vector<pair<int,pair<int,int>>> queries;
    for(int i=0;i<q;i++){
        int k,v;
        cin>>k>>v;
        v--;
        queries.push_back({i,{k,v}});
    }
    sort(queries.begin(), queries.end(), [](pair<int,pair<int,int>> a, pair<int,pair<int,int>> b){
        return a.second.first > b.second.first;
    });
    vector<pair<int,int>> ans;
    dsu d(n);
    for(auto e:queries){
        int k = e.second.first, v = e.second.second;
        while(!connections.empty() && connections.front().first >= k){
            int a = connections.front().second.first, b = connections.front().second.second;
            connections.pop_front();
            d.merge(a,b);
        }
        ans.emplace_back(e.first, d.h[d.get(v)]);
    }
    sort(ans.begin(), ans.end());
    for(auto e:ans) cout << e.second-1 << endl;
}