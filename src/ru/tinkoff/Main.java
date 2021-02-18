package ru.tinkoff;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    }


    // 2.1. Сортировка массива

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


    // 2.2 Валидация телефонного номера

    // Метод проверки телефонного номера
    // inputNumber - входная строка с номером
    public static String[] ValidatePhoneNumber( String inputNumber ){
        String number = inputNumber;
        String[] result = new String[2];

        if ( number.startsWith( "+7" ) )
        {
            number.replaceFirst( "+7", "8" );
            result[1] += "Замена +7 на 8; ";
        }

        boolean spacesOrBounds = false;

        if ( number.contains( " " ) )
        {
            number.replaceAll( " ", "" );
            spacesOrBounds = true;
        }
        if ( number.contains( " " ) )
        {
            number.replaceAll( "(", "" );
            spacesOrBounds = true;
        }

        if ( number.contains( " " ) )
        {
            number.replaceAll( ")", "" );
            spacesOrBounds = true;
        }

        if ( spacesOrBounds )
            result[1] += "В номере есть пробелы и/или скобки; ";

        if ( number.length() != 11 )
        {
            result[0] = "Введен некорректный номер";
            result[1] += "Количество символов не 11; ";
        }
        else
        {
            result[0] = number;
            if ( result[1].isEmpty() )
                result[1] = " Изменений не было";
        }

        return result;
    }
}
