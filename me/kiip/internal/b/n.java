package me.kiip.internal.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;








































public class n
  extends ByteArrayOutputStream
{
  private final d a;
  
  public n(d paramD, int paramInt)
  {
    a = paramD;
    buf = a.a(Math.max(paramInt, 256));
  }
  
  public void close() throws IOException
  {
    a.a(buf);
    buf = null;
    super.close();
  }
  
  public void finalize()
  {
    a.a(buf);
  }
  



  private void a(int paramInt)
  {
    if (count + paramInt <= buf.length) {
      return;
    }
    byte[] arrayOfByte = a.a((count + paramInt) * 2);
    System.arraycopy(buf, 0, arrayOfByte, 0, count);
    a.a(buf);
    buf = arrayOfByte;
  }
  
  public synchronized void write(byte[] buffer, int offset, int len)
  {
    a(len);
    super.write(buffer, offset, len);
  }
  
  public synchronized void write(int oneByte)
  {
    a(1);
    super.write(oneByte);
  }
}
