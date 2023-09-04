package edu.zjnu.weChat.strategy.model.tuling;

/**
 * @author: 杨海波
 * @date: 2023-08-07 17:08:23
 * @description: Perception
 */
public class Perception {

    private  InputImage inputImage;

    private  InputText inputText;

    private  SelfInfo selfInfo;

    public InputImage getInputImage() {
        return inputImage;
    }

    public void setInputImage(InputImage inputImage) {
        this.inputImage = inputImage;
    }

    public InputText getInputText() {
        return inputText;
    }

    public void setInputText(InputText inputText) {
        this.inputText = inputText;
    }

    public SelfInfo getSelfInfo() {
        return selfInfo;
    }

    public void setSelfInfo(SelfInfo selfInfo) {
        this.selfInfo = selfInfo;
    }
}
