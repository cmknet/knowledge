package org.support.project.knowledge.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.support.project.common.exception.ParseException;
import org.support.project.common.util.FileUtil;
import org.support.project.knowledge.config.AppConfig;
import org.support.project.knowledge.parser.impl.PdfSlideShowParser;

public class PdfSlideShowParserTest {

    public static final String SAMPLE = "sample2";
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        File tempDir = new File(AppConfig.get().getTmpPath());
        File sample = new File(tempDir, SAMPLE + ".pdf");
        File output = new File(tempDir, SAMPLE);
        if (!output.exists()) {
            output.mkdirs();
        }
        FileUtil.copy(PdfSlideShowParserTest.class.getResourceAsStream("/org/support/project/knowledge/paeser/" + SAMPLE + ".pdf"),
                new FileOutputStream(sample));
        
        PdfSlideShowParser parser = new PdfSlideShowParser();
        parser.parse(sample, output);
    }

}
