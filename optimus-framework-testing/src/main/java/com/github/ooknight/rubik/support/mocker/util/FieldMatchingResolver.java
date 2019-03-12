package com.github.ooknight.rubik.support.mocker.util;

/**
 * 字段模式匹配工具类
 */
public class FieldMatchingResolver {

    /**
     * 模式匹配:
     * [*FieldWord*]
     * [*FieldWord]
     * [FieldWord*]
     */
    public static boolean isMatchPattern(String fieldName, String fieldPattern) {
        //
        boolean match = false;

        /*
         * 匹配模式[*FieldWord*]
         */
        if (fieldPattern.startsWith("*") && fieldPattern.endsWith("*")) {
            match = fieldName.toLowerCase().contains(fieldPattern.toLowerCase().subSequence(1, fieldPattern.length() - 1));
        }
        if (match) {
            return match;
        }

        /*
         * 匹配模式[*FieldWord]
         */
        if (fieldPattern.startsWith("*")) {
            match = fieldName.toLowerCase().endsWith(fieldPattern.toLowerCase().substring(1));
        }
        if (match) {
            return match;
        }

        /*
         * 优先级2：匹配模式[FieldWord*]
         */
        if (fieldPattern.endsWith("*")) {
            match = fieldName.toLowerCase().startsWith(fieldPattern.toLowerCase().substring(0, fieldPattern.length() - 1));
        }
        if (match) {
            return match;
        }
        return match;
    }
}
