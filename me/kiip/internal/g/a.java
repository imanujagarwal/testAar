package me.kiip.internal.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import me.kiip.internal.e.b;





public final class a
{
  public static final class a
  {
    private final String a;
    private final boolean b;
    
    a(String paramString, boolean paramBoolean)
    {
      a = paramString;
      b = paramBoolean;
    }
    
    public String a() {
      return a;
    }
    
    public boolean b() {
      return b;
    }
  }
  

  public static a a(Context paramContext)
    throws Exception
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("Cannot be called from the main thread");
    }
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      localPackageManager.getPackageInfo("com.android.vending", 0);
    }
    catch (Exception localException1) {
      if (b.a) {
        localException1.printStackTrace();
      }
    }
    
    b localB = new b(null);
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    if (paramContext.bindService(localIntent, localB, 1)) {
      try {
        c localC = new c(localB.a());
        return new a(localC.a(), localC.a(true));
      } catch (Exception localException2) {
        if (b.a) {
          localException2.printStackTrace();
        }
      } finally {
        paramContext.unbindService(localB);
      }
    }
    throw new IOException("Google Play connection failed");
  }
  
  private static final class b implements ServiceConnection
  {
    boolean a = false;
    
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);
    
    private b() {}
    
    public void onServiceConnected(ComponentName name, IBinder service) { try { b.put(service);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    


    public void onServiceDisconnected(ComponentName name) {}
    

    public IBinder a()
      throws InterruptedException
    {
      if (a) {
        throw new IllegalStateException();
      }
      a = true;
      
      return (IBinder)b.take();
    }
  }
  
  private static final class c implements IInterface {
    private IBinder a;
    
    public c(IBinder paramIBinder) {
      a = paramIBinder;
    }
    
    public IBinder asBinder() {
      return a;
    }
    
    public String a() throws RemoteException {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      String str;
      try {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        str = localParcel2.readString();
      } finally {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      return str;
    }
    
    public boolean a(boolean paramBoolean) throws RemoteException {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      boolean bool;
      try {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        localParcel1.writeInt(paramBoolean ? 1 : 0);
        a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        bool = 0 != localParcel2.readInt();
      } finally {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      return bool;
    }
  }
}
