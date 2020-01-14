package edu.sandau.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 题目类型枚举
 */
@Getter
@AllArgsConstructor
public enum TopicTypeEnum {
    MULTIPLECHOOSE(0, "选择题"),
    TRUEORFALSE(1, "判断题");

    private final Integer key;
    private final String value;

    public  static Integer findKey(String value) {
        TopicTypeEnum[] topicTypeEnum = values();
        for (TopicTypeEnum topicType : topicTypeEnum) {
            if (topicType.getValue().equals(value)) {
                return topicType.getKey();
            }
        }
        return null;
    }
}
