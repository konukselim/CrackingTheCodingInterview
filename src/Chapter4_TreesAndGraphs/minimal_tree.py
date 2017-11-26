class Node(object):
    def __init__(self, item):
        self.item = item
        self.left_child = None
        self.right_child = None
    def __str__(self):
        return str(self.item)


class MinimalTree(object):
    def __init__(self):
        self.root = None

    def create_minimal(self, items):
        if (items):
            mid_item , delim = self.get_mid(items)
            self.place(mid_item)
            self.create_minimal(items[:delim])
            self.create_minimal(items[delim+1:])

    def get_mid(self, items):
        mid_indice = len(items) / 2
        return items[mid_indice], mid_indice

    def place(self, mid_item):
        if not self.root:
            self.root = Node(mid_item)
        else:
            self._place(self.root, mid_item)

    def _place(self, current_node, mid_item):
        if mid_item < current_node.item:
            if current_node.left_child:
                self._place(current_node.left_child, mid_item)
            else:
                current_node.left_child = Node(mid_item)
        else:
            if current_node.right_child:
                self._place(current_node.right_child, mid_item)
            else:
                current_node.right_child = Node(mid_item)

    # this will print the tree in sorted order
    def print_in_order(self):
        print_tree(self.root)


def print_tree(node):
    if node:
        print_tree(node.left_child)
        print node.item
        print_tree(node.right_child)


if __name__== "__main__":
    sorted = [1,2,3,4,5,6,7,8,9,10,11,12,13,15,16]
    m = MinimalTree()
    m.create_minimal(sorted)
    m.print_in_order()