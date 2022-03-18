package adapter;

import code.XCode;
import crypt.Crypt;

public class XCodeAdapter implements Crypt {
    private XCode xCode;

    public XCodeAdapter(XCode xCode) {
        this.xCode = xCode;
    }

    @Override
    public void encrypt(String text) {
        this.xCode.codeToText(text);
    }

    @Override
    public void decrypt(String text) {
        this.xCode.codeToText(text);
    }
}
