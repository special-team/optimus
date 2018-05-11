package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟Map
 */
public class MapMocker implements Mocker<Object> {

    private Type[] types;

    MapMocker(Type[] types) {
        this.types = types;
    }

    @Override
    public Object mock(MockConfig mockConfig) {
        int size = RandomUtils.nextSize(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
        Map<Object, Object> result = new HashMap<>(size);
        BaseMocker keyMocker = new BaseMocker(types[0]);
        BaseMocker valueMocker = new BaseMocker(types[1]);
        for (int index = 0; index < size; index++) {
            result.put(keyMocker.mock(mockConfig), valueMocker.mock(mockConfig));
        }
        return result;
    }
}