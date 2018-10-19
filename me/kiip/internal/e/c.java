package me.kiip.internal.e;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager.LayoutParams;








public abstract class c
  extends Dialog
{
  public c(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a() {
    requestWindowFeature(1);
    
    Window localWindow = getWindow();
    localWindow.setBackgroundDrawableResource(17170445);
    localWindow.clearFlags(2);
  }
  
  public void show()
  {
    super.show();
    
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.copyFrom(localWindow.getAttributes());
    width = -1;
    height = -1;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public void onBackPressed()
  {
    if (b.a) {
      Log.d("KiipDialog", "no action on back pressed when reward unit is active");
    }
  }
}
