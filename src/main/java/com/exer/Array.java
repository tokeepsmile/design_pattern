package com.exer;

import java.util.zip.ZipEntry;

/**
 * @Autor wangwei
 * @Data 2021/5/27 14:54
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpth(){
        return size == 0;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public void add(int index, E e){
        // if (size == data.length)
        //     throw new IllegalArgumentException("array is full");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("param error");
        if (size == data.length){
            resize(2 * data.length);
        }
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("param error");
        return data[index];
    }

    public boolean cotains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("param error");
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void resort(){
        for (int i = 0, j = size - 1; i <= j; i++,j--){
            E temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Capacity: %d, Size: %d\n", data.length, size));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size-1){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
