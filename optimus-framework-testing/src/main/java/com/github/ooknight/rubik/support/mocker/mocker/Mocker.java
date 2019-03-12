package com.github.ooknight.rubik.support.mocker.mocker;

import com.github.ooknight.rubik.support.mocker.DataConfig;

/**
 * 模拟器接口
 */
public interface Mocker<T> {

    /**
     * 模拟数据
     *
     * @param mockConfig 模拟数据配置
     * @return 模拟数据对象
     */
    T mock(DataConfig mockConfig);
}
