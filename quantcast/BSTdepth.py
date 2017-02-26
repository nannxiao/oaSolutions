





# interactive
# a binary tree node
class Node:
    def _init_(self, key):
        self.key = key
        self.left = None
        self.right = None

# a function to check if a given node is leaf or not:
def isLeaf(node):
    if node is None:
        return False
    if node.left is None and node.right is None:
        return True
    return False

# a function to return sum of all leaves in a given binary tree:
def leavesSum(root):
    # initialize result
    res = 0
    
    # update result if root is not None
    if root is not None:
        
        if isLeaf(root.left) and isLeaf(root.right):
            res+=root.left.key
            res+=root.right.key
        elif isLeaf(root.left):
            res+=root.left.key
        elif isLeaf(root.right):
            res+=root.right.key
        else:
            res+=LeavesSum(root.left)
        
        res+=LeavesSum(root.right)
    
