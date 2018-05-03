package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * Byte对象模拟器
 */
public class ByteMocker implements Mocker<Byte> {

    @Override
    public Byte mock(MockConfig mockConfig) {
        return (byte) RandomUtils.nextInt(mockConfig.getByteRange()[0], mockConfig.getByteRange()[1]);
    }
}
