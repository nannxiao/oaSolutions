# a function to count the number of leaves in a given BST:
def countLeaves(root):
    if root is None:
        return 0
    elif root.left is None and root.right is None:
        return 1
    elif root.left is None:
        return self.countLeaves(root.right)
    elif root.right is None:
        return self.countLeaves(root.left)
    else:
        return self.countLeaves(root.left) + self.countLeaves(root.right)
   
# a function to return the sum of all leaves depth in the given BST:
def 
        






