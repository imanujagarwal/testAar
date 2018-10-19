package me.kiip.internal.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;




public enum b
{
  private final String e;
  private Bitmap f;
  
  private b(String paramString)
  {
    e = paramString;
  }
  
  private float a(float paramFloat, Context paramContext) {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    return TypedValue.applyDimension(1, paramFloat, localDisplayMetrics);
  }
  
  private int b(float paramFloat, Context paramContext) {
    return (int)(a(paramFloat, paramContext) + 0.5F);
  }
  
  public Drawable a(Context paramContext) {
    Bitmap localBitmap = a();
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap);
    
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    localBitmapDrawable.setTargetDensity(b(xdpi, paramContext));
    return localBitmapDrawable;
  }
  
  public Bitmap a() {
    if (f == null) {
      byte[] arrayOfByte = Base64.decode(e, 0);
      f = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
    }
    return f;
  }
}
