def Solution(A, K, L):
    len_A = len(A)
    possible_answer = []
    for k_index in range(len_A - K + 1):
        sum_k = sum(A[k_index: k_index + K])
        for l_index in range(k_index):
            if l_index + L < k_index:
                sum_l = sum(A[l_index: l_index+L])
                possible_answer.append(sum_k + sum_l)
        for l_index in range(k_index + K, len_A):
            if l_index + L <= len_A :
                sum_l = sum(A[l_index: l_index+L])
                possible_answer.append(sum_k + sum_l)
    #print(possible_answer)
    if possible_answer:
        return max(possible_answer)
    else:
        return -1