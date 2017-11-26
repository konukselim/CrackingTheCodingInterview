class Node:
    def __init__(self, item):
        self.item = item
        self.children = []

    def addChild(self, child):
        self.children.append(child)
    
    def addChildren(self, children):
        for child in children:
            self.children.append(child)
