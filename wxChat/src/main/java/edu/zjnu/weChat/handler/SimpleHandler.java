package edu.zjnu.weChat.handler;


import edu.zjnu.weChat.api.MessageTools;
import edu.zjnu.weChat.api.WechatTools;
import edu.zjnu.weChat.beans.BaseMsg;
import edu.zjnu.weChat.beans.RecommendInfo;
import edu.zjnu.weChat.face.IMsgHandlerFace;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: 杨海波
 * @date: 2023-04-24 16:51:02
 * @description: * @date: 2023-04-24 16:51:02
 */
@Component
public class SimpleHandler implements IMsgHandlerFace {


    @Override
    public String textMsgHandle(BaseMsg msg) {
        // 群消息不处理
        if (!msg.isGroupMsg()) {
            // 发送文本消息
            String text = msg.getText();
            if ("exit".equals(text)) {
                WechatTools.logout();
            }

            return text;
        }
        return null;
    }

    @Override
    public String picMsgHandle(BaseMsg msg) {

        return "图片保存成功";
    }

    @Override
    public String voiceMsgHandle(BaseMsg msg) {

        return "声音保存成功";
    }

    @Override
    public String viedoMsgHandle(BaseMsg msg) {

        return "视频保存成功";
    }

    @Override
    public String nameCardMsgHandle(BaseMsg msg) {
        return "收到名片消息";
    }

    /**
     * 收到系统消息
     *
     * @param msg
     */
    @Override
    public void sysMsgHandle(BaseMsg msg) {
        String text = msg.getContent();
    }

    @Override
    public String verifyAddFriendMsgHandle(BaseMsg msg) {
        // 同意好友请求，false为不接受好友请求
        MessageTools.addFriend(msg, true);
        RecommendInfo recommendInfo = msg.getRecommendInfo();
        String nickName = recommendInfo.getNickName();
        String province = recommendInfo.getProvince();
        String city = recommendInfo.getCity();
        return "你好，来自" + province + city + "的" + nickName + "， 欢迎添加我为好友！";
    }

    @Override
    public String mediaMsgHandle(BaseMsg msg) {

        return "文件" + msg.toString() + "保存成功";
    }

}
