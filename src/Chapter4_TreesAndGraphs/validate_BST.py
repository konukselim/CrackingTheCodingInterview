from create_tree import *
val = None

def validate(tree):
    return in_order_traverse(tree.root, True)

def in_order_traverse(node, is_valid):
    if not is_valid:
        return False
    if node:
        in_order_traverse(node.left, is_valid)
        is_valid = visit(node)
        in_order_traverse(node.right, is_valid)
    return is_valid

def visit(node):
    global val
    if val:
        if node.item >= val:
            val = node.item
            return True
        return False
    else:
        val = node.item
        return True

t = Tree([1, [2, [4,5,'-'],'-'], [3,[6,'-',7], '-']])
print validate(t)
t2 = Tree([5, [3, [2,1,'-'],'-'], [8,[6,'-',7], '-']])
print validate(t2)