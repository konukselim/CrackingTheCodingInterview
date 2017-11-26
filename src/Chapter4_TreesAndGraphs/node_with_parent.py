class Node:
    def __init__(self, item = None, parent = None):
        self.item = item
        self.parent = parent
        self.left = None
        self.right = None

    def addChildren(self, left =  None, right = None):
        self.left = left
        self.right = right