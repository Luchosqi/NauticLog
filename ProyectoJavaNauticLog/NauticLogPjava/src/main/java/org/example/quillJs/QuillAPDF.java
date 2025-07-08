package org.example.quillJs;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;

/**
 * Class responsible for exporting HTML content to PDF.
 */
public class QuillAPDF {
    private static final String DEFAULT_OUTPUT_DIR = "output";
    private static final String DEFAULT_FILENAME = "informe.pdf";

    /**
     * Exports HTML content to a PDF file.
     *
     * @param htmlContent The HTML content to export
     * @return The path to the generated PDF file
     * @throws Exception If there's an error during PDF generation
     */
    public String exportToPDF(String htmlContent) throws Exception {
        return exportToPDF(htmlContent, DEFAULT_OUTPUT_DIR, DEFAULT_FILENAME);
    }

    /**
     * Exports HTML content to a PDF file with a specified output directory and filename.
     *
     * @param htmlContent The HTML content to export
     * @param outputDir The directory where the PDF will be saved
     * @param filename The name of the PDF file
     * @return The path to the generated PDF file
     * @throws Exception If there's an error during PDF generation
     */
    public String exportToPDF(String htmlContent, String outputDir, String filename) throws Exception {
        // Ensure the HTML has proper structure
        String fullHtml = "<html><head><meta charset='utf-8'/></head><body>" + htmlContent + "</body></html>";
        
        // Ensure output directory exists
        File outputDirFile = new File(outputDir);
        if (!outputDirFile.exists()) {
            outputDirFile.mkdirs();
        }
        
        String outputPath = outputDir + File.separator + filename;
        
        // Generate the PDF
        try (OutputStream os = new FileOutputStream(outputPath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(fullHtml, null);
            builder.toStream(os);
            builder.run();
        }
        
        return outputPath;
    }
}