package pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PDFGeneration {

    public static void main(String[] args) throws Exception{

        FontFactory.register("src/main/resources/playlist-script.otf");

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
        document.open();

        Image template = Image.getInstance("src/main/resources/template");

        template.scaleToFit(900, 900);
        template.setAlignment(Image.ALIGN_CENTER);


        Image qr = Image.getInstance("src/main/resources/qr.jpeg");
        qr.setAbsolutePosition(150f, 200f);
        qr.scaleAbsolute(300, 300);


        String foobar = "Ro y Facu";
        Font font = FontFactory.getFont("Playlist Script");
        font.setColor(BaseColor.BLACK);
        font.setSize(80);
        PdfContentByte canvas = writer.getDirectContent();
        Phrase phrase = new Phrase(foobar, font);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 300, 600, 0);

        document.add(template);
        document.add(qr);


        document.close();
    }
}
