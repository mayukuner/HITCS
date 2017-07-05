/**
 * quicksort.java -- Quick Sort
 *
 * Written on ������, 20 ���� 2016.
 */

import java.util.*;

public class quicksort {
  
  static void shuffleArray(int[] a)
  {
    /*
     * �ú����������ǽ�a�����������
     */
    Random rnd = new Random();
    for (int i = a.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      int tmp = a[index];
      a[index] = a[i];
      a[i] = tmp;
    }
  }
  
  static Random rnd = new Random();
  static int partition(int l, int r, int[] a) {
    
    // ������[l,r]�л��һ�������λ��p
    int p = l + rnd.nextInt(r-l);

    // ����a[l]��a[p]
    int tmp = a[l];
    a[l] = a[p];
    a[p] = tmp;

    // ��a[l]��Ϊ��׼��pivot��
    int x = a[l];
    
    while (l < r) {

      // ���ұ��ҵ���һ��С�ڻ�׼��Ԫ�أ���������뵽����λ�ã�l����
      while (l < r && a[r] >= x)
        r--;
      if (l < r) {
        a[l] = a[r];
        l++;
      }

      // ������ҵ���һ�����ڵ��ڻ�׼��Ԫ�أ���������뵽����λ�ã�r����
      while (l < r && a[l] < x)
        l++;
      if (l < r) {
        a[r] = a[l];
        r--;
      }
    }

    // ����׼Ԫ�����²��뵽������
    a[l] = x;
    return l;
  }
  
  static void quickSort(int l, int r, int[] a) {
    if (l < r) {
      int mid = partition(l, r, a);
      
      // �ݹ�������벿��
      quickSort(l, mid - 1, a);
      
      // �ݹ������Ұ벿��
      quickSort(mid + 1, r, a);  
    }
  }
  
  public static void main(String Args[]) {
    
    // ����һ��0..99999���������
    int[] a= new int[100000];
    for (int i = 0; i < a.length; i++)
      a[i] = i;
    shuffleArray(a);

    // ���п�������
    quickSort(0, a.length-1, a);

    // ���������
    boolean flag = true;
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] != i) {
        System.out.println("ERROR");
        flag = false;
      }
    }
    if (flag)
      System.out.println("FINISHED");
  }
}
