package com.phanduy.gptTunning;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ReadData {

    private static Logger LOGGER;

    public static ArrayList<ATData> readData(String fileName) {
        BufferedReader br = null;
        FileInputStream fileInputStream = null;
        InputStreamReader clientSecretReader = null;
        ArrayList<ATData> listData = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(fileName);
            clientSecretReader = new InputStreamReader(fileInputStream);
            br = new BufferedReader(clientSecretReader);

            String st;
            while ((st = br.readLine()) != null) {
                if (!st.isEmpty()) {
//                    Pattern pattern = Pattern.compile("^[A-Za-z0-9., ]+");
//                    st = st.trim().replaceAll("[^A-Za-z0-9.,: ]+", "");
                    String[] parts = st.trim().split(Pattern.quote(","));
                    if (parts.length > 0) {
                        if (!parts[0].toLowerCase().equals("screen id")) {
                            ATData atData = new ATData();
                            atData.screenId = parts[0];
                            atData.japaneseDes = parts[1];
                            atData.vietnameseDes = parts[2];
                            listData.add(atData);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("" + ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (clientSecretReader != null) {
                try {
                    clientSecretReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReadData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listData;
    }
}
