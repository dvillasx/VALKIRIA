package com.tequila.mommy;

public class Tratamiento {
    String topic;
    String subTopic;



    public Tratamiento(String topic, String subTopic) {
        this.topic = topic;
        this.subTopic = subTopic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }
}
