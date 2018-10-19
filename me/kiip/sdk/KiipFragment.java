package me.kiip.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import java.util.List;
import me.kiip.internal.e.d;







@TargetApi(11)
public class KiipFragment
  extends Fragment
{
  private d a;
  
  public static void setDefaultQueue(List<Poptart> queue)
  {
    d.a(queue);
  }
  



  public static List<Poptart> getDefaultQueue()
  {
    return d.a();
  }
  



  public KiipFragment()
  {
    setRetainInstance(true);
    
    a = new d();
  }
  






  public void showPoptart(Poptart poptart)
  {
    a.a(poptart);
  }
  





  public void dismissPoptart(Poptart poptart)
  {
    a.b(poptart);
  }
  







  public void setOnShowListener(DialogInterface.OnShowListener listener)
  {
    a.a(listener);
  }
  




  public void setOnDismissListener(DialogInterface.OnDismissListener listener)
  {
    a.a(listener);
  }
  



  public void onAttach(Activity activity)
  {
    super.onAttach(activity);
    a.a(activity);
  }
  
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    a.a(savedInstanceState);
  }
  
  public void onStart()
  {
    super.onStart();
    a.b();
  }
  
  public void onStop()
  {
    a.c();
    super.onStop();
  }
  
  public void onDestroyView()
  {
    a.d();
    super.onDestroyView();
  }
  
  public void onDestroy()
  {
    a.e();
    super.onDestroy();
  }
  
  public void onDetach()
  {
    a.f();
    super.onDetach();
  }
}
