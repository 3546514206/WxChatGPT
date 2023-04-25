package edu.zjnu.weChat.handler;


import edu.zjnu.weChat.api.MessageTools;
import edu.zjnu.weChat.api.WechatTools;
import edu.zjnu.weChat.beans.BaseMsg;
import edu.zjnu.weChat.beans.RecommendInfo;
import edu.zjnu.weChat.face.IMsgHandlerFace;
import edu.zjnu.weChat.utils.WxHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: 杨海波
 * @date: 2023-04-24 16:51:02
 */
@Component
public class SimpleHandler implements IMsgHandlerFace, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public String textMsgHandle(BaseMsg msg) throws IOException {
        // 群消息不处理
        if (!msg.isGroupMsg()) {
            // 发送文本消息
            String text = msg.getText();
            if ("exit".equals(text)) {
                WechatTools.logout();
            }

            String url = applicationContext.getEnvironment().getProperty("chatGPT.server") + applicationContext.getEnvironment().getProperty("chatGPT.servlet.context-path");
            HttpEntity httpEntity = WxHttpClient.getInstance().doPost(url, text);
            String responseEntity = EntityUtils.toString(httpEntity);
            return responseEntity;
        }
        return null;
    }

    @Override
    public String picMsgHandle(BaseMsg msg) {
        if (msg.isGroupMsg()) {
            return null;
        }

        return "图片保存成功";
    }

    @Override
    public String voiceMsgHandle(BaseMsg msg) {
        if (msg.isGroupMsg()) {
            return null;
        }
        return "声音保存成功";
    }

    @Override
    public String viedoMsgHandle(BaseMsg msg) {
        if (msg.isGroupMsg()) {
            return null;
        }
        return "视频保存成功";
    }

    @Override
    public String nameCardMsgHandle(BaseMsg msg) {
        if (msg.isGroupMsg()) {
            return null;
        }
        return "收到名片消息";
    }

    /**
     * 收到系统消息
     *
     * @param msg
     */
    @Override
    public void sysMsgHandle(BaseMsg msg) {
        if (!msg.isGroupMsg()) {
            String text = msg.getContent();
        }

    }

    @Override
    public String verifyAddFriendMsgHandle(BaseMsg msg) {
        // 同意好友请求，false为不接受好友请求
        MessageTools.addFriend(msg, false);
        RecommendInfo recommendInfo = msg.getRecommendInfo();
        String nickName = recommendInfo.getNickName();
        String province = recommendInfo.getProvince();
        String city = recommendInfo.getCity();
        return "你好，来自" + province + city + "的" + nickName + "， 欢迎添加我为好友！";
    }

    @Override
    public String mediaMsgHandle(BaseMsg msg) {
        if (msg.isGroupMsg()) {
            return null;
        }
        return "文件" + msg.toString() + "保存成功";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
