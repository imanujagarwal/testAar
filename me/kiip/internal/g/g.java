package me.kiip.internal.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import java.util.HashSet;
import me.kiip.internal.e.b;








public class g
  implements SensorEventListener
{
  protected final String a = getClass().getSimpleName();
  
  private static g b;
  
  private SensorManager c;
  
  private float[] d = new float[3];
  private float[] e = new float[3];
  
  private float[] f = new float[9];
  
  private g() {}
  
  public static g a(Context paramContext)
  {
    if (b == null) {
      b = new g();
      b.b(paramContext);
    }
    return b;
  }
  
  private HashSet<a> g = new HashSet();
  
  private void b(Context paramContext) {
    try {
      c = ((SensorManager)paramContext.getSystemService("sensor"));
    } catch (Exception localException) {
      if (b.a) {
        Log.d(a, "Either Accelerometer or Magnetic Field sensors not available");
      }
    }
  }
  
  public boolean a()
  {
    try {
      boolean bool1 = c.registerListener(this, c.getDefaultSensor(1), 3);
      if (!bool1) {
        return false;
      }
      
      boolean bool2 = c.registerListener(this, c.getDefaultSensor(2), 3);
      if (!bool2) {
        return false;
      }
      
      c.unregisterListener(this);
      
      return true;
    }
    catch (Exception localException) {
      if (c != null) {
        c.unregisterListener(this);
      }
      if (b.a) {
        Log.d(a, "Either Accelerometer or Magnetic Field sensors not available");
      }
    }
    
    return false;
  }
  
  public void b() {
    try { c.registerListener(this, c.getDefaultSensor(1), 3);
      c.registerListener(this, c.getDefaultSensor(2), 3);
    } catch (Exception localException) {
      if (b.a) {
        Log.d(a, "Either Accelerometer or Magnetic Field sensors not available");
      }
    }
  }
  
  public void c() {
    c.unregisterListener(this);
    if (g.size() == 1) {
      g = new HashSet();
    }
  }
  
  public void a(a paramA) {
    g.add(paramA);
  }
  
  protected float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2) {
    if (paramArrayOfFloat2 == null) return paramArrayOfFloat1;
    for (int i = 0; i < paramArrayOfFloat1.length; i++) {
      paramArrayOfFloat2[i] += 0.14F * (paramArrayOfFloat1[i] - paramArrayOfFloat2[i]);
    }
    return paramArrayOfFloat2;
  }
  

  public void onSensorChanged(SensorEvent event)
  {
    switch (sensor.getType()) {
    case 1: 
      e = a((float[])values.clone(), e);
      break;
    
    case 2: 
      d = a((float[])values.clone(), d);
    }
    
    
    if ((e != null) && (d != null) && 
      (SensorManager.getRotationMatrix(f, null, e, d)))
    {
      final float[] arrayOfFloat = new float[3];
      SensorManager.getOrientation(f, arrayOfFloat);
      new Thread(new Runnable()
      {
        public void run() {
          for (g.a localA : g.a(g.this)) {
            if (localA != null) {
              localA.a(-g.b(g.this)[2] * 0.101972D, Math.toDegrees(arrayOfFloat[0]));
            }
          }
        }
      })
      







        .run();
    }
  }
  
  public void onAccuracyChanged(Sensor sensor, int accuracy) {}
  
  public static abstract interface a
  {
    public abstract void a(double paramDouble1, double paramDouble2);
  }
}
