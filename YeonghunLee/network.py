from collections import deque

def bfs(graph, visited, i):
    deq = deque()
    visited[i] = True
    
    if i not in graph:
        return
    
    for elem in graph[i]:
        deq.append(elem)
    
    while deq:
        next = deq.popleft()
        
        if visited[next]:
            continue
        
        visited[next] = True
        for el in graph[next]:
            deq.append(el)
    

def solution(n, computers):
    dictionary = {}
    answer = 0
    lst = computers
    for i in range(len(lst)):
        for j in range(len(lst)):
            if i == j:
                continue
            elif lst[i][j] == 1:
                if i not in dictionary:
                    dictionary[i] = [j]
                else:
                    dictionary[i].append(j)
    
    visited = [False for i in range(n)]
    for i in range(n):
       # print(visited)
        if visited[i]:
            continue
        
        bfs(dictionary, visited, i)
        answer += 1
    
    return answer