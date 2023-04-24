#include <stdio.h>
#include <string.h>
#include <string>
#include <queue>

using namespace std;

int main() {
	int n, k;
	queue<int> q;
	scanf("%d %d", &n, &k);
	for (int i = 1; i < n+1; i++) {
		q.push(i);
	}
	printf("%c", '<');
	int temp = 1;
	while (!q.empty()) {
		if (temp % k == 0) {
			if (temp == k) {
				printf("%d", q.front());
				q.pop();
			}
			else {
				printf(", %d", q.front());
				q.pop();
			}
		}
		else {
			q.push(q.front());
			q.pop();
		}
		temp++;
	}
	printf("%c", '>');
}