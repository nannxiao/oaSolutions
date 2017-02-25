    def containsDuplicate(self, nums, k):
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
