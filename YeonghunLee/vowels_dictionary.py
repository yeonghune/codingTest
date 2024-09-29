cnt = -1
arr = []
answer = 0

def dfs(word):
    global answer, arr, cnt
    if len(arr) > 5:
        return
    
    cnt += 1
    string = ''
    for i in arr:
        string += i
    
    if string == word:
        answer = cnt
    
    for i in ['A', 'E', 'I', 'O', 'U']:
        arr.append(i)
        dfs(word)
        arr.pop()
        
        

def solution(word):
    global answer
    
    dfs(word)
    
    return answer