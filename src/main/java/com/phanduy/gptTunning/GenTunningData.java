package com.phanduy.gptTunning;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenTunningData {
    public static ArrayList<TunningModel> genTunningModels(ArrayList<ATData> listData) {
        ArrayList<TunningModel> listModels = new ArrayList<>();
        for (ATData atData: listData) {
            for (int i = 0, size = TunningMessage.listTunningQuestions.length; i < size; i++) {
                TunningModel tunningModel = new TunningModel();
                tunningModel.genTunningMessage(atData, i);
                listModels.add(tunningModel);
            }
        }
        return listModels;
    }

    public static void saveToFile(ArrayList<TunningModel> listTunningModel, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            for (TunningModel tunningModel: listTunningModel) {
                writer.append(gson.toJson(tunningModel));
                writer.append("\n"); // Xuống dòng sau mỗi chuỗi
            }
            System.out.println("Save done!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<TunningModel> genValidationModels(ArrayList<ATData> listData) {
        ArrayList<TunningModel> listModels = new ArrayList<>();
        for (ATData atData: listData) {
            for (int i = 0, size = TunningMessage.listValidationQuestions.length; i < size; i++) {
                TunningModel tunningModel = new TunningModel();
                tunningModel.genValidateMessage(atData, i);
                listModels.add(tunningModel);
            }
        }
        return listModels;
    }
}
