package com.dalingjia.collection.list;

/**
 * ArrayList的简单实现（手写）
 *
 */
public class MyArrayList {

    private Object[] elementData;       //底层数组
    private int size;               //数组中元素大小

    public int size(){
        return size;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity){
        if(initialCapacity < 0){
            throw new IndexOutOfBoundsException();
        }
        elementData = new Object[initialCapacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    public boolean add(Object obj){
        //判断长度是否足够
        ensureCapacity();
        elementData[size++] = obj;
        return true;
    }

    /**
     * 添加的元素index只能<=size
     * @param index
     * @param obj
     */
    public void add(int index,Object obj){
        rangeCheckForAdd(index);
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = obj;
        size++;

    }

    public Object remove(int index){

        rangeCheck(index);
        Object oldValue = elementData[index];
        int length = elementData.length - index -1 ;
        if(length >0){
            System.arraycopy(elementData, index+1, elementData, index, elementData.length-index-1);
        }
        elementData[size--] = null;
        return oldValue;
    }

    public boolean remove(Object obj){
        if(obj == null){
            for (int i = 0; i < size; i++) {
                if(elementData[i] == null){
                    remove(i);
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if(obj.equals(elementData[i])){
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }


    //返回旧值
    public Object set(int index,Object obj){
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    public void rangeCheck(int index){
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public void ensureCapacity(){

        //开始扩容
        if(size == elementData.length){
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData,0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public String showList(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(elementData[i]);
            if(i != size-1){
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        System.out.println(myArrayList.elementData.length);//底层数组长度
        myArrayList.add("tanhq");
        myArrayList.add("jingling");
        myArrayList.add("longge");
        myArrayList.add("longge");
        myArrayList.add(1, "gege");
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.get(2));
        myArrayList.remove(2);
        myArrayList.remove("gege");
        myArrayList.set(2, "jj");
        System.out.println(myArrayList.showList());
    }

}
