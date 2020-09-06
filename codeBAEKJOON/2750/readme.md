# 문제 주소  
https://www.acmicpc.net/problem/2750

## 목표
여러가지 방법을 통해 오름차순으로 정렬

## 문제 해결
문제 자체는 쉬운 축에 속하므로 성능을 올리는 방법을 찾아봄
```
1. Scanner + Array + Arrays.sort
    -> 메모리 : 19,144kb / 시간 : 196ms
2. BufferedReader + Array + Arrays.sort  
    -> 메모리 : 13,980kb / 시간 : 128ms
3. BufferedReader + ArrayList + Collections.sort
    -> 메모리 : 14,064kb / 시간 : 128ms
4. BufferedReader + Array + Bubble_Sort
    -> 메모리 : 14,000kb / 시간 : 140ms
5. BufferedReader + Array + Quick_Sort
    -> 메모리 : 13,968kb / 시간 : 120ms
6. BufferedReader + Array + Counting_Sort
    -> 카운팅 정렬 이해 후 풀 예정
```
