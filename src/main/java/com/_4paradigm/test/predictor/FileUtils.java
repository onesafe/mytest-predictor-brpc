package com._4paradigm.test.predictor;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;

/**
 * Created by wangyiping on 28/08/2019 4:51 PM.
 */
public class FileUtils {

    public static String readFileFromResourceToString(String path) throws IOException {
        return Resources.toString(Resources.getResource(path), Charsets.UTF_8);
    }
}
