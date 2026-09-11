package com.livecodingexercise.infra.repository;

import java.util.Collection;

public interface Repository<T, K> {

    T get(K key);

    Collection<T> getAll();

    T update(T t);

    T create(T t);
}
