package ru.tinkoff;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    }


    // Метод сортировки
    // array - входной массив
    // return - сортированный массив
    public static int[] thanosSort( int[] array )
    {
        // делаем копию, чтобы не менять входной массив ( по условию )
        int[] result = Arrays.copyOf( array, array.length );

        // сортируем
        thanosSortImpl( result, 0, result.length - 1 );
        return result;
    }


    // сортировка массива на участке
    // array - массив
    // l - индекс левой границы
    // r - индекс правой границы
    private static void thanosSortImpl( int[] array, int l, int r )
    {
        // выходим, если один элемент в подмассиве
        if ( r <= l )
            return;

        // считаем среднее арифмитическое на участке
        int Sum = 0;
        for ( int i = l; i <= r; ++i )
            Sum += array[i];
        double Average = ( (double)Sum ) / ( r - l + 1 );

        // переложим во временный массив в нужном порядке
        int[] sorted = new int[r-l+1];
        int ldx = 0, rdx = sorted.length - 1;
        for ( int i = l; i <= r; ++i )
            sorted[ ( array[i] < Average ) ? ldx++ : rdx-- ] = array[i];

        // в исходном массиве поменяем порядок на участке в соответствии с сортировкой
        for ( int i = l, si = 0; i <= r; ++i, ++si )
            array[i] = sorted[si];

        // найдем индекс разбиения по среднему для сортировки подучастков
        int mid = l;
        for ( int i = l; i <= r; ++i )
            if ( array[i] < Average )
                mid = i;

         // сортировка подучастков массива
        thanosSortImpl( array, l, mid );
        thanosSortImpl( array, mid + 1, r );
    }
}
