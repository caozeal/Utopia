package com.caozeal.practice.inter;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * <p>创建时间：2019/6/25 13:46
 * <p>com.writ.practice.inter
 * @author caozhiyong
 * @version 1.0
 */
public interface TestCollection2<E> extends Collection<E> {

    @Override
    default boolean removeIf(Predicate<? super E> filter){
        return false;
    }
}
