package com.caozeal.practice.inter;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * <p>创建时间：2019/6/25 13:44
 * <p>com.writ.practice
 * @author caozhiyong
 * @version 1.0
 */
public interface TestCollection<E> extends Collection<E> {

    @Override
    default boolean removeIf(Predicate<? super E> filter){
        return true;
    }
}
