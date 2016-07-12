package com.epicodus.discussionforum.model;


public class Topic {
    private String mTopicName;

    public Topic(String topicName) {
        this.mTopicName = topicName;
    }

    public String getTopicName() {
        return mTopicName;
    }
}
