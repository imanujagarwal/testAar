package me.kiip.internal.b;

import java.io.UnsupportedEncodingException;
import me.kiip.internal.a.k;
import me.kiip.internal.a.p;
import me.kiip.internal.a.p.a;
import me.kiip.internal.a.p.b;
import org.json.JSONException;
import org.json.JSONObject;
































public class l
  extends m<JSONObject>
{
  public l(int paramInt, String paramString, JSONObject paramJSONObject, p.b<JSONObject> paramB, p.a paramA)
  {
    super(paramInt, paramString, paramJSONObject == null ? null : paramJSONObject.toString(), paramB, paramA);
  }
  













  protected p<JSONObject> a(k paramK)
  {
    try
    {
      String str = new String(b, g.a(c, "utf-8"));
      return p.a(new JSONObject(str), 
        g.a(paramK));
    } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
      return p.a(new me.kiip.internal.a.m(localUnsupportedEncodingException));
    } catch (JSONException localJSONException) {
      return p.a(new me.kiip.internal.a.m(localJSONException));
    }
  }
}
