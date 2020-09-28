
# python3

class Query:

    def __init__(self, query):
        self.type = query[0]
        if self.type == 'check':
            self.ind = int(query[1])
        else:
            self.s = query[1]


class QueryProcessor:
    _multiplier = 263
    _prime = 1000000007

    def __init__(self, bucket_count):
        self.bucket_count = bucket_count
        # store all strings in one list
        self.elems = [None] * bucket_count

    def _hash_func(self, s):
        ans = 0
        for c in reversed(s):
            ans = (ans * self._multiplier + ord(c)) % self._prime
        return (ans % self.bucket_count + self.bucket_count) % self.bucket_count

    def write_search_result(self, was_found):
        print('yes' if was_found else 'no')

    def write_chain(self, chain):
        if chain != None:
            print(' '.join(chain))
        else:
            print(' ')

    def read_query(self):
        return Query(input().split())

    def process_query(self, query):
        if query.type == "check":
            self.write_chain(self.elems[query.ind])
        else:
            hash_key = self._hash_func(query.s)
            if query.type == 'find':
                if self.elems[hash_key] != None and (query.s in self.elems[hash_key]):
                    self.write_search_result(True)
                else:
                    self.write_search_result(False)
            elif query.type == 'add':
                if self.elems[hash_key] == None:
                    self.elems[hash_key] = [query.s]
                else:
                    if query.s not in self.elems[hash_key]:
                        self.elems[hash_key].insert(0, query.s)
            else:
                if self.elems[hash_key] != None and query.s in self.elems[hash_key]:
                    self.elems[hash_key].remove(query.s)
                    if len(self.elems[hash_key]) == 0:
                        self.elems[hash_key] = None

    def process_queries(self):
        n = int(input())
        for i in range(n):
            self.process_query(self.read_query())

if __name__ == '__main__':
    bucket_count = int(input())
    proc = QueryProcessor(bucket_count)
    proc.process_queries()
