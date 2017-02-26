    def containsDuplicate(nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        
        list = []
        dic = {}
        for i, n in enumerate(nums):
            dic[n] = dic.get(n,0) + 1
            if dic[n] == k:
                for m in range(len(nums)):
                    if nums[m] == n:
                        list.append(m)
        return list
    
    
    
# O(n)  

    def containsDuplicate(s, k):
        dic = defaultdict(list)
        list = []
        
    # set every character as key in dictionary
    # then add a list to every key containing the corresponding indexes   
    
        for i, val in enumerate(s):
            dic[val].append(i)
            
    # check if the length of every list is greater than k 
    # if is, add every index of the list to our outcome list
    
        for key in dic.keys():
            if len(dic[key]) >= k:
                for num in dic[key]:
                    list.append(num)
        return list
        
        
        
        
