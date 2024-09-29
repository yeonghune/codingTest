from collections import deque

n, m = map(int, input().split())

lst = [list(map(int, input().split())) for i in range(n)]
result = 0

deq = deque()
virus = []
empty = []
for i in range(n):
    for j in range(m):
        if lst[i][j] == 2:
            virus.append((i, j))
        elif lst[i][j] == 0:
            empty.append((i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def calc():
    global ans
    graph = [arr[:] for arr in lst]

    for x, y in seq:
        graph[x][y] = 1

    bfs(graph)

    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                cnt += 1
    ans = max(ans, cnt)

def bfs(graph):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    visited = [[False for i in range(m)] for j in range(n)]

    for x, y in virus:
        deq.append((x, y))
        visited[x][y] = True

    while deq:
        x, y = deq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if graph[nx][ny] != 0:
                continue
            if visited[nx][ny]:
                continue

            visited[nx][ny] = True
            graph[nx][ny] = 2
            deq.append((nx, ny))


def find_max(idx, cnt):
    global result
    if cnt > 3:
        return

    if idx == len(empty):
        if cnt == 3:
            calc()
        return

    seq.append(empty[idx])
    find_max(idx + 1, cnt + 1)
    seq.pop()
    find_max(idx + 1, cnt)

ans = 0
seq = []
find_max(0, 0)
print(ans)