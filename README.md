# ITAcademy-Sprint1-tasca5

Instructions to run the java application:

In the folder out/artifacts we created a jar file to be able to run it.

In terminal or cmd locate the folder where the jar is located. 
In my case: C:/Users/marca/IdeaProjects/Sprint1-tasca5-nivell1-ex1/out/artifacts/Sprint1-tasca5-nivell1-ex1.jar/Sprint1-tasca5-nivell1-ex1.jar

To traverse throw the levels use the command: 'cd' and the tab key for autofill function or type the next folder. 
If you don't remember the folder you can use the command: 'dir' to see a list of subfolders.
You can also use the command: "cd.." to go back one level in the folders tree.

When you are in the right folder (Sprint1-tasca5-nivell1-ex1.jar) then type the command: 'java -jar Sprint1-tasca5-nivell1-ex1.jar'
If your jdk and jre versions match, the program will run printing all the answers to every exercise. You should see something like this:

PS C:\> java -jar C:\Users\marca\IdeaProjects\sprint1\tasca5\Sprint1-tasca5-nivell1-[ex1-ex5]\out\artifacts\Sprint1_tasca5_nivell1_ex1_jar\Sprint1-tasca5-nivell1-ex1.jar [C:\\Users\\marca\\Desktop\\stuff\\]


    *** Exercise 2 ***
    Directory: C:\Users\marca\Desktop\stuff
    File: C:\Users\marca\Desktop\stuff\instruccions.txt
    Directory: C:\Users\marca\Desktop\stuff\level0
    File: C:\Users\marca\Desktop\stuff\level0A.txt
    File: C:\Users\marca\Desktop\stuff\level0B.txt
    File: C:\Users\marca\Desktop\stuff\level0C.txt
    Directory: C:\Users\marca\Desktop\stuff\level0\level1
    File: C:\Users\marca\Desktop\stuff\level0\level1A.txt
    File: C:\Users\marca\Desktop\stuff\level0\level1B.txt
    File: C:\Users\marca\Desktop\stuff\level0\level1\level2A.txt
    File: C:\Users\marca\Desktop\stuff\ReadingExample.txt
    File: C:\Users\marca\Desktop\stuff\SavingFiles.txt
    File: C:\Users\marca\Desktop\stuff\SerializationExample.txt

    *** Exercise 3 ***
    Tree directory saved in file!

    *** Exercise 4 ***
    Hi!
    I am just a single text file serving as an example for the reading a text and printing it in the console exercise!
    Glad to serve you;
    Bye!

    *** Exercise 5 ***
    Serialization and deserialization successful!


IMPORTANT: In order for the application to work, the Strings in the beginning should be adapted to indicate the user desired folder the application 
will traverse and also create the text files.
The 'stuff' folder should be created in advanced or else an error will jump for not having enough permission to create a folder in the desktop.
The txt files created by the app will be created in this 'stuff' folder.
