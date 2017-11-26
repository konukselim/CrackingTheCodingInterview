def check_subtree(tree1, tree2):
    if not tree2:
        return True
    return is_subtree(tree1.root, tree2.root)

def is_subtree(n1, n2):
    if not n1:
        return False
    elif n1.item == n2.item and match_tree(n1, n2):
        return True
    return is_subtree(n1.left, n2) and is_subtree(n1.right, n2)

def match_tree(n1,n2):
    if not n1 and not n2:
        return True
    elif not n1 or not n2:
        return False
    elif n1.item != n2.item:
        return False
    else:
        return match_tree(n1.left, n2.left) and match_tree(n1.right, n2.right)


