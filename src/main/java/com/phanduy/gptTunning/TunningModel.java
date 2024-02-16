package com.phanduy.gptTunning;

import java.util.ArrayList;

public class TunningModel {
    public ArrayList<TunningMessage> messages;

    public void genTunningMessage(ATData atData, int index) {
        messages = new ArrayList<>();
        messages.add(TunningMessage.buildTunningUserMessage(atData, index));
        messages.add(TunningMessage.buildTunningAssistantMessage(atData));
    }

    public void genValidateMessage(ATData atData, int index) {
        messages = new ArrayList<>();
        messages.add(TunningMessage.buildValidateUserMessage(atData, index));
        messages.add(TunningMessage.buildValidateAssistantMessage(atData));
    }
}
