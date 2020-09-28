import sys

n, m = map(int, sys.stdin.readline().split())
lines = list(map(int, sys.stdin.readline().split()))
rank = [1] * n
parent = list(range(0, n))
ans = max(lines)

def getParent(table):
    if table != parent[table]:
        parent[table] = getParent(parent[table])
    return parent[table]

def merge(destination, source):
    global ans
    realDestination, realSource = getParent(destination), getParent(source)

    if realDestination == realSource:
        print(ans)
        return False

    if rank[realDestination] > rank[realSource]:
        parent[realSource] = realDestination
        lines[realDestination] = lines[realSource] + lines[realDestination]
        lines[realSource] = 0
        ans = max(ans, lines[realDestination])
    else:
        parent[realDestination] = realSource
        lines[realSource] = lines[realSource] + lines[realDestination]
        lines[realDestination] = 0
        ans = max(ans, lines[realSource])
        if rank[realDestination] == rank[realSource]:
            rank[realSource] += 1
    print(ans)
    
    return True

for i in range(m):
    destination, source = map(int, sys.stdin.readline().split())
    merge(destination - 1, source - 1)
