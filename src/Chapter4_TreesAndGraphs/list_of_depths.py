from linkedlist import LinkedList
from minimal_tree import *

def list_of_depths(tree):
    l = LinkedList()
    l.add(tree.root)
    linkedlists = [l]
    nodes = [tree.root]
    create_linked_list(nodes, linkedlists)
    for ll in linkedlists:
        print ll


def create_linked_list(nodes, linkedlists):
    if nodes:
        childnodes = []
        ll = LinkedList()
        for node in nodes:
            if node.left_child:
                childnodes.append(node.left_child)
                ll.add(node.left_child)
            if node.right_child:
                childnodes.append(node.right_child)
                ll.add(node.right_child)
        linkedlists.append(ll)
        create_linked_list(childnodes, linkedlists)

if __name__ == "__main__":
    sorted = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
    m = MinimalTree()
    m.create_minimal(sorted)
    list_of_depths(m)
