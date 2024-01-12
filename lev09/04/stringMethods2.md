Let's write a program that converts a file path from Unix style to Windows style. 
Unix uses the / character to separate folders, while Windows uses the \ character.

Solution 1. Using a char array
![image](https://github.com/saram12saram2/JavaKot/assets/133630488/a7a2623b-13c1-46b8-909e-cda0a1895b3e)





Solution 2. Using the split() and join() methods:

![image](https://github.com/saram12saram2/JavaKot/assets/133630488/3a9a23c1-1f6c-4ecd-9f56-3754cff011c8)




Solution 3. Using the replace(char oldChar, char newChar) method:

![image](https://github.com/saram12saram2/JavaKot/assets/133630488/a0fd1bc7-4bce-4737-964f-5b6a5b675e8f)
