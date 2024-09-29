def solution(citations):
    citations.sort(reverse=True)
    h = citations[0]
    while True:
        cnt = 0
        for i in citations:
            if i >= h:
                cnt += 1
        
        if cnt >= h:
            break
        
        h -= 1
        
    return h