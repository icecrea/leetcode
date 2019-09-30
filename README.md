刷题笔记
=================================

## 剑指offer: 
 
> 1.二维数组查找  
2.替换空格  
3.打印链表  
4.给某二叉树的前序遍历和中序遍历的结果，重建二叉树  
5.用两个栈实现队列  
6.旋转数组的最小数字  
7.斐波那契数列  
8.青蛙跳台阶  
9.变态跳台阶  
10.矩形覆盖  
11.二进制中1的个数  
12.给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方  
13.调整数组顺序使奇数位于偶数前面  
14.链表中倒数第k个节点  
15.反转链表  
16.树的子结构  
17.二叉树的镜像  
18.顺时针打印矩阵  
19.包含Min的栈  
20.栈的压入、弹出序列  
21.从上往下打印二叉树  
22.二叉树的后续遍历列表  
23.二叉树中和为某一值的路径  
24.复杂链表的复制  
25.二叉搜索树转换成一个排序的双向链表  
26.字符串排列  
27.数组中超过一半的数字  
28.最小的K个数  
29.连续子数组最大和  
30.数组中1出现的次数  
31.把数组排成最小的数  
32.丑数 只包含质因子2、3和5的数称作丑数，求按从小到大的顺序的第N个丑数  
33.第一个只出现一次的字符  
34.数组中的逆序对  
35.两个链表的第一个公共节点  
36.数字在排序数组中出现的次数  
37.二叉树树的深度  
38.是否平衡二叉树  
39.数组中两个只出现一次的数字  
40.数组中两个只出现一次的数字  
41.和为S的连续正数序列  
42.左旋转字符串  
43.反转单词序列  
44.扑克牌顺子  
45.圆圈中最后剩下的数  
46.求1+2+3+...+n  
47.字符串转整数  
48.数组中重复的数字  
49.不用除法构建乘积数组  
50.正则表达式匹配  

## 程序员代码面试指南 : 

### chapter2 : 链表部分题目：
> 01.打印两个有续链表公共部分  
02.在单链表和双链表中删除倒数第K个节点  
03.删除链表中间节点和a/b节点  
04.反转链表  
05.反转部分链表  
06.约瑟夫环问题-链表解法  
07.判断链表是否回文结构  
08.将单向链表按某值划分成左边小、中间相等、右边大的形式  
09.复制含有随机指针节点的链表  
10.两个单链表生成相加链表  
11.两个链表相交的第一个节点
12.将单链表每K个节点之间逆序  
13.删除无序单链表中值重复出现的节点  
14.在单链表中删除指定值的节点  
15.将搜索二叉树转换成双向链表  
16.单链表的选择排序  
17.怪异的删除方式  
18.单链表的选择排序  
19.合并两个有序的单链表  
20.按照左右半区的方式重新组合单链表  

## Leetcode: 

#### 链表问题 ：
##### 简单：
> 21.将两个有序链表合并为一个新的有序链表并返回  
83.删除链表重复元素  
141.判断链表中是否有环  
160.找到两个单链表相交的起始节点  
203.移除链表元素  
206.反转链表  
234.回文链表  
237.删除链表中的节点  
876.链表中间节点  

##### 中等：
> 2.两个链表用来表示两个非负的整数。逆序存储，将两个数相加起来，返回新链表  
19.删除链表的倒数第n个节点  
24.两两交换链表中的节点  
61.旋转链表  
82.删除链表重复元素2  
92.反转链表2  
109.有序链表转换二叉搜索树(undo)    
138.复制带随机指针的链表    
142.环形链表2  
143.重排链表  
147.对链表进行插入排序  
148.排序链表  
328.奇偶链表  
445.两数相加2  
725.分隔链表  

#### 排序问题 ：

> 56.合并区间     
57.插入区间     
75.颜色分类    
147.链表插入排序    
148.排序链表    
164.最大间距    
215.数组中第K个最大元素    
274.H指数    
324.摆动排序2    
349.两个数组交集    
524.通过删除字母匹配到字典里最长单词    
767.重构字符串,两相邻的字符不同    
922.按奇偶排序数组2    
969.煎饼排序  
973.最接近原点的K个点   
976.三角形最大周长   





#### 基础排序算法：
> 1.冒泡排序： 原地排序，稳定排序（相邻元素大小相等时不交换），最好O(N),最坏O(N^2),平均O(N^2)  
2.插入排序： 原地排序，稳定排序（可以将后面出现的元素，插入到前面出现元素的后面），最好O(N),最坏O(N^2),平均O(N^2)
3.选择排序： 原地排序，不稳定排序（每次查找剩余未排序元素最小值和前面元素交换位置，破坏稳定性），最好、最坏、平均O(N^2)  
4.归并排序： 非原地排序(空间O(N))，稳定排序（子数组合并时候，将p~q的放前面,q+1~r放后面），最好、最坏、平均O(NLog(N))  
5.快速排序： 原地排序，稳定排序（子数组合并时候，将p~q的放前面,q+1~r放后面），最好O(NLog(N))、最坏O(N^2、平均O(NLog(N)) 