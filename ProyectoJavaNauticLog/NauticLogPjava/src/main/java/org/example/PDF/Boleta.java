package org.example.PDF;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.example.MaquinasBarcos.Maquina;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Boleta {
    String numeroFactura="N° 1";
    LocalDate fecha;

    public void generarFactura(Maquina maquina) throws FileNotFoundException {
        String carpeta = "facturas";
        crearCarpetaSiNoExiste(carpeta);

        String nombreBase = "factura_De_" + maquina.getNombre() + "_" + LocalDate.now();
        String extension = "pdf";

        String path = generarNombreDisponible(carpeta, nombreBase, extension);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);
        float twocol = 285f;
        float twocol150=twocol*150f;
        float twocolumnWidth[]={twocol150,twocol};
        Table table = new Table(twocolumnWidth);
        table.addCell(new Cell().add("Factura").setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
        Table nestedTabe = new Table(new float []{twocol/2,twocol/2});
        nestedTabe.addCell(new Cell().add(numeroFactura).setBold().setBorder(Border.NO_BORDER));
        nestedTabe.addCell(new Cell().add(nombreBase).setBold().setBorder(Border.NO_BORDER));
        nestedTabe.addCell(new Cell().add("Fecha:").setBold().setBold().setBorder(Border.NO_BORDER));
        nestedTabe.addCell(new Cell().add(String.valueOf(fecha.now())).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(nestedTabe).setBorder(Border.NO_BORDER));
        document.add(table);



        document.close();

        System.out.println("PDF generado en: " + path);
    }

    private void crearCarpetaSiNoExiste(String carpeta) {
        File dir = new File(carpeta);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    private String generarNombreDisponible(String carpeta, String nombreBase, String extension) {
        String nombreCompleto = nombreBase + "." + extension;
        File archivo = new File(carpeta, nombreCompleto);
        int contador = 1;

        while (archivo.exists()) {
            nombreCompleto = nombreBase + "(" + contador + ")." + extension;
            archivo = new File(carpeta, nombreCompleto);
            contador++;
        }

        return archivo.getAbsolutePath();
    }

    @Override
    public String toString() {
        return "Boleta{}";
    }
}
