package com.phanduy.gptTunning;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ProcessPriceThread extends Thread {
    private static Logger LOGGER;

    boolean isRunning = true;

    public ProcessPriceThread() {
        LOGGER = Logger.getLogger("ProcessUpdatePriceThread");
    }

    public void stopThread() {
        isRunning = false;
        try {
            interrupt();
        } catch (Exception ex) {

        }
    }

    @Override
    public void run() {
        ArrayList<ATData> listData = ReadData.readData("C:\\Users\\duy.phan\\Downloads\\"+"fine_tunning_data.csv");
        ArrayList<TunningModel> listTunningModel = GenTunningData.genTunningModels(listData);
        GenTunningData.saveToFile(listTunningModel, "tunning.jsonl");
        ArrayList<TunningModel> listValidationModel = GenTunningData.genValidationModels(listData);
        GenTunningData.saveToFile(listValidationModel, "validation.jsonl");
    }
}
