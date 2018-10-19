package me.kiip.internal.e;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;
import me.kiip.sdk.Poptart;


public final class d
{
  private static List<Poptart> a;
  private Activity b;
  private final List<Poptart> c;
  private DialogInterface.OnShowListener d;
  private DialogInterface.OnDismissListener e;
  
  public static void a(List<Poptart> paramList)
  {
    a = paramList;
  }
  
  public static List<Poptart> a() { return a; }
  






  public d()
  {
    c = (a != null ? a : new LinkedList());
  }
  

  private Activity g()
  {
    return b;
  }
  



  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    d = paramOnShowListener;
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener) {
    e = paramOnDismissListener;
  }
  

  public void a(Poptart paramPoptart)
  {
    if (paramPoptart == null) {
      return;
    }
    
    synchronized (c) {
      c.add(paramPoptart);
      
      if (c.size() == 1) {
        a(true);
      }
    }
  }
  
  private void a(boolean paramBoolean) {
    if ((c.size() <= 0) || (g() == null)) {
      return;
    }
    
    Poptart localPoptart = (Poptart)c.get(0);
    
    if (d != null) {
      d.onShow(localPoptart);
    }
    
    localPoptart.setTag(Integer.valueOf(g().hashCode()));
    localPoptart.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface dialog) {
        Poptart localPoptart = (Poptart)dialog;
        localPoptart.setOnDismissListener(null);
        
        synchronized (d.a(d.this)) {
          if (d.b(d.this) != null) {
            d.b(d.this).onDismiss(localPoptart);
          }
          
          d.a(d.this).remove(0);
          
          d.a(d.this, true);
        }
      }
    });
    localPoptart.show(g(), paramBoolean);
  }
  
  public void b(Poptart paramPoptart) {
    synchronized (c) {
      int i = c.indexOf(paramPoptart);
      
      if (i > 0) {
        c.remove(i);
      }
      else if (i == 0) {
        ((Poptart)c.get(i)).dismiss();
      }
    }
  }
  
  private void c(Poptart paramPoptart) {
    paramPoptart.setOnDismissListener(null);
    paramPoptart.cancel();
  }
  

  public void a(Activity paramActivity)
  {
    b = paramActivity;
  }
  


  public void a(Bundle paramBundle) {}
  

  public void b()
  {
    if (c.size() > 0) {
      Poptart localPoptart = (Poptart)c.get(0);
      Object localObject = localPoptart.getTag();
      
      if ((localPoptart.isShowing()) && (localObject != null) && (!localObject.equals(Integer.valueOf(g().hashCode())))) {
        c(localPoptart);
      }
    }
    

    a(false);
  }
  


  public void c() {}
  


  public void d()
  {
    if (c.size() > 0) {
      Poptart localPoptart = (Poptart)c.get(0);
      Object localObject = localPoptart.getTag();
      
      if ((localObject != null) && (localObject.equals(Integer.valueOf(g().hashCode())))) {
        c(localPoptart);
      }
    }
  }
  
  public void e() {
    if (c != a) {
      c.clear();
    }
  }
  
  public void f() {
    b = null;
  }
}
