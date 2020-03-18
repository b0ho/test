#include <bits/stdc++.h>
using namespace std;

int n, m;

vector<int> g[303030], inp[303030];
int dep[303030];
int fu[303030]; //full : i를 루트로 하는 서브트리에 완전히 포함된 back edge 개수
int su[303030]; //sub : i를 루트로 하는 서브트리에 조금이라도 포함된 back edge 개수
int ab[303030]; //absolute : i의 부모와 연결된 back edge 개수

void dfs(int v, int p){
	for(auto i : inp[v]){
		if(i == p) continue;
		if(!dep[i]){ //tree edge
			g[v].push_back(i);
			dep[i] = dep[v] + 1;
			int t = fu[v]; dfs(i, v); ab[i] = fu[v] - t;
			fu[v] += fu[i]; su[v] += su[i];
		}else if(dep[i] < dep[v]){ //back edge
			fu[i]++; su[v]++;
		}
	}
}

int main(){
	ios_base::sync_with_stdio(0); cin.tie(0);
	cin >> n >> m;
	for(int i=0; i<m; i++){
		int s, e; cin >> s >> e;
		inp[s].push_back(e);
		inp[e].push_back(s);
	}
	dep[1] = 1; dfs(1, -1);

	long long ans = 0;
	for(int i=1; i<=n; i++){
		int t = 1;
		for(auto ch : g[i]){
			//i의 부모보다 위로 이어지는 간선이 2개 이상인 경우 정점을 제거하면 tree edge와 back edge 모두 생성됨
			//fu[ch]가 0이 아니라면 서브트리 내부에 사이클 존재
			if(su[ch] - ab[ch] > 1 || fu[ch]) t = 0;
		}
		//0이 아니라면 i가 관여를 안 하는 곳에 back edge가 존재
		if(m-n+1-su[i]) t = 0;
		if(t) ans += i;
	}
	cout << ans;
}