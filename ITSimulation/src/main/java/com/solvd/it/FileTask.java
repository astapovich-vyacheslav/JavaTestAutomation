package com.solvd.it;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileTask {
    public static int getUniqueWordsNumber(File file) {
        try {
            String content = FileUtils.readFileToString(file, "US-ASCII");
            String[] strings = StringUtils.split(content);
            int result = 0;
            Set<String> seenStrings = new HashSet<>(Arrays.asList(strings));
            return seenStrings.size();
        } catch (IOException e) {
            return 0;
        }
    }
}
