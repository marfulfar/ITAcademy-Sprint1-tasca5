package main;

import main.customObjectSerializable.CustomObjectSerializable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //final String userFolder = "C:\\Users\\marca\\Desktop\\stuff\\";
        final String userSavingFile = "C:\\Users\\marca\\Desktop\\stuff\\SavingFiles.txt";
        final String userReadingFile = "C:\\Users\\marca\\Desktop\\stuff\\ReadingExample.txt";
        final String userSerializationFile = "C:\\Users\\marca\\Desktop\\stuff\\SerializationExample.txt";

//Exercise 1 Uses Path and matchers to retrieve the tree of files and directories recursively
// and stores it in a List of Paths
        List<Path> allFiles =  gettingAllFilesAndFolders(args[0]);

//Exercise 2 Orders and formats and then prints the List according to the exercise
        System.out.println("\n*** Exercise 2 ***");
        ArrayList<String> finalList = orderAndFormatFiles(allFiles);
        for (String line:finalList) {
            System.out.println(line);
        }

//Exercise 3 Saves the list tree in a txt file
        System.out.println("\n*** Exercise 3 ***");
        if (savingListFiles(userSavingFile,finalList)==true){
            System.out.println("Tree directory saved in file!");
        }else{
            System.out.println("Error saving the tree in the file!");
        }

//Exercise 4 Read a txt file and show its contents in teh console
        System.out.println("\n*** Exercise 4 ***");
        readingTextAndPrinting(userReadingFile);

//Exercise 5 Serialization and deserialization of a custom object
        System.out.println("\n*** Exercise 5 ***");
        serialitzationAndDeserialization(userSerializationFile);


    }//closes main


    public static List<Path> gettingAllFilesAndFolders(String userFolder) throws IOException {
        final String pathTemp;
        List<Path> allFiles;
        Path pathToUserFolder = Paths.get(userFolder);

        //Getting all folders paths in the userPathFolder (main folder)
        BiPredicate<Path, BasicFileAttributes> matcherFolder = (path,attributes)-> attributes.isDirectory();
        List myFolders = Files.find(pathToUserFolder,80,matcherFolder).sorted().toList();

        //Getting all the files and folders that have the first folder path in their path name
        pathTemp = myFolders.get(0).toString();
        BiPredicate<Path, BasicFileAttributes> matcherFiles = (path,attributes)-> (String.valueOf(path).contains(pathTemp));

        //final list with all the files and folders we are looking for
        allFiles = Files.find(pathToUserFolder,80,matcherFiles).sorted().toList();

        return allFiles;
    }

    public static boolean savingListFiles(String userPath, ArrayList<String> filesList) throws IOException {
        boolean isSaved=false;
        File savingFile = new File(userPath);
        FileWriter myFileWriter = new FileWriter(savingFile);

        for (String line:filesList) {
            myFileWriter.append(line+"\n");
            isSaved=true;
        }
        myFileWriter.close();

        return isSaved;
    }

    public static ArrayList<String> orderAndFormatFiles(List<Path> orderedFiles) {
        ArrayList<String> finalList = new ArrayList<>();
        for (int i=0; i<orderedFiles.size();i++){
            String nameTemp = orderedFiles.get(i).toString();

            if (nameTemp.contains("txt")){
                finalList.add("File: " +nameTemp);
            }else{
                finalList.add("Directory: "+nameTemp);
            }
        }
        return finalList;
    }

    public static void readingTextAndPrinting(String userReadingFile) throws IOException {
        File myReadingFile = new File(userReadingFile);
        FileReader myFileReader = new FileReader(myReadingFile);
        BufferedReader myBuffer = new BufferedReader(myFileReader);

        while(myBuffer.ready()){
            System.out.println(myBuffer.readLine());
        }
        myBuffer.close();
    }

    public static void serialitzationAndDeserialization(String userSerializationFile) throws IOException, ClassNotFoundException {
        CustomObjectSerializable myObject = new CustomObjectSerializable("Tomb","Raider",33);

        FileOutputStream fileOutStream = new FileOutputStream(userSerializationFile);
        ObjectOutputStream objectOutStream  = new ObjectOutputStream(fileOutStream);

        objectOutStream.writeObject(myObject);
        objectOutStream.flush();
        objectOutStream.close();

        FileInputStream fileInputStream = new FileInputStream(userSerializationFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        CustomObjectSerializable myObject2 = (CustomObjectSerializable) objectInputStream.readObject();
        objectInputStream.close();

        if (myObject.getName().equals (myObject2.getName())){
            System.out.println("Serialization and deserialization successful!");
        }

    }//closes method serialization


}//closes class