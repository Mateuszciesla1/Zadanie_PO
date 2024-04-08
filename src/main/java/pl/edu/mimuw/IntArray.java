package pl.edu.mimuw;

import java.util.Arrays;

public class IntArray {
    private final int[] array;

    public IntArray(int ... newArray){
        array = new int[newArray.length];
        for(int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }


    public IntArray(){
        this.array = new int[0];
    }

    public IntArray unshifted(int newElement){
        int []newArray = new int[array.length + 1];
        newArray[0] = newElement;
        for(int i = 1; i <= array.length; i++){
            newArray[i] = array[i-1];
        }
        return new IntArray(newArray);
    }

    public IntArray pushed(int newElement){
        int []newArray = new int[array.length + 1];
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[array.length] = newElement;
        return new IntArray(newArray);
    }

    public IntArray shifted(){
        if(array.length == 0)
            return new IntArray();

        int []newArray = new int[array.length - 1];
        for(int i = 0; i < array.length-1; i++){
            newArray[i] = array[i+1];
        }
        return new IntArray(newArray);
    }

    public  IntArray popped(){
        if(array.length == 0)
            return new IntArray();

        int []newArray = new int[array.length - 1];
        for(int i = 0; i < array.length-1; i++){
            newArray[i] = array[i];
        }
        return new IntArray(newArray);
    }

    public int at(int index){
        return array[index];
    }

    public IntArray with(int index, int newElement){
        int []newArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(i == index)
                newArray[i] = newElement;
            else
                newArray[i] = array[i];
        }
        return new IntArray(newArray);
    }

    public int getLength(){
        return array.length;
    }
    //Zakladam, ze uzytkownik indeksuje tablice od 0
    public IntArray filled(int begIndex, int endIndex, int value){
        int []newArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(begIndex <= i && i <= endIndex)
                newArray[i] = value;
            else
                newArray[i] = array[i];
        }
        return new IntArray(newArray);
    }

    public IntArray reversed(){
        int []newArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[array.length - 1 - i];
        }
        return new IntArray(newArray);
    }
    public IntArray concat(IntArray secondArray){
        int newLenght = array.length + secondArray.getLength();
        int [] newArray = new int [newLenght];
        for(int i = 0; i < newLenght; i++){
            if(i < array.length)
                newArray[i] = array[i];
            else
                newArray[i] = secondArray.at(i - array.length );
        }
        return new IntArray(newArray);
    }

    public Boolean includes(int element){
        for(int i = 0; i < array.length; i++){
            if(element == array[i]){
                return true;
            }
        }
        return false;
    }

    public int indexOf(int element){
        for(int i = 0; i < array.length; i++)
            if(array[i] == element)
                return i;
        return -1;
    }

    public int lastIndexOf(int element){
        int lastIndex = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == element)
                lastIndex = i;
        }
        return lastIndex;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;

        IntArray secondArray = (IntArray) obj;

        return Arrays.equals(array, secondArray.array);
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
