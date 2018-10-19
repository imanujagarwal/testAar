package me.kiip.internal.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;














































public class d
{
  private final List<byte[]> b = new LinkedList();
  private final List<byte[]> c = new ArrayList(64);
  

  private int d = 0;
  



  private final int e;
  


  protected static final Comparator<byte[]> a = new Comparator()
  {
    public int a(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2) {
      return paramAnonymousArrayOfByte1.length - paramAnonymousArrayOfByte2.length;
    }
  };
  


  public d(int paramInt)
  {
    e = paramInt;
  }
  







  public synchronized byte[] a(int paramInt)
  {
    for (int i = 0; i < c.size(); i++) {
      byte[] arrayOfByte = (byte[])c.get(i);
      if (arrayOfByte.length >= paramInt) {
        d -= arrayOfByte.length;
        c.remove(i);
        b.remove(arrayOfByte);
        return arrayOfByte;
      }
    }
    return new byte[paramInt];
  }
  





  public synchronized void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length > e)) {
      return;
    }
    b.add(paramArrayOfByte);
    int i = Collections.binarySearch(c, paramArrayOfByte, a);
    if (i < 0) {
      i = -i - 1;
    }
    c.add(i, paramArrayOfByte);
    d += paramArrayOfByte.length;
    a();
  }
  


  private synchronized void a()
  {
    while (d > e) {
      byte[] arrayOfByte = (byte[])b.remove(0);
      c.remove(arrayOfByte);
      d -= arrayOfByte.length;
    }
  }
}
