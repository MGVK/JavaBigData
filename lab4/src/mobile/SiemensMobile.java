package mobile;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SiemensMobile implements Mobile {

    private static final String MAC_MASK     = "20:A8:B9";
    private static final String companyName  = "Siemens";
    private static final String supportPhone = "+78002002962";

    public SiemensMobile() {

    }


    @Override

    public void makeCall() {
        try {
            Desktop.getDesktop().browse(new URI("tel:" + supportPhone));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
