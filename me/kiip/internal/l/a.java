package me.kiip.internal.l;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.EditText;

public class a
{
  String a;
  
  public a()
  {
    this(null);
  }
  
  public a(String paramString) {
    a = paramString;
  }
  



  public void a(String paramString)
  {
    a = paramString;
  }
  
  public void a(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult) {
    DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        paramJsResult.confirm();
      }
      
    };
    DialogInterface.OnCancelListener local2 = new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface dialog) {
        paramJsResult.cancel();


      }
      



    };
    AlertDialog localAlertDialog = new AlertDialog.Builder(paramWebView.getContext()).setTitle(b(paramString1)).setMessage(paramString2).setPositiveButton(17039370, local1).setOnCancelListener(local2).create();
    localAlertDialog.show();
  }
  
  public void b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    c(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void c(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult) {
    DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        if (-1 == which) {
          paramJsResult.confirm();
        } else if (-2 == which) {
          paramJsResult.cancel();
        }
        
      }
    };
    DialogInterface.OnCancelListener local4 = new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface dialog) {
        paramJsResult.cancel();



      }
      



    };
    AlertDialog localAlertDialog = new AlertDialog.Builder(paramWebView.getContext()).setTitle(b(paramString1)).setMessage(paramString2).setPositiveButton(17039370, local3).setNegativeButton(17039360, local3).setOnCancelListener(local4).create();
    localAlertDialog.show();
  }
  
  public void a(WebView paramWebView, String paramString1, String paramString2, String paramString3, final JsPromptResult paramJsPromptResult) {
    android.content.Context localContext = paramWebView.getContext();
    final EditText localEditText = new EditText(localContext);
    
    DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        if (-1 == which) {
          paramJsPromptResult.confirm(localEditText.getText().toString());
        } else if (-2 == which) {
          paramJsPromptResult.cancel();
        }
        
      }
    };
    DialogInterface.OnCancelListener local6 = new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface dialog) {
        paramJsPromptResult.cancel();



      }
      




    };
    AlertDialog localAlertDialog = new AlertDialog.Builder(paramWebView.getContext()).setTitle(b(paramString1)).setMessage(paramString2).setView(localEditText).setPositiveButton(17039370, local5).setNegativeButton(17039360, local5).setOnCancelListener(local6).create();
    localAlertDialog.show();
  }
  
  private String b(String paramString) {
    String str = a;
    if (str == null) {
      str = c(paramString);
    }
    return str;
  }
  
  private static String c(String paramString) {
    try {
      return new java.net.URL(paramString).getHost();
    } catch (java.net.MalformedURLException localMalformedURLException) {}
    return null;
  }
}
