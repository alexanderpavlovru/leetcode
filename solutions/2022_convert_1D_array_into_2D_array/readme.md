## 2022. Convert 1D Array Into 2D Array

[https://leetcode.com/problems/convert-1d-array-into-2d-array/](https://leetcode.com/problems/convert-1d-array-into-2d-array/)

<details>
  <summary>Solution (click to expand)</summary>

#### Algorithm:
1. Outer loop - i rows in array.
2. Inner loop - j indexes from 0 to n. 
3. Write value into 2D array i,j, the value from the original array with offset i * n + j

#### Time complexity:
O(m * n), m - outer loop, n - inner loop
#### Space complexity
O(1), no any additional space

</details>