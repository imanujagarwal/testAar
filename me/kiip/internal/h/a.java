package me.kiip.internal.h;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


























































































































































































public class a
  extends ViewGroup
  implements SurfaceHolder.Callback
{
  SurfaceView a;
  SurfaceHolder b;
  Camera.Size c;
  List<Camera.Size> d;
  Camera e;
  
  public a(Context paramContext)
  {
    super(paramContext);
    
    a = new SurfaceView(paramContext);
    addView(a);
    


    b = a.getHolder();
    b.addCallback(this);
  }
  
  public void a() {
    a.setVisibility(0);
  }
  
  public void b() {
    a.setVisibility(8);
  }
  
  public void setCamera(Camera camera) {
    e = camera;
    if (e != null) {
      d = e.getParameters().getSupportedPreviewSizes();
      requestLayout();
      

      Camera.Parameters localParameters = e.getParameters();
      
      List localList = localParameters.getSupportedFocusModes();
      if (localList.contains("auto"))
      {
        localParameters.setFocusMode("auto");
        
        e.setParameters(localParameters);
      }
      try
      {
        switch (getDisplay().getRotation()) {
        case 0: 
          if (Build.VERSION.SDK_INT >= 8) {
            e.setDisplayOrientation(90);
          }
          else {
            localParameters.setRotation(90);
            e.setParameters(localParameters);
          }
          break;
        case 1: 
          if (Build.VERSION.SDK_INT >= 8) {
            e.setDisplayOrientation(0);
          }
          else {
            localParameters.setRotation(0);
            e.setParameters(localParameters);
          }
          break;
        }
        
        e.setPreviewDisplay(b);
        e.startPreview();
      } catch (IOException localIOException) {
        Log.e("KiipCameraPreview", "IOException caused by setPreviewDisplay()", localIOException);
      }
    }
  }
  

  protected void onLayout(boolean changed, int l, int t, int r, int b)
  {
    if ((changed) && (getChildCount() > 0)) {
      View localView = getChildAt(0);
      
      int i = r - l;
      int j = b - t;
      
      int k = i;
      int m = j;
      if (c != null) {
        k = c.width;
        m = c.height;
      }
      
      int n;
      if (i * m > j * k) {
        n = k * j / m;
        localView.layout((i - n) / 2, 0, (i + n) / 2, j);
      } else {
        n = m * i / k;
        localView.layout(0, (j - n) / 2, i, (j + n) / 2);
      }
    }
  }
  




  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
  {
    int i = resolveSize(getSuggestedMinimumWidth(), widthMeasureSpec);
    int j = resolveSize(getSuggestedMinimumHeight(), heightMeasureSpec);
    setMeasuredDimension(i, j);
    
    if (d != null) {
      c = a(d, i, j);
    }
  }
  





  public void surfaceCreated(SurfaceHolder holder) {}
  





  public void surfaceDestroyed(SurfaceHolder holder) {}
  





  private Camera.Size a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    double d1 = 0.1D;
    double d2 = paramInt1 / paramInt2;
    if (paramList == null) { return null;
    }
    Object localObject = null;
    double d3 = Double.MAX_VALUE;
    
    int i = paramInt2;
    

    for (Iterator localIterator = paramList.iterator(); localIterator.hasNext();) { localSize = (Camera.Size)localIterator.next();
      double d4 = width / height;
      if (Math.abs(d4 - d2) <= 0.1D) {
        if (Math.abs(height - i) < d3) {
          localObject = localSize;
          d3 = Math.abs(height - i);
        }
      }
    }
    Camera.Size localSize;
    if (localObject == null) {
      d3 = Double.MAX_VALUE;
      for (localIterator = paramList.iterator(); localIterator.hasNext();) { localSize = (Camera.Size)localIterator.next();
        if (Math.abs(height - i) < d3) {
          localObject = localSize;
          d3 = Math.abs(height - i);
        }
      }
    }
    return localObject;
  }
  
  public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
    if (e != null) {
      Camera.Parameters localParameters = e.getParameters();
      localParameters.setPreviewSize(c.width, c.height);
      requestLayout();
      
      e.setParameters(localParameters);
      e.startPreview();
    }
  }
}
