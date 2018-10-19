package me.kiip.internal.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import me.kiip.internal.a.e;
import me.kiip.internal.a.m;
import me.kiip.internal.a.n;
import me.kiip.internal.a.n.b;
import me.kiip.internal.a.p;
import me.kiip.internal.a.p.a;
import me.kiip.internal.a.p.b;
import me.kiip.internal.a.v;



























public class k
  extends n<Bitmap>
{
  private final Object a = new Object();
  
  private p.b<Bitmap> b;
  
  private final Bitmap.Config c;
  
  private final int d;
  
  private final int e;
  private final ImageView.ScaleType f;
  private static final Object g = new Object();
  


















  public k(String paramString, p.b<Bitmap> paramB, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig, p.a paramA)
  {
    super(0, paramString, paramA);
    a(new e(1000, 2, 2.0F));
    
    b = paramB;
    c = paramConfig;
    d = paramInt1;
    e = paramInt2;
    f = paramScaleType;
  }
  










  public n.b r()
  {
    return n.b.a;
  }
  














  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return paramInt3;
    }
    

    if (paramScaleType == ImageView.ScaleType.FIT_XY) {
      if (paramInt1 == 0) {
        return paramInt3;
      }
      return paramInt1;
    }
    

    if (paramInt1 == 0) {
      d1 = paramInt2 / paramInt4;
      return (int)(paramInt3 * d1);
    }
    
    if (paramInt2 == 0) {
      return paramInt1;
    }
    
    double d1 = paramInt4 / paramInt3;
    int i = paramInt1;
    

    if (paramScaleType == ImageView.ScaleType.CENTER_CROP) {
      if (i * d1 < paramInt2) {
        i = (int)(paramInt2 / d1);
      }
      return i;
    }
    
    if (i * d1 > paramInt2) {
      i = (int)(paramInt2 / d1);
    }
    return i;
  }
  

  protected p<Bitmap> a(me.kiip.internal.a.k paramK)
  {
    synchronized (g) {
      try {
        return b(paramK);
      } catch (OutOfMemoryError localOutOfMemoryError) {
        v.c("Caught OOM for %d byte image, url=%s", new Object[] { Integer.valueOf(b.length), c() });
        return p.a(new m(localOutOfMemoryError));
      }
    }
  }
  


  private p<Bitmap> b(me.kiip.internal.a.k paramK)
  {
    byte[] arrayOfByte = b;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    Object localObject = null;
    if ((d == 0) && (e == 0)) {
      inPreferredConfig = c;
      localObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    else {
      inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      int i = outWidth;
      int j = outHeight;
      

      int k = a(d, e, i, j, f);
      
      int m = a(e, d, j, i, f);
      


      inJustDecodeBounds = false;
      


      inSampleSize = a(i, j, k, m);
      
      Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      

      if ((localBitmap != null) && ((localBitmap.getWidth() > k) || 
        (localBitmap.getHeight() > m))) {
        localObject = Bitmap.createScaledBitmap(localBitmap, k, m, true);
        
        localBitmap.recycle();
      } else {
        localObject = localBitmap;
      }
    }
    
    if (localObject == null) {
      return p.a(new m(paramK));
    }
    return p.a(localObject, g.a(paramK));
  }
  





  protected void a(Bitmap paramBitmap)
  {
    p.b localB;
    



    synchronized (a) {
      localB = b;
    }
    if (localB != null) {
      localB.a(paramBitmap);
    }
  }
  










  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt1 / paramInt3;
    double d2 = paramInt2 / paramInt4;
    double d3 = Math.min(d1, d2);
    float f1 = 1.0F;
    while (f1 * 2.0F <= d3) {
      f1 *= 2.0F;
    }
    
    return (int)f1;
  }
}
