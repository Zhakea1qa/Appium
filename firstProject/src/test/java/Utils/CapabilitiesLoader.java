package Utils;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class CapabilitiesLoader {
    public static DesiredCapabilities loadCapabilities(String filePath) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String jsonString = new String(data, StandardCharsets.UTF_8);

            JSONObject jsonObject = new JSONObject(jsonString);
            jsonObject.keys().forEachRemaining(key -> capabilities.setCapability(key, jsonObject.getString(key)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return capabilities;
    }
}
