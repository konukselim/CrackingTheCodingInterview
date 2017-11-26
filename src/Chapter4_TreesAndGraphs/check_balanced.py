WRONG = -100
from create_tree import *

def get_height(node):
    if not node:
        return -1

    left_height = get_height(node.left)
    if left_height == WRONG:
        return WRONG

    right_height = get_height(node.right)
    if right_height == WRONG:
        return WRONG

    if abs(left_height- right_height) > 1:
        return WRONG
    else:
        return max(left_height, right_height) + 1

def check_balanced(tree):
    tree_height = get_height(tree.root)
    return tree_height != WRONG

t = Tree([1, [2, [4,5,'-'],'-'], [3,[6,'-',7], '-']])
print check_balanced(t)
t2 = Tree([1, [2, [4,5,'-'],8], [3,[6,'-',7], 9]])
print check_balanced(t2)