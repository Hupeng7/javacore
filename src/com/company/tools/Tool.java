package com.company.tools;

import java.util.*;

/**
 * @author Black
 * @time 2018/4/15.
 */
class test{
    public static void main(String[] args) {
        Tool tool = new Tool();
        String[] arr= {"d","f","s"};

        System.out.println(tool.arrToList(arr).get(1));

        System.out.println(tool.arrHasOne(arr,"d"));

        System.out.println(tool.listRemove(arr,"s").contains("s"));

        /**
         * String
         */
        String a = "abcd";
        String b = "abcd";
        System.out.print("a==b: ");
        System.out.println(a==b);
        System.out.print("a equals b: ");
        System.out.println(a.equals(b));

        String c = new String("abcd");
        String d = new String("abcd");
        System.out.print("c==d: ");
        System.out.println(c==d);
        System.out.print("c equals d: ");
        System.out.println(c.equals(d));


    }
}

public class Tool {

    /**
     * Array to List
     * 把一个数组转换成一个ArrayList
     * 一般写法：
     * 1.List list = (List)Arrays.asList(arr);
     * 2.ArrayList list = new ArrayList(Arrays.asList(arr));
     * Arrays.asList确实会返回一个 ArrayList对象，但是该类是 Arrays类 中一个私有静态内部类，
     * 而不是常见的 java.util.ArrayList类。这个 java.util.Arrays.ArrayList 类具有 set()，get()，contains()等方法，
     * 但是不具有任何添加或移除元素的任何方法。因为该类的大小(size)是固定的。
     * 为了创建出一个真正的 java.util.ArrayList,代码应该如下所示：
     * @param arr
     * @return
     */
    public  List arrToList(Object[] arr){
           List list = new ArrayList<String>(arr.length);
            Collections.addAll(list,arr);
            return list;
        }

    /**
     * 检查数组中是否包含某个特定值
     * 一般写法：
     * 1. Set<Object> set = new HashSet<Object>(Arrays.asList(arr));return set.contains(one);
     *    就功能而言，该代码是正确无误的，但在数组转List,List再转Set的过程中消耗了大量的性能。
     * 2. Arrays.asList(arr).contains(one);
     * @param arr
     * @param one
     * @return
     */
     public  boolean arrHasOne(Object[] arr,Object one){
         boolean flag =false;
         for (Object o:
              arr) {
             if (o.equals(one)){
                 flag=true;
             }
         }
         return flag;
     }

    /**
     * 在迭代过程中移除List中元素
     * 一般写法：
     * 1.list = new ArrayList(Arrays.asList("a","b","c"));
     * for (int i = 0; i < list.size(); i++) {
     *list.remove(i);
     * }
     * 2.next()方法必须在remove()方法之前被调用。在 foreach 循环中，
     * 编译器使得 remove()方法先于next()方法被调用，这就导致了
     * ConcurrentModificationException 异常
     * 。具体细节可以查看 ArrayList.iterator()的源码。
     * @param arr
     * @param o
     * @return
     */
     public  List listRemove(Object[] arr,Object o){
         List list = new ArrayList(Arrays.asList(arr));
         Iterator<Object> iter = list.iterator();
         while (iter.hasNext()){
             Object obj = iter.next();
             if (o.equals(obj)){
                 iter.remove();
             }
         }
         return list;
     }



    }

