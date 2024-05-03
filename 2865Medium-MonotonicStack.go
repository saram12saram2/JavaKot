// My solution to
// 2865. Beautiful Towers I
// using Monotonic stack

func maximumSumOfHeights(heights []int) int64 {
	n := len(heights)
	left := make([]int, n)
	right := make([]int, n)
	f := make([]int64, n)
	g := make([]int64, n)

	// left stack 
	stack1 := []int{}
	for i, height := range heights {
		for len(stack1) > 0 && heights[stack1[len(stack1)-1]] > height {
			stack1 = stack1[:len(stack1)-1]
		}
		if len(stack1) > 0 {
			left[i] = stack1[len(stack1)-1]
		} else {
			left[i] = -1
		}
		stack1 = append(stack1, i)
	}

	// right limits
	stack2 := []int{}
	for i := n - 1; i >= 0; i-- {
		height := heights[i]
		for len(stack2) > 0 && heights[stack2[len(stack2)-1]] >= height {
			stack2 = stack2[:len(stack2)-1]
		}
		if len(stack2) > 0 {
			right[i] = stack2[len(stack2)-1]
		} else {
			right[i] = n
		}
		stack2 = append(stack2, i)
	}

	// f array
	for i, height := range heights {
		if i > 0 && height >= heights[i-1] {
			f[i] = f[i-1] + int64(height)
		} else {
			j := left[i]
			if j != -1 {
				f[i] = int64(height)*(int64(i-j)) + f[j]
			} else {
				f[i] = int64(height) * int64(i+1)
			}
		}
	}

	// g array
	for i := n - 1; i >= 0; i-- {
		height := heights[i]
		if i < n-1 && height >= heights[i+1] {
			g[i] = g[i+1] + int64(height)
		} else {
			j := right[i]
			if j != n {
				g[i] = int64(height)*(int64(j-i)) + g[j]
			} else {
				g[i] = int64(height) * int64(n-i)
			}
		}
	}

	// max sum
	maxSum := int64(0)
	for i, height := range heights {
		maxSum = max(maxSum, f[i]+g[i]-int64(height))
	}

	return maxSum
}

func max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}
