# a function to count the number of leaves in a given BST:
def countLeaves(root):
    # return 0 when the node was null:
    if root is None:
        return 0
    # return 1 when the node was a leaf:
    elif root.left is None and root.right is None:
        return 1
    # recursively call the function with the child that exists:
    elif root.left is None:
        return self.countLeaves(root.right)
    elif root.right is None:
        return self.countLeaves(root.left)
    else:
        return self.countLeaves(root.left) + self.countLeaves(root.right)
   
# a function to return the sum of all leaves depth in the given BST:
# add an extra parameter d to count the leave's depths
def sumLeavesDepth(root, d):
    if root is None:
        return 0
    elif root.left is None and root.right is None:
        return d + 1
    elif root.left is None:
        return self.sumLeavesDepth(root, d+1)
    elif root.right is None:
        return self.sumLeavesDepth(root, d+1)
    
    return self.sumLeavesDepth(root.left) + self.sumLeavesDepth(root.right)
        
def averageLeavesDepth(root):
    print "the average depth of all leaves is:", sumLeavesDepth(root, 0)/countLeaves(root)





