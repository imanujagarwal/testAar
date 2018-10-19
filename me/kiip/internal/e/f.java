package me.kiip.internal.e;

import android.location.Location;
import android.util.Log;
import javax.xml.datatype.Duration;
import org.json.JSONException;
import org.json.JSONObject;




















public class f
{
  private static final String[] a = { "action_save", "action_send", "action_share", "action_search", "action_purchase", "action_completion", "action_update", "action_input", "action_tap" };
  















  private String b;
  















  private Location c;
  














  private Duration d;
  















  public static JSONObject a(f paramF)
  {
    JSONObject localJSONObject = new JSONObject();
    
    if (paramF == null) {
      Log.e("KiipMomentMeta", "Couldn't send Meta Data");
      return localJSONObject;
    }
    try
    {
      localJSONObject.put("action", b);
      if (c != null) {
        localJSONObject.put("location", c.toString());
      }
      if (d != null) {
        localJSONObject.put("duration", d.toString());
      }
    } catch (JSONException localJSONException) {
      Log.e("KiipMomentMeta", "Couldn't create Meta Data JSON", localJSONException);
    }
    return localJSONObject;
  }
}
