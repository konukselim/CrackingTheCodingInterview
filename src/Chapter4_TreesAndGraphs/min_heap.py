class MinHeap:
    def __init__(self):
        self.heapList = [0]
        self.size = 0

    def hasChild(self, i):
        if (self.size >= i*2):
            return True
        return False

    def minChild(self, i):
        if (self.size == i*2):
            return i*2
        else:
            if (self.heapList[i*2] < self.heapList[i*2 +1]):
                return i*2
            return i*2 +1

    def percolateUp(self, i):
        while (i > 1):
            if (self.heapList[i/2] > self.heapList[i]):
                self.heapList[i/2] , self.heapList[i] = self.heapList[i] , self.heapList[i/2]
            else:
                break
            i = i/2

    def percolateDown(self, i):
        while (self.hasChild(i)):
            mc = self.minChild(i)
            if (self.heapList[i] > self.heapList[mc]):
                self.heapList[i] , self.heapList[mc] = self.heapList[mc] , self.heapList[i]
                i = mc

    def insert(self, elem):
        self.heapList.append(elem)
        self.size += 1
        self.percolateUp(self.size)

    def extractMin(self):
        if (self.size != 0):
            minElement = self.heapList[1]
            self.heapList[1] = self.heapList[self.size]
            self.size -= 1
            self.heapList.pop()
            self.percolateDown(1)
            return minElement

mh = MinHeap()
mh.insert(5)
mh.insert(3)
mh.insert(6)
mh.insert(2)
mh.insert(12)
mh.insert(7)
mh.extractMin()
print mh.heapList