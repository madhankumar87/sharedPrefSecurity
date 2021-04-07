package com.mvi.androidsecurity;

public interface ISharedPreference {
    String get(String name);

    void put(String name, String value);
}
