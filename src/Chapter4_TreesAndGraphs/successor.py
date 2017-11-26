from node_with_parent import *

def successor(node):
    if node.right:
        return find_left_most(node.right)

    elif node.parent:
        if node.parent.left == node:
            return node.parent
        else:
            return find_first_left_parent(node.parent)

    else:
        return None

def find_left_most(node):
    while(node.left):
        node = node.left
    return node

def find_first_left_parent(node):
    if not node.parent:
        return None
    if node == node.parent.left:
        return node.parent
    else:
        return find_first_left_parent(node.parent)