package org.example.quillJs;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;


public class QuillAPDF {
    private static final String DEFAULT_OUTPUT_DIR = "output";
    private static final String DEFAULT_FILENAME = "informe.pdf";


    public String exportToPDF(String htmlContent) throws Exception {
        return exportToPDF(htmlContent, DEFAULT_OUTPUT_DIR, DEFAULT_FILENAME);
    }


    public String exportToPDF(String htmlContent, String outputDir, String filename) throws Exception {
        String fullHtml = "<html><head><meta charset='utf-8'/></head><body>" + htmlContent + "</body></html>";

        File outputDirFile = new File(outputDir);
        if (!outputDirFile.exists()) {
            outputDirFile.mkdirs();
        }

        String outputPath = outputDir + File.separator + filename;

        try (OutputStream os = new FileOutputStream(outputPath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(fullHtml, null);
            builder.toStream(os);
            builder.run();
        }

        return outputPath;
    }
}