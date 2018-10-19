package me.kiip.internal.d;

import java.io.UnsupportedEncodingException;






























































































































































































































































































































































































































































public class a
{
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      return new String(b(paramArrayOfByte, paramInt), "US-ASCII");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }
  





























  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  











  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localB = new b(paramInt3, null);
    

    int i = paramInt2 / 3 * 4;
    

    if (d) {
      if (paramInt2 % 3 > 0) {
        i += 4;
      }
    } else {
      switch (paramInt2 % 3) {
      case 0: 
        break; case 1:  i += 2; break;
      case 2:  i += 3;
      }
      
    }
    
    if ((e) && (paramInt2 > 0)) {
      i += ((paramInt2 - 1) / 57 + 1) * (f ? 2 : 1);
    }
    

    a = new byte[i];
    localB.a(paramArrayOfByte, paramInt1, paramInt2, true);
    
    if ((!a) && (b != i)) { throw new AssertionError();
    }
    return a;
  }
  




  private a() {}
  



  static class b
    extends a.a
  {
    private static final byte[] h = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
    









    private static final byte[] i = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
    
    private final byte[] j;
    
    int c;
    
    private int k;
    
    public final boolean d;
    
    public final boolean e;
    
    public final boolean f;
    private final byte[] l;
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      a = paramArrayOfByte;
      
      d = ((paramInt & 0x1) == 0);
      e = ((paramInt & 0x2) == 0);
      f = ((paramInt & 0x4) != 0);
      l = ((paramInt & 0x8) == 0 ? h : i);
      
      j = new byte[2];
      c = 0;
      
      k = (e ? 19 : -1);
    }
    








    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = l;
      byte[] arrayOfByte2 = a;
      int m = 0;
      int n = k;
      
      int i1 = paramInt1;
      paramInt2 += paramInt1;
      int i2 = -1;
      




      switch (c)
      {
      case 0: 
        break;
      
      case 1: 
        if (i1 + 2 <= paramInt2)
        {

          i2 = (j[0] & 0xFF) << 16 | (paramArrayOfByte[(i1++)] & 0xFF) << 8 | paramArrayOfByte[(i1++)] & 0xFF;
          

          c = 0;
        }
        
        break;
      case 2: 
        if (i1 + 1 <= paramInt2)
        {
          i2 = (j[0] & 0xFF) << 16 | (j[1] & 0xFF) << 8 | paramArrayOfByte[(i1++)] & 0xFF;
          

          c = 0;
        }
        break;
      }
      
      if (i2 != -1) {
        arrayOfByte2[(m++)] = arrayOfByte1[(i2 >> 18 & 0x3F)];
        arrayOfByte2[(m++)] = arrayOfByte1[(i2 >> 12 & 0x3F)];
        arrayOfByte2[(m++)] = arrayOfByte1[(i2 >> 6 & 0x3F)];
        arrayOfByte2[(m++)] = arrayOfByte1[(i2 & 0x3F)];
        n--; if (n == 0) {
          if (f) arrayOfByte2[(m++)] = 13;
          arrayOfByte2[(m++)] = 10;
          n = 19;
        }
      }
      





      while (i1 + 3 <= paramInt2) {
        i2 = (paramArrayOfByte[i1] & 0xFF) << 16 | (paramArrayOfByte[(i1 + 1)] & 0xFF) << 8 | paramArrayOfByte[(i1 + 2)] & 0xFF;
        

        arrayOfByte2[m] = arrayOfByte1[(i2 >> 18 & 0x3F)];
        arrayOfByte2[(m + 1)] = arrayOfByte1[(i2 >> 12 & 0x3F)];
        arrayOfByte2[(m + 2)] = arrayOfByte1[(i2 >> 6 & 0x3F)];
        arrayOfByte2[(m + 3)] = arrayOfByte1[(i2 & 0x3F)];
        i1 += 3;
        m += 4;
        n--; if (n == 0) {
          if (f) arrayOfByte2[(m++)] = 13;
          arrayOfByte2[(m++)] = 10;
          n = 19;
        }
      }
      
      if (paramBoolean)
      {
        int i3;
        


        if (i1 - c == paramInt2 - 1) {
          i3 = 0;
          i2 = ((c > 0 ? j[(i3++)] : paramArrayOfByte[(i1++)]) & 0xFF) << 4;
          c -= i3;
          arrayOfByte2[(m++)] = arrayOfByte1[(i2 >> 6 & 0x3F)];
          arrayOfByte2[(m++)] = arrayOfByte1[(i2 & 0x3F)];
          if (d) {
            arrayOfByte2[(m++)] = 61;
            arrayOfByte2[(m++)] = 61;
          }
          if (e) {
            if (f) arrayOfByte2[(m++)] = 13;
            arrayOfByte2[(m++)] = 10;
          }
        } else if (i1 - c == paramInt2 - 2) {
          i3 = 0;
          i2 = ((c > 1 ? j[(i3++)] : paramArrayOfByte[(i1++)]) & 0xFF) << 10 | ((c > 0 ? j[(i3++)] : paramArrayOfByte[(i1++)]) & 0xFF) << 2;
          
          c -= i3;
          arrayOfByte2[(m++)] = arrayOfByte1[(i2 >> 12 & 0x3F)];
          arrayOfByte2[(m++)] = arrayOfByte1[(i2 >> 6 & 0x3F)];
          arrayOfByte2[(m++)] = arrayOfByte1[(i2 & 0x3F)];
          if (d) {
            arrayOfByte2[(m++)] = 61;
          }
          if (e) {
            if (f) arrayOfByte2[(m++)] = 13;
            arrayOfByte2[(m++)] = 10;
          }
        } else if ((e) && (m > 0) && (n != 19)) {
          if (f) arrayOfByte2[(m++)] = 13;
          arrayOfByte2[(m++)] = 10;
        }
        
        if ((!g) && (c != 0)) throw new AssertionError();
        if ((!g) && (i1 != paramInt2)) { throw new AssertionError();
        }
        

      }
      else if (i1 == paramInt2 - 1) {
        j[(c++)] = paramArrayOfByte[i1];
      } else if (i1 == paramInt2 - 2) {
        j[(c++)] = paramArrayOfByte[i1];
        j[(c++)] = paramArrayOfByte[(i1 + 1)];
      }
      

      b = m;
      k = n;
      
      return true;
    }
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
    
    a() {}
  }
}
