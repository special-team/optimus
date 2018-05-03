package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.MockConfig;
import com.github.ooknight.rubik.support.mocker.Mocker;
import com.github.ooknight.rubik.support.mocker.util.RandomUtils;

/**
 * 模拟String对象
 */
public class StringMocker implements Mocker<String> {

    @Override
    public String mock(MockConfig mockConfig) {
        int size = RandomUtils.nextSize(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
        String[] stringSeed = mockConfig.getStringSeed();
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append(stringSeed[RandomUtils.nextInt(0, stringSeed.length)]);
        }
        return sb.toString();
    }
}
