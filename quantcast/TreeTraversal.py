#iteratively

# Given a binary tree, return the inorder traversal of its nodes' values.
def inOrderTraversal(root):
	res = []
	stack = []
	while True:
		while root is not None:
			stack.append(root)
			root = root.left
		if not stack:
			return res
		node = stack.pop()
		res.append(node.val)
		root = node.right

# Given a binary tree, return the preorder traversal of its nodes' values.
def preOrderTraversal(root):
	res = []
	stack = []
	stack.append(root)
	while stack:
		node = stack.pop()
		if node is not None:
			res.append(node.val)
			stack.append(node.right)
			stack.append(node.left)
	return res

# Given a binary tree, return the postorder traversal of its nodes' values.
def postOrderTraversal(root):
	res = []
	stack = []
	stack.append(root)
	while stack:
		node = stack.pop()
		if node is not None:
			res.append(node.val)
			stack.append(node.left)
			stack.append(node.right)
	return res[::-1]


# recursively

# Given a binary tree, return the inorder traversal of its nodes' values.
def inOrderTraversal(root):
	res = []
	self.helper(root, res)
	return res

def helper(root, res):
	if root is not None:
		self.helper(root.left, res)
		res.append(root.val)
		self.helper(root.right, res)

# Given a binary tree, return the preorder traversal of its nodes' values.

def preOrderTraversal(root):
	res = []
	self.helper(root, res)
	return res

def helper(root, res):
	if root is not None:
		res.append(root.val)
		self.helper(root.left, res)
		self.helper(root.right, res)

# Given a binary tree, return the postorder traversal of its nodes' values.

def postOrderTraversal(root):
	res = []
	# if not root:
		# return res
	self.helper(root, res)
	return res

def helper(root, res):
	if root is not None:
		self.helper(root.left, res)
		self.helper(root.right, res)
		res.append(root.val)
