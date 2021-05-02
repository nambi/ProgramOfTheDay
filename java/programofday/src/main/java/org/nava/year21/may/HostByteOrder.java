package org.nava.year21.may;

import java.nio.ByteOrder;

/**
 * Write a program to determine the host byte order (endianness) of any system.
 * Let’s scope this to big endian and little endian systems.
 */
public class HostByteOrder {

    /**
     * Just check the pointer references,
     * if it refers to most significant number then its BIG Endian otherwise its Little Endian
     * Java does not support pointer arithmetic so we have to use native library
     * @return
     */
    public static ByteOrder hostByteOrder() {
        return ByteOrder.nativeOrder();
    }

    public static void main(String[] args) {
        System.out.println(hostByteOrder());
    }

}
