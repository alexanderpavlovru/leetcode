## 14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

[https://leetcode.com/problems/longest-common-prefix/description/](https://leetcode.com/problems/longest-common-prefix/description/)

#### Example 1:

Input: ```strs = ["flower","flow","flight"]```
Output: ```fl```

#### Example 2:

Input: ```strs = ["dog","racecar","car"]```
Output: ```"""```
Explanation: There is no common prefix among the input strings.

<br>

<details>
  <summary>Solution (click to expand)</summary>

#### Algorithm:
1. Берем нулевую строку из массива и проходим по всем ее символам
2. Для каждого символа проходим по всем словам и сверяем символ из нулевой строки с символом текущей 
строки на одинаковых позициях.
3. Если символы не равны, значит общего префикса уже быть не может, возвращаем префикс - подстрока от начала до текущего
индекса.
    
#### Time complexity:
O(n * m), where n is the number of strings, m - length of string

#### Space complexity
O(1)

</details>