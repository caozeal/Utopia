package com.caozeal.practice.inter;

import java.util.Collection;
import java.util.Iterator;

/**
 * 不能同时实现TestCollection，TestCollection2这两个接口，默认方法冲突
 * <p>创建时间：2019/6/25 13:47
 * <p>com.writ.practice.inter
 * @author caozhiyong
 * @version 1.0
 */
public class TestCollection3<E> implements TestCollection<E>
//        , TestCollection2<E>
{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
