def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        added = []
        for j in range(len(arr1[i])):
            added.append(arr1[i][j]+arr2[i][j])
        answer.append(added)
    return answer
