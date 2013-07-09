package org.hexlet.java;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello World!");

        // константы
        int dec_i = 123;
        int oct_i = 0124;
        int hex_i = 0xFF;
        int bin_i = 0b00_00_11;

        long dec_l = 321L;
        long oct_l = -0321L;
        long hex_l = 0xFF_D2L;
        long bin_l = 0b00110011L;

        System.out.println("Primitive types");
        System.out.println("Constains");

        System.out.println("decimal");
        System.out.println(dec_i);
        System.out.println(dec_l);

        System.out.println("octavian");
        System.out.println(oct_i);
        System.out.println(oct_l);

        System.out.println("hexdecimal");
        System.out.println(hex_i);
        System.out.println(hex_l);

        System.out.println("binary");
        System.out.println(bin_i);
        System.out.println(bin_l);

        double fixed_point_d = 1.24;
        double floating_point_d = 3.14e12;

        float fixed_point_f = 1.45f;
        float floating_point_f = 6.28E4F;

        System.out.println("Real numbers");

        System.out.println("with fixed point");
        System.out.println(fixed_point_d);
        System.out.println(fixed_point_f);

        System.out.println("with floating point");
        System.out.println(floating_point_d);
        System.out.println(floating_point_f);

        System.out.println("Конкатенация и символьное сложение");
        System.out.println(2+'D');
        System.out.println(2+"D");
        System.out.println('D');

        for (char ch='\u0410'; ch <= '\u042f'; ch++){
            System.out.print(ch+" ");
        }
        System.out.println();

        System.out.println("Логический Тип");
        boolean b = true, bb = false;

        System.out.println(b);
        System.out.println(bb);
        System.out.println(b & bb && !bb | b);
        System.out.println((!b || bb) && (bb ^ b));

        System.out.println("Определение максимального числа");

        byte b_size = 1;
        short s_size = 1;
        int i_size = 1;
        long l_size = 1;

/*        for ( int i = 0 ; i < 64 ; i++ ) {
            b_size = (byte) ((b_size << 1) < 0 ? b_size<<1)+1: b_size+0);
            s_size = (s_size << 1) < 0 ? s_size: (short) ((s_size + 1) << 1 + 1);
            i_size = (i_size << 1) < 0 ? i_size: (int) ((i_size + 1) << 1 + 1);
            l_size = (l_size << 1) < 0 ? l_size: (long) ((l_size + 1) << 1 + 1);
            System.out.println(b_size);
            System.out.println(s_size);
            System.out.println(i_size);
            System.out.println(l_size);
        }

        System.out.println(b_size);
        System.out.println(s_size);
        System.out.println(i_size);
        System.out.println(l_size);*/

   /*     for (int size  = 0; size <= 64; size++) {
            System.out.print(size + "\t" + b_size + "\t");
            double step = Math.pow(2, size);
            b_size = (byte) (b_size + step);
            System.out.print(b_size + "\t"+ (long)step + "\n");
            if (b_size < 0) {
                b_size = (byte) (b_size + step);
                System.out.println("Size(bit) " + (size + 1));
                break;
            }
        }
        System.out.println("byte size = " + (b_size));

        for (int size  = 0; size <= 64; size++) {
            System.out.print(size + "\t" + s_size + "\t");
            double step = Math.pow(2, size);
            s_size = (short) (s_size + step);
            System.out.print(s_size + "\t"+ (long)step + "\n");
            if (s_size < 0) {
                s_size = (short) (s_size + step);
                System.out.println("Size(bit) " + (size + 1));
                break;
            }
        }
        System.out.println("short size = " + (s_size));

        for (int size  = 0; size <= 64; size++) {
            System.out.print(size + "\t" + i_size + "\t");
            double step = Math.pow(2, size);
            i_size = (int) (i_size + step);
            System.out.print(i_size + "\t"+ (long)step + "\n");
            if (i_size < 0) {
                i_size = (int) (i_size + step);
                System.out.println("Size(bit) " + (size + 1));
                break;
            }
        }
        System.out.println("int size = " + (i_size));

        for (int size  = 0; size <= 64; size++) {
            System.out.print(size + "\t" + l_size + "\t");
            double step = Math.pow(2, size);
            l_size = (long) (l_size + step);
            System.out.print(l_size + "\t"+ (long)step + "\n");
            if (l_size < 0) {
                l_size = (long) (l_size + step);
                System.out.println("Size(bit) " + (size + 1));
                break;
            }
        }
        System.out.println("long size = " + (l_size));      */
    }
}
