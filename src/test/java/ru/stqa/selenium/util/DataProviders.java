package ru.stqa.selenium.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> dataProviderFirst() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/negativeLoginIncorrectTest.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> DPnegativePasswordIncorret() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/negativePasswordIncorrectTest.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> DPActivityNewList() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/activityAddingNewList.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }



    @DataProvider
    public static Iterator<Object[]> dataProviderSecond() {
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"smth@test.com", "password", "There isn't an account for this email"});
        data.add(new Object[]{"smthtest", "psw2", "There isn't an account for this username"});
        data.add(new Object[]{"","anypssword", "Missing email"});
        data.add(new Object[]{"12345@test.com","","There isn't an account for this email"});

        return data.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataProviderThird() {
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 4; ++i) {
            data.add(new Object[]{this.generateRandomName(),this.generateRandomPassword()});
        }

        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> DPNewCard() {
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 3; ++i) {
            data.add(new Object[]{this.genRandomString(2,8)});
        }

        return data.iterator();
    }


    public String genRandomString(int min,int max) {
        String str = "";
        int length = 0;
        int i = 0;
        int number;
        if (min > max) return "";
        Random gen = new Random();
        length = min + gen.nextInt(max - min +1);
        do {
            number = '0' + gen.nextInt('z' - '0' + 1);
            if ((number < 58 || number > 96 || (number > 64 && number < 91)))
            {
                str = str + (char) number;
                i++;
            }
        }
            while (i < length);

        return str;
    }
    private Object generateRandomName() {

        return "demo" + (new Random()).nextInt()+"@gmail.com";
    }

    private Object generateRandomPassword() {

        return "pass" + (new Random()).nextInt();
    }




}

