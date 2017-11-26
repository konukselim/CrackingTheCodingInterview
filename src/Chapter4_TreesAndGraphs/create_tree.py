# [] will use for the nodes that have subtree(s)
# '-' will use for the null leaf nodes
class Node:
    def __init__(self, item = None):
        self.item = item
        self.left = None
        self.right = None

class Tree(object):
    def __init__(self, notation):
        self.root = Node()
        self.create_tree(notation, self.root);

    def create_tree(self, notation, current_node):
        current_node.item = notation[0]
        if type(notation[1]) == list:
            current_node.left = Node()
            self.create_tree(notation[1] , current_node.left)
        else:
            if notation[1] != '-':
                current_node.left = Node(notation[1])

        if type(notation[2]) == list:
            current_node.right = Node()
            self.create_tree(notation[2], current_node.right)
        else:
            if notation[2] != '-':
                current_node.right = Node(notation[2])

    def print_tree(self):
        self.print_pre_order(self.root)

    def print_in_order(self, node):
        if node:
            self.print_in_order(node.left)
            print node.item
            self.print_in_order(node.right)
