package com.phanduy.gptTunning;

public class TunningMessage {
    public static final String ROLE_USER = "user";
    public static final String ROLE_ASSISTANT = "assistant";

    public static final String[] listTunningQuestions = new String[] {
            "What is ",
            "Describe the ",
            "Can you tell me about the ",
            "What is the function of the ",
            "Explain the ",
            "Detail the ",
            "Tell me about the ",
            "What is the purpose of the "
    };
    public static final String[] listValidationQuestions = new String[] {
            "Can you explain about the ",
    };

    public String role;
    public String content;

    public static TunningMessage buildTunningUserMessage(ATData atData, int index) {
        TunningMessage tunningMessage = new TunningMessage();
        tunningMessage.role = ROLE_USER;
        int questionIndex = index >= 0 && index < listTunningQuestions.length ? index : 0;
        tunningMessage.content = listTunningQuestions[questionIndex] + atData.screenId + " screen ?";
        return tunningMessage;
    }

    public static TunningMessage buildTunningAssistantMessage(ATData atData) {
        TunningMessage tunningMessage = new TunningMessage();
        tunningMessage.role = ROLE_ASSISTANT;
        tunningMessage.content = "The " + atData.screenId + " screen is " + atData.japaneseDes;
        return tunningMessage;
    }

    public static TunningMessage buildValidateUserMessage(ATData atData, int index) {
        TunningMessage tunningMessage = new TunningMessage();
        tunningMessage.role = ROLE_USER;
        int questionIndex = index >= 0 && index < listValidationQuestions.length ? index : 0;
        tunningMessage.content = listValidationQuestions[questionIndex] + atData.screenId + " screen ?";
        return tunningMessage;
    }

    public static TunningMessage buildValidateAssistantMessage(ATData atData) {
        TunningMessage tunningMessage = new TunningMessage();
        tunningMessage.role = ROLE_ASSISTANT;
        tunningMessage.content = "The " + atData.screenId + " screen is " + atData.japaneseDes;
        return tunningMessage;
    }
}
