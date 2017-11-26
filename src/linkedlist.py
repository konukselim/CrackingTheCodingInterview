class Node :
    def __init__( self, data ) :
        self.data = data
        self.next = None
        self.prev = None

class LinkedList :
    def __init__( self ) :
        self.head = None

    def add( self, data ) :
        node = Node( data )
        if self.head == None :
            self.head = node
        else :
            curr = self.head
            while curr.next:
                curr = curr.next

            curr.next = node
            curr.next.prev = curr

    def search( self, k ) :
        p = self.head
        if p != None :
            while p.next != None :
                if ( p.data == k ) :
                    return p
                p = p.next
            if ( p.data == k ) :
                return p
        return None

    def remove( self, p ) :
        tmp = p.prev
        p.prev.next = p.next
        p.prev = tmp

    def __str__( self ) :
        s = ""
        p = self.head
        if p != None :
            while p.next != None :
                s += " " + str(p.data)
                p = p.next
            s += " " + str(p.data)
        return s