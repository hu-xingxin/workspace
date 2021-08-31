package com.myutils.officeUtils.wordUtils;

import java.util.Date;
import java.util.Map;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年10月14日 10:36
 **/

public class WordUtil {

    public void generateWrod(Map<String, Object> map, String templateName) {
       String templatePath = "";
       String outPath = "";
        DynWordUtils dynWordUtils = new DynWordUtils();
        dynWordUtils.process(map, templatePath, outPath);
    }
}
