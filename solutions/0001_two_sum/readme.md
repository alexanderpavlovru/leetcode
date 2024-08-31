## 1. Two Sum  

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

[https://leetcode.com/problems/two-sum/description/](https://leetcode.com/problems/two-sum/description/)

#### Example 1:

Input: ```nums = [2,7,11,15], target = 9```  
Output: ```[0,1]```  
Explanation: Because ```nums[0] + nums[1] == 9```, we return ```[0, 1]```.

#### Example 2:

Input: ```nums = [3,2,4], target = 6```   
Output: ```[1,2]```

#### Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

<br>

<details>
  <summary>Solution (click to expand)</summary>

1. Создаем хэшмап для хранения значений и их индексов.
2. Проходим по всему массиву, вычисляем число, которое будем искать в мапе: ```n = target - nums[i]``` и смотрим в мапе есть ли такое число.  
3. Если есть, то сравниваем не равны ли они по индексу (что бы не сравнивать один и тот же элемент).
4. Выводим в ответ текущий индекс i и индекс из мапы


</details>