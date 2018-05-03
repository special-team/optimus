package com.github.ooknight.rubik.core.session;

import com.github.ooknight.rubik.support.core.OClass;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class Menu extends OClass {

    @JSONField(ordinal = 101)
    private final String key;
    @JSONField(ordinal = 102)
    private final String name;
    @JSONField(ordinal = 103)
    private final String url;
    @JSONField(ordinal = 104)
    private final String icon;
    @JSONField(ordinal = 105)
    private final List<Menu> children = new ArrayList<>();

    public Menu(String key, String name) {
        this(key, name, null, null);
    }

    public Menu(String key, String name, String url, String icon) {
        this.key = key;
        this.name = name;
        this.url = url;
        this.icon = icon;
    }
}
