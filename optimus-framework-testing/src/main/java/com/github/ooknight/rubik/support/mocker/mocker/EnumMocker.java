package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Double对象模拟器
 */
public class EnumMocker<T extends Enum> implements Mocker<T> {

    private Class<T> clazz;

    public EnumMocker(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T mock(MockConfig mockConfig) {
        T[] enums = clazz.getEnumConstants();
        return enums[RandomUtils.nextInt(0, enums.length)];
    }
}
