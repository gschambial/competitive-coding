/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wokjam.test;

/**
 * @version 1.0, 18-Oct-2018
 * @author gourav
 */
public class Stack {

    Long[] arr            = new Long[10];
    int    currentPointer = 0;

    public void push(Long i) {
        this.arr[currentPointer] = i;
        this.currentPointer++;
    }

    public Long pop() {
        if (this.currentPointer != 0) {
            this.currentPointer--;
        }
        Long toReturn = arr[this.currentPointer];
        return toReturn;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5L);
        System.out.println(stack.pop());
    }

}
