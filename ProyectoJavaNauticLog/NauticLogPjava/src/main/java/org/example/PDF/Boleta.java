package org.example.PDF;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import org.example.Inventario.Insumo;
import org.example.MaquinasBarcos.Barco;
import org.example.Persona.Cliente;
import org.example.Persona.Mecanico;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static com.itextpdf.kernel.pdf.PdfName.Color;

public class Boleta {
    private int numeroFactura;
    private final String encabezadoNFactura = "N°:";
    LocalDate fecha;

    public int generarNumeroFactura() {
        Random random = new Random();
        numeroFactura = random.nextInt(800_000) + 100_000;
        return numeroFactura;
    }

    public void generarFactura(Mecanico mecanico, Barco barco, Cliente cliente, List<Insumo> insumos) {
        try {
            String carpeta = "facturas";
            crearCarpetaSiNoExiste(carpeta);

            String nombreBase = "factura_" + mecanico.getNombreEmpresa() + "_" + LocalDate.now();
            String extension = "pdf";
            String path = generarNombreDisponible(carpeta, nombreBase, extension);

            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf, PageSize.A4);
            doc.setMargins(20, 20, 20, 20);

            doc.add(new Paragraph("ASESORIAS E INVERSIONES " + mecanico.getNombreEmpresa().toUpperCase()).setBold().setFontSize(14));
            doc.add(new Paragraph("Giro: Reparación de Barcos y Asesoría Técnica Mecánica Naval"));
            doc.add(new Paragraph("Dirección: " + mecanico.getDireccionEmpresa()));
            doc.add(new Paragraph("Email: " + mecanico.getCorreoElectronico()));
            doc.add(new Paragraph("R.U.T.: " + mecanico.getRutEmpresa()).setBold().setFontSize(12).setFontColor(ColorConstants.RED));

            doc.add(new Paragraph("Factura Electrónica N° " + generarNumeroFactura()).setBold());
            doc.add(new Paragraph("Fecha Emisión: " + LocalDate.now().toString()));
            doc.add(new Paragraph("\n"));

            doc.add(new Paragraph("SEÑOR(ES): " + cliente.toString()));
            doc.add(new Paragraph("CIUDAD: - COMUNA: - TIPO DE COMPRA: Directa"));
            doc.add(new Paragraph("\n"));

            float[] columnWidths = {80f, 200f, 60f, 60f, 60f, 60f, 60f};
            Table insumoTable = new Table(columnWidths);
            insumoTable.setWidth(100);
            String[] headers = {"Código", "Descripción", "Cantidad", "Precio", "% Imp. Adic.", "% Desc.", "Valor"};

            for (String h : headers) {
                insumoTable.addHeaderCell(new Cell().add(new Paragraph(h)).setBold().setBackgroundColor(ColorConstants.LIGHT_GRAY));
            }

            double neto = 0;
            for (Insumo insumo : insumos) {
                double precio = insumo.calcularPrecioBoleta();
                double valor = precio; // cantidad y descuento fijos por ahora

                insumoTable.addCell("COD-" + insumo.getNombre().substring(0, 2).toUpperCase());
                insumoTable.addCell(insumo.getNombre() + " - " + insumo.toString());
                insumoTable.addCell("1 UNID");
                insumoTable.addCell(String.format("%.2f", precio));
                insumoTable.addCell("0");
                insumoTable.addCell("0");
                insumoTable.addCell(String.format("%.2f", valor));

                neto += valor;
            }

            doc.add(insumoTable);
            doc.add(new Paragraph("\n"));

            double iva = neto * 0.19;
            double total = neto + iva;

            doc.add(new Paragraph(String.format("MONTO NETO          $ %.3f", neto)).setBold());
            doc.add(new Paragraph(String.format("I.V.A 19%%           $ %.3f", iva)).setBold());
            doc.add(new Paragraph("IMPUESTO ADICIONAL  $ 0").setBold());
            doc.add(new Paragraph(String.format("TOTAL               $ %.3f", total)).setBold().setFontSize(13));

            doc.add(new Paragraph("\n\n"));
            doc.add(new Paragraph("Nombre: _____________________   RUT: ___________   Fecha: ______   Recinto: ______   Firma: ____________"));
            doc.add(new Paragraph("“El acuse de recibo que se declara en este acto [...] han sido recibido(s)”").setFontSize(9).setItalic());
            doc.add(new Paragraph("CEDIBLE").setFontColor(ColorConstants.RED).setBold().setFontSize(10));

            doc.close();
            System.out.println("Factura generada correctamente en: " + path);

        } catch (Exception e) {
            System.err.println("Error al generar la factura: " + e.getMessage());
            e.printStackTrace();
        }
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
