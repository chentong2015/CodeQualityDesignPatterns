import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

// Web Core 控制代码重构
// @Controller
// @GetMapping(path = "/loadI18N", produces = MediaType.APPLICATION_JSON_VALUE)
public class I18NController {

    Logger log = Logger.getLogger("ASSEMBLY_AUDIT_LOGGER_NAME");

    public String loadloadI18NString(String i18nPath, String module, String lang) {
        if(module.isEmpty() || lang.isEmpty()){
            log.warning("Http Parameters 'lang' and 'module' must be defined");
            return "";
        }

        log.warning("Loads localization file for module['"+module+"'] and language['"+lang+"']");

        String fileName = module+"_"+lang+".json";

        InputStream inputstream = null;

        if(!i18nPath.isEmpty()){
            String path = i18nPath + File.separator + fileName;
            try {
                inputstream = new FileInputStream(path);
                log.info("Loads localization file from external path ['"+path+"']");
            }catch(Exception e){
                log.warning("External localization file ['"+path+"'] does not exist");
            }

        }

        if(inputstream == null){
            try {
                inputstream = getClass().getResourceAsStream("/static/assets/i18n/" + fileName);
                if (null == inputstream) {
                    throw new RuntimeException("Default localization file['" + fileName +"'] " +
                            "not found in resources '/static/assets/i18n/'");
                }
                log.warning("Loads localization file ['"+fileName+"'] from resources");
            }catch(Exception e){
                log.warning("Localization file['"+fileName+"'] not found in resources");
                return "";
            }
        }

        String responseText;
        try {
            responseText = IOUtils.toString(inputstream, StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.warning("Can not load localizations");
            return "";
        } finally {
            IOUtils.closeQuietly(inputstream);
        }
        log.warning("Localization file ['"+fileName+"'] loaded");


        return responseText;
    }
}
