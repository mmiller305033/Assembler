/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mark Miller
 */
public class Assembler {

    static ArrayList<String[]> tokenizedSource = new ArrayList<>();
    static SYMTABLE symbols = new SYMTABLE();
    static OPTABLE op = new OPTABLE();
    static int LOCCTR;
    static int PC;
    static int StartingAddress;
    static int ProgramLength;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        tokenizeSourceFile();
        pass1();
        symbols.printSYMTABLE();
//        for (int i = 0; i < tokenizedSource.size(); i++) {
//
//            System.out.println(Arrays.toString(tokenizedSource.get(i)));
//        }
    }

    public static void pass1() throws IOException {
        if (tokenizedSource.get(0)[1].equals("START")) {
            LOCCTR = Integer.parseInt(tokenizedSource.get(0)[2]);
            StartingAddress = Integer.parseInt(tokenizedSource.get(0)[2]);
            
        } else {
            LOCCTR = 0;
            StartingAddress = 0;
        }
        int i = 0;
        while (i < tokenizedSource.size()) {
            if (!(tokenizedSource.get(i)[0].equals("")) && !(tokenizedSource.get(i)[0].equals(" "))) {
                if (symbols.getSymbol(tokenizedSource.get(i)[0]) != null) {
                    System.out.println("Duplicate Symbol");
                   
                } else {
                    symbols.addSymbol(tokenizedSource.get(i)[0], Integer.toString(LOCCTR));
                }
            }
            if(op.isOPCode(tokenizedSource.get(i)[1])){
                LOCCTR += 3;
            }
            else if(tokenizedSource.get(i)[1].equals("WORD")){
                LOCCTR += 3;
            }
            else if(tokenizedSource.get(i)[1].equals("RESW")){
                LOCCTR += (3*Integer.parseInt(tokenizedSource.get(i)[2]));
            }
            else if(tokenizedSource.get(i)[1].equals("RESB")){
                LOCCTR += Integer.parseInt(tokenizedSource.get(i)[2]);
            }
            else if(tokenizedSource.get(i)[1].equals("BYTE")){
                //ADD LATER
            }
            else{
                System.out.println("Invalid OP Code");
            }
            ProgramLength = LOCCTR - StartingAddress;
            i++;
        }
    }

    public static void pass2() {

    }

    public static void tokenizeSourceFile() throws FileNotFoundException, IOException {
        FileInputStream fstream = new FileInputStream("C:\\Users\\Mark Miller\\Downloads\\control_section.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] split = new String[3];
                strLine = removeComments(strLine);
                strLine = formatOperands(strLine);
                strLine = strLine.trim();
                strLine = formatLine(strLine);
                split = strLine.split("/");
                if (split.length != 1) {
                    tokenizedSource.add(split);
                }

            }
        }

    }

    public static String removeComments(String line) {
        String newLine = "";
        for (int i = 0; i < line.length(); i++) {
            if (!(line.substring(i, i + 1).equals("."))) {
                newLine += line.substring(i, i + 1);
            } else {
                break;
            }
        }
        return newLine;
    }

    public static String formatOperands(String line) {
        if (!(line.equals(""))) {
            String newLine = line.substring(0, 1);
            for (int i = 1; i < line.length() - 1; i++) {
                if (line.substring(i, i + 1).equals(" ") && line.substring(i - 1, i).equals(",")) {

                } else {
                    newLine += line.substring(i, i + 1);
                }
            }
            newLine += line.substring(line.length() - 1, line.length());
            return newLine;
        }
        return "";
    }

    public static int countTokens(String line) {
        String trim = line.trim();
        if (trim.isEmpty()) {
            return 0;
        }
        return trim.split("\\s+").length;
    }

    public static String formatLine(String line) {
        String newLine = "";
        switch (countTokens(line)) {
            case 1:
                newLine = " /" + line + "/ ";
                break;
            case 2:
                newLine += "/";
                for (int i = 0; i < line.length(); i++) {
                    if ((line.substring(i, i + 1).equals(" ")) || (line.substring(i, i + 1).equals("\t"))) {
                        newLine += "/";
                    } else {
                        newLine += line.substring(i, i + 1);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < line.length(); i++) {
                    if ((line.substring(i, i + 1).equals(" ")) || (line.substring(i, i + 1).equals("\t"))) {
                        newLine += "/";
                    } else {
                        newLine += line.substring(i, i + 1);
                    }
                }
                break;
        }
        return newLine;
    }
}
