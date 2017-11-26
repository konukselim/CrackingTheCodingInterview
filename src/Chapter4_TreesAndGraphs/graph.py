from collections import deque

class Graph(object):
    def __init__(self, nodes):
        self.nodes = {}
        for node in nodes:
            if not node[0] in self.nodes:
                self.nodes[node[0]] = []

            for n in node[1]:
                if not n in self.nodes:
                    self.nodes[n] = []
                self.nodes[node[0]].append(n)

    def addEdge(self, node1, node2):
        if not node2 in self.nodes:
            self.nodes[node2] = []
        
        if not node1 in self.nodes:
            self.nodes[node1] = [node2]

        elif not node2 in self.nodes[node1]:
            self.nodes[node1].append(node2)

    def search(self, queue, node):
        while queue:
            poppedItem = queue.popleft()
            for child in self.nodes[poppedItem]:
                if node == child:
                    return True
                if not child in queue:
                    queue.append(child)

        return False

    def routeBetweenNodes(self, node1, node2):
        if node1 == node2:
            return True
        
        queue = deque([node1])
        return self.search(queue, node2)
    
    def printGraph(self):
        for key in self.nodes:
            print key, self.nodes[key]
    
g = Graph([(1, {2,9}) , (2, {3,6}) , (9, {5}) , (3, {6,7}) , (4, {9,11}) , (7, {10,11})])
print g.routeBetweenNodes(2,10)
# g.printGraph()