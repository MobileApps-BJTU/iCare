
package com.example.n56.care.Util;

public class TextMsgEntity {
    private static final String TAG = TextMsgEntity.class.getSimpleName();

    private int head;

    private String name;

    private String date;

    private String text;

    private boolean isComMeg = true;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getMsgType() {
        return isComMeg;
    }

    public void setMsgType(boolean isComMsg) {
    	isComMeg = isComMsg;
    }

    public TextMsgEntity() {
    }

    public TextMsgEntity(int head, String name, String date, String text, boolean isComMsg) {
        super();
        this.head = head;
        this.name = name;
        this.date = date;
        this.text = text;
        this.isComMeg = isComMsg;
    }

}
