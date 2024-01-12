![image](https://github.com/saram12saram2/JavaKot/assets/133630488/519f2e78-99fa-46ef-893c-4cb50fd85a5e)



Unicode encoding

"You already know that each character displayed on the screen corresponds to a specific numerical code. A standardized set of these codes is called an encoding.

"Once upon a time, when computers were newly invented, seven bits (less than one byte) were enough to encode every character. The first encoding contained only 128 characters. This encoding was called ASCII."

"That's a strange name."

"There's nothing strange about it. It's an abbreviation. ASCII stands for American Standard Code for Information Interchange — a standard American code table for printable characters and some special codes."

"It consists of 33 non-printable control characters (which affect how text and spaces are processed) and 95 printable characters, including numbers, uppercase and lowercase Latin letters, and several punctuation marks.

![image](https://github.com/saram12saram2/JavaKot/assets/133630488/268124bf-d71d-4b05-84e6-b6de5e907b21)

"As computers grew in popularity, each country began to release its own encoding. Usually, they took ASCII as a starting point and replaced rarely used ASCII characters with symbols from their respective alphabets.

"Over time, an idea emerged: create a single encoding that contains all the characters of every encoding in the world.
![image](https://github.com/saram12saram2/JavaKot/assets/133630488/8dc25444-bbf9-4c0b-8403-33e1431fcf8d)

"Thus, in 1993, the Unicode encoding was created, and the Java language became the first programming language that used this encoding as the standard for storing text. Now Unicode is the standard for the entire IT industry.

"Although Unicode itself is the standard, it has several representations or Unicode transformation formats (UTF): UTF-8, UTF-16 and UTF-32, etc.

"Java uses an advanced version of Unicode encoding — UTF-16: each character is encoded in 16 bits (2 bytes). It can accommodate up to 65,536 characters! You can find almost every character of every alphabets in the world in this encoding."
