package datastructure;

import java.util.Arrays;

public class DynamicList {
    String[] list;
    int size;
    public DynamicList(){list=new String[8];size=0;}

    void add(String value){
        if(list.length==size){
            String[] temp=new String[2*size];
            System.arraycopy(list,0,temp,0,list.length);
            list=temp;
        }
        list[size]=value;
        size++;
    }

    String del(int index){
        if(index<0|| index>size)throw new RuntimeException();
        String deletedElement= list[index];
        for(int i=index;i<size;i++){
            list[i]=list[i+1];
        }
        size--;
        if(size< list.length/4.0){
            String[] temp=new String[list.length/2];
            System.arraycopy(list,0,temp,0,list.length/2);
            list=temp;
        }
        return deletedElement;
    }

    String get(int index){
        if(index<0|| index>size)throw new RuntimeException();
        return list[index];
    }

    boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString() {
        return "DynamicList{" +
                "list=" + Arrays.toString(list) +
                ", size=" + size +
                '}';
    }
}
