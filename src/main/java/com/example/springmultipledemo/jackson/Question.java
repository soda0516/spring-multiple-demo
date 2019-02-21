package com.example.springmultipledemo.jackson;

import lombok.Data;

@Data
//这个是根据抽象类的某个字段，在进行反序列化时候，指定某个子类
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.EXISTING_PROPERTY,
//        property = "typeId",visible = true
//)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = QuestionSingleChoice.class, name = "1"),
//        @JsonSubTypes.Type(value = QuestionMultipleChoice.class, name = "2")
//})
public abstract class Question {
    private Integer id;

    private String questionTitle;

    private Integer typeId;

    private String typeName;

}