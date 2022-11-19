from collections import Counter

def solution(S):
    for i in range(len(S)):
        tmp_list = []
        for k in range(len(S)-i):
            tmp_list.append(S[k:k+1+i])
        if 1 in Counter(tmp_list).values():
            return i+1
