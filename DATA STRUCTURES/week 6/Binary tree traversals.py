# python3

import sys
import threading

sys.setrecursionlimit(10 ** 6)  # max depth of recursion
threading.stack_size(2 ** 27)  # new thread will get stack of such size


class TreeOrders:
    """Binary tree traversals.
    Builds and outputs in-order, pre-order and post-order traversals of
    a rooted binary tree.
    Samples:
    >>> tree = TreeOrders()
    >>> tree.key = [4, 2, 5, 1, 3]
    >>> tree.left = [1, 3, -1, -1, -1]
    >>> tree.right = [2, 4, -1, -1, -1]
    >>> [x for x in tree.in_order()]
    [1, 2, 3, 4, 5]
    >>> [x for x in tree.pre_order()]
    [4, 2, 1, 3, 5]
    >>> [x for x in tree.post_order()]
    [1, 3, 2, 5, 4]
    >>> # Explanation:
    >>> #
    >>> #       root
    >>> #         4
    >>> #        / \
    >>> #       2   5
    >>> #      / \
    >>> #     1   3
    """

    def read(self):
        self.n = int(sys.stdin.readline())
        self.key = [0 for _ in range(self.n)]
        self.left = [0 for _ in range(self.n)]
        self.right = [0 for _ in range(self.n)]
        for i in range(self.n):
            self.key[i], self.left[i], self.right[i] = map(
                int, sys.stdin.readline().split()
            )

    def in_order(self):
        """In-order tree traversal."""
        current_id = 0
        stack = []

        while True:
            if current_id != -1:
                stack.append(current_id)
                current_id = self.left[current_id]
            elif stack:
                current_id = stack.pop()
                yield self.key[current_id]
                current_id = self.right[current_id]
            else:
                break

    def pre_order(self):
        """Pre-order tree traversal."""
        current_id = 0
        stack = []

        while True:
            if current_id != -1:
                yield self.key[current_id]
                stack.append(current_id)
                current_id = self.left[current_id]
            elif stack:
                current_id = stack.pop()
                current_id = self.right[current_id]
            else:
                break

    def post_order(self):
        """Post-order tree traversal."""
        # Create two stacks and push root's index to the first one.
        stack1 = [0]
        stack2 = []

        while stack1:
            current_id = stack1.pop()
            stack2.append(self.key[current_id])

            left_id = self.left[current_id]
            right_id = self.right[current_id]
            if left_id != -1:
                stack1.append(left_id)
            if right_id != -1:
                stack1.append(right_id)

        while stack2:
            yield stack2.pop()


def main():
    tree = TreeOrders()
    tree.read()
    print(" ".join(str(x) for x in tree.in_order()))
    print(" ".join(str(x) for x in tree.pre_order()))
    print(" ".join(str(x) for x in tree.post_order()))


threading.Thread(target=main).start()
