package com.solvd.it;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileTask {
    public static int getUniqueWordsNumber(File file) {
        try {
            String content = FileUtils.readFileToString(file, "US-ASCII");
            List<String> strings = Arrays.stream(StringUtils.split(content))
                    .distinct().toList();
            return strings.size();
        } catch (IOException e) {
            return 0;
        }
    }
}
