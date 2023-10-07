public final int MAX_SIZE = 1024;

public String readBytes(Socket socket) throws IOException {
  InputStream in = socket.getInputStream();
  byte[] data = new byte[MAX_SIZE+1];
  int offset = 0;
  int bytesRead = 0;
  while ((bytesRead = in.read(data, offset, data.length - offset)) != -1) {
    offset += bytesRead;
    if (offset >= data.length) {
      throw new IOException("Too much input");
    }
  }
  String str = new String(data, 0, offset, "UTF-8");
  in.close();
  return str;
}
