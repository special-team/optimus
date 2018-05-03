package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;

import java.lang.reflect.ParameterizedType;

/**
 * 模拟泛型
 */
public class GenericMocker implements Mocker<Object> {

    private ParameterizedType type;

    GenericMocker(ParameterizedType type) {
        this.type = type;
    }

    @Override
    public Object mock(MockConfig mockConfig) {
        return new BaseMocker(type.getRawType(), type.getActualTypeArguments()).mock(mockConfig);
    }
}
