func combinationSum2(candidates []int, target int) [][]int {
	var res [][]int
	sort.Ints(candidates)
	backtrack(candidates, target, 0, []int{}, &res)
	return res
}

func backtrack(candidates []int, target, start int, current []int, res *[][]int) {
	if target == 0 {
		// Make a copy of current as it will be modified
		temp := make([]int, len(current))
		copy(temp, current)
		*res = append(*res, temp)
		return
	}

	for i := start; i < len(candidates); i++ {
		// Skip duplicates
		if i > start && candidates[i] == candidates[i-1] {
			continue
		}
		// Break if the current candidate exceeds the target
		if candidates[i] > target {
			break
		}
		// Include the current candidate and proceed
		current = append(current, candidates[i])
		backtrack(candidates, target-candidates[i], i+1, current, res)
		// Exclude the current candidate and backtrack
		current = current[:len(current)-1]
	}
}


/*
func main() {
	candidates1 := []int{10, 1, 2, 7, 6, 1, 5}
	target1 := 8
	fmt.Println(combinationSum2(candidates1, target1))

	candidates2 := []int{2, 5, 2, 1, 2}
	target2 := 5
	fmt.Println(combinationSum2(candidates2, target2))
}
*/
